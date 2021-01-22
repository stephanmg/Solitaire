/**
 * @brief controls the game (and thus moves and commands)
 * Note: !!! Currently only one game is allowed to be saved and restored !!!
 */
class GameController(val game: PlayableGame) {
    /// Manages undoable commands
    val moveManager: MoveManager = MoveManager(game)

    /**
     * @brief reset the 'active' game's board
     */
    public fun reset() : Unit {
        game.reset()
    }

    /**
     * @brief loads the game state into the 'active' game
     * History is being cleared for consistency for now.
     */
    public fun load(): Unit {
        game.gameState = GameStateUtils.load()
        moveManager.history.clear()
    }

    /**
     * @brief stores the game state of the 'active' game
     * @brief game
     */
    public fun save(): Unit {
        GameStateUtils.save(game.gameState)
    }

    /**
     * @brief move west
     * @param fromPosX
     * @param fromPosY
     */
    public fun moveWest(fromPosX: Int, fromPosY: Int): Unit {
        moveManager.move(fromPosX, fromPosY, Direction.WEST)
    }

    /**
     * @brief move east
     * @param fromPosX
     * @param fromPosY
     */
    public fun moveEast(fromPosX: Int, fromPosY: Int): Unit {
        moveManager.move(fromPosX, fromPosY, Direction.EAST)
    }

    /**
     * @brief move south
     * @param fromPosX
     * @param fromPosY
     */
    public fun moveSouth(fromPosX: Int, fromPosY: Int): Unit {
        moveManager.move(fromPosX, fromPosY, Direction.SOUTH)
    }

    /**
     * @brief move north
     * @param fromPosX
     * @param fromPosY
     */
    public fun moveNorth(fromPosX: Int, fromPosY: Int): Unit {
        moveManager.move(fromPosX, fromPosY, Direction.NORTH)
    }

    /**
     * @brief undo a visual undoable move
     */
    public fun undo(): Unit {
        moveManager.undo()
    }
}