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
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @brief test GUI
 * TODO will be refactored to use Javalin API
 * @url https://javalin.io/
 */

class GUI : Application() {
    private var canStillWin = true
    private val pegImage = "file:peg.png"
    /**
     * @brief stage
     */
    private fun createPegImage() = ImageView(Image(pegImage))
    override fun start(primaryStage: Stage) {
        val btn = Button()
        btn.text = "Say 'Hello World'"
        btn.onAction = EventHandler { println("Hello World!") }

        val root = BorderPane()

        val scene = Scene(root, 250.0, 260.0)

        val n = 5
        val gridPane = GridPane()

        var curBtn: Button? = null
        var nextBtn: Button?
        var count = 0
        val currentBoard: Board = BoardFactory().square(5)
        var fromPosX: Int = -1
        var fromPosY: Int = -1

        val callback = fun(btn: Button, i: Int, j: Int) {
            /// TODO: Better use a MVC or MVVC framework
            println(btn.text)

            /*
            enumValues<Game.Direction>().forEach {
                if (GameUtils.canJump(Peg(-1, value, i, j), it, currentBoard)) {
                        println("Can Jump!")
                }
            }*/

            if (count == 0) {
                curBtn = btn
                nextBtn = null
                fromPosX = i
                fromPosY = j
            }
            count++

            if (count == 2) {
                val jumpToX = fromPosX - i
                val jumpToY: Int = fromPosY - j

                nextBtn = btn
                count = 0

                val dir: Game.Direction? = GameUtils.getDirection(jumpToX, jumpToY)
                println(dir)
                println("fromPos: $fromPosX, $fromPosY")
                if (dir == null) {
                    println("jump not possible")
                    return
                }
                if (GameUtils.canJump(currentBoard.pegs[Pair(fromPosX,fromPosY)]!!, dir, currentBoard)) {
                    println("Peg could jump in desired direction")
                    // do the jump
                    GameUtils.jump(currentBoard.pegs[Pair(fromPosX,fromPosY)]!!, dir, currentBoard)
                    for (peg in currentBoard.pegs) {
                        val button = getNodeFromGridPane(gridPane, peg.value.i, peg.value.j)
                        if (button is Button) {
                            val b: Button = button
                            b.graphic = if (peg.value.value ==1) createPegImage() else null
                        }

                    }
                    /// TODO: Redraw board then! (the below lines will only change the two clicked buttons)
                    curBtn!!.graphic = null;
                    nextBtn!!.graphic = createPegImage()
                } else {
                    println("peg could not jump in desired direction!")
                }

                println("Callback!")
            }

            fun checkGameOver(): Boolean {
                for (peg in currentBoard.pegs.values) {
                    enumValues<Game.Direction>().forEach {
                        if(GameUtils.canJump(peg, it, currentBoard)) {
                            return false
                        }
                    }
                }
                return true
            }

            val won: Boolean = currentBoard.numPegs() == 5
            val lost: Boolean = checkGameOver()

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
                if (checkGameOver()) { label.text = "Game over!"; label.textFill = Color.web("#ff0000"); canStillWin = false }
                popup.content.add(label)
                popup.show(primaryStage)
            }

        }

        /// Draw initial board
        for (i in 0 until n) {
            for (j in 0 until n) {
                var btnBoard = Button()
                if (!(i == ((n-1) / 2)  && j == ((n-1) / 2))) {
                    btnBoard.graphic = createPegImage()
                }

                btnBoard.setMaxSize(50.0, 50.0)
                btnBoard.setMinSize(50.0, 50.0)

                btnBoard.onAction = EventHandler {
                    println("Callback!")
                    callback(btnBoard, j, i)
                }

                gridPane.add(btnBoard, j, i, 1, 1)

            }
        }

        root.center = gridPane
        root.top = Label(if (canStillWin) "Can still win" else "Cannot win anymore")
         gridPane.requestFocus()
         primaryStage.title = "Solitaire UI"
         primaryStage.scene = scene
         primaryStage.sizeToScene()
         primaryStage.show()
    }

    private fun getNodeFromGridPane(gridPane: GridPane, col: Int, row: Int): Node? {
        for (node in gridPane.children) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node
            }
        }
        return null
    }
}