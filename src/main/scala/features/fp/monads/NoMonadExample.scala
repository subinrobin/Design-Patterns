package features.fp.monads

case class Doer() {
    def getAlgorithm(isFail: Boolean): Algorithm =
        if (isFail) {
            null
        } else {
            Algorithm()
        }
}

case class Algorithm() {
    def getImplementation(isFail: Boolean, left: Int, right: Int): Implementation =
        if (isFail) {
            null
        } else {
            Implementation(left, right)
        }
}

case class Implementation(left: Int, right: Int) {
    def compute: Int = left + right
}

object NoMonadExample {
    def main(args: Array[String]): Unit = {
        System.out.println(s"The result is: ${compute(Doer(), 10, 16)}")
    }

    def compute(doer: Doer, left: Int, right: Int): Int =
        if (doer != null) {
            val algorithm = doer.getAlgorithm(false)
            if (algorithm != null) {
                val implementation = algorithm.getImplementation(false,
                    left, right)
                if (implementation != null) {
                    implementation.compute
                } else {
                    -1
                }
            } else {
                -1
            }
        } else {
            -1
        }
}