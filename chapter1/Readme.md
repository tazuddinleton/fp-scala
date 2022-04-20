# Functional Programming 

### What is functional programming
Functional programming is based on a simple premise that we should write programs using only pure function. In other word we should write programs using functions that don't have side effects. 
### What is side effect
When a function do something (other than just returning value) that has observable effect.
### Examples of side effect
- Modifying a variable
- Modifying a data structure in place
- Setting a field on an object
- Throwing an exception or halting with an error
- Printing to the console or reading user input
- Reading from or writing to a file
- Drawing on the screen

It's obvious that those are necessry things to write a program that actually do something. Functional Programming does not prohibit you from doing things it just offers a better way of doing things.

Notice the follwing snippet
```
def buyCoffee(cc: CreditCard): Coffee = {
 val cup = new Coffee()
 cc.charge(cup.price) // side effects
 cup
}
```
Compare that with
```
def buyCoffee (cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee()
    (cup, Charge(cc, cup.price))
}
```
Instead of charging the credit card right away the second method returns a `Charge` object that defers the operation. That is better because now it enables to combine multiple charges per credit card.

### Referential Transparency
The idea that every occurance of an expression *e* in a given program *p* can be replaced by the computed value of *e* without changing/affecting overall meaning of the prpgram *p*.


