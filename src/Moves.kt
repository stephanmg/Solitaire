/**
 * @brief move east
 */
class MoveEast(var game: PlayableGame, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    /// TODO: copy() does not do a deep copy!!! so UNDO not possible refers to same board: Save the state, coudl also use Memento
    val oldBoard = game.gameState!!.board.copy()

    override fun execute() {
        GameUtils.jump(game.gameState!!.board.pegs[Pair(fromPosX, fromPosY)]!!, Game.Direction.EAST, game.gameState!!.board)
    }

    override fun undo() {
        game.gameState = GameState(game.gameState!!.board, game.gameState!!.type, game.gameState!!.moves)
    }
}

/**
 * @brief move west
 */
class MoveWest(var game: PlayableGame, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    val oldBoard = game.gameState!!.board.copy()

    override fun execute() {
        GameUtils.jump(game.gameState!!.board.pegs[Pair(fromPosX, fromPosY)]!!, Game.Direction.WEST, game.gameState!!.board)
    }

    override fun undo() {
        game.gameState = GameState(game.gameState!!.board, game.gameState!!.type, game.gameState!!.moves)
    }
}

/**
 * @brief move south
 */
class MoveSouth(var game: PlayableGame, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    val oldBoard = game.gameState!!.board.copy()

    override fun execute() {
        GameUtils.jump(game.gameState!!.board.pegs[Pair(fromPosX, fromPosY)]!!, Game.Direction.SOUTH, game.gameState!!.board)
    }

    override fun undo() {
        game.gameState = GameState(game.gameState!!.board, game.gameState!!.type, game.gameState!!.moves)
    }
}

/**
 * @brief move north
 */
class MoveNorth(var game: PlayableGame, val fromPosX: Int, val fromPosY: Int) : UndoableVisualCommand {
    val oldBoard = game.gameState!!.board.copy()

    override fun execute() {
        GameUtils.jump(game.gameState!!.board.pegs[Pair(fromPosX, fromPosY)]!!, Game.Direction.NORTH, game.gameState!!.board)
    }

    override fun undo() {
        game.gameState = GameState(game.gameState!!.board, game.gameState!!.type, game.gameState!!.moves)
    }
}

/**
 * @brief reset the game
 */
class Reset(var game: PlayableGame) : Command {
    override fun execute() {
        game.gameState = GameState(BoardFactory.board(game.gameState!!.type), game.gameState!!.type, game.gameState!!.moves)
    }
}