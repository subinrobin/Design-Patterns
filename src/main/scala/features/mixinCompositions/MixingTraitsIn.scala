package features.mixinCompositions

import features.traits.Ping
import features.traits.Pong

object MixinRunner extends Ping with Pong {
    def main(args: Array[String]): Unit = {
        ping()
        pong()
    }
}
