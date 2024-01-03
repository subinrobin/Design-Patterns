package patterns.creational.singleton

import scala.collection.concurrent.TrieMap

object StringUtils {
    def countNumberOfSpaces(text: String): Int = text.split("\\s+").length - 1
}

object UtilsExample {
    def main(args: Array[String]): Unit = {
        val sentence = "Hello there! I am a utils example."
        System.out.println(
            s"The number of spaces in '$sentence' is: ${StringUtils.countNumberOfSpaces(sentence)}"
        )
    }
}

// adding state to singleton class here using users Map
object AppRegistry {
    System.out.println("Registry initialization block called.")
    private val users = TrieMap.empty[String, String]

    def addUser(id: String, name: String): Unit = {
        users.put(id, name)
    }

    def removeUser(id: String): Unit = {
        users.remove(id)
    }

    def isUserRegistered(id: String): Boolean = users.contains(id)

    def getAllUserNames(): List[String] = users.values.toList
}

object AppRegistryExample {
    def main(args: Array[String]): Unit = {
        System.out.println("Sleeping for 5 seconds.")
        Thread.sleep(5000)
        System.out.println("I woke up.")
        AppRegistry.addUser("1", "Ivan")
        AppRegistry.addUser("2", "John")
        AppRegistry.addUser("3", "Martin")
        System.out.println(s"Is user with ID=1 registered? ${AppRegistry.isUserRegistered("1")}")
        System.out.println("Removing ID=2")
        AppRegistry.removeUser("2")
        System.out.println(s"Is user with ID=2 registered? ${AppRegistry.isUserRegistered("2")}")
        System.out.println(s"All users registered are: ${AppRegistry.getAllUserNames().mkString (",")}")
    }
}