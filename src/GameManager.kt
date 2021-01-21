/**
 * BoardTypes
 */
enum class BoardType {
    SQUARE,
    EMPTY, 
    CLASSIC
}

/**
 * @brief manages games 
 * Note: !!! Currently only one game is allowed to be saved and restored !!!
 */
class GameManager { 
    val history = mutableListOf<UndoableVisualCommand>()
    
    /**
     * @brief reset the 'active' game's board
     * @param game
     */
    public fun reset(game: PlayableGame) : Unit {
        game.reset()
    }

    /**
     * @brief loads the game state into the 'active' game
     * History is being cleared for consistency for now.
     */
    public fun load(game: PlayableGame): Unit {
        game.gameState = GameStateUtils.load()
        history.clear()
    }

    /**
     * @brief stores the game state of the 'active' game
     * @brief game
     */
    public fun save(game: PlayableGame): Unit {
        GameStateUtils.save(game.gameState)
    }

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
     * @brief redos a move in the game
     */
    public fun redo() {
        /* TODO: Could use Memento pattern to support redo operation and use GameState to save state */
    }

    /**
     * @brief perform move on board
     * @param command
     */
    public fun execute(command: UndoableVisualCommand) {
        history.add(command)
        command.execute()
    }
}