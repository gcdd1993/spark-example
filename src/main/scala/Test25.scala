/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test25 {

  class Student[T](val localId: T) {
    def getSchoolId(hukouId: T) = "S-" + hukouId + "-" + localId
  }

//  def getCard[T](content: T) = {
//    if (content.isInstanceOf[Int]) {
//      "card, 001, " + content
//    } else if (content.isInstanceOf[String]) {
//      "card: this is your card, " + content
//    } else {
//      "card: " + content
//    }
//  }
  def getCard[T](content: T) = {
    content match {
      case content: Int => "card: 001, " + content
      case content:String => "card: this is your card, " + content
      case content => "card: " + content
    }
  }

  def main(args: Array[String]): Unit = {
    val leo = new Student[Int](111)
    val hukouId = leo.getSchoolId(123)
    println(hukouId)

    val marry = new Student(1)
    marry.getSchoolId(222)

    println(getCard("111"))
  }

}
