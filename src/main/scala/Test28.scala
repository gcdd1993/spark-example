/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test28 {

  class Calculator[T: Ordering](val number1: T, val number2: T) {
    def max(implicit order: Ordering[T]): T = {
      if (order.compare(number1, number2) > 0) {
        number1
      } else {
        number2
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val calculator = new Calculator[Int](1, 2)
    println(calculator.max)
  }

}
