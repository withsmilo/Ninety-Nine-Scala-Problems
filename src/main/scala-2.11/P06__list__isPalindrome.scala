
/*
P06 (*) Find out whether a list is a palindrome.
Example:
scala> isPalindrome(List(1, 2, 3, 2, 1))
res0: Boolean = true
 */

import scala.annotation.tailrec

object P06__list__isPalindrome extends App {

  def test(idx: Int, fn: List[Int] => Boolean) {
    val l1 = List(1, 2, 3, 2, 1)
    val l2 = List(1, 2, 3, 2, 1, 5)
    println(s"[#$idx] Input:$l1, isPalindrome(List) result:" + fn(l1))
    println(s"[#$idx] Input:$l2, isPalindrome(List) result:" + fn(l2))
  }

  // #1 Use recursive method
  @tailrec def isPalindrome[A](ls: List[A]) : Boolean = {
    ls match {
      case Nil => true
      case _ :: Nil => true
      case all => (all.head == all.last) && isPalindrome(all.tail.init)
    }
  }
  test(1, isPalindrome)
}
