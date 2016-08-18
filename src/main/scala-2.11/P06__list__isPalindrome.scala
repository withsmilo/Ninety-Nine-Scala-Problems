
/*
P06 (*) Find out whether a list is a palindrome.
Example:
scala> isPalindrome(List(1, 2, 3, 2, 1))
res0: Boolean = true
 */

import scala.annotation.tailrec

object P06__list__isPalindrome extends App {

  // Define isPalindrome method.
  @tailrec def isPalindrome[A](ls: List[A]) : Boolean = {
    ls match {
      case Nil => true
      case _ :: Nil => true
      case all => (all.head == all.last) && isPalindrome(all.tail.init)
    }
  }

  // Test it.
  val testList1 = List(1, 2, 3, 2, 1)
  val testList2 = List(1, 2, 3, 2, 1, 5)
  println("test list: " + testList1)
  println("is palindrome?: " + isPalindrome(testList1))
  println("test list: " + testList2)
  println("is palindrome?: " + isPalindrome(testList2))
  /*
  test list: List(1, 2, 3, 2, 1)
  is palindrome?: true
  test list: List(1, 2, 3, 2, 1, 5)
  is palindrome?: false
   */
}
