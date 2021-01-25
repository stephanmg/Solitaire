---
title: MoveManager -
---
//[Solitaire](../../index.md)/[[root]](../index.md)/[MoveManager](index.md)



# MoveManager  
 [jvm] class [MoveManager](index.md)(**game**: [PlayableGame](../-playable-game/index.md))   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="/MoveManager/MoveManager/#PlayableGame/PointingToDeclaration/"></a>[MoveManager](-move-manager.md)| <a name="/MoveManager/MoveManager/#PlayableGame/PointingToDeclaration/"></a> [jvm] fun [MoveManager](-move-manager.md)(game: [PlayableGame](../-playable-game/index.md))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../-undoable-command/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1349245809)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../-undoable-command/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1349245809)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="/MoveManager/execute/#UndoableCommand/PointingToDeclaration/"></a>[execute](execute.md)| <a name="/MoveManager/execute/#UndoableCommand/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [execute](execute.md)(command: [UndoableCommand](../-undoable-command/index.md))  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../-undoable-command/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1349245809)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../-undoable-command/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1349245809)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="/MoveManager/move/#kotlin.Int#kotlin.Int#Direction/PointingToDeclaration/"></a>[move](move.md)| <a name="/MoveManager/move/#kotlin.Int#kotlin.Int#Direction/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [move](move.md)(fromPosX: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), fromPosY: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), direction: [Direction](../-direction/index.md))  <br><br><br>
| <a name="/MoveManager/redo/#/PointingToDeclaration/"></a>[redo](redo.md)| <a name="/MoveManager/redo/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [redo](redo.md)()  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../-undoable-command/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1349245809)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../-undoable-command/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1349245809)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="/MoveManager/undo/#/PointingToDeclaration/"></a>[undo](undo.md)| <a name="/MoveManager/undo/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [undo](undo.md)()  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="/MoveManager/game/#/PointingToDeclaration/"></a>[game](game.md)| <a name="/MoveManager/game/#/PointingToDeclaration/"></a> [jvm] val [game](game.md): [PlayableGame](../-playable-game/index.md)   <br>
| <a name="/MoveManager/history/#/PointingToDeclaration/"></a>[history](history.md)| <a name="/MoveManager/history/#/PointingToDeclaration/"></a> [jvm] val [history](history.md): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)<[UndoableCommand](../-undoable-command/index.md)>   <br>
| <a name="/MoveManager/redoHistory/#/PointingToDeclaration/"></a>[redoHistory](redo-history.md)| <a name="/MoveManager/redoHistory/#/PointingToDeclaration/"></a> [jvm] val [redoHistory](redo-history.md): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)<[UndoableCommand](../-undoable-command/index.md)>   <br>

