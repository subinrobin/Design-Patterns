package features.fp.monads

import java.io.{File, PrintWriter}
import scala.io.Source

sealed trait State {
    def next: State
}

abstract class FileIO {

    // this makes sure nobody can create a state
    private class FileIOState(id: Int) extends State {
        override def next: State = new FileIOState(id + 1)
    }

    def run(args: Array[String]): Unit = {
        val action = runIO(args(0), args(1))
        action(new FileIOState(0))
    }

    def runIO(readPath: String, writePath: String): IOAction[_]
}

sealed abstract class IOAction[T] extends ((State) => (State, T)) {
    // START: we don't have to extend. We could also do this...
    def unit[Y](value: Y): IOAction[Y] = IOAction(value)

    def flatMap[Y](f: (T) => IOAction[Y]): IOAction[Y] = {
        val self = this
        new IOAction[Y] {
            override def apply(state: State): (State, Y) = {
                val (state2, res) = self(state)
                val action2 = f(res)
                action2(state2)
            }

        }
    }

    def map[Y](f: T => Y): IOAction[Y] =
        flatMap(i => unit(f(i)))

    // END: we don't have to extend. We could also do this...
}

object IOAction {
    def apply[T](result: => T): IOAction[T] =
        new SimpleAction[T](result)

    private class SimpleAction[T](result: => T) extends IOAction[T] {
        override def apply(state: State): (State, T) =
            (state.next, result)
    }

}

sealed abstract class IOActionNoStateChange[T] extends ((State) => (State, T)) {
    // START: we don't have to extend. We could also do this...
    def unit[Y](value: Y): IOActionNoStateChange[Y] = IOActionNoStateChange.unit(value)

    def flatMap[Y](f: (T) => IOActionNoStateChange[Y]): IOActionNoStateChange[Y] = {
        val self = this
        new IOActionNoStateChange[Y] {
            override def apply(state: State): (State, Y) = {
                val (state2, res) = self(state)
                val action2 = f(res)
                action2(state2)
            }

        }
    }

    def map[Y](f: T => Y): IOActionNoStateChange[Y] =
        flatMap(i => unit(f(i)))

    // END: we don't have to extend. We could also do this...
}

object IOActionNoStateChange {
    def apply[T](result: => T): IOActionNoStateChange[T] =
        new EmptyAction[T](result)

    private class EmptyAction[T](value: T) extends IOActionNoStateChange[T] {
        override def apply(state: State): (State, T) =
            (state, value)
    }

    def unit[T](value: T): IOActionNoStateChange[T] = new EmptyAction[T](value)

}

package object io {
    def readFile(path: String) =
        IOAction(Source.fromFile(path).getLines())

    def writeFile(path: String, lines: Iterator[String]) =
        IOAction({
            val file = new File(path)
            printToFile(file) { p => lines.foreach(p.println) }
        })

    private def printToFile(file: File)(writeOp: PrintWriter => Unit): Unit = {
        val writer = new PrintWriter(file)
        try {
            writeOp(writer)
        } finally {
            writer.close()
        }
    }
}


object FileIOExample extends FileIO {
    import io._
    def main(args: Array[String]): Unit = {
        val baseDir = "src/main/resources/monads/"
        val args1 = Array(s"${baseDir}input.txt", s"${baseDir}output.txt")
        run(args1)
    }

    override def runIO(readPath: String, writePath: String): IOAction[_] =
        for {
            lines <- readFile(readPath)
            _ <- writeFile(writePath, lines.map(_.toUpperCase))
        } yield ()
}