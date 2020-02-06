package example29

import org.apache.spark.{SparkConf, SparkContext}

/**
  * word count 单词统计
  *
  * @author gaochen
  * @date 2020/2/3
  */
object WordCountLocal {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("JavaWordCountLocal")
      .setMaster("local")

    val sc = new SparkContext(conf)
    val rdd = sc.textFile("spark.txt")
    rdd.flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)
      .foreach(wordCount => println(wordCount._1 + " appeared " + wordCount._2 + " times."))
  }
}
