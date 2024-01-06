package patterns.structural.facade

import com.typesafe.scalalogging.LazyLogging
import org.json4s.{DefaultFormats, StringInput}
import org.json4s.jackson.JsonMethods

import java.util.Base64

case class Person(name: String, age: Int)

trait DataDownloader extends LazyLogging {
    def download(url: String): Array[Byte] = {
        logger.info("Downloading from: {}", url)
        Thread.sleep(5000)
        // {
        // "name": "Ivan",
        // "age": 26
        // }
        // the string below is the Base64 encoded Json above.
        "ew0KICAgICJuYW1lIjogIkl2YW4iLA0KICAgICJhZ2UiOiAyNg0KfQ==".getBytes
    }
}

trait DataDecoder {
    def decode(data: Array[Byte]): String = new String(Base64.getDecoder.decode(data), "UTF-8")
}

trait DataDeserializer {
    implicit val formats = DefaultFormats

    def parse[T](data: String)(implicit m: Manifest[T]): T =
        JsonMethods.parse(data).extract[T]
}


class DataReader extends DataDownloader with DataDecoder with DataDeserializer {
    def readPerson(url: String): Person = {
        val data = download(url)
        val json = decode(data)
        parse[Person](json)
    }
}

object FacadeExample {
    def main(args: Array[String]): Unit = {
        val reader = new DataReader
        System.out.println(s"""We just read the following person: ${reader.readPerson("https://www.ivan-nikolov.com/")}""")
    }
}