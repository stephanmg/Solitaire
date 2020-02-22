import java.util.*
import kotlin.test.assert


/**
 * Game
 *
 * This will be used to solve the Solitaire problem with a DFS approach and provide an UI
 */
class Game {
    /**
     * Legal jump directions are: NORTH, SOUTH, EAST, WEST
     */
    private enum class Direction {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    /**
     * Node representing a board in our queue
     */
    private data class Node(var board: Board?=null)

    /**
     * Play interactively
     *
     * Let a user play (Maybe frontend in React?) and invoke dfs_solve each time to
     * indicate if solution still possible or if the user has lost the game already
     * @param peg start peg
     */
    fun play(peg: Peg) {
        var lost = false;
        while (!lost) {
            // ask for user input, then jump

        }
    }

    /**
     * Check if a peg can jump in one of the classical directions
     * @param peg
     * @param direction
     */
    private fun canJump(peg: Peg, direction: Direction, currentBoard: Board): Boolean {
        val pegs = currentBoard.pegs;
        val i = peg.i;
        val j = peg.j;

        val onBoundary: (Int, Int) -> Boolean = {
            x, y -> (x == currentBoard.size-1 || y == currentBoard.size-1 || x == 0 || y == 0)
        }

        val jumpable: (Int, Int) -> Boolean =
            { x, y ->
                pegs[Pair(i, j)]!!.value == 1 &&
                        pegs[Pair(i + x, j + y)]!!.value == 1 && pegs[Pair(i+2*x, j+2*y)]!!.value == 0
            }

        fun foo(x: Int, y:Int): Boolean {
            if (pegs[Pair(i+2*x, j+2*y)] == null) {
                return false
            } else {

                if ( (pegs[Pair(i, j)]!!.value == 1) &&
                    (pegs[Pair(i + x, j + y)]!!.value == 1) && (pegs[Pair(i + 2 * x, j + 2 * y)]!!.value == 0)) {
                    print("Peg: " + peg)
                    println("jumps to: " + (i+2*x) + ", " + (j+2*y))
                    println("value at this pos: " + pegs[Pair(i + 2 * x, j + 2 * y)]!!.value)
                    println("\n")
                    return true;
                }
                return false;

            }
        }
        when (direction) {
            Direction.EAST -> return foo(1,0)// if (onBoundary(i, j)) false else jumpable(1, 0)
            Direction.NORTH -> return foo(0,1)//if (onBoundary(i, j)) false else jumpable(0, 1)
            Direction.SOUTH -> return foo(0,-1)//if (onBoundary(i, j)) false else jumpable(0, -1)
            Direction.WEST -> return foo(-1,0)//if (onBoundary(i, j)) false else jumpable(-1, 0)
        }
    }

    /**
     * Actual do the jump in the board
     * @param peg
     * @param direction
     */
    private fun doJump(peg: Peg, direction: Direction, currentBoard: Board): Board {
        val move: (Peg, Int, Int) -> Unit =
             { peg, x, y -> currentBoard.pegs[Pair(peg.i+x,peg.j+y)]!!.value = 0;
                 currentBoard.pegs[Pair(peg.i,peg.j)]!!.value = 0;
                 currentBoard.pegs[Pair(peg.i+2*x,peg.j+2*y)]!!.value = 1; }

        when (direction) {
            Direction.EAST -> move(peg, 1, 0)
            Direction.NORTH -> move(peg, 0, 1)
            Direction.SOUTH -> move(peg, 0, -1)
            Direction.WEST -> move(peg, -1, 0)
        }
        return currentBoard;
    }

    /**
     * Helper method to perform check and then jump if possible
     * @param peg
     * @param direction
     */
    private fun jump(peg: Peg, direction: Direction, board: Board): Board? {
        if (canJump(peg, direction, board)) {
            return doJump(peg, direction, board)
        }
        return null;
    }

    /**
     * Little test function for jumpable
     */
    public fun testJump(currentBoard: Board) {
        for (peg in currentBoard.pegs.values) {
            enumValues<Direction>().forEach {
                canJump(peg, it, currentBoard)
            }
        }
    }

    /**
     * DFS solve
     *
     * Will be used during interactive game play
     */
    public fun solveDfs(currentBoard: Board) {
        val queue: LinkedList<Node> = LinkedList()

        for (peg in currentBoard.pegs.values) {
            enumValues<Direction>().forEach {
                if (canJump(peg, it, currentBoard)) {
                   // queue.add(Node(jump(peg, it, currentBoard)))
                    queue.add(Node(currentBoard))
                  //  println("Can jump!");
                   // println("Peg: $peg")
                } else {
                }
            }
        }
        println("Number of nodes in board:" + queue.size)
        return

        /// TODO: jump needs to be fixed -> board needs to be cloned, then jump needs to be performed

        println("Starting search...")
        while (!queue.isEmpty()) {
            var n = queue.poll()
            println("Start node: $n")
            if (n.board!!.numPegs() == 1) {
                println("Found a solution, aborting now...")
                return
            } else {
                println("Number of nodes: " + queue.size);
                for (peg in n.board!!.pegs.values) {
                    enumValues<Direction>().forEach {
                        if (canJump(peg, it, n.board!!)) {
                            var b: Board = BoardFactory().square(5)
                            b = n.board!!
 //                           queue.add(Node(jump(peg, it, b)))
                            queue.add(Node(b))
                        } else {
                            // Nothing to do, cannot jump and board is null
                        }
                    }
                }
                println("Number of nodes in initial queue: " + queue.size)
                assert(queue.size == 4)
                return
            }
        }
    }
}

/**
 * Play a game
 */
fun main() {
    val game: Game = Game()
    //game.testJump(BoardFactory().square(5))
    game.solveDfs(BoardFactory().square(5))
}
