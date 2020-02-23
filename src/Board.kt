/**
 * A board consists out of pegs.
 *
 * @param pegs building blocks of board
 * @param pegRow position of (jumped) peg in 2d which created the next board position
 * @param pegCol position of (jumped) peg in 2d which created the next board position
 * @param size dimensions of board
 */
data class Board(val pegs: MutableMap<Pair<Int, Int>, Peg>, val pegRow: Int=-1, val pegCol: Int=-1, val size: Int=0) {
    /**
     * @brief toString()
     * @see Object.toString()
     */
    override fun toString(): String {
        val builder = StringBuilder()
        for (peg in pegs) { builder.append(peg) }
        return "Board with following pegs\n:$builder"
    }

    /**
     * @brief get number of pegs in board
     * @return number of pegs in board as Int
     */
    fun numPegs(): Int {
        var numPegsInBoard: Int = 0
        for (peg in pegs) {
            if (peg.value.value == 1) {
                numPegsInBoard++
            }
        }
        return numPegsInBoard;
    }

    /**
     * @brief deep copy
     * @param pegs
     * @return deep-copied board as Board
     */
    fun copy(pegs: MutableMap<Pair<Int, Int>, Peg> = this.pegs.toMutableMap()) =
        Board(pegs, this.pegRow, this.pegCol, this.size)
}

/**
 * A board factory creates empty and square boards
 */
class BoardFactory {
    /**
     * @brief creates an empty board
     * @param pegCol
     * @param pegRow
     * @param size
     * @return board
     */
    private fun empty(pegCol: Int=-1, pegRow:Int=-1, size: Int=0): Board {
        return Board(mutableMapOf(), pegCol, pegRow, size)
    }

    /**
     * @brief creates a square board
     * @param n size of board
     * @return board
     */
    fun square(n: Int): Board {
        val board = empty()
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == ((n-1) / 2)  && j == ((n-1) / 2)) {
                    println("Empty peg at: $i,$j")
                    board.pegs[Pair(i, j)] = Peg(j + i * n, 0, i, j)
                } else {
                    board.pegs[Pair(i, j)] = Peg(j + i * n, 1, i, j)
                }
            }
        }
        return board
    }
}

