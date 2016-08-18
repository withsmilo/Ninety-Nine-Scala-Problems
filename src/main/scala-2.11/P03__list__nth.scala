
/*
P03 (*) Find the Kth element of a list.
By convention, the first element in the list is element 0.
Example:

scala> nth(2, List(1, 1, 2, 3, 5, 8))
res0: Int = 2
 */

import scala.annotation.tailrec

object P03__list__nth extends App {

  // Define nth method.
  @tailrec def nth[A](kth: Int, ls: List[A]): A = {
    (kth, ls) match {
      case (0, item :: _ ) => item
      case (i, _ :: remainder) => nth(i - 1, remainder)
      case (_, Nil) => throw new NoSuchElementException
    }
  }

  // Test it.
  val testList = List(1, 1, 2, 3, 5, 8)
  println("test list: " + testList)
  println("2th element: " + nth(2, testList))
  /*
   1. nth(2, List(1, 1, 2, 3, 5, 8))
   2. nth(1, List(1, 2, 3, 5, 8))
   3. nth(0, List(2, 3, 5, 8))
   4. 2
   */
  /*
  test list: List(1, 1, 2, 3, 5, 8)
  2th element: 2
   */
}
