
/*
P01 (*) Find the last element of a list.
Example:
scala> last(List(1, 1, 2, 3, 5, 8))
res0: Int = 8
 */

import scala.annotation.tailrec

object P01__list__last extends App {

  def test(idx: Int, fn: List[Int] => Int) {
    val l = List(1, 1, 2, 3, 5, 8)
    println(s"[#$idx] Input:$l, last(List) result:" + fn(l))
  }

  // #1 Use recursive method
  @tailrec def last1[A](ls: List[A]): A = {
    ls match {
      case item :: Nil => item // last element is found!
      case _ :: remainder => last1(remainder)
      case _ => throw new NoSuchElementException
    }
  }
  test(1, last1)

  // #2 Use 'fold' method
  def last2[A](ls: List[A]): A = {
    ls.fold(None: Option[A])((x, y) => Some(y)) match {
      case Some(item: A) => item
      case _ => throw new NoSuchElementException
    }
  }
  test(2, last2)

  // #3 Use 'foldLeft(/:)' method
  def last3[A](ls: List[A]): A = {
    ((None: Option[A]) /: ls)((x, y) => Some(y))
      .getOrElse(throw new NoSuchElementException)
  }
  test(3, last3)
}
