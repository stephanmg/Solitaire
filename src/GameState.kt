import kotlinx.serialization.Serializable

/**
 * @brief represents a game state which should be serialized
 * @param board current board configuration
 * @param moves number of moves the user played so far
 */
@Serializable
data class GameState(val board: Board, val moves: Int);

/**
 * @brief utilitiy functions for managing the game state
 */
object GameStateUtils {
    /**
     * @brief creates and empty state to serialize
     */
    @JvmStatic
    public fun empty(): GameState {
        return GameState(BoardFactory().empty(), 0)
    }
}