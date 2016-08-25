
/*
P02 (*) Find the last but one element of a list.
Example:
scala> penultimate(List(1, 1, 2, 3, 5, 8))
res0: Int = 5
 */

import scala.annotation.tailrec

object P02__list__penultimate extends App {

  def test(idx: Int, fn: List[Int] => Int): Unit = {
    val l = List(1, 1, 2, 3, 5, 8)
    println(s"[#$idx] Input:$l, penultimate(List) result:" + fn(l))
  }

  // Define penultimate method.
  @tailrec def penultimate[A](ls: List[A]): A = {
    ls match {
      case item :: _ :: Nil => item // penultimate element is found!
      case _ :: remainder => penultimate(remainder)
      case _ => throw new NoSuchElementException
    }
  }
  test(1, penultimate)
}
