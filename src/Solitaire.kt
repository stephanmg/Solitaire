import javafx.application.Application

/**
 * @brief main
 * Launches the GUI (JavaFX for now)
 */
class Solitaire {
    companion object {
        /**
          * @brief entry point for main program
          * @param args to the program
          */
        @JvmStatic
        fun main(args: Array<String>) {
            if (args.size != 1) {
                val program = System.getProperty("sun.java.command").split(".")[0]
                println("Usage: $program [Number of pegs]")
            } else {
                val n: Int = args[0].toInt()
                require(n > 0) { println("Creating board of size $n not sensible, n > 0 expected.") }
                val board = BoardFactory.square()
                println(board)
            }
            /// Finally lauch the application if not in terminal/console mode
            Application.launch(GUI::class.java, *args)
            // ConsoleGame.play()
        }
    }
}

