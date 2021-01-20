import javafx.application.Application

/**
 * @brief main
 * Launches the GUI (JavaFX for now)
 */
class Solitaire {
    companion object {
        /**
          * @brief main
          */
        @JvmStatic
        fun main(args: Array<String>) {
            if (args.size != 1) {
                val program = System.getProperty("sun.java.command").split(".")[0]
                println("Usage: $program [Number of pegs]")
            } else {
                val n: Int = args[0].toInt()
                require(n > 0) { println("Creating board of size $n not sensible, n > 0 expected.") }
                val board = BoardFactory().square(n)
                println(board)
            }

            Application.launch(GUI::class.java, *args)
            /// TODO: Add GUI label to indicate if solution can still be reached or not (check with level based dfsSolve)
            /// TODO: Fix/Add redo/undo operation?
            /// TODO: Add UI to let the computer play a game until the end (solve it) and/or add replay option
        }
    }
}

