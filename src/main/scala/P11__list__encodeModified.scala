
/*
P11 (*) Modified run-length encoding.
Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
Example:

scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
 */
object P11__list__encodeModified {

  def test(idx: Int, fn: List[Any] => List[Any]) {
    val l = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    println(s"[#$idx] Input:$l, encodeModified(List) result:" + fn(l))
  }

  // Define encodeModified method.
  def encodeModified[A](ls: List[A]): List[Any] = {
    import P10__list__encode.encode
    encode(ls).map(f => if (f._1 == 1) f._2 else f)
  }

  // Test it.
  def main(p: Array[String]): Unit = {
    test(1, encodeModified)
    /*
    [#1] Input:List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e), encodeModified(List) result:List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
     */
  }
}
