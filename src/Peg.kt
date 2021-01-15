/**
 * PegTypes
 */
enum class PegType {
    EMPTY, FULL, BOUNDARY
}

/**
 * A peg
 * @param id unique identifier of the peg
 * @param value value of the peq if present in board 1 else 0
 * @param i offset of peg in row or -1 if not placed on board
 * @param j: offset of peg in column or -1 if not placed on board
 */
data class Peg(
    private val id: Int=-1,
    var value: Int=0, /* TODO: replace Int with an enum: EMPTY,FULL,BOUNDARY */
    val i: Int=-1,
    val j: Int=-1
) {
    override fun toString() = "Peg with index $id has value $value at position ($i, $j)\n"
    fun available() = value != 0
}