import org.apache.spark.{SparkConf, SparkContext}

/**
  * TODO
  *
  * @author gaochen
  * @date 2020/2/3
  */
object Example29 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("WordCountLocal")
      .setMaster("local")

    val sc = new SparkContext(conf)
    val rdd = sc.textFile("C:\\Users\\13983\\Desktop\\spark.txt")
    rdd.flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)
      .foreach(wordCount => println(wordCount._1 + " appeared " + wordCount._2 + " times."))
  }
}
