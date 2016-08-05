
/*
P02 (*) Find the last but one element of a list.
Example:
scala> penultimate(List(1, 1, 2, 3, 5, 8))
res0: Int = 5
 */

object P02 extends App {

  // Define penultimate method.
  def penultimate[A](ls: List[A]): A = {
    ls match {
      case item :: _ :: Nil => item // penultimate element is found!
      case _ :: remainder => penultimate(remainder)
      case _ => throw new NoSuchElementException
    }
  }

  // Test it.
  val testList = List(1, 1, 2, 3, 5, 8)
  println("test list: " + testList)
  println("penultimate element: " + penultimate(testList))
  /*
  test list: List(1, 1, 2, 3, 5, 8)
  penultimate element: 5
   */
}
