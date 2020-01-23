/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test23 {
  def main(args: Array[String]): Unit = {
    //    def greeting(arr: Array[String]): Unit = {
    //      arr match {
    //        case Array("leo") => println("Hi, Leo!")
    //        case Array(girl1, girl2, girl3) => println("Hi, girls, nice to meet you. " + girl1 + " and " + girl2 + " and " + girl3)
    //        case Array("leo", _*) => println("Hi, Leo, please introduce your friends to me.")
    //        case _ => println("hey, who are you?")
    //      }
    //    }
    def greeting(arr: List[String]): Unit = {
      arr match {
        case "leo" :: Nil => println("Hi, Leo!")
        case girl1 :: girl2 :: girl3 :: Nil => println("Hi, girls, nice to meet you. " + girl1 + " and " + girl2 + " and " + girl3)
        case "leo" :: tail => println("Hi, Leo, please introduce your friends to me.")
        case _ => println("hey, who are you?")
      }
    }

    greeting(List("leo", "marry", "tom", "toppy"))
  }
}
