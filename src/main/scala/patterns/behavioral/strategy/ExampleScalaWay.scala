package patterns.behavioral.strategy

class Application[T](strategy: (String) => List[T]) {
    def write(file: String): Unit = {
        System.out.println(s"Got the following data ${strategy(file)}")
    }
}

import com.github.tototoshi.csv.CSVReader
import org.json4s.{DefaultFormats, StreamInput}
import org.json4s.jackson.JsonMethods

import java.io.InputStreamReader

object StrategyFactory {
    implicit val formats = DefaultFormats

    def apply(filename: String): (String) => List[Person] =
        filename match {
            case f if f.endsWith(".json") => parseJson
            case f if f.endsWith(".csv") => parseCsv
            case f => throw new RuntimeException(s"Unknown format: $f")
        }

    def parseJson(file: String): List[Person] =
        JsonMethods.parse(this.getClass.getResourceAsStream(file)).extract[List[Person]]

    def parseCsv(file: String): List[Person] = CSVReader.open(new
        InputStreamReader(this.getClass.getResourceAsStream(file))).all().map {
        case List(name, age, address) => Person(name, age.toInt, address)
    }
}

object StrategyExample {
    def main(args: Array[String]): Unit = {
        val applicationCsv = new Application[Person](StrategyFactory("/strategy/people.csv"))
        val applicationJson = new Application[Person](StrategyFactory("/strategy/people.json"))
        System.out.println("Using the csv: ")
        applicationCsv.write("/strategy/people.csv")
        System.out.println("Using the json: ")
        applicationJson.write("/strategy/people.json")
    }
}