
/*
P01 (*) Find the last element of a list.
Example:
scala> last(List(1, 1, 2, 3, 5, 8))
res0: Int = 8
 */

object P01__list__last extends App {

  // Define last method.
  def last[A](ls: List[A]): A = {
    ls match {
      case item :: Nil => item // last element is found!
      case _ :: remainder => last(remainder)
      case _ => throw new NoSuchElementException
    }
  }

  // Test it.
  val testList = List(1, 1, 2, 3, 5, 8)
  println("test list: " + testList)
  println("last element: " + last(testList))
  /*
  test list: List(1, 1, 2, 3, 5, 8)
  last element: 8
   */
}
