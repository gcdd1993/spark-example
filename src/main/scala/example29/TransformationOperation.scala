package example29

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Transformation操作实战
  *
  * @author gaochen
  * @date 2020/2/6
  */
object TransformationOperation {
  val sc = new SparkContext(new SparkConf()
    .setMaster("local")
    .setAppName("TransformationOperation"))

  def main(args: Array[String]): Unit = {
    //    map()
    //    filter()
    flatMap()
  }

  /**
    * 将集合中每个元素乘以2
    * <p>
    * 将RDD中的每个元素传入自定义函数，获取一个新的元素，然后用新的元素组成新的RDD
    */
  def map(): Unit = {
    val arr = 1 to 100
    sc.parallelize(arr)
      .map(_ * 2)
      .foreach(println(_))
  }

  /**
    * 过滤出集合中的偶数
    * <p>
    * 对RDD中每个元素进行判断，如果返回true则保留，返回false则剔除。
    */
  def filter(): Unit = {
    val arr = 1 to 100
    sc.parallelize(arr)
      .filter(_ % 2 == 0)
      .foreach(println(_))
  }

  /**
    * 将行拆分为单词
    * <p>
    * 与map类似，但是对每个元素都可以返回一个或多个新元素。
    */
  def flatMap(): Unit = {
    sc.textFile("spark.txt")
      .flatMap(_.split(" "))
      .foreach(println(_))
  }
}
