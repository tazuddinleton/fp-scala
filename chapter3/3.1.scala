
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

    def apply[A](as: A*): List[A] = {
        if (as.isEmpty) Nil
        else Cons(as.head, apply(as.tail : _*))
    }


    def main(args: Array[String]): Unit = {
        println(List(1,2,3,4))
        println(List.sum(List(1,2,3,4)))
        println(List.product(List(1,2,3,4)))
    }
}
