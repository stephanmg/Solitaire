/**
 * @brief move peg east in current game 
 * @param game
 * @param fromPosX
 * @param fromPosY
 */
/// TODO: copy() does not do a deep copy!!! so UNDO not possible refers to same board: Save the state, coudl also use Memento
class MoveEast(var game: PlayableGame, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    val oldBoard = game.gameState!!.board.copy()

    /**
     * @see Command.execute()
     */
    override fun execute() {
        GameUtils.jump(game.gameState!!.board.pegs[Pair(fromPosX, fromPosY)]!!, Direction.EAST, game.gameState!!.board)
    }

    /**
     * @see UndoableVisualCommand.undo()
     */
    override fun undo() {
        game.gameState = GameState(game.gameState!!.board, game.gameState!!.type, game.gameState!!.moves)
    }
}

/**
 * @brief move peg west in current game
 * @param game
 * @param fromPosX
 * @param fromPosY
 */
class MoveWest(var game: PlayableGame, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    val oldBoard = game.gameState!!.board.copy()

    /**
     * @see Command.execute()
     */
    override fun execute() {
        GameUtils.jump(game.gameState!!.board.pegs[Pair(fromPosX, fromPosY)]!!, Direction.WEST, game.gameState!!.board)
    }

    /**
     * @see UndoableVisualCommand.undo()
     */
    override fun undo() {
        game.gameState = GameState(game.gameState!!.board, game.gameState!!.type, game.gameState!!.moves)
    }
}

/**
 * @brief move peg south in current game
 * @param game
 * @param fromPosX
 * @param fromPosY
 */
class MoveSouth(var game: PlayableGame, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    val oldBoard = game.gameState!!.board.copy()

    /**
     * @see Command.execute()
     */
    override fun execute() {
        GameUtils.jump(game.gameState!!.board.pegs[Pair(fromPosX, fromPosY)]!!, Direction.SOUTH, game.gameState!!.board)
    }

    /**
     * @see UndoableVisualCommand.undo()
     */
    override fun undo() {
        game.gameState = GameState(game.gameState!!.board, game.gameState!!.type, game.gameState!!.moves)
    }
}

/**
 * @brief move peg north in current game
 * @param game
 * @param fromPosX
 * @param fromPosY
 */
class MoveNorth(var game: PlayableGame, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    val oldBoard = game.gameState!!.board.copy()

    /**
     * @see Command.execute()
     */
    override fun execute() {
        GameUtils.jump(game.gameState!!.board.pegs[Pair(fromPosX, fromPosY)]!!, Direction.NORTH, game.gameState!!.board)
    }

    /**
     * @see UndoableVisualCommand.undo()
     */
    override fun undo() {
        game.gameState = GameState(game.gameState!!.board, game.gameState!!.type, game.gameState!!.moves)
    }
}

/**
 * @brief reset the game
 * @param game
 */
class Reset(var game: PlayableGame) : Command {
    /**
     * @see Command.execute()
     */
    override fun execute() {
        game.gameState = GameState(BoardFactory.board(game.gameState!!.type), game.gameState!!.type, game.gameState!!.moves)
    }
}