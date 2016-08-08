
/*
P09 (**) Pack consecutive duplicates of list elements into sublists.
If a list contains repeated elements they should be placed in separate sublists.
Example:

scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 */

object P09__list__pack {

  // Define pack method.
  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) {
      List(List())
    } else {
      val (prefix, suffix) = ls.span(_ == ls.head)
      //println("  [span] prefix[" + prefix + "], suffix[" + suffix + "]")
      if (suffix.isEmpty)
        List(prefix)
      else
        prefix :: pack(suffix)
    }
  }

  // Test it.
  def main(p: Array[String]): Unit = {
    val testList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    println("test list: " + testList)
    println("packed list: " + pack(testList))
    /*
    test list: List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      [span] prefix[List('a, 'a, 'a, 'a)], suffix[List('b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)]
      [span] prefix[List('b)], suffix[List('c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)]
      [span] prefix[List('c, 'c)], suffix[List('a, 'a, 'd, 'e, 'e, 'e, 'e)]
      [span] prefix[List('a, 'a)], suffix[List('d, 'e, 'e, 'e, 'e)]
      [span] prefix[List('d)], suffix[List('e, 'e, 'e, 'e)]
      [span] prefix[List('e, 'e, 'e, 'e)], suffix[List()]
    packed list: List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
     */
  }
}
