import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color
import javafx.stage.Popup
import javafx.stage.Stage
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

/**
 * @brief GUI
 * TODO: Add Javalin webinterface
 * TODO: Use TornadoFX instead of JavaFX
 * TODO: Adapt Solitaire to 3D
 */
class GUI : Application() {
    private var canStillWin = true
    private val pegImage = "file:peg.png"
    private fun createPegImage() = ImageView(Image(pegImage))
    private val n = 5
    /// TODO: Improve alignment
    private val sizeX = 250.0*2+100
    private val sizeY = 260.0*2

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
        var currentBoard: Board = BoardFactory().classic() 
        var fromPosX: Int = -1
        var fromPosY: Int = -1
        val moveLabel = Label("Number of validMoves: 0")
        var validMoves = 0

        /**
         * @brief callback to check and move pegs
         */
        val callback = fun(btn: Button, i: Int, j: Int) {
            btn.style = "-fx-background-color: beige; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
            if ((count % 2) == 0) {
                curBtn = btn
                nextBtn = null
                fromPosX = i
                fromPosY = j
            }  else {
                // canStillWin = Game().solveDfs(currentBoard)
                println("Can still win?" + canStillWin)
                val jumpToX = fromPosX - i
                val jumpToY: Int = fromPosY - j
                nextBtn = btn
                val dir: Game.Direction? = GameUtils.getDirection(jumpToX, jumpToY)
                if (dir == null) {
                    curBtn!!.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
                    nextBtn!!.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
                    curBtn = nextBtn
                // check if peg can legally jump... 
                } else if (GameUtils.canJump(currentBoard.pegs[Pair(fromPosX,fromPosY)]!!, dir, currentBoard)) {
                    // then do the jump
                    GameUtils.jump(currentBoard.pegs[Pair(fromPosX,fromPosY)]!!, dir, currentBoard)
                    for (peg in currentBoard.pegs) {
                        val button = getNodeFromGridPane(gridPane, peg.value.i, peg.value.j)
                        if (button is Button) {
                            val b: Button = button
                            b.graphic = if (peg.value.available()) createPegImage() else null
                        }
                    }
                    curBtn!!.graphic = null;
                    nextBtn!!.graphic = createPegImage()
                    curBtn!!.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
                    nextBtn!!.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
                    validMoves++
                } else {
                    curBtn!!.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
                    nextBtn!!.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"
                    curBtn = nextBtn
                }
            } 
            count++

            /// move label
            moveLabel.minWidth = 80.0
            moveLabel.minHeight = 50.0
            moveLabel.text = "Number of moves: ${validMoves}"

            /// indicate loss or win
            val won: Boolean = currentBoard.numPegs() == 5
            val lost: Boolean = GameUtils.checkGameOver(currentBoard)
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
                if (GameUtils.checkGameOver(currentBoard)) { label.text = "Game over!"; label.textFill = Color.web("#ff0000"); canStillWin = false }
                popup.content.add(label)
                popup.show(primaryStage)
            }
        }

        /**
         * @brief configure board's view
         */
        val configureBoardView = fun() {
            gridPane = GridPane()
            drawBoard(gridPane, currentBoard, callback)
            root.center=gridPane
            gridPane.style = "-fx-grid-lines-visible: true;"
        }

        /**
         * @brief create board
         */
        val createBoard = fun(text: String) {
            /// TODO: Refactor: use BoardFactory().board()
            when (text) {
                "Classic" -> currentBoard = BoardFactory().classic() 
                "Square" -> currentBoard = BoardFactory().square(n)
            } 

            /// configure board
            configureBoardView()
        }

        // Create menu selection
        val menuButton = MenuButton("Board selector")
        menuButton.getItems().addAll(MenuItem("Classic"), MenuItem("Square"))
        menuButton.getItems().forEach {
            val text = it.text
            it.onAction = EventHandler() {
                createBoard(text)
            }
        }

        drawBoard(gridPane, currentBoard, callback)

        root.center = gridPane
        root.top = Label(if (canStillWin) "Can still win" else "Cannot win anymore")
        root.bottom = moveLabel
        gridPane.requestFocus()
        root.right = menuButton
        /*gridPane.setMaxSize(sizeX, sizeY)
        gridPane.setMinSize(sizeX, sizeY)
        gridPane.setPrefSize(sizeX, sizeY)
        */
        gridPane.style = "-fx-grid-lines-visible: true;"
        primaryStage.title = "Stephan's Solitaire UI"
        primaryStage.scene = scene
        primaryStage.sizeToScene()
        primaryStage.show()
    }

    /**
     * @brief helper method to get a node from the grid pane
     * @param gridPane
     * @param col
     * @param row
     */
    private fun getNodeFromGridPane(gridPane: GridPane, col: Int, row: Int): Node? {
        for (node in gridPane.children) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node
            }
        }
        return null
    }
    
    /**
     * @brief draw a board
     * @param gridPane
     * @param callback - button callback to remove and add pegs to the gridPane
     */
    private fun drawBoard(gridPane: GridPane, board: Board, callback: (btn: Button, i: Int, j: Int) -> Unit) {
        val draw = fun(i: Int, j: Int, value: Int) {
            var btn = Button()
            /// only non-empty holes get a peg
            if (value == 1) 
                btn.graphic = createPegImage()

            /// default sizes for buttons making look background image nice
            btn.setMaxSize(50.0, 50.0)
            btn.setMinSize(50.0, 50.0)
            /// only buttons within the board have a clickable button
            if (value != -1) {
               btn.onAction = EventHandler {
                    callback(btn, j, i)
               }
            /// explicit boundary of the board does not have clickable button
            } else {
                btn.onAction = EventHandler {
                   btn.style = "-fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey; -fx-background-color: lightgrey"
                }
            }

            if (value == -1) 
                btn.style = "-fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey; -fx-background-color: lightgrey"
            else
                btn.style = "-fx-background-color: #f8f8ff; -fx-border-style: solid solid none solid; -fx-border-width: 1; -fx-border-color: grey"


            gridPane.add(btn, j, i, 1, 1)
        }

        board.pegs.forEach { 
            coordinates, peg -> draw(coordinates.first, coordinates.second, peg.value)
        }
    }
}