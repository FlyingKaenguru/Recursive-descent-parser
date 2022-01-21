# Recursive-descent-parser

The graphic [recursiveDescentParser.jpg](recursiveDescentParser.jpg) helps in understanding the recursive calls. 
The parser does not build a visible tree. 
It builds a string considering the grammar.  

`5+6*7` becomes `6*7+5`

Due to the conversion of the term, the parser rather falls into the category of 'term rewriting'.

In its prototype version, the parser is only able to handle single-digit numbers and operators (+,-,/,*). 
If other characters are entered, the application cannot handle them.