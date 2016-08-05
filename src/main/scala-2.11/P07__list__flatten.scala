
/*
P07 (**) Flatten a nested list structure.
Example:
scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 */

object P07__list__flatten extends App {

  // Define flatten method.
  def flatten(ls: List[Any]): List[Any] = {
    ls.flatMap {
      case someLs: List[Any] =>
        //println("  [flatMap] Call flatten(" + someLs + ")");
        flatten(someLs)
      case item => List(item)
    }
  }

  // Test it.
  val testList = List(List(1, 1), 2, List(3, List(5, 8)))
  println("test list: " + testList)
  println("flatten list: " + flatten(testList))
  /*
  test list: List(List(1, 1), 2, List(3, List(5, 8)))
    [flatMap] Call flatten(List(1, 1))
    [flatMap] Call flatten(List(3, List(5, 8)))
    [flatMap] Call flatten(List(5, 8))
  flatten list: List(1, 1, 2, 3, 5, 8)
   */
}
