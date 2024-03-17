A Study of Spark in Scala
=========================
# Set up
1. Download Spark from [here](https://spark.apache.org/downloads.html)
2. Unzip 
```
tar xvf spark-3.3.0-bin-hadoop3.tgz
```
3. Move to `/opt`
```
sudo mv spark-3.3.0-bin-hadoop3 /opt/spark
```
4. Add environment variables for Spark
```
export SPARK_HOME=/opt/spark
export PATH=$PATH:$SPARK_HOME/bin:$SPARK_HOME/sbin
```
5. Run the spark shell
```
spark-shell
```
# Data
```
wget https://dst-de.s3.eu-west-3.amazonaws.com/scala_spark_fr/shakespeare.txt
```
6. Install sbt. The instructions below are for Ubuntu as of 2024-03-16. The latest instructions can be found [here](https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Linux.html)
```
sudo apt-get update
sudo apt-get install apt-transport-https curl gnupg -yqq
echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | sudo tee /etc/apt/sources.list.d/sbt.list
echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | sudo tee /etc/apt/sources.list.d/sbt_old.list
curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo -H gpg --no-default-keyring --keyring gnupg-ring:/etc/apt/trusted.gpg.d/scalasbt-release.gpg --import
sudo chmod 644 /etc/apt/trusted.gpg.d/scalasbt-release.gpg
sudo apt-get update
sudo apt-get install sbt
```


# Spark web ui
While Spark-shell is running, you can see the history of Spark jobs run via the Spark Shell application UI
[http://localhost:4040/jobs/](http://localhost:4040/jobs/)

# How to use
1. To run the app with 2 cores, use the following (not you can use replace `local[2]` with `local[*]` to use all available cores instead)
```
spark-submit --class "SimpleApp" --master local[2] target/scala-2.13/apachespark_2.13-0.1.0-SNAPSHOT.jarA
```
