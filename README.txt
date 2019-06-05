Name: Annabelle Taylor
Email: atayl22@u.rochester.edu
Class: CSC 172 The Science of Data Structures
Assignment: Project 2
Lab: TR 4:50-6:05 pm
TA: Pauline Chen

*NOTE BEFORE RUNNNING: Spaces required between each element ine expression*

Begin in the driver; as command line prompts, I take the requested file names for the input and output files from the user and set up the file IO. As I read each line from the input file (one line = one expression), I split it between spaces. However, everything is maintained as a String--nothing is yet turned into a number. This is actually the one thing that I wish I could figure out better in my code--I require there to be spaces between every operator and every operand. I have to edit the input file, as suggested by my intro warning.

I then create an instance of Calculator with this String array, and still within the driver class I set a new double equal to the outcome of the postfix calculation after it has been converted. I write that answer to a new line of the output file, then skip a line. This continues until the input EOF.

Most of the "dirty work" occurs within Calculator.java. There are two major methods: parse and calculations. I begin by parsing my input array. I go through the array space by space. If the current element is an instance of Number (which I check with the method isNumber, which attempts to parse whatever element into a double), then I enqueue it--still as a String, mind you. Else, I go into the pushing and popping of operators. For each type (arithmetic or logical, regardless of precedence), if the current stack of operators is null, I just push that element onto the stack. Otherwise, I follow the precedence outlined in the abstract for both arithmetic and logical operators. Once I reach the end of an array, I pop the rest of the stack and enqueue the elements.

The queue that I recieved from parseArray gets passed into calcuations. We now have a full queue and an empty stack. As we iterate through the queue, if we reach an element that isNumber, we push it into the stack. It is only if an element is an operator that we begin to convert into numbers. Depending on what kind of operator it is, I pop off the appropriate number of operands to perform the operation with. I check to see what the operator string corresponds to, and then I perform that upon the one or two operands I have as doubles. I then convert it back into a string so that I can push the result back onto the stack of numbers. At the end, there should only be one number left in the stack, and that is returned and copied over to the output file.

I implemented the exponentiation and modulo functions in my project. Test cases for those, along with any other original test cases, are present in infix_expr.txt beginning at line 31 (7 % 4). Results are presented in OUTPUT.txt. The one problem I had was with expression 24, ! ( 3 * ( 1 + 6 ) = 63 / 3 ), whose answer should have been 0, but for some reason mine turned out to be 1.

COMPILE INSTRUCTIONS
--------------------
(In OUTPUT.txt)

FILES IN THIS LAB
-----------------
Driver.java (To operate the entire program)
Calculator.java (To invert the expression into postfix and evaluate)
MyQueue.java (To create a queue of Strings)
MyStack.java (To create a stack of Strings)
qNode.java (Queue node)
sNode.java (Stack node)
infix_expr.txt (All test cases I use)
README.txt (Instruction/explanation)
OUTPUT.txt (Results)