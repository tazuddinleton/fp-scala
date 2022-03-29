

// currying

class A {

}
class B {

}
class C {

}
object Excersize23 {
    
    def partial1[A, B, C](a: A, f: (a: A, b: B) => C): B => C = {
        b => f(a, b)
    }

    def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
        a => b => f(a, b)
    }

    def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
        Function.uncurried(f)
    }

    def compose[A, B, C](f: B => C, g: A => B): A => C = {
        a => f(g(a))
    }

    def main(args: Array[String]): Unit = {

        val a = new A()
        val b = new B()
        val c = new C()

        val f = (a: A, b: B) => c
        val f1 = curry[A, B, C](f)        
        val f2 = f1(a)

        val v = f2(b)
        println(c.toString())
        println(v==c)
        
        val uncurried = uncurry[A, B, C](f1)
        println(uncurried.toString())

        // REPL:
        // val f = (a: Int) => (b: Int) => a+b
        // val f: Int => Int => Int = Lambda$1264/1414042262@1201769d
        // f(10)(32)
        // val res2: Int = 42
        // Function.uncurried(f)
        // val res0: (Int, Int) => Int = scala.Function$$$Lambda$1343/1186361374@3686389
        // Function.uncurried(f)(10, 32)
        // val res1: Int = 42
    }
}