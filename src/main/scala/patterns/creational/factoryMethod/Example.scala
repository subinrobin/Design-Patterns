package patterns.creational.factoryMethod

trait SimpleConnection {
    val name: String = this.getClass.getSimpleName

    def executeQuery(query: String): Unit
}

class SimpleMysqlConnection extends SimpleConnection {

    override def executeQuery(query: String): Unit = {
        System.out.println(s"Executing the query '$query' the $name way.")
    }
}

class SimplePgSqlConnection extends SimpleConnection {

    override def executeQuery(query: String): Unit = {
        System.out.println(s"Executing the query '$query' the $name way.")
    }
}

abstract class DatabaseClient {
    def executeQuery(query: String): Unit = {
        val connection = connect()
        connection.executeQuery(query)
    }

    protected def connect(): SimpleConnection
}

class MysqlClient extends DatabaseClient {
    override protected def connect(): SimpleConnection = new SimpleMysqlConnection
}

class PgSqlClient extends DatabaseClient {
    override protected def connect(): SimpleConnection = new SimplePgSqlConnection
}

object Example {
    def main(args: Array[String]): Unit = {
        val clientMySql: DatabaseClient = new MysqlClient
        val clientPgSql: DatabaseClient = new PgSqlClient
        clientMySql.executeQuery("SELECT * FROM users")
        clientPgSql.executeQuery("SELECT * FROM employees")
    }
}