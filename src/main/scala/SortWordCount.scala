import org.apache.spark.{SparkConf, SparkContext}

/**
  * 对文本文件内的每个单词都统计出其出现的次数
  *
  * @author gaochen
  * @date 2020/2/7
  */
object SortWordCount {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf()
      .setAppName("BroadCastVariable")
      .setMaster("local"))

    val lines = sc.textFile("spark.txt")
    lines.flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)
      // 将value-key进行反转映射，以便进行排序
      .map(t => (t._2, t._1))
      .sortByKey(ascending = false)
      // 排序结束，再次将value-key进行反转映射
      .map(t => (t._2, t._1))
      .foreach(t => println(s"${t._1} appeared ${t._2} times."))
  }
}
