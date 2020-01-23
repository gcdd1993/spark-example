/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test17 {
  def main(args: Array[String]): Unit = {
    def decorator(l: List[Int], prefix: String): Unit = {
      if (l != Nil) {
        println(prefix + l.head)
        decorator(l.tail, prefix)
      }
    }

    decorator(List(1, 2, 3, 4, 5, 6), "prefix")

  }
}
