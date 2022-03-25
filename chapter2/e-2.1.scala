
object Fibonacci {
    // fib recursive
    def fib(n: Int): Int = {
        if (n < 2) n
        else fib(n-1) + fib(n-2)
    }

    def fibIter(x: Int, y: Int, position: Int, loopCounter: Int): Int = {
      if (position < 2) position
      else if (loopCounter > position) y
      else fibIter(y, x+y, position, loopCounter+1)
    }

    def finFibIter(n: Int): Int = {
        fibIter(0, 1, n, 2)
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
        println(finFibIter(8))
    }
}