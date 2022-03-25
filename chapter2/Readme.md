
# Scala Basics
### `object` Keyword
`object` keyword creates a singleton type. It's equivalent of anonymous class in Java/C#. `object` is also used where you would use a static class. Scala doesn't have a static keyword.
### `Unit` type
This is equivalent of `void` in C/C# world. 
### `def` and `private def`
`def` defines a method, private def defines a private method.
### No explicit `return`
You don't have to use `return` keyword to return a value. Scala returns whatever the last expression yields to.
### Returning Multiple values
You can return multiple values by separating by commas.
### Everything is object
`2 + 1` is just a syntactic sugar for `2.+(1)`.
### Module/Namespaces
Everytihng in scala is `object`. In listing 2.1 `MyModule` is a *namespace* for it's members. Objects whose sole purpose is to provide namespace for it's members are also called *module*.