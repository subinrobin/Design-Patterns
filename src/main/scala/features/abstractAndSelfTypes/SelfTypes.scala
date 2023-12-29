package features.abstractAndSelfTypes

trait Persister[T] {
    this: Database[T] with History with Mystery =>
    def persist(data: T): Unit = {
        println("Calling persist")
        save(data)
        add()
    }
}

import scala.collection.mutable

trait Database[T] {
    def save(data: T)
}

trait MemoryDatabase[T] extends Database[T] {
    val db: mutable.ListBuffer[T] = mutable.ListBuffer.empty

    override def save(data: T): Unit = {
        System.out.println("Saving to in memory database.")
        db.+=:(data)
    }
}

trait FileDatabase[T] extends Database[T] {
    override def save(data: T): Unit = {
        System.out.println("Saving to file.")
    }
}

class FilePersister[T]
    extends Persister[T]
    with FileDatabase[T]
    with History
    with Mystery {
    override def add(): Unit = {
        super[History].add()
    }
}

class MemoryPersister[T]
    extends Persister[T]
    with MemoryDatabase[T]
    with History
    with Mystery {
    override def add(): Unit = {
        super[Mystery].add()
    }
}
object PersisterExample {
    def main(args: Array[String]): Unit = {
        val fileStringPersister = new FilePersister[String]
        val memoryIntPersister = new MemoryPersister[Int]

        fileStringPersister.persist("Something")
        fileStringPersister.persist("Something else")

        memoryIntPersister.persist(100)
        memoryIntPersister.persist(123)
    }
}

// Requiring multiple components as self type
trait History {
    def add(): Unit = {
        System.out.println("Action added to history.")
    }
}

// conflicting components
trait Mystery {
    def add(): Unit = {
        System.out.println("Mystery added!")
    }
}
