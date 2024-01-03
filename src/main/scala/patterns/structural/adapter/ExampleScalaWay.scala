package patterns.structural.adapter

package object adapter {

    implicit class FinalAppLoggerImplicit(logger: FinalLogger) extends Log {

        override def info(message: String): Unit = logger.log(message, "info")

        override def warning(message: String): Unit = logger.log(message, "warning")

        override def error(message: String): Unit = logger.log(message, "error")

        override def debug(message: String): Unit = logger.log(message, "debug")
    }
}

object AdapterImplicitExample {
    def main(args: Array[String]): Unit = {
        // implicit class auto converts final logger to log
        import adapter._
        val logger: Log = new FinalLogger
        logger.info("This is an info message.")
        logger.debug("Debug something here.")
        logger.error("Show an error message.")
        logger.warning("About to finish.")
        logger.info("Bye!")
    }
}