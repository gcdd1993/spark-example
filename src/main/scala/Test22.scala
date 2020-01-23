import java.io.{FileNotFoundException, IOException}

/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test22 {
  def main(args: Array[String]): Unit = {
    def processException(e: Exception): Unit = {
      e match {
        case e1: IllegalArgumentException => println("you have illegal arguments! exception is: " + e1)
        case e2: FileNotFoundException => println("cannot find the file you need read or write!, exception is: " + e2)
        case e3: IOException => println("you got an error while you were doing IO operation! exception is: " + e3)
        case _: Exception => println("cannot know which exception you have!")
      }
    }

    processException(new IllegalArgumentException("illegal"))
  }
}
