package patterns.structural.decorator

import com.typesafe.scalalogging.LazyLogging

import java.io.{BufferedInputStream, BufferedReader, ByteArrayOutputStream, InputStreamReader}
import java.nio.charset.Charset
import java.util.Base64
import java.util.zip.GZIPOutputStream
import scala.jdk.CollectionConverters.IteratorHasAsScala

trait InputReader {
    def readLines(): LazyList[String]
}

class AdvancedInputReader(reader: BufferedReader) extends InputReader {
    override def readLines(): LazyList[String] =
        reader.lines().iterator().asScala.to(LazyList)
}

abstract class InputReaderDecorator(inputReader: InputReader) extends InputReader {
    override def readLines(): LazyList[String] =
        inputReader.readLines()
}

class CapitalizedInputReader(inputReader: InputReader) extends InputReaderDecorator(inputReader) {
    override def readLines(): LazyList[String] =
        super.readLines().map(_.toUpperCase)
}

class CompressingInputReader(inputReader: InputReader) extends InputReaderDecorator(inputReader) with LazyLogging {
    override def readLines(): LazyList[String] = super.readLines().map {
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
}

class Base64EncoderInputReader(inputReader: InputReader) extends InputReaderDecorator(inputReader) {
    override def readLines(): LazyList[String] = super.readLines().map(line => Base64.getEncoder.encodeToString(line.getBytes(Charset.forName("UTF-8"))))
}

object DecoratorExample {
    def main(args: Array[String]): Unit = {
        val stream = new BufferedReader(
            new InputStreamReader(
                new BufferedInputStream(this.getClass.getResourceAsStream("/decorator/data.txt"))
            )
        )
        try {
            val reader = new CapitalizedInputReader(new AdvancedInputReader(stream))
            reader.readLines().foreach(println)
        } finally {
            stream.close()
        }
    }
}

object DecoratorExampleBig {
    def main(args: Array[String]): Unit = {
        val stream = new BufferedReader(
            new InputStreamReader(
                new BufferedInputStream(this.getClass.getResourceAsStream("/decorator/data.txt"))
            )
        )
        try {
            val reader = new CompressingInputReader(
                new Base64EncoderInputReader(
                    new CapitalizedInputReader(
                        new AdvancedInputReader(stream)
                    )
                )
            )
            reader.readLines().foreach(println)
        } finally {
            stream.close()
        }
    }
}