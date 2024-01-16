package patterns.functional.cake

import org.h2.jdbcx.JdbcConnectionPool

import java.sql.Connection

case class Class(id: Int, name: String)
case class Person(id: Int, name: String, age: Int)

trait DatabaseService {
    val dbDriver: String
    val connectionString: String
    val username: String
    val password: String
    val ds = {
        JdbcConnectionPool.create(connectionString, username, password)
    }

    def getConnection: Connection = ds.getConnection
}

trait DatabaseComponent {
    val databaseService: DatabaseService

    class H2DatabaseService(val connectionString: String, val username: String, val password: String) extends DatabaseService {
        val dbDriver = "org.h2.Driver"
    }
}

object ApplicationComponentRegistry
  extends UserComponent
    with DaoComponent
    with DatabaseComponent
    with MigrationComponent {
    override val dao: ApplicationComponentRegistry.Dao = new Dao
    override val databaseService: DatabaseService = new H2DatabaseService("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "", "")
    override val migrationService: ApplicationComponentRegistry.MigrationService = new MigrationService
    override val userService: ApplicationComponentRegistry.UserService = new UserService
}

object Application {

    import ApplicationComponentRegistry._

    def main(args: Array[String]): Unit = {
        migrationService.runMigrations()
        System.out.println(dao.getPeople)
        System.out.println(dao.getClasses)
        System.out.println(dao.getPeopleInClass("Scala Design Patterns"))
        System.out.println(dao.getPeopleInClass("Mountain Biking"))
        System.out.println(s"Average age of everyone in Scala Design Patterns: ${userService.getAverageAgeOfUsersInClass("Scala Design Patterns")}")
    }

//    import scalaz.Reader
//    def getAverageAgeOfUsersInClass(className: String) =
//        Reader((userService: UserService) => userService.getAverageAgeOfUsersInClass(className))
}