/**
 * BoardTypes
 */
enum class BoardType {
    SQUARE, EMPTY, STAR, USER, RECTANGULAR
}

/**
 * @brief manages games
 */
class GameManager(val i: Int, val j: Int, val size: Int, val type: BoardType) {
    private var board: Board? = null
    private val games: Collection<Board> = emptyList()

    /**
     * @brief create a new board if no game is actively played yet
     */
    public fun create(): Board? {
        if (board == null) {
           board = BoardFactory().board(i, j, size, type)
        }
        return board
    }

    /**
     * @brief return the current board (in the current game)
     */
    public fun board(): Board? {
        return board
    }

    /**
     * @brief restarts the current board (in the current game)
     */
    public fun restart(): Unit {
        throw NotImplementedError("Restart not yet implemented!")
    }

    /**
     * @brief saves a game state
     * Find the board in the list, and save it's state to the index
     */
    public fun save(): Unit {
        throw NotImplementedError("Save not yet implemented!")
    }

    /**
     * @brief loads a game state by index
     */
    public fun load(index: Int): Board? {
        throw NotImplementedError("Load not yet implemented!")
    }
}