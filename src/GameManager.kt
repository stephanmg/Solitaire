enum class BoardType {
    SQUARE, EMPTY, STAR, USER, RECTANGULAR
}

class GameManager(val i: Int, val j: Int, val size: Int, val type: BoardType) {
    private var board: Board? = null

    public fun create(): Board? {
        if (board == null) {
           board = BoardFactory().board(i, j, size, type)
        }
        return board()
    }

    public fun board(): Board? {
        return board
    }

    public fun clear(): Unit {
        board = null
    }
}