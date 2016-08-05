
/*
P05 (*) Reverse a list.
Example:
scala> reverse(List(1, 1, 2, 3, 5, 8))
res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 */

object P05__list__reverse extends App {

  // Define reverse method.
  def reverse[A](ls: List[A]): List[A] = {
    ls match {
      case item :: remainder => reverse(remainder) ::: List(item)
      case Nil => Nil
    }
  }

  // Define reverseByTailCall method.
  def reverseByTailCall[A](ls: List[A]): List[A] = {
    def reverseR[B](curLs: List[B], resLs: List[B]): List[B] = {
      curLs match {
        case item :: remainder => reverseR(remainder, item :: resLs)
        case Nil => resLs
      }
    }
    reverseR(ls, Nil)
  }

  // Test it.
  val testList = List(1, 1, 2, 3, 5, 8)
  println("test list: " + testList)
  println("reverse list using reverse method: " + reverse(testList))
  println("reverse list using reverseByTailCall method: " + reverseByTailCall(testList))
  /*
  test list: List(1, 1, 2, 3, 5, 8)
  reverse list using reverse method: List(8, 5, 3, 2, 1, 1)
  reverse list using reverseByTailCall method: List(8, 5, 3, 2, 1, 1)
   */
}
