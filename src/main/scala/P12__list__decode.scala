
/*
P12 (**) Decode a run-length encoded list.
Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
Example:

scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
 */

object P12__list__decode extends App {

  def test(idx: Int, fn: List[(Int, Any)] => List[Any]) {
    val l = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    println(s"[#$idx] Input:$l, decode(List) result:" + fn(l))
  }

  def decode[A](ls: List[(Int, A)]): List[A] = {
    ls.flatMap(f => List.fill(f._1)(f._2))
  }
  test(1, decode)
  /*
  [#1] Input:List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)), decode(List) result:List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
   */
}
