import java.util.*

/**
 * Game
 *
 * This will be used to solve the Solitaire problem with a DFS approach and provide an UI
 */
class Game {
    /**
     * Legal jump directions are: NORTH, SOUTH, EAST or WEST
     */
    enum class Direction {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    /**
     * @brief Node representing a board in our queue
     */
    private data class Node(var board: Board?=null)

    /**
     * @brief Play interactively
     *
     * Notes: Let a user play (Maybe frontend in React?) and invoke dfs_solve each time to
     * indicate if solution still possible or if the user has lost the game already
     * @param peg start peg
     */
    fun play(peg: Peg) {
        val lost = false
        while (!lost) {
            /// TODO: Implement. Ask for user input, then jump accordingly
        }
    }

    /**
     * @brief 
     * 
     * @param peg
     * @param direction
     * @param currentBoard
     */
    private fun canJump(peg: Peg, direction: Direction, currentBoard: Board): Boolean {
        val pegs = currentBoard.pegs
        val i = peg.i
        val j = peg.j

        /**
         * @brief check if a peg can jump in current board configuration
         * @param x
         * @param y
         * @return true if can jump otherwise false
         */
        fun jumpable(x: Int, y:Int): Boolean {
            /// NOT PART OF THE BOARD (Should not happen actually but who knows)
            if (pegs[Pair(i+2*x, j+2*y)] == null) {
                return false
            } else  {
                /// BOUNDARY
                if (pegs[Pair(i+2*x, j+2*y)]!!.value == PegType.BOUNDARY) { 
                    return false
                }
                /// LEGAL JUMP 
                if ((pegs[Pair(i, j)]!!.value == PegType.FULL) &&
                    (pegs[Pair(i + x, j + y)]!!.value == PegType.FULL) &&
                    (pegs[Pair(i + 2 * x, j + 2 * y)]!!.value == PegType.EMPTY)) {
                    println("jumps to: " + (i+2*x) + ", " + (j+2*y))
                    println("value at this pos: " + pegs[Pair(i + 2 * x, j + 2 * y)]!!.value)
                    println("\n")
                    return true
                }
                return false
            }
        }

        /// Check all directions: EAST, NORTH, SOUTH and WEST
        return when (direction) {
            Direction.EAST -> jumpable(1, 0) // if (onBoundary(i, j)) false else jumpable(1, 0)
            Direction.NORTH -> jumpable(0, 1) // if (onBoundary(i, j)) false else jumpable(0, 1)
            Direction.SOUTH -> jumpable(0, -1) // if (onBoundary(i, j)) false else jumpable(0, -1)
            Direction.WEST -> jumpable(-1, 0) // if (onBoundary(i, j)) false else jumpable(-1, 0)
        }
    }

    /**
     * @brief performs the jump and returns am modified board
     * @param peg
     * @param direction
     * @param currentBoard
     */
    private fun doJump(peg: Peg, direction: Direction, currentBoard: Board): Board {
        val move: (Peg, Int, Int) -> Unit =
             { peg, x, y -> currentBoard.pegs[Pair(peg.i+x,peg.j+y)]!!.value = PegType.EMPTY
                 currentBoard.pegs[Pair(peg.i,peg.j)]!!.value = PegType.EMPTY
                 currentBoard.pegs[Pair(peg.i+2*x,peg.j+2*y)]!!.value = PegType.FULL }

        when (direction) {
            Direction.EAST -> move(peg, 1, 0)
            Direction.NORTH -> move(peg, 0, 1)
            Direction.SOUTH -> move(peg, 0, -1)
            Direction.WEST -> move(peg, -1, 0)
        }

        return currentBoard
    }

    /**
     * @brief jump helper
     * Helper method to perform check and then jump if possible
     * @param peg
     * @param direction
     */
    private fun jump(peg: Peg, direction: Direction, board: Board): Board? {
        if (canJump(peg, direction, board)) {
            return doJump(peg, direction, board)
        }
        return null
    }

    /**
     * @brief testJump
     * Little test function for jumpable
     */
    fun testJump(currentBoard: Board) {
        for (peg in currentBoard.pegs.values) {
            enumValues<Direction>().forEach {
                canJump(peg, it, currentBoard)
            }
        }
    }

    /**
     * @brief DFS solve
     * Finds some solution or all solutions if solution is feasible
     * @param currentBoard
     * Will be used during interactive game play
     * TODO: How do we now if a solution was reached? (Hardcode for known boards or until level-based DFS stuck)
     */
    fun solveDfs(currentBoard: Board): Boolean {
        val queue: LinkedList<Node> = LinkedList()
        // initial board
        queue.add(Node(currentBoard.copy()))

        var numSolutionsSoFar = 0
        println("Starting DFS search...")
        while (!queue.isEmpty()) {
            val n = queue.poll()
            println("Current node: $n")
            if (n.board!!.numPegs() == 5) {
                numSolutionsSoFar++
                println("Found solution #$numSolutionsSoFar")
            } else {
                for (peg in n.board!!.pegs.values) {
                    enumValues<Direction>().forEach {
                        if (canJump(peg, it, n.board!!)) {
                            val b: Board = n.board!!.copy()
                            queue.add(Node(jump(peg, it, b)))
                        }
                    }
                }
            }
        }
        // Check if we found any solution at all
        if (numSolutionsSoFar == 0) {
            println("Queue empty and no solution found so far! No solution exists?")
            return false
        } else {
            println("We found #$numSolutionsSoFar ways (Sequence of boards/jumps) to solve the problem")
            return true
        }
    }
}

/**
 * @brief a collection of useful game utilities
 */
object GameUtils {
    /**
     * @brief check if peg can jump
     * @param peg
     * @param direction
     * @param currentBoard
     */
    @JvmStatic
    fun canJump(peg: Peg, direction: Game.Direction, currentBoard: Board): Boolean {
        val pegs = currentBoard.pegs
        val i = peg.i
        val j = peg.j

        /**
         * @brief check if a peg can jump in current board configuration
         * @param x
         * @param y
         * @return true if can jump otherwise false
         * TODO: Make this check correct anyway, also if we disallow selecting boundary elements in the GUI this will not have any impact
         */
        /// NOT PART OF THE BOARD (Should not happen actually but who knows)
        fun jumpable(x: Int, y:Int): Boolean {
            if (pegs[Pair(i+2*x, j+2*y)] == null) {
                println("peg null!")
                return false
            } else {
                println(i+2*x)
                println(i+2*y)
                /// BOUNDARY
                if (pegs[Pair(i+2*x, j+2*y)]!!.value == PegType.BOUNDARY) { // Boundary... TODO maybe should refactor board data structure
                    /// This might be also okay, pegs is a dictionary, so we can build arbitrary boards, Pegs do not need
                    /// to store their index, could also ask the dictionary for the key (Pair with indices) but this is slower
                    println("Peg (to position) on boundary!")
                    return false
                }

                /* 
                /// Note: The boundary is everything outside the board TODO: is this correct
                if (pegs[Pair(i, j)]!!.value == -1) {
                    println("Peg (from position) on boundary!")
                    return false;
                }
                */
                /// LEGAL JUMP
                if ((pegs[Pair(i, j)]!!.value == PegType.FULL) &&
                    (pegs[Pair(i + x, j + y)]!!.value == PegType.FULL) &&
                    (pegs[Pair(i + 2 * x, j + 2 * y)]!!.value == PegType.EMPTY)) {
                    println("jumps to: " + (i+2*x) + ", " + (j+2*y))
                    println("value at this pos: " + pegs[Pair(i + 2 * x, j + 2 * y)]!!.value)
                    println("\n")
                    return true
                }
                println("Here!")
                println(x)
                println(y)
                return false
            }
        }

        /// Check all directions: EAST, NORTH, SOUTH and WEST
        return when (direction) {
            Game.Direction.EAST -> jumpable(-1, 0) // if (onBoundary(i, j)) false else jumpable(1, 0)
            Game.Direction.NORTH -> jumpable(0, 1) // if (onBoundary(i, j)) false else jumpable(0, 1)
            Game.Direction.SOUTH -> jumpable(0, -1) // if (onBoundary(i, j)) false else jumpable(0, -1)
            Game.Direction.WEST -> jumpable(1, 0) // if (onBoundary(i, j)) false else jumpable(-1, 0)
        }
    }

    /**
     * @brief
     * @param peg
     * @param currentBoard
     */
    private fun doJump(peg: Peg, direction: Game.Direction, currentBoard: Board): Board {
        val move: (Peg, Int, Int) -> Unit =
            { peg, x, y -> currentBoard.pegs[Pair(peg.i+x,peg.j+y)]!!.value = PegType.EMPTY
                currentBoard.pegs[Pair(peg.i,peg.j)]!!.value = PegType.EMPTY
                currentBoard.pegs[Pair(peg.i+2*x,peg.j+2*y)]!!.value = PegType.FULL }

        when (direction) {
            Game.Direction.EAST -> move(peg, -1, 0)
            Game.Direction.NORTH -> move(peg, 0, 1)
            Game.Direction.SOUTH -> move(peg, 0, -1)
            Game.Direction.WEST -> move(peg, 1, 0)
        }

        return currentBoard
    }

    /**
     * @brief jump
     * Helper method to perform check and then jump if possible
     * @param peg
     * @param direction
     */
    @JvmStatic
    fun jump(peg: Peg, direction: Game.Direction, board: Board): Board? {
        if (canJump(peg, direction, board)) {
            return doJump(peg, direction, board)
        }
        return null
    }

    /**
     * @brief get direction
     * @param i
     * @param j
     */
    @JvmStatic
    fun getDirection(i: Int, j: Int): Game.Direction? {
        return when(Pair(i, j)) {
            Pair(2, 0)  -> Game.Direction.EAST
            Pair(-2, 0) -> Game.Direction.WEST
            Pair(0, -2)  -> Game.Direction.NORTH
            Pair(0, 2) -> Game.Direction.SOUTH
            else -> null
        }
    }
    /**
     * @brief check if game is over or not
     * @param currentBoard game state
     */
    @JvmStatic
    fun checkGameOver(currentBoard: Board): Boolean {
        for (peg in currentBoard.pegs.values) {
            enumValues<Game.Direction>().forEach {
                if(GameUtils.canJump(peg, it, currentBoard)) {
                    return false
                }
            }
        }
        return true
    }

    /**
     * @brief perform a move
     * @param command
     * @param gameManager
     */
    @JvmStatic
    private fun move(command: UndoableVisualCommand, moveManager: MoveManager) {
        moveManager.execute(command)
    }

    /**
     * @brief move
     * @param gameManager
     * @param fromPosX,
     * @param fromPosY
     * @param direction
     */
    @JvmStatic
    fun move(fromPosX: Int, fromPosY: Int, direction: Game.Direction, moveManager: MoveManager) {
        when(direction) {
            Game.Direction.EAST -> move(MoveEast(moveManager.game, fromPosX, fromPosY), moveManager)
            Game.Direction.WEST -> move(MoveWest(moveManager.game, fromPosX, fromPosY), moveManager)
            Game.Direction.NORTH -> move(MoveNorth(moveManager.game, fromPosX, fromPosY), moveManager)
            Game.Direction.SOUTH-> move(MoveSouth(moveManager.game, fromPosX, fromPosY), moveManager)
        }
    }
}

/**
 * @brief main
 * Play a test game
 */
fun main() {
    /// Square board of n=5 has solution with 5 pegs left, probably a coincidence
    val game = Game()
    game.solveDfs(BoardFactory().square(5))
}
