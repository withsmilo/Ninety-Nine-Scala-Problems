
/*
P03 (*) Find the Kth element of a list.
By convention, the first element in the list is element 0.
Example:

scala> nth(2, List(1, 1, 2, 3, 5, 8))
res0: Int = 2
 */

import scala.annotation.tailrec

object P03__list__nth extends App {

  def test(idx: Int, fn: (Int, List[Int]) => Int) {
    val l = List(1, 1, 2, 3, 5, 8)
    println(s"[#$idx] Input:$l, nth(2, List) result:" + fn(2, l))
  }

  // #1 Use recursive method
  @tailrec def nth1[A](kth: Int, ls: List[A]): A = {
    (kth, ls) match {
      case (0, item :: _ ) => item
      case (i, _ :: remainder) => nth1(i - 1, remainder)
      case (_, Nil) => throw new NoSuchElementException
    }
  }
  test(1, nth1)
  /*
   1. nth(2, List(1, 1, 2, 3, 5, 8))
   2. nth(1, List(1, 2, 3, 5, 8))
   3. nth(0, List(2, 3, 5, 8))
   4. 2
   */

  // #2 Use 'find' method
  def nth2[A](kth: Int, ls: List[A]): A = {
    ls.zipWithIndex
      .find(p => p._2 == kth) match {
      case Some((i, _)) => i
      case None => throw new NoSuchElementException
    }
  }
  test(2, nth2)

  // #3 Use 'collectFirst' method
  // `kth` means a stable identifier. (http://stackoverflow.com/a/7078077/1837846)
  def nth3[A](kth: Int, ls: List[A]): A = {
    ls.zipWithIndex
      .collectFirst({ case (i, `kth`) => i })
      .getOrElse(throw new NoSuchElementException)
  }
  test(3, nth3)

  // #4 Use closure
  def nth4[A](kth: Int, ls: List[A]): A = {
    def mkFtReturnTrueWhenCalledKTimes[B](k: Int): (B => Boolean) = {
      var n = -1
      (i: B) => {n += 1; n == k}
    }
    ls.find(mkFtReturnTrueWhenCalledKTimes(kth))
      .getOrElse(throw new NoSuchElementException)
  }
  test(4, nth4)

  // #5 Use anonymous class 'Function1'
  def nth5[A](kth: Int, ls: List[A]): A = {
    ls.find(new Function1[A, Boolean] {
      var n = -1
      def apply(i: A) = {n += 1; n == kth}
    })
      .getOrElse(throw new NoSuchElementException)
  }
  test(5, nth5)
}
