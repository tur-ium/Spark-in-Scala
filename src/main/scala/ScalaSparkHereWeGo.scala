import org.apache.spark.sql.SparkSession

object ScalaSparkHereWeGo {
  def main(args: Array[String]): Unit = {
    val logFile = "/opt/spark/README.md" // You can select an other file
    val spark = SparkSession.builder.appName("Spark in Scala, let's do this!").getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    spark.stop()
  }
}
