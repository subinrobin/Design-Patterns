package patterns.structural.bridge

import org.apache.commons.codec.binary.Hex

trait Sha1HasherSW extends Hasher {
    override def hash(data: String): String =
        new String(Hex.encodeHex(getDigest("SHA-1", data).digest()))
}

trait Sha256HasherSW extends Hasher {
    override def hash(data: String): String =
        new String(Hex.encodeHex(getDigest("SHA-256", data).digest()))
}

trait Md5HasherSW extends Hasher {
    override def hash(data: String): String =
        new String(Hex.encodeHex(getDigest("MD5", data).digest()))
}

abstract class PasswordConverterBase {
    self: Hasher =>
    def convert(password: String): String
}

class SimplePasswordConverterScala extends PasswordConverterBase {
    self: Hasher =>
    override def convert(password: String): String =
        hash(password)
}

class SaltedPasswordConverterScala(salt: String) extends PasswordConverterBase {
    self: Hasher =>
    override def convert(password: String): String =
        hash(s"${salt}:${password}")
}

object ScalaBridgeExample {
    def main(args: Array[String]): Unit = {
        val p1 = new SimplePasswordConverterScala with Sha256HasherSW
        val p2 = new SimplePasswordConverterScala with Md5HasherSW
        val p3 = new SaltedPasswordConverterScala("8jsdf32T^$%") with Sha1HasherSW
        val p4 = new SaltedPasswordConverterScala("8jsdf32T^$%") with Sha256HasherSW
        System.out.println(s"'password' in SHA-256 is: ${p1.convert("password")}")
        System.out.println(s"'1234567890' in MD5 is: ${p2.convert("1234567890")}")
        System.out.println(s"'password' in salted SHA-1 is: ${p3.convert("password")}")
        System.out.println(s"'password' in salted SHA-256 is: ${p4.convert("password")}")
    }
}