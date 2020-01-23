/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test06 {

  trait Handler {
    def handle(data: String) {}
  }

  trait DataValidHandler extends Handler {
    override def handle(data: String): Unit = {
      println("check data: " + data)
      super.handle(data)
    }
  }

  trait SignatureValidHandler extends Handler {
    override def handle(data: String): Unit = {
      println("check signature: " + data)
      super.handle(data)
    }
  }

  class Person(val name: String) extends SignatureValidHandler with DataValidHandler {
    def sayHello = {
      println("Hello, " + name)
      handle(name)
    }
  }

  def main(args: Array[String]): Unit = {
    val p = new Person("leo")
    p.sayHello
  }

}
