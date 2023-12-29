package features.abstractAndSelfTypes

case class Person(name: String)

// Generics
trait Adder {
    def sum[T](a: T, b: T)(implicit numeric: Numeric[T]): T =
        numeric.plus(a, b)
}

class Container[T](data: T) {
    def compare(other: T) = data.equals(other)
}

object GenericsExamples extends Adder {
    def main(args: Array[String]): Unit = {
        System.out.println(s"1 + 3 = ${sum(1, 3)}")
        System.out.println(s"1.2 + 6.7 = ${sum(1.2, 6.7)}")
        // System.out.println(s"abc + cde = ${sum("abc", "cde")}") // compilation fails

        val intContainer = new Container(10)
        System.out.println(s"Comparing with int: ${intContainer.compare(11)}")

        val stringContainer = new Container("some text")
        System.out.println(
          s"Comparing with string: ${stringContainer.compare("some text")}"
        )
    }
}

// abstract types
trait ContainerAT {
    type T
    val data: T

    def compare(other: T) = data.equals(other)
}

class StringContainer(val data: String) extends ContainerAT {
    override type T = String
}

object AbstractTypesExamples {
    def main(args: Array[String]): Unit = {
        val stringContainer = new StringContainer("some text")
        System.out.println(
          s"Comparing with string: ${stringContainer.compare("some text")}"
        )
    }
}

// Generics versus abstract types
abstract class PrintData
abstract class PrintMaterial
abstract class PrintMedia

trait Printer {
    type Data <: PrintData
    type Material <: PrintMaterial
    type Media <: PrintMedia

    def print(data: Data, material: Material, media: Media) =
        s"Printing $data with $material material on $media media."
}

case class Paper() extends PrintMedia
case class Air() extends PrintMedia
case class Text() extends PrintData
case class Model() extends PrintData
case class Toner() extends PrintMaterial
case class Plastic() extends PrintMaterial

class LaserPrinter extends Printer {
    type Media = Paper
    type Data = Text
    type Material = Toner
}

class ThreeDPrinter extends Printer {
    type Media = Air
    type Data = Model
    type Material = Plastic
}

object PrinterExample {
    def main(args: Array[String]): Unit = {
        val laser = new LaserPrinter
        val threeD = new ThreeDPrinter

        System.out.println(laser.print(Text(), Toner(), Paper()))
        System.out.println(threeD.print(Model(), Plastic(), Air()))
    }
}

trait GenericPrinter[
    Data <: PrintData,
    Material <: PrintMaterial,
    Media <: PrintMedia
] {
    def print(data: Data, material: Material, media: Media) =
        s"Printing $data with $material material on $media media."
}

class GenericLaserPrinter[Data <: Text, Material <: Toner, Media <: Paper]
    extends GenericPrinter[Data, Material, Media]
class GenericThreeDPrinter[Data <: Model, Material <: Plastic, Media <: Air]
    extends GenericPrinter[Data, Material, Media]

class GenericPrinterImpl[
    Data <: PrintData,
    Material <: PrintMaterial,
    Media <: PrintMedia
] extends GenericPrinter[Data, Material, Media]

object GenericPrinterExample {
    def main(args: Array[String]): Unit = {
        val genericLaser = new GenericLaserPrinter[Text, Toner, Paper]
        val genericThreeD = new GenericThreeDPrinter[Model, Plastic, Air]
        System.out.println(genericLaser.print(Text(), Toner(), Paper()))
        System.out.println(genericThreeD.print(Model(), Plastic(), Air()))

        // val wrongPrinter = new GenericPrinterImpl[Model, Toner, Air]
        // System.out.println(wrongPrinter.print(Model(), Toner(), Air()))
    }
}
