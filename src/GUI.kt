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

        val scene = Scene(root, 300.0, 300.0)


        val n = 9
        val gridPane = GridPane()

        var curBtn: Button? = null
        var nextBtn: Button?
        var count = 0
        val callback = fun(btn: Button) {
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

        for (i in 1..n) {
            for (j in 1..n) {
                val btn = Button()
                if (i == (n+1)/2 && j == (n+1)/2) {
                    btn.text = " "
                } else {
                    btn.text = "*"
                }
                btn.onAction = EventHandler<ActionEvent> { println("Callback!"); callback(btn) }
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