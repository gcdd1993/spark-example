import scala.io.Source

/**
  * TODO
  *
  * @author gaochen
  * @date 2020/1/23
  */
object Test20 {
  def main(args: Array[String]): Unit = {
    val line1 = Source.fromFile("C:\\Users\\13983\\Desktop\\cron.log").mkString
    val line2 = Source.fromFile("C:\\Users\\13983\\Desktop\\sources.list").mkString

    val lines = List(line1, line2)
    val sum = lines.flatMap(_.split(" "))
      .map((_, 1))
      .map(_._2)
      .reduceLeft(_ + _)

    println(sum)
  }
}
