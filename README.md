# QMetric Code Exercise
We value the ability to model problems in software, so our first assessment will be around that subject. The exercise is to model and code a simple supermarket pricing solution and it is inspired on [PragDave Supermaket Kata](http://codekata.com/kata/kata01-supermarket-pricing/). 
 
Please read through the description carefully and implement a solution for it. We don't want you to over-engineer the solution but be prepared to extend the functionality in the next step of the interview process. Please dedicate **around 3 hours** to do the exercise and then send it back for review. Don't get concerned if the feedback is to complete the exercise! 

Please create a local repository using git or and then commit locally. When you have finished please zip up the whole folder (including .git folder) and email to us (tpadberg@qmetric.co.uk) within 3 days. We will then review it within 2 days. We provide a project skeleton in Maven, but feel free to use whatever build tool you like (gradle, etc).

Good Luck!

## Things we value
* Working software!
* Tests
* A working build
* Small checkins with good comments
* Put your notes in NOTES.md (maybe talk about trade offs and design decisions)
* Simple code (but not necessarily easy!)
* The less libraries the better, we want to see your code but if you want to use X then say why in your readme.
* We value good domain names and modelling
* Immutability 

## Things to expect
* If you get to the next stage we will pair on your code
* We will add some more features
* Maybe refactor some things
* Be prepared to talk about your code
* Understand alternatives of design decisions


# The Problem

## Description
You have the task to write a component that can calculate the total amount to pay for a supermarket basket. Products are sold by unit or weight, for example 1 coke or 0.450kg of oranges. The supermarket also wants to provide discounts on certain item combinations, for example:
- Three cans of beans for the price of two.
- Two cans of Coke, for £1.

## Example
Use the following example of a receipt to know what data needs to be available. **There's no requirement to format or print a receipt**.

    Beans                0.50
    Beans                0.50
    Beans                0.50
    Coke                 0.70
    Coke                 0.70
    Oranges
    0.200 kg @  £1.99/kg 0.40
                        -----
    Sub-total            3.30

    Savings
    Beans 3 for 2       -0.50
    Coke 2 for £1       -0.40
                        -----
    Total savings       -0.90
    -------------------------
    Total to Pay         2.40
********************************************************************************
************************************************************IIII

Since the pricing system has a tendency to change
I applied the Extensible nut not modified principle
so that whenever there is a need for a new price system,
all we do is add a new PriceCalculation sub class.

With many implementations of the TotalPriceCalculator,
an external configuration can be used to determine which
one to use in any particular case. Or a tool such as JEE's 
@Priority, @Primary annotations can help specify a particular 
implementation to use.

I could have used ogging but I wanted to limit mysekf to the 
library set you provided me for the test.

The exception handling could have terminate gracefully.

Method sizes and parameter list could be reduced by breaking
down methods into two or more coordinating methods.

I was not sure if the printing of the total price
is also a required functionality.

