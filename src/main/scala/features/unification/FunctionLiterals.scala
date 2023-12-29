package features.unification

class FunctionLiterals {
    val sum = (a: Int, b: Int) => a + b

    def runOperation(f: (Int, Int) => Int, a: Int, b: Int): Int = {
        f(a, b)
    }
}

object FunctionLiterals {

    def main(args: Array[String]): Unit = {
        val obj = new FunctionLiterals
        System.out.println(s"3 + 9 = ${obj.sum(3, 9)}")

        println(obj.runOperation(obj.sum, 10, 20))
        println(obj.runOperation(Math.max, 10, 20))
    }
}

// below is the low level (without syntactic sugar) implementation of above

class SumFunction extends Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
}

class FunctionObjects {
    val sum = new SumFunction

    def runOperation(f: (Int, Int) => Int, a: Int, b: Int): Int = f(a, b)
}

object FunctionObjects {

    def main(args: Array[String]): Unit = {
        val obj = new FunctionObjects
        System.out.println(s"3 + 9 = ${obj.sum(3, 9)}")
        System.out.println(s"Calling run operation: ${obj.runOperation(obj.sum, 10, 20)}")
        System.out.println(s"Using Math.max: ${obj.runOperation(Math.max, 10, 20)}")
    }
}
