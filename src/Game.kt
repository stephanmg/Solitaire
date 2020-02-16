/**
 * Game
 *
 * This will be used to solve the Solitaire problem with a DFS approach and provide an UI
 */
class Game {
    val currentBoard: Board = BoardFactory().empty()
    val prevBoard: Board = BoardFactory().empty()

    /**
     * DFS solve
     *
     * Will be used during interactive game play
     */
    private fun dfs_solve() {

    }

    /**
     * Play interactively
     *
     * Let a user play (Maybe frontend in React?) and invoke dfs_solve each time to
     * indicate if solution still possible or if the user has lost the game already
     */
    fun play() {

    }
}

