package patterns.oops.compositePattern.menus

import scala.collection.mutable.ListBuffer

case class Menu(override val name: String, override val description: String)
    extends MenuComponent {
        val menuComponents = ListBuffer.empty[MenuComponent]
        
        override def add(value: MenuComponent): Unit = {
            menuComponents.addOne(value)
        }

        override def remove(value: MenuComponent): Unit = {
            val i = menuComponents.indexOf(value)
            menuComponents.remove(i)
        }

        override def getChild(i: Int): MenuComponent = {
            menuComponents(i)
        }

        override def print(): Unit = {
            println(name)
            println(description)
            println("-----------------------")

            menuComponents.foreach(_.print())
        }
    }
