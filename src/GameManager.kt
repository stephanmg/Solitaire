/**
 * BoardTypes
 */
enum class BoardType {
    SQUARE,
    EMPTY, 
    CLASSIC
}

/**
 * @brief manages games 
 * Note: !!! Currently only one game is allowed to be saved and restored !!!
 * TODO: Make this a singleton? Support multiple save games?
 */
class GameManager(val type: BoardType) {
    public var board: Board? = null
    /* TODO: Should use a GameState to capture all game data, 
        e.g. board and number of validMoves -> then serialize
        this with the GameStateutils and check if board wins */
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

    /**
     * @brief undo a move
     */
    public fun undo() {
        if (history.count() > 0) {
           history.last().undo()
           println(board)
           history.removeLast()
        }
    }

    /**
     * @brief redo a move
     */
    public fun redo() {
        /* TODO: Use Memento pattern to support redo operation */
    }

    /**
     * @brief perform move on board
     */
    public fun move(command: UndoableVisualCommand) {
        history.add(command)
        command.execute()
        println(board)
    }
}