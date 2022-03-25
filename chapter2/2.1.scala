
// A comment!
/* Another comment */
/** A documentation comment */

object MyModule {
    def abs(n: Int): Int = {
        if (n < 0) -n
        else n
    }

    def factorial(n: Int) = {
        def go(n: Int, acc: Int): Int = {
            if (n <= 0) acc
            else go(n-1, n*acc)
        }
        go(n, 1)
    }

    private def formatAbs(x: Int) = {
        val msg = "The absolute value of %d is %s"
        msg.format(x, abs(x))
    }

    private def formatFactorial(x: Int) = {
        val msg = "The factorial of %d is %d"
        msg.format(x, factorial(x))
    }

    private def formatResult(name: String, x: Int, f: Int => Int) = {
        var msg = "The %s of %d is %d"
        msg.format(name, x, f(x))
    }

    def main(args: Array[String]): Unit = {
        // println(formatAbs(abs(-3)))
        // println(formatFactorial(5))

        println(formatResult("factorial", 10, factorial))
        println(formatResult("absolute", -10, abs))
    }

    
}