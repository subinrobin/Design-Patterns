package patterns.structural.proxy

import java.io.{BufferedReader, InputStreamReader}
import scala.jdk.CollectionConverters.IteratorHasAsScala

trait FileReader {
    def readFileContents(): String
}

class FileReaderReal(filename: String) extends FileReader {
    val contents = {
        val stream = this.getClass.getResourceAsStream(filename)
        val reader = new BufferedReader(
            new InputStreamReader(
                stream
            )
        )
        try {
            reader.lines()
              .iterator()
              .asScala
              .mkString(System.getProperty("line.separator"))
        } finally {
            reader.close()
            stream.close()
        }
    }
    System.out.println(s"Finished reading the actual file: $filename")

    override def readFileContents(): String = contents
}

class FileReaderProxy(filename: String) extends FileReader {
    private var fileReader: FileReaderReal = _

    override def readFileContents(): String = {
        if (fileReader == null) {
            fileReader = new FileReaderReal(filename)
        }
        fileReader.readFileContents()
    }
}

class FileReaderProxyLazy(filename: String) extends FileReader {
    private lazy val fileReader: FileReaderReal = new FileReaderReal(filename)

    override def readFileContents(): String = {
        fileReader.readFileContents()
    }
}

object ProxyExample {
    def main(args: Array[String]): Unit = {
        val fileMap = Map(
            "file1.txt" -> new FileReaderProxy("/proxy/file1.txt"),
            "file2.txt" -> new FileReaderProxy("/proxy/file2.txt"),
            "file3.txt" -> new FileReaderProxy("/proxy/file3.txt"),
            "file4.txt" -> new FileReaderReal("/proxy/file1.txt")
        )
        System.out.println(
            """Created the map. You should have seen
          file1.txt read because it wasn't used in a proxy.""")
        System.out.println(
            s"""Reading file1.txt from the proxy:
        ${fileMap("file1.txt").readFileContents()}""")
        System.out.println(
            s"""Reading file3.txt from the proxy:
        ${fileMap("file3.txt").readFileContents()}""")
    }
}

object ProxyExampleLazy {
    def main(args: Array[String]): Unit = {
        val fileMap = Map(
            "file1.txt" -> new FileReaderProxyLazy("/proxy/file1.txt"),
            "file2.txt" -> new FileReaderProxyLazy("/proxy/file2.txt"),
            "file3.txt" -> new FileReaderProxyLazy("/proxy/file3.txt"),
            "file4.txt" -> new FileReaderReal("/proxy/file1.txt")
        )
        System.out.println(
            """Created the map. You should have seen
          file1.txt read because it wasn't used in a proxy.""")
        System.out.println(
            s"""Reading file1.txt from the proxy:
        ${fileMap("file1.txt").readFileContents()}""")
        System.out.println(
            s"""Reading file3.txt from the proxy:
        ${fileMap("file3.txt").readFileContents()}""")
    }
}