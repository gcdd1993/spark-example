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

  // 班级分数
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

  val _students = Array(
    (1, "leo"),
    (2, "jack"),
    (3, "tom")
  )

  val _scores = Array(
    (1, 100),
    (2, 90),
    (3, 60),
    (1, 70),
    (2, 80),
    (3, 90)
  )

  def main(args: Array[String]): Unit = {
    //    map()
    //    filter()
    //    flatMap()
    //    groupByKey()
    //    reduceByKey()
    //    sortByKey()
    join()
    cogroup()
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

  /**
    * 将每个班级的成绩进行分组
    * <p>
    * 根据key进行分组，每个key对应一个
    * {{{
    *   Iterable<value>
    * }}}
    */
  def groupByKey(): Unit = {

    sc.parallelize(scores)
      .groupByKey()
      .foreach(tuple => {
        println(s"${tuple._1} : ${tuple._2.mkString(",")}")
      })
  }

  /**
    * 统计每个班级的总分
    * <p>
    * 对每个key对应的value进行reduce操作。
    */
  def reduceByKey(): Unit = {
    sc.parallelize(scores)
      .reduceByKey(_ + _)
      .foreach(tuple => println(s"${tuple._1} : ${tuple._2}"))
  }

  /**
    * 将学生分数进行排序
    * <p>
    * 对每个key对应的value进行排序操作。
    */
  def sortByKey(): Unit = {
    sc.parallelize(scores)
      .map(t => (t._2, t._1))
      .groupByKey()
      .sortByKey(ascending = false)
      .foreach(tuple => println(s"${tuple._1} : ${tuple._2}"))
  }

  /**
    * 打印每个学生的成绩
    * <p>
    * 对两个包含<key,value>对的RDD进行join操作，每个key join上的pair，都会传入自定义函数进行处理。
    */
  def join(): Unit = {
    val rdd1 = sc.parallelize(_students)
    val rdd2 = sc.parallelize(_scores)

    rdd1.join(rdd2)
      .foreach(t => println(s"${t._1} : ${t._2}"))

  }

  /**
    * 打印每个学生的成绩
    * <p>
    * 同join，但是是每个key对应的
    * {{{
    *   Iterable<value>
    * }}}
    * 都会传入自定义函数进行处理。
    */
  def cogroup(): Unit = {
    val rdd1 = sc.parallelize(_students)
    val rdd2 = sc.parallelize(_scores)

    rdd1.cogroup(rdd2)
      .foreach(t => println(s"${t._1} : ${t._2}"))
  }
}
