import sbt._

object Dependencies {

  object Versions {
    val targetJVMVer = "1.8"

    val scalaVer = "2.11.8"
    val sparkVer = "2.0.2"
    val hadoopVer = "2.6.0"
    val hbaseVer = "0.98.0-hadoop2"
  }

  object Bundles {
    import Versions._

    val sparkDeps = Seq("spark-core", "spark-sql", "spark-hive", "spark-yarn").map(
      m => "org.apache.spark" %% m % sparkVer % "provided"
    )

    val hadoopDeps = Seq("hadoop-client", "hadoop-yarn-client").map(
      m => "org.apache.hadoop" % m % hadoopVer % "provided"
    )

    val hbaseDeps = Seq("hbase-server", "hbase-common", "hbase-hadoop2-compat").map(
      m => "org.apache.hbase" % m % hbaseVer % "provided"
    )

    val coreDeps = Seq(
      "io.spray" %% "spray-json" % "1.3.2",
      "com.typesafe" % "config" % "1.3.1",
      "com.iheart" %% "ficus" % "1.4.0",
      "joda-time" % "joda-time" % "2.9.1",
      "org.joda" % "joda-convert" % "1.8",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
    )

    val testFrameworkDeps = Seq(
      "org.scalatest" %% "scalatest" % "2.2.5",
      "org.scalamock" %% "scalamock-scalatest-support" % "3.2",
      "org.apache.spark" %% "spark-core" % sparkVer classifier "tests",
      "org.apache.spark" %% "spark-sql" % sparkVer classifier "tests"
    ).map(_ % "test")

    val allDependencies = sparkDeps ++
      hadoopDeps ++
      hbaseDeps ++
      coreDeps ++
      testFrameworkDeps
  }
}
