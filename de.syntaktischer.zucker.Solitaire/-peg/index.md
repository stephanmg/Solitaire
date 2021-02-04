---
title: Peg -
---
//[Solitaire](../../index.md)/[de.syntaktischer.zucker.Solitaire](../index.md)/[Peg](index.md)



# Peg  
 [jvm] data class [Peg](index.md)(**id**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **value**: [PegType](../-peg-type/index.md), **i**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **j**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))   


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="de.syntaktischer.zucker.Solitaire/Peg///PointingToDeclaration/"></a>id| <a name="de.syntaktischer.zucker.Solitaire/Peg///PointingToDeclaration/"></a><br><br>unique identifier of the peg<br><br>
| <a name="de.syntaktischer.zucker.Solitaire/Peg///PointingToDeclaration/"></a>value| <a name="de.syntaktischer.zucker.Solitaire/Peg///PointingToDeclaration/"></a><br><br>value of the peg indicating presence (FULL) or absence (EMPTY) in board location<br><br>
| <a name="de.syntaktischer.zucker.Solitaire/Peg///PointingToDeclaration/"></a>i| <a name="de.syntaktischer.zucker.Solitaire/Peg///PointingToDeclaration/"></a><br><br>offset of peg in row or -1 if not placed on board<br><br>
| <a name="de.syntaktischer.zucker.Solitaire/Peg///PointingToDeclaration/"></a>j| <a name="de.syntaktischer.zucker.Solitaire/Peg///PointingToDeclaration/"></a><br><br>: offset of peg in column or -1 if not placed on board<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="de.syntaktischer.zucker.Solitaire/Peg/Peg/#kotlin.Int#de.syntaktischer.zucker.Solitaire.PegType#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a>[Peg](-peg.md)| <a name="de.syntaktischer.zucker.Solitaire/Peg/Peg/#kotlin.Int#de.syntaktischer.zucker.Solitaire.PegType#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a> [jvm] fun [Peg](-peg.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = -1, value: [PegType](../-peg-type/index.md) = PegType.EMPTY, i: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = -1, j: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = -1)unique identifier of the peg   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="de.syntaktischer.zucker.Solitaire/Peg/available/#/PointingToDeclaration/"></a>[available](available.md)| <a name="de.syntaktischer.zucker.Solitaire/Peg/available/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [available](available.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/Peg/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="de.syntaktischer.zucker.Solitaire/Peg/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [PegType](../-peg-type/index.md)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/Peg/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="de.syntaktischer.zucker.Solitaire/Peg/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/Peg/component4/#/PointingToDeclaration/"></a>[component4](component4.md)| <a name="de.syntaktischer.zucker.Solitaire/Peg/component4/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component4](component4.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/Peg/copy/#/PointingToDeclaration/"></a>[copy](copy.md)| <a name="de.syntaktischer.zucker.Solitaire/Peg/copy/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(): [Peg](index.md)  <br>fun [copy](copy.md)(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = -1, value: [PegType](../-peg-type/index.md) = PegType.EMPTY, i: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = -1, j: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = -1): [Peg](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../-undoable-command/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-850997695)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../-undoable-command/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-850997695)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../-undoable-command/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-850997695)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../-undoable-command/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-850997695)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="de.syntaktischer.zucker.Solitaire/Peg/toString/#/PointingToDeclaration/"></a>[toString](to-string.md)| <a name="de.syntaktischer.zucker.Solitaire/Peg/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="de.syntaktischer.zucker.Solitaire/Peg/i/#/PointingToDeclaration/"></a>[i](i.md)| <a name="de.syntaktischer.zucker.Solitaire/Peg/i/#/PointingToDeclaration/"></a> [jvm] val [i](i.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)offset of peg in row or -1 if not placed on board   <br>
| <a name="de.syntaktischer.zucker.Solitaire/Peg/j/#/PointingToDeclaration/"></a>[j](j.md)| <a name="de.syntaktischer.zucker.Solitaire/Peg/j/#/PointingToDeclaration/"></a> [jvm] val [j](j.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): offset of peg in column or -1 if not placed on board   <br>
| <a name="de.syntaktischer.zucker.Solitaire/Peg/value/#/PointingToDeclaration/"></a>[value](value.md)| <a name="de.syntaktischer.zucker.Solitaire/Peg/value/#/PointingToDeclaration/"></a> [jvm] var [value](value.md): [PegType](../-peg-type/index.md)value of the peg indicating presence (FULL) or absence (EMPTY) in board location   <br>

