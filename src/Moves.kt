/**
 * @brief move west
 */
class MoveLeft(val gameManager: GameManager, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    /// TODO: copy() does not do a deep copy!!! so UNDO not possible refers to same board
    val oldBoard = gameManager.board()!!.copy()

    override fun execute() {
        GameUtils.jump(gameManager.board()!!.pegs[Pair(fromPosX, fromPosY)]!!, Game.Direction.EAST, gameManager.board()!!)
    }

    override fun undo() {
        gameManager.board = oldBoard
    }
}

/**
 * @brief move east
 */
class MoveRight(val gameManager: GameManager, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    val oldBoard = gameManager.board()!!.copy()
    override fun execute() {
        GameUtils.jump(gameManager.board()!!.pegs[Pair(fromPosX, fromPosY)]!!, Game.Direction.WEST, gameManager.board()!!)
    }

    override fun undo() {
        gameManager.board = oldBoard
    }
}

/**
 * @brief move north
 */
class MoveTop(val gameManager: GameManager, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    val oldBoard = gameManager.board()!!.copy()
    override fun execute() {
        GameUtils.jump(gameManager.board()!!.pegs[Pair(fromPosX, fromPosY)]!!, Game.Direction.NORTH, gameManager.board()!!)
    }

    override fun undo() {
        gameManager.board = oldBoard
    }
}

/**
 * @brief move south
 */
class MoveBottom(val gameManager: GameManager, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    val oldBoard = gameManager.board()!!.copy()

    override fun execute() {
        GameUtils.jump(gameManager.board()!!.pegs[Pair(fromPosX, fromPosY)]!!, Game.Direction.SOUTH, gameManager.board()!!)
    }

    override fun undo() {
        gameManager.board = oldBoard
    }
}