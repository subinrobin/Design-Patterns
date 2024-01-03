package patterns.creational.builder

case class PersonC(
                   firstName: String = "",
                   lastName: String = "",
                   age: Int = 0
                 )

object PersonCaseClassExample {
    def main(args: Array[String]): Unit = {
        val person1 = PersonC(
            firstName = "Ivan",
            lastName = "Nikolov",
            age = 26
        )
        val person2 = PersonC(
            firstName = "John"
        )
        System.out.println(s"Person 1: ${person1}")
        System.out.println(s"Person 2: ${person2}")
    }
}