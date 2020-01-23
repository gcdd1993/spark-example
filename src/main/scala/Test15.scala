/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test15 {

  def main(args: Array[String]): Unit = {
    def sum(a: Int, b: Int) = a + b

    sum(1, 1)

    def sum2(a: Int) = (b: Int) => a + b

    sum2(1)(1)

    def sum3(a: Int)(b: Int) = a + b

    sum3(1)(1)
  }
}
