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
 * @brief utility functions for managing the game state
 * TODO: Should use GameState (encapsulates baord and validMoves) not only Board
 */
object GameStateUtils {
    /**
     * @brief serialize a board
     * @param currentBoard
     */
    @JvmStatic
    public fun save(currentBoard: Board) {
      val format = Json { allowStructuredMapKeys = true; isLenient = true }
      val string = format.encodeToString(currentBoard)
      val homedir = System.getProperty("user.home")
      File("${homedir}/current_games.sst").printWriter().use { out -> out.println(string) }
    }

    /**
     * @brief deserialize a board
     * @return board
     */
    @JvmStatic
    public fun load(): Board? {
      val format = Json { allowStructuredMapKeys = true; isLenient = true }
      val homedir = System.getProperty("user.home")
      val board = format.decodeFromString<Board>(File("${homedir}/current_games.sst").readText())
      return board
    }
}