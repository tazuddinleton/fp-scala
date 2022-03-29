object Listing23 {
    // def findFirst(ss: Array[String], key: String): Int = {
    //     @annotation.tailrec
    //     def loop(n: Int): Int = {
    //         if(n >= ss.length) -1
    //         else if(ss(n) == key) n
    //         else loop(n+1)
    //     }
    //     loop(0)
    // }

    def findFirst[T](ss: Array[T], comparator: T => Boolean): Int = {
        @annotation.tailrec
        def loop(n: Int): Int = {
            if(n >= ss.length) -1
            else if(comparator(ss(n))) n
            else loop(n+1)
        }
        loop(0)
    }

    def main(args: Array[String]): Unit = {
        var colors =  Array("Red", "Green", "Blue")
        println(findFirst(colors, n => n == "Blue"))

        var nums = Array(1,2,3)
        println(findFirst(nums, n=> n == 1))
    }
}
