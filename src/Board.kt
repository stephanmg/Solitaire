import kotlinx.serialization.Serializable;

/**
 * @brief supported solitaire board types
 * A square board, the classic board and an empty board
 */
enum class BoardType {
    SQUARE, /* SQUARE BOARD */
    EMPTY, /* EMPTY BOARD */ 
    CLASSIC /* CLASSIC BOARD */
}

/**
 * @brief representation of the solitaire board
 * The game board consists out of pegs and holes
 * A peg is present (1), a hole is present (0)
 * and we are outside the board boundary (-1)
 *
 * @param pegs building blocks of board
 * @param size dimensions (x and y) of board
 * 
 * Layout:
 * |---------------------------------------|
 * | 1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1|
 * |---------------------------------------|
 * |-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1|
 * |---------------------------------------|
 * |-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1|
 * |---------------------------------------|
 * | 1 |  1 |  1 | 1 | 1 | 1 |  1 |  1 |  1|
 * |---------------------------------------|
 * | 1 |  1 |  1 | 1 | 0 | 1 |  1 |  1 |  1|
 * |---------------------------------------|
 * | 1 |  1 |  1 | 1 | 1 | 1 |  1 |  1 |  1|
 * |---------------------------------------|
 * |-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1|
 * |---------------------------------------|
 * |-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1|
 * |---------------------------------------|
 * |-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1|
 * |---------------------------------------|
 */
@Serializable
data class Board(val pegs: MutableMap<Pair<Int, Int>, Peg>, val moves: Int = 0) {
    /**
     * @brief string representation of a board
     * @see Object.toString()
     */
    override fun toString(): String {
        val builder = StringBuilder()
        for (peg in pegs) { builder.append(peg) }
        return "Board with following pegs:\n$builder"
    }

    /**
     * @brief get number of pegs in board
     * @return number of pegs in board as Int
     */
    fun numPegs(): Int {
        var numPegsInBoard = 0
        for (peg in pegs) if (peg.value.available()) numPegsInBoard++
        return numPegsInBoard
    }

    /**
     * @brief deep copy
     * @param pegs
     * @return deep-copied board as Board
     */
    fun copy(pegs: MutableMap<Pair<Int, Int>, Peg> = this.pegs.toMutableMap()) = Board(pegs)
}

/**
 * @brief a factory to create solitaire boards
 */
object BoardFactory {
    /**
     * @brief create an empty board
     * @return empty board
     */
    @JvmStatic
    fun empty(): Board {
        return Board(mutableMapOf())
    }

    /**
     * @brief create a square 80-hole board
     * @param n size of board
     * @return square board
     */
    @JvmStatic
    fun square(n: Int=9): Board {
        val board = empty()
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == ((n-1) / 2)  && j == ((n-1) / 2)) {
                    println("Empty peg at coordinates (x, y): $i, $j")
                    board.pegs[Pair(i, j)] = Peg(j + i * n, PegType.EMPTY, i, j)
                } else {
                    board.pegs[Pair(i, j)] = Peg(j + i * n, PegType.FULL, i, j)
                }
            }
        }
        return board
    }

    /**
     * @brief create classic 33-holes board
     * @return classic board
     */
    @JvmStatic
    public fun classic(): Board {
        val board = empty()
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                if (i < 3 && j < 3) /* upper left border */
                   board.pegs[Pair(i, j)] = Peg(j + i * 9, PegType.BOUNDARY, i, j)
                else if (i < 3 && j > 5) /* lower left border */
                   board.pegs[Pair(i, j)] = Peg(j + i * 9, PegType.BOUNDARY, i, j)
                else if (i > 5 && j < 3) /* upper right border */
                   board.pegs[Pair(i, j)] = Peg(j + i * 9, PegType.BOUNDARY, i, j)
                else if (i > 5 && j > 5) /* lower right border */
                   board.pegs[Pair(i, j)] = Peg(j + i * 9, PegType.BOUNDARY, i, j)
                else if (i == ((9-1) / 2)  && j == ((9-1) / 2))  /* center hole empty */
                   board.pegs[Pair(i, j)] = Peg(j + i * 9, PegType.EMPTY, i, j)
                else /* peg in hole */
                   board.pegs[Pair(i, j)] = Peg(j + i * 9, PegType.FULL, i, j)
            }
        }
        return board
    }

    /**
     * @brief create a board with a given board type
     * @see BoardType
     * @param i max size in x 
     * @param j max size in y
     * @param size total number of pegs
     * @param type board's layout: square or classic
     * @return board
     */
    @JvmStatic
    fun board(type: BoardType): Board {
        return when (type) {
            BoardType.SQUARE -> square() 
            BoardType.CLASSIC -> classic() 
            else -> empty()
        } 
    }
}