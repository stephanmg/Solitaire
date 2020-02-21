import java.util.*


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

        val jumpable: (Peg, Int, Int) -> Boolean =
            { peg, x, y -> pegs[Pair(i + x, j + y)]!!.value == 1 && pegs[Pair(i + x, j + y)]!!.value == 0 }

        return when (direction) {
            Direction.EAST -> jumpable(peg, 1, 0)
            Direction.NORTH -> jumpable(peg, 0, 1)
            Direction.SOUTH -> jumpable(peg, 0, -1)
            Direction.WEST -> jumpable(peg, -1, 0)
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
     * DFS solve
     *
     * Will be used during interactive game play
     */
    public fun solveDfs(currentBoard: Board) {
        val queue: LinkedList<Node> = LinkedList()

        for (peg in currentBoard.pegs.values) {
            enumValues<Direction>().forEach {
                if (canJump(peg, it, currentBoard)) {
                    queue.add(Node(jump(peg, it, currentBoard)))
                }
            }
        }

        while (!queue.isEmpty()) {
            var n = queue.first()
            if (n.board!!.numPegs() == 1) {
                println("Found a solution, aborting now...")
                return
            } else {
                for (peg in n.board!!.pegs.values) {
                    enumValues<Direction>().forEach {
                        if (canJump(peg, it, n.board!!)) {
                            queue.add(Node(jump(peg, it, n.board!!)))
                        } else {
                            // Nothing to do, cannot jump and board is null
                        }
                    }
                }
            }
        }
    }
}

/**
 * Play a game
 */
fun main() {
    val game: Game = Game()
    game.solveDfs(BoardFactory().square(3))
}
