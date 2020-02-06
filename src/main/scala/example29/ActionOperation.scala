package example29

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Action操作实战
  *
  * @author gaochen
  **/
object ActionOperation {
  val sc = new SparkContext(new SparkConf()
    .setMaster("local")
    .setAppName("ActionOperation"))

  val scores = Array(
    ("class1", 60),
    ("class1", 80),
    ("class1", 70),
    ("class1", 100),
    ("class1", 90),
    ("class2", 70),
    ("class2", 80),
    ("class2", 60),
    ("class2", 100),
    ("class2", 90)
  )

  def main(args: Array[String]): Unit = {
    //    reduce()
    //    collect()
    //    count()
    //    take()
    //    saveAsTextFile()
    countByKey()
  }

  /**
    * 将RDD中的所有元素进行聚合操作。第一个和第二个元素聚合，值与第三个元素聚合，值与第四个元素聚合，以此类推。
    */
  def reduce(): Unit = {
    val arr = 1 to 100
    val sum = sc.parallelize(arr)
      .reduce(_ + _)

    println(s"sum : $sum")
  }

  /**
    * 将RDD中所有元素获取到本地客户端。
    */
  def collect(): Unit = {
    val arr = 1 to 10
    val result = sc.parallelize(arr)
      .map(_ * 2)
      .collect()

    result.foreach(println(_))
  }

  /**
    * 获取RDD元素总数。
    */
  def count(): Unit = {
    val arr = 1 to 100
    val count = sc.parallelize(arr)
      .count()

    println(s"count: $count")
  }

  /**
    * 获取RDD中前n个元素。
    */
  def take(): Unit = {
    val arr = 1 to 100
    sc.parallelize(arr)
      .take(10)
      .foreach(println(_))
  }

  /**
    * 将RDD元素保存到文件中，对每个元素调用toString方法
    */
  def saveAsTextFile(): Unit = {
    val arr = 1 to 100
    sc.parallelize(arr)
      .saveAsTextFile("C:\\Users\\13983\\Desktop\\test.txt")
  }

  /**
    * 对每个key对应的值进行count计数。
    */
  def countByKey(): Unit = {
    val res = sc.parallelize(scores)
      .countByKey()
    res.foreach(map => println(map._1, map._2))
  }
}
