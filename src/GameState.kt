import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File

/**
 * @brief represents a game state which should be serialized
 * @param board current board configuration
 * @param moves number of moves the user played so far
 * @param type the board's type
 */
@Serializable
data class GameState(val board: Board, val type: BoardType, val moves: Int);

/**
 * @brief a playable game
 * @param type
 */
class PlayableGame(val type: BoardType) {
  var gameState: GameState? = null

  init {
    gameState = GameState(BoardFactory().board(type), type, 0)
  }
}


/**
 * @brief utility functions for managing the game state
 */
object GameStateUtils {
    /**
     * @brief serialize a board
     * @param currentBoard
     */
    @JvmStatic
    public fun save(gameState: GameState?) {
      val format = Json { allowStructuredMapKeys = true; isLenient = true }
      val string = format.encodeToString(gameState)
      val homedir = System.getProperty("user.home")
      File("${homedir}/current_games.sst").printWriter().use { out -> out.println(string) }
    }

    /**
     * @brief deserialize a board
     * @return board
     */
    @JvmStatic
    public fun load(): GameState? {
      val format = Json { allowStructuredMapKeys = true; isLenient = true }
      val homedir = System.getProperty("user.home")
      val gameState = format.decodeFromString<GameState>(File("${homedir}/current_games.sst").readText())
      return gameState
    }
}