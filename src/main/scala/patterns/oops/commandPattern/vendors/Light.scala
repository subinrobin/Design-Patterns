package patterns.oops.commandPattern.vendors

class Light(room: String) {
    def on(): Unit = {
        println("switch on light")
    }

    def off(): Unit = {
        println("switch off light")
    }
}
