
/*
P07 (**) Flatten a nested list structure.
Example:
scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 */

object P07__list__flatten extends App {

  def test(idx: Int, fn: List[Any] => List[Any]) {
    val l = List(List(1, 1), 2, List(3, List(5, 8)))
    println(s"[#$idx] Input:$l, flatten(List) result:" + fn(l))
  }

  // Define flatten method.
  def flatten(ls: List[Any]): List[Any] = {
    ls.flatMap {
      case someLs: List[Any] =>
        //println("  [flatMap] Call flatten(" + someLs + ")");
        flatten(someLs)
      case item => List(item)
    }
  }
  test(1, flatten)
}
