/**
 * @brief possible visual commands which can be undone
 */
interface UndoableVisualCommand : Command {
    fun undo()
}