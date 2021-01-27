import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.layout.*;
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.control.*
import javafx.scene.paint.Color
import javafx.stage.Popup
import javafx.stage.Stage

/**
 * @brief Set up the JavaFX GUI 
 */
class GUI : Application() {
    private var canStillWin = true
    private val baseStyle = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
    /// TODO: Improve alignment
    private val sizeX = 250.0*2+100
    private val sizeY = 260.0*2
    private val moveLabelText: String = "Number of moves: 0"

    /**
     * @brief start the stage
     * @param primaryStage
     */
    override fun start(primaryStage: Stage) {
        val root = BorderPane()
        val scene = Scene(root, sizeX, sizeY)
        var gridPane = GridPane()
        var curBtn: Button? = null
        var nextBtn: Button?
        var count = 0
        var fromPosX: Int = -1
        var fromPosY: Int = -1
        val moveLabel = Label(moveLabelText)
        var validMoves = 0
        var gameController = GameController(PlayableGame(BoardType.CLASSIC))

        /**
         * @brief game logic 
         * @param btn
         * @param i
         * @param j
         */
        val callback = fun(btn: Button, i: Int, j: Int) {
            btn.style = "-fx-background-color: beige; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
            if ((count % 2) == 0) {
                curBtn = btn
                nextBtn = null
                fromPosX = i
                fromPosY = j
            } else {
                /// TODO: Re-add the label
                // canStillWin = Game().solveDfs(currentBoard)
                val jumpToX: Int = fromPosX - i
                val jumpToY: Int = fromPosY - j
                nextBtn = btn
                val dir: Direction? = GameUtils.getJumpDirection(jumpToX, jumpToY)
                if (dir == null) {
                    /// if direction is invalid... do nothing
                    GUIUtils.stylize(curBtn, nextBtn)
                    curBtn = nextBtn
                   // else check if peg can legally jump in the current board in given direction
                } else if (GameUtils.canJump(gameController.game.gameState!!.board.pegs[Pair(fromPosX, fromPosY)]!!, dir, gameController.game.gameState!!.board)) {
                    // i.) then do the jump in the board
                    gameController.moveManager.move(fromPosX, fromPosY, dir)

                    // ii.) and draw the jump we made in the board's GUI as well (update game)
                    GUIUtils.draw(gridPane, gameController.game)
                    curBtn!!.graphic = null;
                    nextBtn!!.graphic = GUIUtils.createPegImage()
                    GUIUtils.stylize(curBtn, nextBtn)

                    // iii.) increment number of valid moves
                    validMoves++
                    gameController.game.gameState = GameState(gameController.game.gameState!!.board, gameController.game.gameState!!.type, validMoves)
                // otherwise new trial
                } else {
                    GUIUtils.stylize(curBtn, nextBtn)
                    curBtn = nextBtn
                }
            } 
            // increment click count (each 2 clicks check for a move)
            count++

            /// set number of valid moves label
            moveLabel.minWidth = 80.0
            moveLabel.minHeight = 50.0
            moveLabel.text = "Number of moves: ${validMoves}"

            /// indicate loss or win
            val won: Boolean = GameUtils.checkWon(gameController.game)
            val lost: Boolean = GameUtils.checkGameOver(gameController.game.gameState!!.board)
            if (won || lost) {
                // set background
                val label = Label()
                label.minWidth = 80.0
                label.minHeight = 50.0
                val popup = Popup()
                label.style = " -fx-background-color: #f8f8ff; "
                // won
                if (won) { label.text = "Won!"; label.textFill = Color.web("#00ff00") }
                // game over
                if (GameUtils.checkGameOver(gameController.game.gameState!!.board)) { label.text = "Game over!"; label.textFill = Color.web("#ff0000"); canStillWin = false }
                popup.content.add(label)
                popup.show(primaryStage)
            }
        }

        /**
         * @brief configure board's view
         */
        val configureBoardView = fun() {
            gridPane = GridPane()
            drawBoard(gridPane, gameController.game.gameState!!.board, callback)
            root.center=gridPane
            gridPane.style = "-fx-grid-lines-visible: true;"
        }

        /**
         * @brief create board
         * @param text
         */
        val createBoard = fun(text: String) {
            when (text) {
                "Classic" -> gameController = GameController(PlayableGame(BoardType.CLASSIC))
                "Square" -> gameController = GameController(PlayableGame(BoardType.SQUARE))
            } 

            /// reset number of moves
            validMoves = 0
            moveLabel.text = moveLabelText

            /// configure board
            configureBoardView()
        }

        /**
         * @brief manage the game
         * @param text
         */
        val manageGame = fun(text: String) {
            val reinit = fun() {
                gameController.game.gameState!!.board.pegs.forEach { 
                    /// TODO: If other board type is loaded we need to change gridpane: gridPane might be too big or too large (buttons)
                    /// Encode board type in gameController serialization, then check in gameManger if same board type loaded or not, if not need to call drawBoard and update gridPane
                    var btn = GUIUtils.getNodeFromGridPane(gridPane, it.value.i, it.value.j) as Button
                    btn.graphic = if (it.value.available()) GUIUtils.createPegImage() else null
                    count = 0
                    validMoves = gameController.game.gameState!!.moves
                    moveLabel.text = "Number of moves: ${validMoves}"
                }
            }

            when (text) {
                "Save" -> {
                    gameController.save()
                }
                "Load" -> {
                    gameController.load() 
                    reinit()
                }
                "Reset" -> {
                    gameController.reset()
                    validMoves = 0
                    moveLabel.text = "Number of moves: 0"
                    reinit()
                }
                "Undo" -> {
                    gameController.undo()
                    reinit()
                }
                "Redo" -> {
                    gameController.redo()
                    reinit()
                }
            }
        }

        val menuBar = MenuBar()
        val menuGame = Menu("Game")
        val menuBoards = Menu("Boards")
        val menuConfigure = Menu("Configure")
        val menuHelp = Menu("Help")
        val menuAbout = Menu("About")

        menuGame.getItems().add(MenuItem("Save"))
        menuGame.getItems().add(MenuItem("Load"))
        menuGame.getItems().add(MenuItem("Reset"))
        menuGame.getItems().add(MenuItem("Undo"))
        menuGame.getItems().add(MenuItem("Redo"))

        menuBoards.getItems().add(MenuItem("Classic"))
        menuBoards.getItems().add(MenuItem("Square"))

        menuBar.getMenus().add(menuGame)
        menuBar.getMenus().add(menuBoards)
        menuBar.getMenus().add(menuHelp)
        menuBar.getMenus().add(menuAbout)
        menuBar.getMenus().add(menuConfigure)

        menuGame.getItems().forEach() {
            val text = it.text
            it.onAction = EventHandler() {
                manageGame(text)
            }
        }

        // Create menu selection
        menuBoards.getItems().forEach {
            val text = it.text
            it.onAction = EventHandler() {
                createBoard(text)
            }
        }

        val displayAbout = fun() {
            throw NotImplementedError("Display about not yet implemented!")
        }

        val displayHelp = fun() {
            throw NotImplementedError("Display help not yet implemented!")
        }

        val displayConfigure = fun() {
            throw NotImplementedError("Configure game not yet implemented!")
        }
 
        menuHelp.onAction = EventHandler() {
            displayHelp()
        }

        menuAbout.onAction = EventHandler() {
            displayAbout()
        }

        menuConfigure.onAction = EventHandler() {
            displayConfigure()
        }

        /// draw initial board and set layout
        drawBoard(gridPane, gameController.game.gameState!!.board, callback)
        root.center = gridPane
        root.right = Label(if (canStillWin) "Can still win" else "Cannot win anymore")
        root.bottom = moveLabel
        gridPane.requestFocus()
        root.top = menuBar
        gridPane.style = "-fx-grid-lines-visible: true;"
        primaryStage.title = "Stephan's Solitaire UI"
        primaryStage.scene = scene
        primaryStage.sizeToScene()
        primaryStage.show()
    }

    /**
     * @brief draw a board
     * @param gridPane
     * @param board 
     * @param callback - button callback to remove and add pegs to the gridPane
     */
    private fun drawBoard(gridPane: GridPane, board: Board, callback: (btn: Button, i: Int, j: Int) -> Unit) {
        val draw = fun(i: Int, j: Int, value: PegType) {
            var btn = Button()
            /// only non-empty holes get a peg
            if (value == PegType.FULL) {
                btn.graphic = GUIUtils.createPegImage()
            }

            /// default sizes for buttons making look background image nice
            btn.setMaxSize(50.0, 50.0)
            btn.setMinSize(50.0, 50.0)
            /// only buttons within the board have a clickable button
            if (value != PegType.BOUNDARY) {
               btn.onAction = EventHandler {
                    callback(btn, j, i)
               }
            /// explicit boundary of the board does not have clickable button
            } else {
                btn.onAction = EventHandler {
                   btn.style = "-fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey; -fx-background-color: lightgrey"
                }
            }

            if (value == PegType.BOUNDARY)
                btn.style = "-fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey; -fx-background-color: lightgrey"
            else
                btn.style = baseStyle

            gridPane.add(btn, j, i, 1, 1)
        }

        /// for each peg we will check how it has to be drawn then add it to the grid pane
        board.pegs.forEach { 
            coordinates, peg -> draw(coordinates.first, coordinates.second, peg.value)
        }
    }
}
    /**
     * @brief utility functions for drawing and managing the visual representation of the board
     */
    object GUIUtils {
    /**
     * @brief draw a board from the 'active' game
     * @param gridPane
     * @param game
     */
    @JvmStatic
    fun draw(gridPane: GridPane, game: PlayableGame) {
        for (peg in game.gameState!!.board.pegs) {
            val button = getNodeFromGridPane(gridPane, peg.value.i, peg.value.j)
            if (button is Button) {
                val b: Button = button
                b.graphic = if (peg.value.available()) createPegImage() else null
            }
        }
    }
    /**
     * @brief apply style sheets to the buttons a peg jumps from and to
     * @param curBtn
     * @param nextBtn
     */
    @JvmStatic
    fun stylize(curBtn: Button?, nextBtn: Button?) {
        curBtn!!.style = baseStyle
        nextBtn!!.style = baseStyle                   
    }

    /**
     * @brief helper method to get a node from the grid pane corresponding to the index of the peg in the map
     * @param gridPane
     * @param col
     * @param row
     */
    @JvmStatic
    fun getNodeFromGridPane(gridPane: GridPane, col: Int, row: Int): Node? {
        for (node in gridPane.children) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node
            }
        }
        return null
    }

    /**
     * @brief create the peg image with reflections
     */
    @JvmStatic
    fun createPegImage(): ImageView {
        val pegImage = GUI::class.java.getResource("/peg.png").toString()
        return ImageView(Image(pegImage))
    }
}
