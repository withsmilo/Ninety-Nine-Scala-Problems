
/*
P05 (*) Reverse a list.
Example:
scala> reverse(List(1, 1, 2, 3, 5, 8))
res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 */

import scala.annotation.tailrec

object P05__list__reverse extends App {

  def test(idx: Int, fn: List[Int] => List[Int]) {
    val l = List(1, 1, 2, 3, 5, 8)
    println(s"[#$idx] Input:$l, reverse(List) result:" + fn(l))
  }

  // #1 Use recursive method
  def reverse[A](ls: List[A]): List[A] = {
    ls match {
      case item :: remainder => reverse(remainder) ::: List(item)
      case Nil => Nil
    }
  }
  test(1, reverse)

  // #2 Use recursive tailCall method
  def reverseByTailCall[A](ls: List[A]): List[A] = {
    @tailrec def reverseR[B](curLs: List[B], resLs: List[B]): List[B] = {
      curLs match {
        case item :: remainder => reverseR(remainder, item :: resLs)
        case Nil => resLs
      }
    }
    reverseR(ls, Nil)
  }
  test(2, reverseByTailCall)

  // #3 Use 'foldLeft' method
  def reverse3[A](ls: List[A]): List[A] = {
    (List[A]() /: ls)((x, y) => y :: x)
  }
  test(3, reverse3)
}
