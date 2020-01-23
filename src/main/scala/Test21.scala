/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test21 {
  def main(args: Array[String]): Unit = {
    //    def judgeGrade(grade: String): Unit = {
    //      grade match {
    //        case "A" => println("Excellent")
    //        case "B" => println("Good")
    //        case "C" => println("Just so so")
    //        case _ => println("you need work harder")
    //      }
    //    }
    //    def judgeGrade(name: String, grade: String): Unit = {
    //      grade match {
    //        case "A" => println(name + ", Excellent")
    //        case "B" => println(name + ",Good")
    //        case "C" => println(name + ",Just so so")
    //        case _ if name == "leo" => println(name + ", you are a good boy, come on")
    //        case _ => println("you need work harder")
    //      }
    //    }

    def judgeGrade(name: String, grade: String): Unit = {
      grade match {
        case "A" => println(name + ", Excellent")
        case "B" => println(name + ",Good")
        case "C" => println(name + ",Just so so")
        case _grade if name == "leo" => println(name + ", you are a good boy, come on ," + _grade)
        case _ => println("you need work harder")
      }
    }

    judgeGrade("Jack", "A")
    judgeGrade("Tom", "B")
    judgeGrade("leo", "D")
    judgeGrade("Tom", "D")
  }
}
