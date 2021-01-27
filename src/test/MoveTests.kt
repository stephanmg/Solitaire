package de.syntaktischer.zucker.test.Solitaire

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import io.mockk.mockk
import io.mockk.every
import de.syntaktischer.zucker.Solitaire.*

/**
 * @brief tests for the game behaviour
 */
class MoveTests {
    /**
     * @brief move west
     */
    @Test
    fun testMoveWest() {
        val game = mockk<PlayableGame>()
        every { game.gameState!!.board } returns BoardFactory.board(BoardType.CLASSIC)
        val moveWest: MoveWest = MoveWest(game, 5, 4)
        moveWest.execute()
    }

    /**
     * @brief move east
     */
    @Test
    fun testMoveEast() {
        val game = mockk<PlayableGame>()
        every { game.gameState!!.board } returns BoardFactory.board(BoardType.CLASSIC)
        val moveEast: MoveEast = MoveEast(game, 3, 4)
        moveEast.execute()
    }

    /**
     * @brief move south
     */
    @Test
    fun testMoveSouth() {
        val game = mockk<PlayableGame>()
        every { game.gameState!!.board } returns BoardFactory.board(BoardType.CLASSIC)
        val moveSouth: MoveSouth = MoveSouth(game, 4, 3)
        moveSouth.execute()
    }

    /**
     * @brief move north
     */
    @Test
    fun testMoveNorth() {
        val game = mockk<PlayableGame>()
        every { game.gameState!!.board } returns BoardFactory.board(BoardType.CLASSIC)
        val moveNorth: MoveNorth = MoveNorth(game, 4, 5)
        moveNorth.execute()
    }
}