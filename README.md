# Logical Calculator
Logical Calculator developed in Java using OOP principles and design patterns.
There is an interface Expression, an abstract class (Base Expression) and 2 classes that implements it:
1. Val- represents True or False.
2. Var- represents variable which we will assign it a value later.
There are 2 abstract classes extend Base Expression-
1. Binary Expression - all binary operations extend it, an operation which contains 2 expressions.
2. Unary Expression - the unary operation nor extends it, an operation which contains one expression.

There are various operations:
'assign' - the method assigns a new expression instead of some variable.
'evaluate' - the method evaluates the expression using a map that assigned values to the variables. 
'nandify', 'notify'- these 2 methods will convert expressions to logically equal expressions according to this logic:
Wikipedia page for Nand Logic- https://en.wikipedia.org/wiki/NAND_logic
Wikipedia page for Nor Logic- https://en.wikipedia.org/wiki/NOR_logic
'simplify'- the method will simplify the expression. For example: applying simplify on the expression ((x & T) ^ (y | F)) will return (x ^ y).

The file ExpressionsTest.java has an example for using the code.
