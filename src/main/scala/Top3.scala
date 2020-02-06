import org.apache.spark.{SparkConf, SparkContext}

/**
  * 取最大的前3个数字
  *
  * @author gaochen
  * @date 2020/2/7
  */
object Top3 {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf()
      .setAppName("BroadCastVariable")
      .setMaster("local"))

    val tops = sc.textFile("top.txt")
    tops.map(i => (i.toInt, i))
      .sortByKey(ascending = false)
      .take(3)
      .map(_._2)
      .foreach(println(_))

  }
}
