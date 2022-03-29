
// implement isSorted
object Excersize22 {
    def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
        @annotation.tailrec
        def loop(n: Int): Boolean = {
            if (as.length < 2 || n == as.length-1) true
            else if (!ordered(as(n), as(n+1))) false
            else loop(n+1)
        }
        loop(0)
    }

    def main(args: Array[String]): Unit = {
        val arr = Array(1, 2, 2)
        println(isSorted(arr, (a, b) => a <= b))
    }
}