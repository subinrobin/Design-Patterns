package patterns.structural.decorator

import com.typesafe.scalalogging.LazyLogging

import java.io.{BufferedInputStream, BufferedReader, ByteArrayOutputStream, InputStreamReader}
import java.nio.charset.Charset
import java.util.Base64
import java.util.zip.GZIPOutputStream
import scala.jdk.CollectionConverters.IteratorHasAsScala

trait InputReaderSW {
    def readLines(): LazyList[String]
}

class AdvancedInputReaderSW(reader: BufferedReader) extends InputReaderSW {
    override def readLines(): LazyList[String] = {
        System.err.println("AdvancedInputReaderSW", "readLine")
        val lines = reader.lines().iterator().asScala.to(LazyList)
        System.err.println("AdvancedInputReaderSW", "readLines")
        lines
    }
}

trait CapitalizedInputReaderTraitSW extends InputReaderSW {
    abstract override def readLines(): LazyList[String] = {
        System.err.println("CapitalizedInputReaderTraitSW", "readLine")
        val lines = super.readLines()
          System.err.println("CapitalizedInputReaderTraitSW", "readLines")
          lines.map(_.toUpperCase)
    }
}

trait CompressingInputReaderTraitSW extends InputReaderSW with LazyLogging {
    abstract override def readLines(): LazyList[String] = {
        System.err.println("CompressingInputReaderTraitSW", "readLine")
        val lines = super.readLines().map {
            line =>
                val text = line.getBytes(Charset.forName("UTF-8"))
                logger.info("Length before compression: {}", text.length.toString)
                val output = new ByteArrayOutputStream()
                val compressor = new GZIPOutputStream(output)
                try {
                    compressor.write(text, 0, text.length)
                    val outputByteArray = output.toByteArray
                    logger.info("Length after compression: {}",
                        outputByteArray.length.toString)
                    new String(outputByteArray, Charset.forName("UTF-8"))
                } finally {
                    compressor.close()
                    output.close()
                }
        }
        System.err.println("CompressingInputReaderTraitSW", "readLines")
        lines
    }
}

trait Base64EncoderInputReaderTraitSW extends InputReaderSW {
    abstract override def readLines(): LazyList[String] = {
        System.err.println("Base64EncoderInputReaderTraitSW", "readLine")
        val lines = super.readLines().map {
            line =>
                Base64.getEncoder.encodeToString(line.getBytes(Charset.forName("UTF-8")))
        }
        System.err.println("Base64EncoderInputReaderTraitSW", "readLines")
        lines
    }
}

object StackableTraitsExample {
    def main(args: Array[String]): Unit = {
        val stream = new BufferedReader(
            new InputStreamReader(
                new BufferedInputStream(this.getClass.getResourceAsStream("/decorator/data.txt"))
            )
        )
        try {
            val reader = new AdvancedInputReaderSW(stream) with CapitalizedInputReaderTraitSW
            reader.readLines().foreach(println)
        } finally {
            stream.close()
        }
    }
}

object StackableTraitsBigExample {
    def main(args: Array[String]): Unit = {
        val stream = new BufferedReader(
            new InputStreamReader(
                new BufferedInputStream(this.getClass.getResourceAsStream("/decorator/data.txt"))
            )
        )
        try {
            val reader = {
                new AdvancedInputReaderSW(stream)
                  with CapitalizedInputReaderTraitSW
                  with Base64EncoderInputReaderTraitSW
                  with CompressingInputReaderTraitSW
            }
            reader.readLines().foreach(println)
        } finally {
            stream.close()
        }
    }
}