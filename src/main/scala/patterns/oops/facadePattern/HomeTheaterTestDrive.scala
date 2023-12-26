package patterns.oops.facadePattern

import patterns.oops.facadePattern.systems.Amplifier
import patterns.oops.facadePattern.systems.Tuner
import patterns.oops.facadePattern.systems.StreamingPlayer
import patterns.oops.facadePattern.systems.Projector
import patterns.oops.facadePattern.systems.Screen
import patterns.oops.facadePattern.systems.TheaterLights
import patterns.oops.facadePattern.systems.PopcornPopper

object HomeTheaterTestDrive {

    def main(args: Array[String]): Unit = {

        val amp = new Amplifier
        val tuner = new Tuner(amp)
        val player = new StreamingPlayer
        val projector = new Projector(player)
        val screen = new Screen
        val lights = new TheaterLights
        val popper = new PopcornPopper

        val homeTheater = new HomeTheaterFacade(
          amp,
          tuner,
          player,
          projector,
          lights,
          screen,
          popper
        )

        homeTheater.watchMovie("Mission Impossible")
        homeTheater.endMovie()
    }

}
