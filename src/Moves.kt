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

class MoveRight(val gameManager: GameManager, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    val oldBoard = gameManager.board()!!.copy()
    override fun execute() {
        GameUtils.jump(gameManager.board()!!.pegs[Pair(fromPosX, fromPosY)]!!, Game.Direction.WEST, gameManager.board()!!)
    }

    override fun undo() {
        gameManager.board = oldBoard
    }
}

class MoveTop(val gameManager: GameManager, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    val oldBoard = gameManager.board()!!.copy()
    override fun execute() {
        GameUtils.jump(gameManager.board()!!.pegs[Pair(fromPosX, fromPosY)]!!, Game.Direction.NORTH, gameManager.board()!!)
    }

    override fun undo() {
        gameManager.board = oldBoard
    }
}

class MoveBottom(val gameManager: GameManager, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    val oldBoard = gameManager.board()!!.copy()

    override fun execute() {
        GameUtils.jump(gameManager.board()!!.pegs[Pair(fromPosX, fromPosY)]!!, Game.Direction.SOUTH, gameManager.board()!!)
    }

    override fun undo() {
        gameManager.board = oldBoard
    }
}