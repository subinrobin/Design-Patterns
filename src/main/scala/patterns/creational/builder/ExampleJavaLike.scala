package patterns.creational.builder

class PersonJ(builder: PersonBuilderJ) {
    val firstName = builder.firstName
    val lastName = builder.lastName
    val age = builder.age
}

class PersonBuilderJ {
    var firstName = ""
    var lastName = ""
    var age = 0

    def setFirstName(firstName: String): PersonBuilderJ = {
        this.firstName = firstName
        this
    }

    def setLastName(lastName: String): PersonBuilderJ = {
        this.lastName = lastName
        this
    }

    def setAge(age: Int): PersonBuilderJ = {
        this.age = age
        this
    }

    def build(): PersonJ = new PersonJ(this)
}

object PersonBuilderExample {
    def main(args: Array[String]): Unit = {
        val person: PersonJ = new PersonBuilderJ()
          .setFirstName("Ivan")
          .setLastName("Nikolov")
          .setAge(26)
          .build()
        System.out.println(s"Person: ${person.firstName} ${person.lastName}. Age: ${person.age}.")
    }
}