package patterns.behavioral.strategy

case class Person(name: String, age: Int, address: String)

trait Parser[T] {
    def parse(file: String): List[T]
}

import com.github.tototoshi.csv.CSVReader

import java.io.InputStreamReader

class CSVParser extends Parser[Person] {
    override def parse(file: String): List[Person] =
        CSVReader.open(new
            InputStreamReader(this.getClass.getResourceAsStream(file))).all().map {
            case List(name, age, address) =>
                Person(name, age.toInt, address)
        }
}

import org.json4s._
import org.json4s.jackson.JsonMethods

class JsonParser extends Parser[Person] {
    implicit val formats = DefaultFormats
    override def parse(file: String): List[Person] =
        JsonMethods.parse(this.getClass.getResourceAsStream(file)).extract[List[Person]]
}

object Parser {
    def apply(filename: String): Parser[Person] =
        filename match {
            case f if f.endsWith(".json") => new JsonParser
            case f if f.endsWith(".csv") => new CSVParser
            case f => throw new RuntimeException(s"Unknown format: $f")
        }
}

class PersonApplication[T](parser: Parser[T]) {
    def write(file: String): Unit = {
        System.out.println(s"Got the following data ${parser.parse(file)}")
    }
}

object ParserExample {
    def main(args: Array[String]): Unit = {
        val csvPeople = Parser("/strategy/people.csv")
        val jsonPeople = Parser("/strategy/people.json")
        val applicationCsv = new PersonApplication(csvPeople)
        val applicationJson = new PersonApplication(jsonPeople)
        System.out.println("Using the csv: ")
        applicationCsv.write("/strategy/people.csv")
        System.out.println("Using the json: ")
        applicationJson.write("/strategy/people.json")
    }
}