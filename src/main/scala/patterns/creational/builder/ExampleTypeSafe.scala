package patterns.creational.builder

sealed trait BuildStep
sealed trait HasFirstName extends BuildStep
sealed trait HasLastName extends BuildStep

class PersonTS(
              val firstName: String,
              val lastName: String,
              val age: Int
            )

class PersonBuilderTS[PassedStep <: BuildStep] private(
                                                      var firstName: String,
                                                      var lastName: String,
                                                      var age: Int
                                                    ) {
    protected def this() = this("", "", 0)

    protected def this(pb: PersonBuilderTS[_]) = this(
        pb.firstName,
        pb.lastName,
        pb.age
    )

    def setFirstName(firstName: String): PersonBuilderTS[HasFirstName] = {
        this.firstName = firstName
        new PersonBuilderTS[HasFirstName](this)
    }

    def setLastName(lastName: String)(implicit ev: PassedStep =:= HasFirstName): PersonBuilderTS[HasLastName] = {
        this.lastName = lastName
        new PersonBuilderTS[HasLastName](this)
    }

    def setAge(age: Int): PersonBuilderTS[PassedStep] = {
        this.age = age
        this
    }

    def build()(implicit ev: PassedStep =:= HasLastName): PersonTS =
        new PersonTS(
            firstName,
            lastName,
            age
        )
}

object PersonBuilderTS {
    def apply() = new PersonBuilderTS[BuildStep]()
}

// set firstname should have happened before set lastname
// drawbacks: Complexity, Mutability, predefined order of initialization
// use only when compile time validation is required
object PersonBuilderTypeSafeExample {
    def main(args: Array[String]): Unit = {
        val person = PersonBuilderTS()
          .setFirstName("Ivan")
          .setAge(26)
          .setLastName("Nikolov")
          .build()
        System.out.println(s"Person: ${person.firstName} ${person.lastName}. Age: ${person.age}.")
    }
}