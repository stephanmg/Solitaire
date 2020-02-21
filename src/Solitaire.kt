import javafx.application.Application

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

     Application.launch(GUI::class.java, *args)
}

