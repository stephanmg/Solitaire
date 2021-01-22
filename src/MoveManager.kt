/**
 * @brief manages the moves and undoable commands
 */
class MoveManager(val game: PlayableGame) {
    /// Keep a list of performed moves and undoable commands
    val history = mutableListOf<UndoableVisualCommand>()
    val redoHistory = mutableListOf<UndoableVisualCommand>()
    
    /**
     * @brief undo a move in the game
     */
    public fun undo(): Unit {
        if (history.count() > 0) {
           redoHistory.add(history.last())
           history.last().undo()
           history.removeLast()
        }
    }

    /**
     * @brief redo a move in the game
     */
    public fun redo(): Unit {
        if (redoHistory.count() > 0) {
            history.add(redoHistory.last())
            redoHistory.last().execute()
            redoHistory.removeLast()
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