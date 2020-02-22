/**
 * A board consists out of pegs
 *
 * @param pegs building blocks of board
 * @param pegRow position of (jumped) peg in 2d which created the next board position
 * @param pegCol position of (jumped) peg in 2d which created the next board position
 * @param size dimensions of board
 */
data class Board(val pegs: MutableMap<Pair<Int, Int>, Peg>, val pegRow: Int=-1, val pegCol: Int=-1, val size: Int=0) {
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
