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

            /// TODO: Add GUI interface to play by computer to the end of the game from current board until solution reached (dfsSolve)
            /// TODO: Add undo move
            /// TODO: Add redo move
            /// TODO: Add GUI indicator if solution can still be reached or not (dfsSolve)
            /// TODO: GameManager: 1) Save game 2) Load game 3) Create Boards
        }
    }
}

