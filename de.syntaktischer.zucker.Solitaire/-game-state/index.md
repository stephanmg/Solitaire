---
title: GameState -
---
//[Solitaire](../../index.md)/[de.syntaktischer.zucker.Solitaire](../index.md)/[GameState](index.md)



# GameState  
 [jvm] data class [GameState](index.md)(**board**: [Board](../-board/index.md), **type**: [BoardType](../-board-type/index.md), **moves**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))   


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="de.syntaktischer.zucker.Solitaire/GameState///PointingToDeclaration/"></a>board| <a name="de.syntaktischer.zucker.Solitaire/GameState///PointingToDeclaration/"></a><br><br>current board configuration<br><br>
| <a name="de.syntaktischer.zucker.Solitaire/GameState///PointingToDeclaration/"></a>type| <a name="de.syntaktischer.zucker.Solitaire/GameState///PointingToDeclaration/"></a><br><br>the board's type<br><br>
| <a name="de.syntaktischer.zucker.Solitaire/GameState///PointingToDeclaration/"></a>moves| <a name="de.syntaktischer.zucker.Solitaire/GameState///PointingToDeclaration/"></a><br><br>number of moves the user played so far<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="de.syntaktischer.zucker.Solitaire/GameState/GameState/#de.syntaktischer.zucker.Solitaire.Board#de.syntaktischer.zucker.Solitaire.BoardType#kotlin.Int/PointingToDeclaration/"></a>[GameState](-game-state.md)| <a name="de.syntaktischer.zucker.Solitaire/GameState/GameState/#de.syntaktischer.zucker.Solitaire.Board#de.syntaktischer.zucker.Solitaire.BoardType#kotlin.Int/PointingToDeclaration/"></a> [jvm] fun [GameState](-game-state.md)(board: [Board](../-board/index.md), type: [BoardType](../-board-type/index.md), moves: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))current board configuration   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="de.syntaktischer.zucker.Solitaire/GameState/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="de.syntaktischer.zucker.Solitaire/GameState/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Board](../-board/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/GameState/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="de.syntaktischer.zucker.Solitaire/GameState/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [BoardType](../-board-type/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/GameState/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="de.syntaktischer.zucker.Solitaire/GameState/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/GameState/copy/#de.syntaktischer.zucker.Solitaire.Board#de.syntaktischer.zucker.Solitaire.BoardType#kotlin.Int/PointingToDeclaration/"></a>[copy](copy.md)| <a name="de.syntaktischer.zucker.Solitaire/GameState/copy/#de.syntaktischer.zucker.Solitaire.Board#de.syntaktischer.zucker.Solitaire.BoardType#kotlin.Int/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(board: [Board](../-board/index.md), type: [BoardType](../-board-type/index.md), moves: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [GameState](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../-undoable-command/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1652271655)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../-undoable-command/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1652271655)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../-undoable-command/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1652271655)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../-undoable-command/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1652271655)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../-undoable-command/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1652271655)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../-undoable-command/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1652271655)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="de.syntaktischer.zucker.Solitaire/GameState/board/#/PointingToDeclaration/"></a>[board](board.md)| <a name="de.syntaktischer.zucker.Solitaire/GameState/board/#/PointingToDeclaration/"></a> [jvm] val [board](board.md): [Board](../-board/index.md)current board configuration   <br>
| <a name="de.syntaktischer.zucker.Solitaire/GameState/moves/#/PointingToDeclaration/"></a>[moves](moves.md)| <a name="de.syntaktischer.zucker.Solitaire/GameState/moves/#/PointingToDeclaration/"></a> [jvm] val [moves](moves.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)number of moves the user played so far   <br>
| <a name="de.syntaktischer.zucker.Solitaire/GameState/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="de.syntaktischer.zucker.Solitaire/GameState/type/#/PointingToDeclaration/"></a> [jvm] val [type](type.md): [BoardType](../-board-type/index.md)the board's type   <br>

