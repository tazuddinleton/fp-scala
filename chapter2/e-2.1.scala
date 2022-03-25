
object Fibonacci {
    def fib(n: Int): Int = {
        if (n < 2) n
        else fib(n-1) + fib(n-2)
    }
    // this method returns void but we do not have to 
    // write explicitly because it's a private method
    private def formatFib(n: Int) = {
        val str = "the %d(th) position fib is: %d"
        println(str.format(n, fib(n)))
    }

    //fib sequenc: 0 1 1 2 3 5
    // it's good practice to explicitly write return value
    // of public methods hence the Unit [Unit is equivalent of void in C like lang]
    def main(args: Array[String]): Unit = {        
        formatFib(8)
    }
}