package patterns.behavioral.valueObject

case class Date(
                 day: Int,
                 month: String,
                 year: Int
               )

object DateExample {
    def main(args: Array[String]): Unit = {
        val thirdOfMarch = Date(3, "MARCH", 2016)
        val fourthOfJuly = Date(4, "JULY", 2016)
        val newYear1 = Date(31, "DECEMBER", 2015)
        val newYear2 = Date(31, "DECEMBER", 2015)
        System.out.println(
            s"""The 3rd of March 2016 is the same as
          | the 4th of July 2016: ${thirdOfMarch == fourthOfJuly}""".stripMargin('|'))
        System.out.println(
            s"""The new year of 2015 is here twice:
        | ${newYear1 == newYear2}""".stripMargin('|'))
    }
}

// alternate approach using predefined tuple classes
// eg. (3, "March", 2016)