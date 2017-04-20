
/*
P08 (**) Eliminate consecutive duplicates of list elements.
If a list contains repeated elements they should be replaced with a single copy of the element.
The order of the elements should not be changed.
Example:

scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 */

object P08__list__compress extends App {

  def test(idx: Int, fn: List[Any] => List[Any]) {
    val l = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    println(s"[#$idx] Input:$l, compress(List) result:" + fn(l))
  }

  // Define compress method.
  def compress[A](ls: List[A]): List[A] = {
    ls.foldLeft(
      List[A]()) { // start value
        (m, n) =>
          //println("  [foldLeft] m[" + m + "] n[" + n + "]");
          if (m.isEmpty) List(n)
          else if (m.last != n) m ::: List(n)
          else m
    }
  }
  test(1, compress)
  /*
  test list: List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    [foldLeft] m[List()] n['a]
    [foldLeft] m[List('a)] n['a]
    [foldLeft] m[List('a)] n['a]
    [foldLeft] m[List('a)] n['a]
    [foldLeft] m[List('a)] n['b]
    [foldLeft] m[List('a, 'b)] n['c]
    [foldLeft] m[List('a, 'b, 'c)] n['c]
    [foldLeft] m[List('a, 'b, 'c)] n['a]
    [foldLeft] m[List('a, 'b, 'c, 'a)] n['a]
    [foldLeft] m[List('a, 'b, 'c, 'a)] n['d]
    [foldLeft] m[List('a, 'b, 'c, 'a, 'd)] n['e]
    [foldLeft] m[List('a, 'b, 'c, 'a, 'd, 'e)] n['e]
    [foldLeft] m[List('a, 'b, 'c, 'a, 'd, 'e)] n['e]
    [foldLeft] m[List('a, 'b, 'c, 'a, 'd, 'e)] n['e]
  compressed list: List('a, 'b, 'c, 'a, 'd, 'e)
   */
}
