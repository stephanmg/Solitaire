import kotlinx.serialization.Serializable

@Serializable
data class GameState(val board: Board, val moves: Int);

/**
 * @brief utilities for managing the game state
 */
object GameStateUtils {
    @JvmStatic
    public fun empty(): GameState {
        return GameState(BoardFactory().empty(), 0)
    }
}