
/*
P04 (*) Find the number of elements of a list.
Example:
scala> length(List(1, 1, 2, 3, 5, 8))
res0: Int = 6
 */

object P04 extends App {

  // Define length method.
  def length[A](ls: List[A]): Int = {
    ls match {
      case Nil => 0
      case _ :: remainder => length(remainder) + 1
    }
  }

  // Define lengthByTailCall method.
  //
  // TailCall on Scala
  // - http://blog.richdougherty.com/2009/04/tail-calls-tailrec-and-trampolines.html
  // - The Scala compiler can optimise self calls in final methods and in local functions.
  // - In this case, `lengthR` is a local function, so it should be properly optimized.
  def lengthByTailCall[A](ls: List[A]): Int = {
    def lengthR[B](curLs: List[B], result: Int): Int = {
      curLs match {
        case Nil => result
        case _ :: remainder => lengthR(remainder, result + 1)
      }
    }
    lengthR(ls, 0)
  }

  // Test it.
  val testList = List(1, 1, 2, 3, 5, 8)
  println("test list: " + testList)
  println("list length using length method: " + length(testList))
  println("list length using lengthUsingTailCall method: " + lengthByTailCall(testList))
  /*
  test list: List(1, 1, 2, 3, 5, 8)
  list length using length method: 6
  list length using lengthUsingTailCall method: 6
   */
}
