import kotlinx.serialization.Serializable

@Serializable
data class GameState(val board: Board, val moves: Int);

object GameStateUtils {
    @JvmStatic
    public fun empty(): GameState {
        return GameState(BoardFactory().empty(), 0)
    }
}