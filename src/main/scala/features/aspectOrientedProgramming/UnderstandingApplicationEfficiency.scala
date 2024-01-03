package features.aspectOrientedProgramming

import org.json4s._
import org.json4s.jackson.JsonMethods._

import java.io.InputStream

sealed case class Person(firstName: String, lastName: String, age: Int)

trait DataReader {
    def readData(): List[Person]
    def readDataInefficiently(): List[Person]
}

class DataReaderImpl extends DataReader {
    implicit val formats: DefaultFormats.type = DefaultFormats

    private def readUntimed(): List[Person] = {
        val inputStream: InputStream = getClass.getResourceAsStream("/aop/users.json")
        parse(inputStream).extract[List[Person]]
    }

    override def readData(): List[Person] = readUntimed()

    override def readDataInefficiently(): List[Person] = {
        (1 to 10000).foreach(_ => readUntimed())
        readUntimed()
    }
}

object DataReaderExample {
    def main(args: Array[String]): Unit = {
        val dataReader = new DataReaderImpl
        System.out.println(
          s"I just read the following data efficiently: ${dataReader.readData()}"
        )
        System.out.println(
          s"I just read the following data inefficiently: ${dataReader.readDataInefficiently()}"
        )
    }
}

// timing application without aop
class DataReaderImplWithLogging extends DataReader {
    implicit val formats: DefaultFormats.type = DefaultFormats

    private def readUntimed(): List[Person] = {
        val inputStream: InputStream = getClass.getResourceAsStream("/aop/users.json")
        parse(inputStream).extract[List[Person]]
    }

    override def readData(): List[Person] = {
        val startMillis = System.currentTimeMillis()
        val result = readUntimed()
        val time = System.currentTimeMillis() - startMillis
        System.err.println(s"readData took $time milliseconds.")
        result
    }

    override def readDataInefficiently(): List[Person] = {
        val startMillis = System.currentTimeMillis()
        (1 to 10000).foreach(_ => readUntimed())
        val result = readUntimed()
        val time = System.currentTimeMillis() - startMillis
        System.err.println(s"readDataInefficiently took $time milliseconds.")
        result
    }
}

object DataReaderWithLoggingExample {
    def main(args: Array[String]): Unit = {
        val dataReader = new DataReaderImplWithLogging
        System.out.println(
            s"I just read the following data efficiently: ${dataReader.readData()}"
        )
        System.out.println(
            s"I just read the following data inefficiently: ${dataReader.readDataInefficiently()}"
        )
    }
}


// timing application using aop
trait LoggingDataReader extends DataReader {

    abstract override def readData(): List[Person] = {
        val startMillis = System.currentTimeMillis()
        val result = super.readData()
        val time = System.currentTimeMillis() - startMillis
        System.err.println(s"readData took $time milliseconds.")
        result
    }

    abstract override def readDataInefficiently(): List[Person] = {
        val startMillis = System.currentTimeMillis()
        val result = super.readDataInefficiently()
        val time = System.currentTimeMillis() - startMillis
        System.err.println(s"readDataInefficiently took $time milliseconds.")
        result
    }
}

object DataReaderAOPExample {
    def main(args: Array[String]): Unit = {
        val dataReader = new DataReaderImpl with LoggingDataReader
        System.out.println(s"I just read the following data efficiently: ${dataReader.readData()}")
        System.out.println(s"I just read the following data inefficiently: ${dataReader.readDataInefficiently()}")
    }
}
