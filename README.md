# Desktop Calculator
A [Java project](https://hyperskill.org/projects/191?track=9) from JetBrains Academy ([hyperskill.org](https://hyperskill.org)).

## About
We do calculations daily. You may need to know how much change you'll have after purchase or how many points your team 
needs to win the cup. A calculator can do the heavy lifting for us. Have you ever wondered how a calculator works? In
this project, you'll create a full-fledged calculator from scratch that can be run on your computer.

## Learning Outcomes
Learn how to work with various components in Swing. Find out how to style and position them, explore the math library,
master loops, and manipulate strings efficiently.

### Stage 1: [Putting two and two together](https://hyperskill.org/projects/191/stages/953/implement)
In the first stage, we'll create a simple version of the calculator. It'll become more advanced and complex in the 
upcoming stages.

We'll start by having just a `JFrame` containing a `JTextField` and a `JButton`. A click on the button adds both numbers in
the `JTextField` and display the result in the format `2+2` => `2+2=4`, where `2+2` is the equation, and `2+2=4` is the
result.

The title for the window should be `Calculator`, the name of the `JTextField` is `EquationTextField` and the name for
the `JButton` should be `Solve`. Position of the components is up to us.

### Stage 2: [Making buttons](https://hyperskill.org/projects/191/stages/954/implement)
In the previous stage, we have created a very simple calculator that can add two numbers, but let's face it — it's 
boring. So in this stage, we are going to expand our calculator to support **subtraction**, **division**, and 
**multiplication**. We will also take our first steps in designing our calculator.

As you may have guessed, we will need buttons — lots of buttons.

Add buttons for numbers(`0` to `9`), for each operator (addition, subtraction, multiplication, division), and of course,
for the equals `=` sign. A click on a button should add the corresponding character to the `JTextField`, except the
equals button that should perform the corresponding operation on both numbers (add `a` to `b`, subtract `b` from `a` and
so on).

The buttons for the numbers should be named `Zero` to `Nine`; the operator buttons should be `Add`, `Subtract`, 
`Multiply`, and `Divide`; and finally the equals button should be `Equals`.

### Stage 3: [Operator Precedence](https://hyperskill.org/projects/191/stages/955/implement)
So far, our calculator can perform four basic operations with two numbers. We can do better. In this stage, we will
improve our calculator so that it will be able to perform different operations on different sets of numbers. We will
also work on the design of our calculator. As of now, it displays the equation and the result in a single `JTextField`.
We will replace it with two `JLabel`'s.

Let's talk briefly about the operator precedence. In math, some operators have a higher weight than others. As you
probably remember, **division** and **multiplication** have higher precedence than **addition** and **subtraction**.
If an equation has two or more operators with equal precedence, they are executed from **left to right**. Take for 
example the equation `5+4-3x2/1`. We get => `5+4-6/1` => `5+4-6` => `9-6` == `3`. We know that multiplication and 
division have equal precedence, but multiplication was executed first, as it was the first in the equation. Then, we
divide, add and, finally, subtract. We need to account for this in our app.

To evaluate each expression, you may need to convert it from **infix** notation to **postfix** notation. Infix notation
is how we usually take down expressions. Each operator follows an operand. The expressions above can serve as examples
of infix notation. Another type of notation is postfix. In this case, operators are followed by operands. For example,
the postfix notation of the expression `5+4-3` is `5 4 3 + -`.

Replace the `JTextField` with two `JLabel`s, one for storing the equation and one for displaying the result. Also, add
three new `JButton`s, a decimal button that places a decimal point in a `JLabel` equation, a CLEAR button that clears
all characters, and a delete button.

For testing reasons, use the Unicode format for operators: Addition - `\u002B`, Subtraction - `\u2212`,
Multiplication - `\u00D7`, Divison - `\u00F7`. The new `JLabel`s should be `EquationLabel` and `ResultLabel`, new
`JButton`s as `Clear`, `Delete` and `Dot`.

### Stage 4: [Handling errors](https://hyperskill.org/projects/191/stages/956/implement)

Every interactive piece of software must have some form of **input validation** and **error handling** to maintain a
proper user experience and prevent crashes. In this stage, we are going to handle errors and validate user input and 
equations.

There's one thing in our program that can hamper its execution. It is a user-provided equation. Let's establish a set of
guidelines for our program:
1. An equation cannot begin with an operator (`+`, `/`, and so on);
2. An equation cannot end with an operator;
3. An operator cannot directly follow another operator (for example, `2+-3`);
4. Division by zero is forbidden.

The cases described above should be handled in the following way:

1. No character should be added to the `EquationLabel` if users try to enter an operator as the first character;
2. Provide visual feedback to users if the equation ends with an operator. Change the font color of the `EquationLabel` with the help of `Colors.RED.darker()` after the `Equals` button has been clicked;
3. If two operators are inserted consecutively, then the second operator should replace the first;
4. Similar to the second case, once the `Equals` button has been clicked, change the color of the `EquationLabel` if the equation contains division by zero.

### Stage 5: [Advanced features](https://hyperskill.org/projects/191/stages/957/implement)

In the final stage, we will add more functions to our calculator. We have added the ability to evaluate expressions of
variable length and operator precedence before. Now we will override the precedence using **parentheses**. We will also
add **the square root function, exponentiation** (`X` raised to the power of `2` and `X` raised to the power of `Y`,
where `X` and `Y` are real numbers), and, finally, **negation**.

Let's cover them step by step.

###### Parentheses
Add a single `JButton` that will insert both left `(` and right `)` parentheses. There are a few cases that determine 
which parenthesis is to be inserted. Insert a left parenthesis if the number of left parentheses is equal to the number
of right parentheses in the expression. Insert a left parentheses if the last character in the expression is another
left bracket, or if the last character in the expression is an operator. Otherwise, insert a right parenthesis. The
expression in the parentheses should be calculated first.

###### Square Root
Add a new `JButton` for the square root function. When the square root button is clicked, insert a radical symbol (`√`)
followed by a left parenthesis. The result of the expression in the parentheses will be used as input to the square root
function.

###### Exponentiation
Add a `JButton` for the **Raise to 2** function and another `JButton` for the **Raise to Y** function. A click on the 
Raise to 2 button inserts `^` as an operator followed by `(2)`, so the number on the left side of the operator is raised
to the power of 2. Similarly, a click on the Raise to Y button inserts a power operator `^` followed by a left 
parenthesis to allow for any real number or expression, which serves as input.

###### Negation
Add a `JButton` to negate a number or an expression. A click on this button inserts a left parenthesis followed by the
subtract symbol `(-` that will negate any number that comes after it. Note that clicking on this button should 
consecutively undo the negation. For instance, if the expression is empty, the first click on this button inserts `(-`.
The second click removes `(-` from the expression. We know that having `(-` before a number negates it, but what about
negating a full expression? To do it, we need to have `(-` and an expression in another pair of parentheses. For 
instance, the negative version of `2+4-7` is `(-(2+4-7))`.

The guidelines for validating and formatting input established in the previous stage still hold true, except for two
things. Square root can start an expression, and you cannot get a negative number by squaring since a square is either
positive or `0`.
