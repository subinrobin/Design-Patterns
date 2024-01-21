package patterns.functional.pimpMyLibrary

case class Person(name: String, age: Int)

package object pimp {
    implicit class StringExtensions(val s: String) extends AnyVal {
        def isAllUpperCase: Boolean =
            !(0 until s.length).exists {
                index =>
                    s.charAt(index).isLower
            }
    }

    implicit class PersonSeqExtensions(val seq: Iterable[Person]) extends AnyVal {
        def saveToDatabase(): Unit = {
            seq.foreach {
                person =>
                    System.out.println(s"Saved: ${person} to the database.")
            }
        }
    }
}

object PimpExample {
    import pimp._
    def main(args: Array[String]): Unit = {
        System.out.println(s"Is 'test' all upper case:${"test".isAllUpperCase}")
        System.out.println(s"Is 'Tes' all upper case:${"Test".isAllUpperCase}")
        System.out.println(s"Is 'TESt' all upper case:${"TESt".isAllUpperCase}")
        System.out.println(s"Is 'TEST' all upper case:${"TEST".isAllUpperCase}")

        val people = List(
            Person("Ivan", 26),
            Person("Maria", 26),
            Person("John", 25)
        )
        people.saveToDatabase()
    }
}