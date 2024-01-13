package patterns.behavioral.state

trait State[T] {
    def press(context: T)
}

class Playing extends State[MediaPlayer] {
    override def press(context: MediaPlayer): Unit = {
        System.out.println("Pressing pause.")
        context.setState(new Paused)
    }
}

class Paused extends State[MediaPlayer] {
    override def press(context: MediaPlayer): Unit = {
        System.out.println("Pressing play.")
        context.setState(new Playing)
    }
}

case class MediaPlayer() {
    private var state: State[MediaPlayer] = new Paused

    def pressPlayOrPauseButton(): Unit = {
        state.press(this)
    }

    def setState(state: State[MediaPlayer]): Unit = {
        this.state = state
    }
}

object MediaPlayerExample {
    def main(args: Array[String]): Unit = {
        val player = MediaPlayer()
        player.pressPlayOrPauseButton()
        player.pressPlayOrPauseButton()
        player.pressPlayOrPauseButton()
        player.pressPlayOrPauseButton()
    }
}