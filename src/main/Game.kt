package de.syntaktischer.zucker.Solitaire

import de.syntaktischer.zucker.Solitaire.*
import java.util.LinkedList

/**
  * @brief direction a peg can jump to
  * Legal jump directions are: NORTH, SOUTH, EAST or WEST
  */
enum class Direction {
   NORTH, /* Jump peg to NORTH */
   SOUTH, /* Jump peg to SOUTH */
   WEST, /* Jump peg to WEST */
   EAST /* Jump peg to EAST */
}

/**
 * @brief Game solver 
 *
 * This will be used to solve the Solitaire problem with a DFS approach and provide an UI
 */
class GameSolver {
    /**
     * @brief node represents one board for the level-wise DFS solve
     * @param board 
     */
    private data class Node(var board: Board?=null)

    /**
     * @brief decide what is the winning state for the supported board types
     * @param type of board
     * @return number of mininum pegs to win
     */
    private fun minPegs(type: BoardType): Int {
        return when(type) {
            BoardType.SQUARE -> 5
            BoardType.CLASSIC -> 1
            else -> 0
        }
    }

    /**
     * @brief DFS solve of the peg board
     * The method will find one of the possible solutions via a DFS solve
     * @param currentBoard
     */
    fun solveDfs(currentBoard: Board): Boolean {
        // number of pegs for winning
        val minPegs = minPegs(if (currentBoard.numPegs() == 80) BoardType.SQUARE else BoardType.CLASSIC)

        // initial board
        val queue: LinkedList<Node> = LinkedList()
        queue.add(Node(currentBoard.copy()))

        // no solution found so far
        var numSolutionsSoFar = 0
        println("Starting DFS search...")

        // try to find a solution via level-wise DFS of board states
        while (!queue.isEmpty()) {
            val n = queue.poll()
            println("Current node to be inspected: $n")
            if (n.board!!.numPegs() == minPegs) {
                numSolutionsSoFar++
                println("Found #$numSolutionsSoFar solutions so far...")
            } else {
                for (peg in n.board!!.pegs.values) {
                    enumValues<Direction>().forEach {
                        if (GameUtils.canJump(peg, it, n.board!!)) {
                            val b: Board = n.board!!.copy()
                            queue.add(Node(GameUtils.jump(peg, it, b)))
                        }
                    }
                }
            }
        }
        // Check if we found any solution at all
        if (numSolutionsSoFar == 0) {
            println("DFS queue empty and still no solution found so far! Do not solutions exist?")
            return false
        } else {
            println("We found #$numSolutionsSoFar ways (Sequence of boards states respectively moves) to solve the current board")
            return true
        }
    }
}

/**
 * @brief a collection of useful game utilities
 * 
 * A collection of repetitive tasks
 */
object GameUtils {
    /**
     * @brief check if a peg can jump in current board
     * @param peg
     * @param direction
     * @param currentBoard
     * @return true if peg can jump and false otherwise
     */
    @JvmStatic
    fun canJump(peg: Peg, direction: Direction, currentBoard: Board): Boolean {
        /// get pegs of board and jumping peg
        val pegs = currentBoard.pegs
        val i = peg.i
        val j = peg.j

        /**
         * @brief check if a peg can jump in current board configuration
         * @param x position of the peg which tries to jump
         * @param y position of the peg which tries to jump
         * @return true if can jump in the board otherwise false
         */
        fun jumpable(x: Int, y:Int): Boolean {
            /// NOT DEFINED (the location we jump to is not defined in the board)
            if (pegs[Pair(i+2*x, j+2*y)] == null) {
                // println("Peg we want to jump to is not defined")
                return false
            /// NOT DEFINED (the location we jump from is not defined in the board)
            } else if (pegs[Pair(i, j)] == null) {
                // println("Peg we want to jump from is not defined")
                return false
            } else {
                /// BOUNDARY (the location we jump from is not part of the board)
                if (pegs[Pair(i, j)]!!.value == PegType.BOUNDARY) {
                    // println("Peg (from position) on boundary!")
                    return false
                }

                /// LEGAL JUMP
                if ((pegs[Pair(i, j)]!!.value == PegType.FULL) &&
                    (pegs[Pair(i + x, j + y)]!!.value == PegType.FULL) &&
                    (pegs[Pair(i + 2 * x, j + 2 * y)]!!.value == PegType.EMPTY)) {
                    // println("Peg jumps to: " + (i+2*x) + ", " + (j+2*y) + " and value at target position: " + pegs[Pair(i + 2 * x, j + 2 * y)]!!.value )
                    return true
                }
                return false
            }
        }

        /// Check all directions: EAST, NORTH, SOUTH and WEST
        return when (direction) {
            Direction.EAST  -> jumpable(-1, 0) 
            Direction.NORTH -> jumpable(0, 1) 
            Direction.SOUTH -> jumpable(0, -1) 
            Direction.WEST  -> jumpable(1, 0) 
        }
    }

    /**
     * @brief
     * @param currentPeg
     * @param currentBoard
     */
    private fun doJump(currentPeg: Peg, direction: Direction, currentBoard: Board): Board {
        val jump: (Peg, Int, Int) -> Unit =
            { peg, x, y -> currentBoard.pegs[Pair(peg.i+x,peg.j+y)]!!.value = PegType.EMPTY
                currentBoard.pegs[Pair(peg.i,peg.j)]!!.value = PegType.EMPTY
                currentBoard.pegs[Pair(peg.i+2*x,peg.j+2*y)]!!.value = PegType.FULL }

        when (direction) {
            Direction.EAST  -> jump(currentPeg, -1, 0)
            Direction.NORTH -> jump(currentPeg, 0, 1)
            Direction.SOUTH -> jump(currentPeg, 0, -1)
            Direction.WEST  -> jump(currentPeg, 1, 0)
        }

        return currentBoard
    }

    /**
     * @brief jump
     * Helper method to perform check and then jump if possible
     * @param peg which will jump
     * @param direction to jump to
     * @param board state
     * @param board configuration after the jump
     */
    @JvmStatic
    fun jump(peg: Peg, direction: Direction, board: Board): Board? {
        if (canJump(peg, direction, board)) {
            return doJump(peg, direction, board)
        }
        return null
    }

    /**
     * @brief get jump direction from peg position
     * @param x coordinate
     * @param y coordinate
     */
    @JvmStatic
    fun getJumpDirection(x: Int, y: Int): Direction? {
        return when(Pair(x, y)) {
            Pair( 2, 0) -> Direction.EAST
            Pair(-2, 0) -> Direction.WEST
            Pair(0,-2)  -> Direction.NORTH
            Pair(0, 2)  -> Direction.SOUTH
            else -> null
        }
    }
    /**
     * @brief check if game is over or not
     * @param currentBoard game state
     * @return true if game over and false if can still win
     */
    @JvmStatic
    fun checkGameOver(currentBoard: Board): Boolean {
        for (peg in currentBoard.pegs.values) {
            enumValues<Direction>().forEach {
                if(GameUtils.canJump(peg, it, currentBoard)) {
                    return false
                }
            }
        }
        return true
    }

    /**
     * @brief utility to check if game has been won
     * @param game
     * @return true if won otherwise false
     */
    @JvmStatic
    fun checkWon(game: PlayableGame): Boolean {
        val gameState: GameState? = game.gameState
        return checkWon(gameState!!.type, gameState.board.numPegs())
    }

    /**
     * brief utility to check if game has been won
     * @param type of board
     * @param numPegs of pegs in board
     */
    @JvmStatic
    private fun checkWon(type: BoardType, numPegs: Int): Boolean {
        return when (type) {
            BoardType.CLASSIC -> 1 == numPegs
            BoardType.SQUARE -> 5 == numPegs
            else -> true
        }
    }

    /**
     * @brief perform an actual move in the board
     * @param command
     * @param gameManager
     */
    @JvmStatic
    private fun move(command: UndoableCommand, moveManager: MoveManager): Unit {
        moveManager.execute(command)
    }

    /**
     * @brief move
     * @param gameManager
     * @param fromPosX
     * @param fromPosY
     * @param direction
     */
    @JvmStatic
    fun move(fromPosX: Int, fromPosY: Int, direction: Direction, moveManager: MoveManager): Unit {
        when(direction) {
            Direction.EAST -> move(MoveEast(moveManager.game, fromPosX, fromPosY), moveManager)
            Direction.WEST -> move(MoveWest(moveManager.game, fromPosX, fromPosY), moveManager)
            Direction.NORTH -> move(MoveNorth(moveManager.game, fromPosX, fromPosY), moveManager)
            Direction.SOUTH-> move(MoveSouth(moveManager.game, fromPosX, fromPosY), moveManager)
        }
    }
}

/**
 * @brief Let the user play a very simple console game
 */
object ConsoleGame {
    /**
     * @brief play a console game
     */
    @JvmStatic 
    fun play() {
        println("*".repeat(44))
        println("WELCOME to 2D Peg Solitaire")
        println("Available board types: 1) CLASSIC 2) SQUARE")
        println("*".repeat(44))
        println(""); print("Choice: ")
        val boardChoice: String = readLine()!!
        var board: Board
        when (boardChoice.toInt()) {
            1 -> board = BoardFactory.board(BoardType.CLASSIC)
            2 -> board = BoardFactory.board(BoardType.SQUARE)
            else -> board = BoardFactory.board(BoardType.CLASSIC)
        }

        var lost = false
        var move = 0
        println("Initial board: \n${board}")
        while (! lost) {
            print("Chose jumping peg by coordinates (x, y): ")
            val (xFrom, yFrom) = readLine()!!.split(",")
            print("Chose destination of jumping peg by coordinates (x, y): ")
            val (xTo, yTo) = readLine()!!.split(",")
            val dirX = xFrom.toInt()-xTo.toInt()
            val dirY = yFrom.toInt()-yTo.toInt()
            val dir: Direction? = GameUtils.getJumpDirection(dirX, dirY)
            if (dir != null) {
               GameUtils.jump(board.pegs[Pair(xFrom.toInt(), yFrom.toInt())]!!, dir, board)
               move++
            }
            println("Board after move ${move}: \n${board}")
        }
    }
}