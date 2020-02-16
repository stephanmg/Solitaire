/**
 * Game
 *
 * This will be used to solve the Solitaire problem with a DFS approach and provide an UI
 */
class Game {
    var currentBoard: Board = BoardFactory().empty()
    var prevBoard: Board = BoardFactory().empty()

    private enum class Direction {
        NORTH, SOUTH, WEST, EAST
    }

    /**
     * DFS solve
     *
     * Will be used during interactive game play
     */
    private fun solveDfs() {

    }

    /**
     * Play interactively
     *
     * Let a user play (Maybe frontend in React?) and invoke dfs_solve each time to
     * indicate if solution still possible or if the user has lost the game already
     */
    fun play() {
        var lost = false;
        while (!lost) {

        }
    }

    /**
     * Check if a peg can jump
     */
    private fun canJump(peg: Peg, direction: Direction): Boolean {
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

    private fun doJump(peg: Peg, direction: Direction) {
        // copy old board which will be the previous board
        prevBoard = currentBoard.copy();

        val move: (Peg, Int, Int) -> Unit =
             { peg, x, y -> currentBoard.pegs[Pair(peg.i+x,peg.j+y)]!!.value = 0;
                 currentBoard.pegs[Pair(peg.i+2*x,peg.j+2*y)]!!.value = 1; }

        when (direction) {
            Direction.EAST -> move(peg, 1, 0)
            Direction.NORTH -> move(peg, 0, 1)
            Direction.SOUTH -> move(peg, 0, -1)
            Direction.WEST -> move(peg, -1, 0)
        }
    }

    private fun jump(peg: Peg, direction: Direction) {
        if (canJump(peg, direction)) {
            doJump(peg, direction)
        }
    }
}

