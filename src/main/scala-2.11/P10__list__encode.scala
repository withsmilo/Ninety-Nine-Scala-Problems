
/*
P10 (*) Run-length encoding of a list.
Use the result of problem P09 to implement the so-called run-length encoding data compression method.
Consecutive duplicates of elements are encoded as tuples (N, E)
where N is the number of duplicates of the element E.
Example:

scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
 */

object P10__list__encode {

  // Define encode method.
  def encode[A](ls: List[A]) : List[(Int, A)] = {
    import P09__list__pack.pack
    pack(ls).map(item => (item.length, item.head))
  }

  // Test it.
  def main(p: Array[String]): Unit = {
    val testList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    println("test list: " + testList)
    println("encoded list: " + encode(testList))
    /*
    test list: List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    encoded list: List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
     */
  }
}