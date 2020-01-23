/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test19 {
  def main(args: Array[String]): Unit = {
    // 为List中每个元素都添加一个前缀
    List(1, 2, 3, 4).map("name is " + _)
  }
}
