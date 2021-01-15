import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color
import javafx.stage.Popup
import javafx.stage.Stage
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @brief GUI
 * TODO: Add Javalin webinterface
 * TODO: Use TornadoFX instead of JavaFX
 * TODO: Adapt Solitaire to 3D
 */
class GUI : Application() {
    private var canStillWin = true
    private val pegImage = "file:peg.png"
    private fun createPegImage() = ImageView(Image(pegImage))
    private val n = 5
    private val sizeX = 250.0
    private val sizeY = 260.0

    /**
     * @brief start the stage
     * @param primaryStage
     */
    override fun start(primaryStage: Stage) {
        val root = BorderPane()
        val scene = Scene(root, sizeX, sizeY)
        val gridPane = GridPane()
        var curBtn: Button? = null
        var nextBtn: Button?
        var count = 0
        val currentBoard: Board = BoardFactory().square(n) 
        var fromPosX: Int = -1
        var fromPosY: Int = -1

        /**
         * @brief callback to check and move pegs
         */
        val callback = fun(btn: Button, i: Int, j: Int) {
            if (count == 0) {
                curBtn = btn
                nextBtn = null
                fromPosX = i
                fromPosY = j
            n}
            count++

            if (count == 2) {
                //canStillWin = Game().solveDfs(currentBoard)
                println("Can still win?" + canStillWin)
                val jumpToX = fromPosX - i
                val jumpToY: Int = fromPosY - j
                nextBtn = btn
                count = 0
                val dir: Game.Direction? = GameUtils.getDirection(jumpToX, jumpToY)
                if (dir == null) {
                    return
                }
                // check if peg can legally jump... 
                if (GameUtils.canJump(currentBoard.pegs[Pair(fromPosX,fromPosY)]!!, dir, currentBoard)) {
                    // then do the jump
                    GameUtils.jump(currentBoard.pegs[Pair(fromPosX,fromPosY)]!!, dir, currentBoard)
                    for (peg in currentBoard.pegs) {
                        val button = getNodeFromGridPane(gridPane, peg.value.i, peg.value.j)
                        if (button is Button) {
                            val b: Button = button
                            b.graphic = if (peg.value.available()) createPegImage() else null
                        }

                    }
                    curBtn!!.graphic = null;
                    nextBtn!!.graphic = createPegImage()
                }
            }

            val won: Boolean = currentBoard.numPegs() == 5
            val lost: Boolean = GameUtils.checkGameOver(currentBoard)
            if (won || lost) {
                // set background
                val label = Label()
                label.minWidth = 80.0
                label.minHeight = 50.0
                val popup = Popup()
                label.style = " -fx-background-color: white;"
                // won
                if (won) { label.text = "Won!"; label.textFill = Color.web("#00ff00") }
                // game over
                if (GameUtils.checkGameOver(currentBoard)) { label.text = "Game over!"; label.textFill = Color.web("#ff0000"); canStillWin = false }
                popup.content.add(label)
                popup.show(primaryStage)
            }
        }

        /// Draw initial board: TODO draw board on currentBoard's peg values -1, 0, or 1 (refactor this to use board and pegs dimensions of hash map with x,y coordinates)
        for (i in 0 until n) {
            for (j in 0 until n) {
                var btnBoard = Button()
                if (!(i == ((n-1) / 2)  && j == ((n-1) / 2))) {
                    btnBoard.graphic = createPegImage()
                }

                btnBoard.setMaxSize(50.0, 50.0)
                btnBoard.setMinSize(50.0, 50.0)
                btnBoard.onAction = EventHandler {
                    callback(btnBoard, j, i)
                }

                gridPane.add(btnBoard, j, i, 1, 1)
            }
        }

        root.center = gridPane
        root.top = Label(if (canStillWin) "Can still win" else "Cannot win anymore")
        gridPane.requestFocus()
        gridPane.setMaxSize(sizeX, sizeY)
        gridPane.setMinSize(sizeX, sizeY)
        gridPane.setPrefSize(sizeX, sizeY)
        primaryStage.title = "Solitaire UI"
        primaryStage.scene = scene
        primaryStage.sizeToScene()
        primaryStage.show()
    }

    /**
     * @brief helper method to get a node from the grid pane
     * @param gridPane
     * @param col
     * @param row
     */
    private fun getNodeFromGridPane(gridPane: GridPane, col: Int, row: Int): Node? {
        for (node in gridPane.children) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node
            }
        }
        return null
    }
}