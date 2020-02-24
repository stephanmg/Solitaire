import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.GridPane
import javafx.scene.layout.StackPane
import javafx.stage.Popup
import javafx.stage.Stage

/**
 * @brief test GUI
 * TODO will be refactored to use Javalin API
 * @url https://javalin.io/
 */
class GUI : Application() {
    /**
     * @brief stage
     */
    override fun start(primaryStage: Stage) {
        val btn = Button()
        btn.text = "Say 'Hello World'"
        btn.onAction = EventHandler<ActionEvent> { println("Hello World!") }

        val root = StackPane()

        val scene = Scene(root, 135.0, 105.0)


        val n = 5
        val gridPane = GridPane()

        var curBtn: Button? = null
        var nextBtn: Button?
        var count = 0
        var currentBoard: Board = BoardFactory().square(5)
        var fromPosX: Int = -1
        var fromPosY: Int = -1

        val callback = fun(btn: Button, i: Int, j: Int) {
            /// TODO: Better use a MVC or MVVC framework
            println(btn.text)
            var value: Int
            if (btn.text == "*") {
                value = 1
            } else {
                value = 0
            }
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
                if (GameUtils.canJump(currentBoard.pegs[Pair(fromPosX,fromPosY)]!!, dir!!, currentBoard)) {
                    println("Peg could jump in desired direction")
                    // do the jump
                    GameUtils.jump(currentBoard.pegs[Pair(fromPosX,fromPosY)]!!, dir!!, currentBoard)
                    for (peg in currentBoard.pegs) {
                        var button = getNodeFromGridPane(gridPane, peg.value.i, peg.value.j)
                        if (button is Button) {
                            var b: Button = button as Button
                            b.text = if (peg.value.value == 1)  "*" else " "
                        }

                    }
                    /// TODO: Redraw board then! (the below lines will only change the two clicked buttons)
                    curBtn!!.text = " "
                    nextBtn!!.text = "*"
                } else {
                    println("peg could not jump in desired direction!")
                }

                println("Callback!")
            }
            fun checkGameOver(): Boolean {
                for (peg in currentBoard.pegs.values) {
                    enumValues<Game.Direction>().forEach {
                        if(GameUtils.canJump(peg, it, currentBoard!!)) {
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
                if (won) { label.text = "Won!"}
                // game over
                if (checkGameOver()) { label.text = "Game over!" }
                popup.content.add(label)
                popup.show(primaryStage)
            }

        }

        for (i in 0 until n) {
            for (j in 0 until n) {
                val btn = Button()
                if (i == ((n-1) / 2)  && j == ((n-1) / 2)) {
                    btn.text = " "
                } else {
                    btn.text = "*"
                }

                btn.onAction = EventHandler<ActionEvent> {
                    println("Callback!");
                    callback(btn, j, i)
                }
                gridPane.add(btn, j, i, 1, 1)
            }
        }

        root.children.add(gridPane);


        if (primaryStage != null) {
            primaryStage.title = "Solitaire UI"
            primaryStage.scene = scene
            primaryStage.sizeToScene()
            primaryStage.show()
        }
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