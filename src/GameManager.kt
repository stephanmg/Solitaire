/**
 * BoardTypes
 */
enum class BoardType {
    SQUARE,
    EMPTY, 
    CLASSIC
}

/**
 * @brief manages games (TODO make this a singleton)
 * 
 * Note: !!! Currently only one game is allowed to be saved and restored !!!
 * 
 * TODO: Keep saved games in a map of file name mapping to the GameState: 
 * Map<FileName/or Index as Int, GameState (serialized)>
 * to allow load and store of multiple games
 * Serialize the list of games in the list and restore in GameManager
 */
class GameManager(val type: BoardType) {
    public var board: Board? = null
    /* TODO: Should use a GameState to capture all game data, 
    e.g. board and number of validMoves -> then serialize
    this with the GameStateutils  */
    val history = mutableListOf<UndoableVisualCommand>()
    
    /**
     * @brief returns the current board (state)
     */
    public fun board(): Board? {
        if (board == null) {
            board = BoardFactory().board(type)
        }
        return board
    }

    /**
     * @brief resets the current board type to start
     */
    public fun reset() {
        board = BoardFactory().board(type)
    }

    /**
     * @brief loads a board
     */
    public fun load(): Board? {
        board = GameStateUtils.load()
        return board
    }

    /**
     * @brief saves a board
     */
    public fun save() {
        GameStateUtils.save(board!!)
    }

    public fun undo() {
        history.last().undo()
        println(board)
        history.removeLast()
    }

    public fun move(command: UndoableVisualCommand) {
        history.add(command)
        command.execute()
        println(board)
    }
}