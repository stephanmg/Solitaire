import javafx.application.Application

/**
 * @brief main
 * Launches the GUI (JavaFX for now)
 */
fun main (args: Array<String>) {
    if (args.size != 1) {
        val program = System.getProperty("sun.java.command").split(".")[0]
        println("Usage: $program [Number of pegs]")
    } else {
        val n: Int = args[0].toInt()
        require(n > 0) { println("Creating board of size $n not sensible, n > 0 expected.") }
        val board = BoardFactory().square(n)
        println(board)
    }
Li     Application.launch(GUI::class.java, *args)
}

