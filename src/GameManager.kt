import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File

/**
 * BoardTypes
 */
enum class BoardType {
    SQUARE,
    EMPTY, 
    STAR, 
    USER, 
    RECTANGULAR, 
    CLASSIC
}

/**
 * @brief manages games
 * TODO: Use GameManagmentUtils in the GameManager
 * TODO: Should use a GameState to capture all game data, e.g. board and number of validMoves -> then serialize
 * TODO: Keep saved games in a map of file name mapping to the GameState: Map<FileName/or Index as Int, GameState (serialized)>
 *       to allow load and store of multiple games
 */
class GameManager(val i: Int, val j: Int, val size: Int, val type: BoardType) {
    private var board: Board? = null
    private val games: Collection<Board> = emptyList()

    /**
     * @brief create a new board if no game is actively played yet
     */
    public fun create(): Board? {
        if (board == null) {
           board = BoardFactory().board(i, j, size, type)
        }
        return board
    }

    /**
     * @brief return the current board (in the current game)
     */
    public fun board(): Board? {
        return board
    }

    /**
     * @brief restarts the current board (in the current game)
     */
    public fun restart(): Unit {
        throw NotImplementedError("Restart not yet implemented!")
    }
}

/**
 * @brief utilities for serialization and deserialization of a game state
 * TODO: Move these into GameState.kt -> GameManager shall use the GameStateUtilities to manage multiple games
 */
object GameManagementUtils {
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