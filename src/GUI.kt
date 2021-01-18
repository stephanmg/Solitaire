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
    private var initialDraw = true

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
        //val currentBoard: Board = BoardFactory().square(n)  
        val currentBoard: Board = BoardFactory().classic() 
        var fromPosX: Int = -1
        var fromPosY: Int = -1

        /**
         * @brief callback to check and move pegs
         */
        val callback = fun(btn: Button, i: Int, j: Int) {
            btn.style = "-fx-background-color: beige; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
            if ((count % 2) == 0) {
                curBtn = btn
                nextBtn = null
                fromPosX = i
                fromPosY = j
                btn.style = "-fx-background-color: beige; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
            }  else {
                //canStillWin = Game().solveDfs(currentBoard)
                println("Can still win?" + canStillWin)
                val jumpToX = fromPosX - i
                val jumpToY: Int = fromPosY - j
                nextBtn = btn
                val dir: Game.Direction? = GameUtils.getDirection(jumpToX, jumpToY)
                if (dir == null) {
                    curBtn!!.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
                    nextBtn!!.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
                    curBtn = nextBtn
                // check if peg can legally jump... 
                } else if (GameUtils.canJump(currentBoard.pegs[Pair(fromPosX,fromPosY)]!!, dir, currentBoard)) {
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
                    curBtn!!.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
                    nextBtn!!.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
                } else {
                    curBtn!!.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
                    nextBtn!!.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
                    curBtn = nextBtn
                }
            } 
            count++

            val won: Boolean = currentBoard.numPegs() == 5
            val lost: Boolean = GameUtils.checkGameOver(currentBoard)
            if (won || lost) {
                // set background
                val label = Label()
                label.minWidth = 80.0
                label.minHeight = 50.0
                val popup = Popup()
                label.style = " -fx-background-color: #f8f8ff; "
                // won
                if (won) { label.text = "Won!"; label.textFill = Color.web("#00ff00") }
                // game over
                if (GameUtils.checkGameOver(currentBoard)) { label.text = "Game over!"; label.textFill = Color.web("#ff0000"); canStillWin = false }
                popup.content.add(label)
                popup.show(primaryStage)
            }
        }

        /* 
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
        */

        drawBoard(gridPane, currentBoard, callback, initialDraw)
        initialDraw = false

        root.center = gridPane
        root.top = Label(if (canStillWin) "Can still win" else "Cannot win anymore")
        gridPane.requestFocus()
        gridPane.setMaxSize(sizeX, sizeY)
        gridPane.setMinSize(sizeX, sizeY)
        gridPane.setPrefSize(sizeX, sizeY)
        gridPane.style = "-fx-grid-lines-visible: true;"
        primaryStage.title = "Stephan's Solitaire UI"
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
    
    /**
     * @brief draw a board
     * @param gridPane
     * @param callback - button callback to remove and add pegs to the gridPane
     */
    private fun drawBoard(gridPane: GridPane, board: Board, callback: (btn: Button, i: Int, j: Int) -> Unit, initialDraw: Boolean) {
        val draw = fun(i: Int, j: Int, value: Int) {
            var btn = Button()
            if (value == 1) 
                btn.graphic = createPegImage()

            btn.setMaxSize(50.0, 50.0)
            btn.setMinSize(50.0, 50.0)
            /// explicit boundary of the board does not have clickable button
            if (value != -1) {
               btn.onAction = EventHandler {
                    callback(btn, j, i)
               }
            } else {
                btn.onAction = EventHandler {
                   btn.style = "-fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey; -fx-background-color: lightgrey"
                }
            }

            if (initialDraw) {
               // btn.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"

               if (value == -1) 
                   btn.style = "-fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey; -fx-background-color: lightgrey"
               else
                   btn.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"

            }

            gridPane.add(btn, j, i, 1, 1)
        }

        board.pegs.forEach { 
            coordinates, peg -> draw(coordinates.first, coordinates.second, peg.value)
        }
    }
}