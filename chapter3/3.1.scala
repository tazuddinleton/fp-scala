
package fpinscala.datastructure 

// a covariant list of generic type A
// trait is almost like interface but can have default implementation
// of methods. It cannot have constructors

sealed trait List[+A] 
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
    def sum(ints: List[Int]): Int =  ints match {
        case Nil => 0
        case Cons(x, xs) => x + sum(xs)
    }

    def product(ds: List[Double]): Double = ds match {
        case Nil => 1.0
        case Cons(0.0, _) => 0.0
        case Cons(x, xs) => x * product(xs)
    }

    // apply is idiomatic method that data structure have in their companion
    // object to facilitate object creation. 
    // A* = Seq[A]
    // Seq has a head and a tail function
    // as.tail: gives all but head as a Seq
    // _* lets pass a Seq to a variadic method
    def apply[A](as: A*): List[A] = {
        if (as.isEmpty) Nil
        else Cons(as.head, apply(as.tail: _*)) 
    }

    def tail[A](a: List[A]): List[A] = a match{
        case Nil => Nil
        case Cons(x, xs) => xs
    }

    def drop[A](l: List[A], n: Int): List[A] = {
        if (n == 0) l
        else drop(tail(l), n-1)
    }

    def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
        case Cons(h, t) if f(h) => dropWhile(t)(f)
        case _ => l
    }

    def setHead[A](a: List[A], h: A): List[A] = a match {
        case _ => Cons(h, tail(a))
    }

    def head[A](a: List[A]): A = a match {
        case Nil => throw new Exception("Nil have no head")
        case Cons(x, _) => x
    }

    def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
        case Nil => a2
        case Cons(h, t) => Cons(h, append(t, a2))
    }



    def main(args: Array[String]): Unit = {
        println(List(1,2,3,4))
        println(sum(List(1,2,3,4)))
        println(product(List(1,2,3,4)))

        val m = List(1,2,3,4,5)
        val x = m match {
            case Cons(x,Cons(2, Cons(4, _))) => x
            case Nil => 42
            case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => sum(m)
            // case Cons(h, t) => h + sum(t)
            case _ => 101
        }

        println(x)

        println(head(setHead(List(3,4,5), 10)))
        val l = List(1,2,3,4,5,6,7)
        println(dropWhile(l)(a => a < 5))
        

        val a1 = List(1,2,3,4)
        val a2 = List(33,33,22)
        println(append(a1, a2))

        println(init(List(1,2,3,4,5)))
    }


    def init[A](l: List[A]): List[A] = {
        def loop(l1: List[A], l2: List[A]): List[A] = l2 match {
            case Nil => l1
            case Cons(x, Nil) => l1
            case Cons(x, xs) => loop(append(l1, Cons(head(l2), Nil)), tail(l2))
        }
        loop(Cons(head(l), Nil), tail(l))
    }
}
