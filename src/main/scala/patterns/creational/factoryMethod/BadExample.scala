package patterns.creational.factoryMethod

trait SimpleConnectionPrinter {
    def printSimpleConnection(connection: SimpleConnection): Unit
}

abstract class BadDatabaseClient {

    protected val connectionPrinter: SimpleConnectionPrinter

    def executeQuery(query: String): Unit = {
        val connection = connect()
        connectionPrinter.printSimpleConnection(connection)
        connection.executeQuery(query)
    }

    protected def connect(): SimpleConnection

}

class SimpleMySqlConnectionPrinter extends SimpleConnectionPrinter {
    override def printSimpleConnection(connection: SimpleConnection): Unit = {
        System.out.println(s"I require a MySQL connection. It is: '${connection.name}'")
    }
}

class SimplePgSqlConnectionPrinter extends SimpleConnectionPrinter {
    override def printSimpleConnection(connection: SimpleConnection): Unit = {
        System.out.println(s"I require a PgSQL connection. It is: '${connection.name}'")
    }
}

class BadMySqlClient extends BadDatabaseClient {
    override protected def connect(): SimpleConnection = new SimpleMysqlConnection

    override protected val connectionPrinter: SimpleConnectionPrinter = new SimpleMySqlConnectionPrinter
}

class BadPgSqlClient extends BadDatabaseClient {
    override protected def connect(): SimpleConnection = new SimplePgSqlConnection

    override protected val connectionPrinter: SimpleConnectionPrinter = new SimpleMySqlConnectionPrinter
}

// both BadDatabaseClient creates SimpleMysqlConnectionPrinter, which requires to be handled carefully
object BadExample {
    def main(args: Array[String]): Unit = {
        val clientMySql: BadDatabaseClient = new BadMySqlClient
        val clientPgSql: BadDatabaseClient = new BadPgSqlClient
        clientMySql.executeQuery("SELECT * FROM users")
        clientPgSql.executeQuery("SELECT * FROM employees")
    }
}