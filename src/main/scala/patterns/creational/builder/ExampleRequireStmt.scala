package patterns.creational.builder

case class Person(
                   firstName: String = "",
                   lastName: String = "",
                   age: Int = 0
                 ) {
    require(firstName != "", "First name is required.")
    require(lastName != "", "Last name is required.")
}

object PersonCaseClassRequireExample {
    def main(args: Array[String]): Unit = {
        val person1 = Person(
            firstName = "Ivan",
            lastName = "Nikolov",
            age = 26
        )
        System.out.println(s"Person 1: ${person1}")
        try {
            val person2 = Person(
                firstName = "John"
            )
            System.out.println(s"Person 2: ${person2}")
        } catch {
            case e: Throwable =>
                e.printStackTrace()
        }
    }
}
