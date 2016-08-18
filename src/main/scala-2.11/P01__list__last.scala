
/*
P01 (*) Find the last element of a list.
Example:
scala> last(List(1, 1, 2, 3, 5, 8))
res0: Int = 8
 */

import scala.annotation.tailrec

object P01__list__last extends App {
  val testList1 = List()
  val testList2 = List(9)
  val testList3 = List(1, 1, 2, 3, 5, 8)

  // #1 Use recursive method
  @tailrec def last1[A](ls: List[A]): A = {
    ls match {
      case item :: Nil => item // last element is found!
      case _ :: remainder => last1(remainder)
      case _ => throw new NoSuchElementException
    }
  }
  //println("[#1] Input[" + testList1 + "], last[" + last1(testList1) + "]")
  println("[#1] Input[" + testList2 + "], last[" + last1(testList2) + "]")
  println("[#1] Input[" + testList3 + "], last[" + last1(testList3) + "]")

  // #2 Use 'fold' method
  def last2[A](ls: List[A]) = ls.fold(None: Option[A])((x, y) => y)
  println("[#2] Input[" + testList1 + "], last[" + last2(testList1) + "]")
  println("[#2] Input[" + testList2 + "], last[" + last2(testList2) + "]")
  println("[#2] Input[" + testList3 + "], last[" + last2(testList3) + "]")

  // #3 Use 'foldLeft(/:)' method
  def last3[A](ls: List[A]) = ((None: Option[A]) /: ls)((x, y) => Some(y))
  println("[#3] Input[" + testList1 + "], last[" + last3(testList1).getOrElse(None) + "]")
  println("[#3] Input[" + testList2 + "], last[" + last3(testList2).getOrElse(None) + "]")
  println("[#3] Input[" + testList3 + "], last[" + last3(testList3).getOrElse(None) + "]")
}
