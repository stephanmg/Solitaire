/**
 * @brief A representation of a game board
 * The game board consists out of pegs which may be empty or full or undefined (not part of the board or boundary)
 *
 * @param pegs building blocks of board
 * @param size dimensions of board
 */
data class Board(val pegs: MutableMap<Pair<Int, Int>, Peg>, val size: Int = 0) {
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
        var numPegsInBoard = 0
        for (peg in pegs) if (peg.value.value == 1) numPegsInBoard++
        return numPegsInBoard
    }

    /**
     * @brief deep copy
     * @param pegs
     * @return deep-copied board as Board
     */
    fun copy(pegs: MutableMap<Pair<Int, Int>, Peg> = this.pegs.toMutableMap()) = Board(pegs, this.size)
}

/**
 * @brief A board factory
 * Creates empty and square boards
 */
class BoardFactory {
    private fun empty(size: Int=0): Board {
        return Board(mutableMapOf(), size)
    }

    /**
     * @brief creates a square board
     * The board consists out of n^2-1 pegs and the center peg is removed in the board
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

    private fun star(n: Int, m:Int) {
        throw NotImplementedError("Star boards not yet implemented!")
    }

    private fun user(size: Int) {
        throw NotImplementedError("User-defined boards not yet implemented!")
    }
    
    private fun rectangular(n: Int, m: Int) {
        throw NotImplementedError("Rectangular boards not yet implemented!")
    }

    /**
     * @brief creates a board with a given type
     * @param i max size in x 
     * @param j max size in y
     * @param size total number of pegs
     * @param type board's layout: square, empty, star or user-defined
     */
    fun board(i: Int, j: Int, size: Int, type: BoardType): Board {
        when (type) {
            BoardType.SQUARE -> { square(i) }
            BoardType.STAR -> { star(i, j) }
            BoardType.RECTANGULAR -> { rectangular(i, j) }
            BoardType.EMPTY -> { empty() }
            BoardType.USER -> { user(size) }
        }
        return empty()
    }
}