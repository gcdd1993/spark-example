/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test07 {

  trait Valid {
    def getName: String

    def valid: Boolean = {
      getName == "leo"
    }
  }

  class Person(val name: String) extends Valid {
    println(valid)

    override def getName: String = "my name is " + name
  }

  def main(args: Array[String]): Unit = {
    val p = new Person("leo")
    println(p.valid)
  }

}
