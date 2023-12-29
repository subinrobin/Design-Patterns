package features.unification

// Algebraic data types and class hierarchies

/* Algebraic data types are just composite types that combine other existing types or just represent some new ones.
They only have data and do not contain any functionality on top of this data as normal classes would.
Some examples can include the day of the week or a class that represents an RGB color—they have no extra functionality and they just carry information.  */

// Sum ADTs
sealed abstract trait Days
case object Sunday extends Days
case object Monday extends Days
case object Tuesday extends Days
case object Wednesday extends Days
case object Thursday extends Days
case object Friday extends Days
case object Satruday extends Days

object DayDemo {
    def main(args: Array[String]): Unit = {
        val day: Days = Monday
        System.out.println(s"The current day is: $day , ${Days.toInt(day)}")
    }
}

// Product ADTs
sealed case class RGB(red: Int, green: Int, blue: Int)

object RGBDemo {
    def main(args: Array[String]): Unit = {
        val magenta = RGB(255, 0, 255)
        System.out.println(s"Magenta in RGB is: $magenta")
    }
}

// Hybrid ADTs (mix of sum and product)
case class Point(x: Double, y: Double)

sealed abstract trait Shape
case class Circle(centre: Point, radius: Double) extends Shape
case class Rectangle(topLeft: Point, height: Double, width: Double)
    extends Shape

// pattern matching for Sum ADT
object Days {
    def toInt(month: Days): Int =
        month match {
            case Monday    => 1
            case Tuesday   => 2
            case Wednesday => 3
            case Thursday  => 4
            case Friday    => 5
            case Satruday  => 6
            case Sunday    => 7
        }
}

// pattern matching for product ADT
object Shape {
    def area(shape: Shape): Double =
        shape match {
            case Circle(Point(_, _), radius) => Math.PI * Math.pow(radius, 2)
            case Rectangle(_, h, w)          => h * w
        }
}

object ShapeDemo {
    def main(args: Array[String]): Unit = {
        val circle = Circle(Point(1, 2), 2.5)
        val rect = Rectangle(Point(6, 7), 5, 6)

        System.out.println(s"The circle area is: ${Shape.area(circle)}")
        System.out.println(s"The rectangle area is: ${Shape.area(rect)}")
    }
}
