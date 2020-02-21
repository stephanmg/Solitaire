/**
 * A board consists out of pegs
 *
 * @param pegs building blocks of board
 * @param pegRow position of (jumped) peg in 2d which created the next board position
 * @param pegCol position of (jumped) peg in 2d which created the next board position
 */
data class Board(val pegs: MutableMap<Pair<Int, Int>, Peg>, val pegRow: Int=-1, val pegCol: Int=-1) {
    override fun toString(): String {
        val builder = StringBuilder()
        for (peg in pegs) { builder.append(peg) }
        return "Board with following pegs\n:$builder"
    }

    fun numPegs(): Int {
        var numPegsInBoard: Int = 0
        for (peg in pegs) {
            if (peg.value.value == 1) {
                numPegsInBoard++
            }
        }
        return numPegsInBoard;
    }
}

/**
 * A board factory creates empty and square boards
 */
class BoardFactory {
    // Empty board
    fun empty(): Board {
        return Board(mutableMapOf())
    }

    // Square board
    fun square(n: Int): Board {
        val board = empty()
        for (i in 1..n) {
            for (j in 1..n) {
                if (i == (n / 2) + 1 && j == (n / 2) + 1) {
                    board.pegs[Pair(i, j)] = Peg(j + (i - 1) * n, 1, i, j)
                } else {
                    board.pegs[Pair(i, j)] = Peg(j + (i - 1) * n, 0, i, j)
                }
            }
        }
        return board
    }
}
