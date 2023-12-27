package patterns.oops.iteratorPattern.menu

import scala.collection.Iterator

trait Menu {
  
    def createIterator(): Iterator[MenuItem]
}
