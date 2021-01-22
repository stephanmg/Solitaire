/**
 * @brief manages the moves and undoable commands
 * Note: History of commands is not serialized. Shall we save this too?
 */
class MoveManager(val game: PlayableGame) {
    /// Keep a list of performed moves and undoable commands
    val history = mutableListOf<UndoableVisualCommand>()
    
    /**
     * @brief undo a move in the game
     */
    public fun undo() {
        if (history.count() > 0) {
           history.last().undo()
           history.removeLast()
        }
    }

    /**
     * @brief perform moves and valid undoable visual commands
     * @param command
     */
    public fun execute(command: UndoableVisualCommand) {
        history.add(command)
        command.execute()
    }

    /**
     * @brief perform a move command explictly
     * @param fromPosX
     * @param fromPosY
     * @param direction
     */
    public fun move(fromPosX: Int, fromPosY: Int, direction: Direction) {
        GameUtils.move(fromPosX, fromPosY, direction, this)
    }
}