import scala.annotation.tailrec

/*
P04 (*) Find the number of elements of a list.
Example:
scala> length(List(1, 1, 2, 3, 5, 8))
res0: Int = 6
 */

object P04__list__length extends App {

  def test(idx: Int, fn: List[Int] => Int) {
    val l = List(1, 1, 2, 3, 5, 8)
    println(s"[#$idx] Input:$l, length(List) result:" + fn(l))
  }

  // #1 Use recursive method
  def length[A](ls: List[A]): Int = {
    ls match {
      case Nil => 0
      case _ :: remainder => length(remainder) + 1
    }
  }
  test(1, length)

  // #2 Use recursive tailCall method
  //
  // TailCall on Scala
  // - http://blog.richdougherty.com/2009/04/tail-calls-tailrec-and-trampolines.html
  // - The Scala compiler can optimise self calls in final methods and in local functions.
  // - In this case, `lengthR` is a local function, so it should be properly optimized.
  def lengthByTailCall[A](ls: List[A]): Int = {
    @tailrec def lengthR[B](curLs: List[B], result: Int): Int = {
      curLs match {
        case Nil => result
        case _ :: remainder => lengthR(remainder, result + 1)
      }
    }
    lengthR(ls, 0)
  }
  test(2, lengthByTailCall)
}
