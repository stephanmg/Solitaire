import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.GridPane
import javafx.scene.layout.StackPane
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

        val callback = fun(btn: Button, i: Int, j: Int) {

            println(btn.text);
            /// TODO: Convert * and " " to 1 and 0 -> Better use a MVC framework
            enumValues<Game.Direction>().forEach {
                if (GameUtils.canJump(Peg(-1, 1, i, j), it, currentBoard)) {
                        println("Can Jump!")
                    /// If jumpable, do jump and draw new board: fun drawBoard(board: Board)
                }
            }

            if (count == 0) {
                curBtn = btn
                nextBtn = null
            }
            count++

            if (count == 2) {
                nextBtn = btn
                count = 0

                if (curBtn!!.text == nextBtn!!.text) {
                    println("Jump not possible")
                } else {
                    println("Possible")
                }
                println("Callback!")
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
                btn.onAction = EventHandler<ActionEvent> { println("Callback!"); callback(btn, i, j) }
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

}