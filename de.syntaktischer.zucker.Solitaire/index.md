---
title: de.syntaktischer.zucker.Solitaire -
---
//[Solitaire](../index.md)/[de.syntaktischer.zucker.Solitaire](index.md)



# Package de.syntaktischer.zucker.Solitaire  


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="de.syntaktischer.zucker.Solitaire/Board///PointingToDeclaration/"></a>[Board](-board/index.md)| <a name="de.syntaktischer.zucker.Solitaire/Board///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [Board](-board/index.md)(**pegs**: [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)>, [Peg](-peg/index.md)>, **moves**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))  <br>More info  <br>A representation of the solitaire boardThe game board consists out of pegs and holes A peg is present (1), a hole is present (0) and we are outside the board boundary (-1) Layout: |---------------------------------------| | 1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1| |---------------------------------------| |-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1| |---------------------------------------| |-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1| |---------------------------------------| | 1 |  1 |  1 | 1 | 1 | 1 |  1 |  1 |  1| |---------------------------------------| | 1 |  1 |  1 | 1 | 0 | 1 |  1 |  1 |  1| |---------------------------------------| | 1 |  1 |  1 | 1 | 1 | 1 |  1 |  1 |  1| |---------------------------------------| |-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1| |---------------------------------------| |-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1| |---------------------------------------| |-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1| |---------------------------------------|  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/BoardFactory///PointingToDeclaration/"></a>[BoardFactory](-board-factory/index.md)| <a name="de.syntaktischer.zucker.Solitaire/BoardFactory///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [BoardFactory](-board-factory/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/BoardType///PointingToDeclaration/"></a>[BoardType](-board-type/index.md)| <a name="de.syntaktischer.zucker.Solitaire/BoardType///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>enum [BoardType](-board-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[BoardType](-board-type/index.md)>   <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/Command///PointingToDeclaration/"></a>[Command](-command/index.md)| <a name="de.syntaktischer.zucker.Solitaire/Command///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Command](-command/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/ConsoleGame///PointingToDeclaration/"></a>[ConsoleGame](-console-game/index.md)| <a name="de.syntaktischer.zucker.Solitaire/ConsoleGame///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [ConsoleGame](-console-game/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/Direction///PointingToDeclaration/"></a>[Direction](-direction/index.md)| <a name="de.syntaktischer.zucker.Solitaire/Direction///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>enum [Direction](-direction/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[Direction](-direction/index.md)>   <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/GameController///PointingToDeclaration/"></a>[GameController](-game-controller/index.md)| <a name="de.syntaktischer.zucker.Solitaire/GameController///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [GameController](-game-controller/index.md)(**game**: [PlayableGame](-playable-game/index.md))  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/GameSolver///PointingToDeclaration/"></a>[GameSolver](-game-solver/index.md)| <a name="de.syntaktischer.zucker.Solitaire/GameSolver///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [GameSolver](-game-solver/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/GameState///PointingToDeclaration/"></a>[GameState](-game-state/index.md)| <a name="de.syntaktischer.zucker.Solitaire/GameState///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [GameState](-game-state/index.md)(**board**: [Board](-board/index.md), **type**: [BoardType](-board-type/index.md), **moves**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/GameStateUtils///PointingToDeclaration/"></a>[GameStateUtils](-game-state-utils/index.md)| <a name="de.syntaktischer.zucker.Solitaire/GameStateUtils///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [GameStateUtils](-game-state-utils/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/GameUtils///PointingToDeclaration/"></a>[GameUtils](-game-utils/index.md)| <a name="de.syntaktischer.zucker.Solitaire/GameUtils///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [GameUtils](-game-utils/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/GUI///PointingToDeclaration/"></a>[GUI](-g-u-i/index.md)| <a name="de.syntaktischer.zucker.Solitaire/GUI///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [GUI](-g-u-i/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/GUIUtils///PointingToDeclaration/"></a>[GUIUtils](-g-u-i-utils/index.md)| <a name="de.syntaktischer.zucker.Solitaire/GUIUtils///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [GUIUtils](-g-u-i-utils/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/MoveEast///PointingToDeclaration/"></a>[MoveEast](-move-east/index.md)| <a name="de.syntaktischer.zucker.Solitaire/MoveEast///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [MoveEast](-move-east/index.md)(**game**: [PlayableGame](-playable-game/index.md), **fromPosX**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **fromPosY**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [UndoableCommand](-undoable-command/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/MoveManager///PointingToDeclaration/"></a>[MoveManager](-move-manager/index.md)| <a name="de.syntaktischer.zucker.Solitaire/MoveManager///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [MoveManager](-move-manager/index.md)(**game**: [PlayableGame](-playable-game/index.md))  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/MoveNorth///PointingToDeclaration/"></a>[MoveNorth](-move-north/index.md)| <a name="de.syntaktischer.zucker.Solitaire/MoveNorth///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [MoveNorth](-move-north/index.md)(**game**: [PlayableGame](-playable-game/index.md), **fromPosX**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **fromPosY**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [UndoableCommand](-undoable-command/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/MoveSouth///PointingToDeclaration/"></a>[MoveSouth](-move-south/index.md)| <a name="de.syntaktischer.zucker.Solitaire/MoveSouth///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [MoveSouth](-move-south/index.md)(**game**: [PlayableGame](-playable-game/index.md), **fromPosX**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **fromPosY**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [UndoableCommand](-undoable-command/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/MoveWest///PointingToDeclaration/"></a>[MoveWest](-move-west/index.md)| <a name="de.syntaktischer.zucker.Solitaire/MoveWest///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [MoveWest](-move-west/index.md)(**game**: [PlayableGame](-playable-game/index.md), **fromPosX**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **fromPosY**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [UndoableCommand](-undoable-command/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/Peg///PointingToDeclaration/"></a>[Peg](-peg/index.md)| <a name="de.syntaktischer.zucker.Solitaire/Peg///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [Peg](-peg/index.md)(**id**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **value**: [PegType](-peg-type/index.md), **i**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **j**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/PegType///PointingToDeclaration/"></a>[PegType](-peg-type/index.md)| <a name="de.syntaktischer.zucker.Solitaire/PegType///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>enum [PegType](-peg-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[PegType](-peg-type/index.md)>   <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/PlayableGame///PointingToDeclaration/"></a>[PlayableGame](-playable-game/index.md)| <a name="de.syntaktischer.zucker.Solitaire/PlayableGame///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [PlayableGame](-playable-game/index.md)(**type**: [BoardType](-board-type/index.md))  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/Reset///PointingToDeclaration/"></a>[Reset](-reset/index.md)| <a name="de.syntaktischer.zucker.Solitaire/Reset///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Reset](-reset/index.md)(**game**: [PlayableGame](-playable-game/index.md)) : [Command](-command/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/Solitaire///PointingToDeclaration/"></a>[Solitaire](-solitaire/index.md)| <a name="de.syntaktischer.zucker.Solitaire/Solitaire///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Solitaire](-solitaire/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/UndoableCommand///PointingToDeclaration/"></a>[UndoableCommand](-undoable-command/index.md)| <a name="de.syntaktischer.zucker.Solitaire/UndoableCommand///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [UndoableCommand](-undoable-command/index.md) : [Command](-command/index.md)  <br><br><br>
