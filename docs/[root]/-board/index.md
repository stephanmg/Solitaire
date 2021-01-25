---
title: Board -
---
//[Solitaire](../../index.md)/[[root]](../index.md)/[Board](index.md)



# Board  
 [jvm] data class [Board](index.md)(**pegs**: [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)>, [Peg](../-peg/index.md)>, **moves**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))   


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="/Board///PointingToDeclaration/"></a>pegs| <a name="/Board///PointingToDeclaration/"></a><br><br>building blocks of board<br><br>
| <a name="/Board///PointingToDeclaration/"></a>size| <a name="/Board///PointingToDeclaration/"></a><br><br>dimensions (x and y) of board<br><br><br><br>Layout: |---------------------------------------|<br><br><br><br>| 1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1|<br><br><br><br>|---------------------------------------|<br><br><br><br>|-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1|<br><br><br><br>|---------------------------------------|<br><br><br><br>|-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1|<br><br><br><br>|---------------------------------------|<br><br><br><br>| 1 |  1 |  1 | 1 | 1 | 1 |  1 |  1 |  1|<br><br><br><br>|---------------------------------------|<br><br><br><br>| 1 |  1 |  1 | 1 | 0 | 1 |  1 |  1 |  1|<br><br><br><br>|---------------------------------------|<br><br><br><br>| 1 |  1 |  1 | 1 | 1 | 1 |  1 |  1 |  1|<br><br><br><br>|---------------------------------------|<br><br><br><br>|-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1|<br><br><br><br>|---------------------------------------|<br><br><br><br>|-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1|<br><br><br><br>|---------------------------------------|<br><br><br><br>|-1 | -1 | -1 | 1 | 1 | 1 | -1 | -1 | -1|<br><br><br><br>|---------------------------------------|<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="/Board/Board/#kotlin.collections.MutableMap[kotlin.Pair[kotlin.Int,kotlin.Int],Peg]#kotlin.Int/PointingToDeclaration/"></a>[Board](-board.md)| <a name="/Board/Board/#kotlin.collections.MutableMap[kotlin.Pair[kotlin.Int,kotlin.Int],Peg]#kotlin.Int/PointingToDeclaration/"></a> [jvm] fun [Board](-board.md)(pegs: [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)>, [Peg](../-peg/index.md)>, moves: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0)building blocks of board   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="/Board/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="/Board/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)>, [Peg](../-peg/index.md)>  <br><br><br>
| <a name="/Board/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="/Board/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="/Board/copy/#/PointingToDeclaration/"></a>[copy](copy.md)| <a name="/Board/copy/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(): [Board](index.md)  <br>fun [copy](copy.md)(pegs: [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)>, [Peg](../-peg/index.md)>, moves: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0): [Board](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../-undoable-command/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1349245809)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../-undoable-command/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1349245809)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../-undoable-command/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1349245809)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../-undoable-command/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1349245809)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="/Board/numPegs/#/PointingToDeclaration/"></a>[numPegs](num-pegs.md)| <a name="/Board/numPegs/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [numPegs](num-pegs.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="/Board/toString/#/PointingToDeclaration/"></a>[toString](to-string.md)| <a name="/Board/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="/Board/moves/#/PointingToDeclaration/"></a>[moves](moves.md)| <a name="/Board/moves/#/PointingToDeclaration/"></a> [jvm] val [moves](moves.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0   <br>
| <a name="/Board/pegs/#/PointingToDeclaration/"></a>[pegs](pegs.md)| <a name="/Board/pegs/#/PointingToDeclaration/"></a> [jvm] val [pegs](pegs.md): [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)>, [Peg](../-peg/index.md)>building blocks of board   <br>

