/**
 * @brief manages the moves and undoable commands
 * Note: History of commands is not serialized. Shall we serialize this to allow replay?
 */
class MoveManager(val game: PlayableGame) {
    /// Keep a list of performed moves and undoable commands
    val history = mutableListOf<UndoableVisualCommand>()
    
    /**
     * @brief undo a move in the game
     */
    public fun undo(): Unit {
        if (history.count() > 0) {
           history.last().undo()
           history.removeLast()
        }
    }

    /**
     * @brief perform moves and valid undoable visual commands
     * @param command
     */
    public fun execute(command: UndoableVisualCommand): Unit {
        history.add(command)
        command.execute()
    }

    /**
     * @brief perform a move command explictly
     * @param fromPosX
     * @param fromPosY
     * @param direction
     */
    public fun move(fromPosX: Int, fromPosY: Int, direction: Direction): Unit {
        GameUtils.move(fromPosX, fromPosY, direction, this)
    }
}