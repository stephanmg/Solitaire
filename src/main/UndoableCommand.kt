/**
 * @brief UndoableCommand interface
 * All commands implementing this interface are deemed undoable
 */
interface UndoableCommand : Command {
    fun undo(): Unit
}