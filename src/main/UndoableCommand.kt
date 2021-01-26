/**
 * @brief UndoableCommand interface
 * All commands implementing this interface are deemed undoable
 */
interface UndoableCommand : Command {
    /**
     * @brief undo a command
     */
    fun undo(): Unit
}