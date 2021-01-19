import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File

/**
 * BoardTypes
 */
enum class BoardType {
    SQUARE, EMPTY, STAR, USER, RECTANGULAR, CLASSIC
}

/**
 * @brief manages games
 * TODO: Use GameManagmentUtils in the GameManager
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

object GameManagementUtils {
    @JvmStatic
    public fun save(currentBoard: Board) {
      val format = Json { allowStructuredMapKeys = true }
      val string = format.encodeToString(currentBoard)
      val homedir = System.getProperty("user.home")
      File("${homedir}/current_games.sst").printWriter().use { out -> out.println(string) }
    }

    @JvmStatic
    public fun load(): Board? {
      val format = Json { allowStructuredMapKeys = true }
      val homedir = System.getProperty("user.home")
      val board = format.decodeFromString<Board>(File("${homedir}/current_games.sst").readText())
      return board
    }
}