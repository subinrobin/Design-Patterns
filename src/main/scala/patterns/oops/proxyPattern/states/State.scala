package patterns.oops.proxyPattern.states

trait State {

    def insertQuarter(): Unit

    def ejectQuarter(): Unit

    def turnCrank(): Unit

    def dispense(): Unit

    override def toString(): String = {
        this.getClass().getSimpleName()
    }
}
