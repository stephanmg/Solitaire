/**
 * A peg
 * @param id unique identifier of the peg
 * @param value value of the peq if present in board 1 else 0
 * @param i offset of peg in row or -1 if not placed on board
 * @param j: offset of peg in column or -1 if not placed on board
 */
data class Peg(val id: Int=-1, var value: Int=0, val i: Int=-1, val j: Int=-1) {
    override fun toString(): String = "Peg with index $id has value $value at position ($i, $j)\n"
}