import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File

/**
 * @brief represents a game state which should be serialized
 * @param board current board configuration
 * @param type the board's type
 * @param moves number of moves the user played so far
 */
@Serializable
data class GameState(val board: Board, val type: BoardType, val moves: Int)

/**
 * @brief a playable game
 * @param type of board
 */
class PlayableGame(val type: BoardType) {
  // State of the current game
  var gameState: GameState? = null
  // Reset the current game
  val reset: Reset = Reset(this)

  /**
   * @brief reset the current game
   */
  public fun reset(): Unit {
     reset.execute()
  }

  init {
    gameState = GameState(BoardFactory.board(type), type, 0)
  }
}

/**
 * @brief utility functions for managing the game state's serialization/deserialization
 * Saves a game to a pre-defined location and restores from that location
 */
object GameStateUtils {
    /**
     * @brief serialize a board / saves a board
     * @param currentBoard
     */
    @JvmStatic
    public fun save(gameState: GameState?): Unit {
      val format = Json { allowStructuredMapKeys = true; isLenient = true }
      val string = format.encodeToString(gameState)
      val homedir = System.getProperty("user.home")
      File("${homedir}/current_games.sst").printWriter().use { out -> out.println(string) }
    }

    /**
     * @brief deserialize a board / loads a board
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