import kotlinx.serialization.Serializable;

/**
 * @brief possible types of pegs in a board
 */
enum class PegType {
    EMPTY, /* hole in board */
    FULL,  /* peg present at hole */
    BOUNDARY /* outside valid board range */
}

/**
 * @brief representation of a peg
 * @param id unique identifier of the peg
 * @param value value of the peg indicating presence (FULL) or absence (EMPTY) in board location
 * @param i offset of peg in row or -1 if not placed on board
 * @param j: offset of peg in column or -1 if not placed on board
 */
@Serializable
data class Peg(private val id: Int=-1, var value: PegType=PegType.EMPTY, val i: Int=-1, val j: Int=-1) {
    /**
     * @brief string representation of a peg
     * @see Object.toString()
     * @return string representing the peg
     */
    override fun toString(): String = "${if (isInitialized()) "(Warning: Not initialized)" else ""}Peg with index $id has value $value at position ($i, $j)\n"

    /**
     * @brief check if peg is available at hole
     * @return true if peg is available or false if hole or boundary
     */
    fun available(): Boolean {
        return when (value) {
            PegType.FULL -> true
            else -> false 
        }
    }

    /**
     * @brief check if peg has been initialized properly
     * @return true if fully initialized otherwise false
     */
    private fun isInitialized(): Boolean {
        return (i == -1 && j == -1 && id == -1)
    }

    /**
     * @brief deep copy of a peg
     * @return deep-copied peg
     */
    fun copy() = Peg(this.id, this.value, this.i, this.j)

}