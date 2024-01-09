package patterns.behavioral.chainOfResponsibility

import scala.io.Source

trait PartialFunctionDispenser {
    def dispense(dispenserAmount: Int): PartialFunction[Money, Money] = {
        case Money(amount) if amount >= dispenserAmount =>
            val notes = amount / dispenserAmount
            val left = amount % dispenserAmount
            System.out.println(s"Dispensing $notes note/s of $dispenserAmount.")
            Money(left)
        case m@Money(amount) => m
    }
}

class PartialFunctionATM extends PartialFunctionDispenser {
    val dispenser =
        dispense(50)
          .andThen(dispense(20))
          .andThen(dispense(10))
          .andThen(dispense(5))

    def requestMoney(money: Money): Unit = {
        if (money.amount % 5 != 0) {
            System.err.println("The smallest nominal is 5 and we cannot satisfy your request.")
        } else {
            dispenser(money)
        }
    }
}

object ATMExampleSW {
    def main(args: Array[String]): Unit = {
        val atm = new PartialFunctionATM
        printHelp()
        Source.stdin.getLines().foreach(line => processLine(line, atm))
    }

    def printHelp(): Unit = {
        System.out.println("Usage: ")
        System.out.println("1. Write an amount to withdraw...")
        System.out.println("2. Write EXIT to quit the application.")
    }

    def processLine(line: String, atm: PartialFunctionATM): Unit = {
        line match {
            case "EXIT" =>
                System.out.println("Bye!")
                System.exit(0)
            case l =>
                try {
                    atm.requestMoney(Money(l.toInt))
                    System.out.println("Thanks!")
                } catch {
                    case _: Throwable =>
                        System.err.println(s"Invalid input: $l.")
                        printHelp()
                }
        }
    }
}