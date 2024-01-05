package patterns.structural.bridge

import org.apache.commons.codec.binary.Hex

import java.security.MessageDigest

trait Hasher {
    def hash(data: String): String

    protected def getDigest(algorithm: String, data: String): MessageDigest = {
        val crypt = MessageDigest.getInstance(algorithm)
        crypt.reset()
        crypt.update(data.getBytes("UTF-8"))
        crypt
    }
}

class Sha1Hasher extends Hasher {
    override def hash(data: String): String =
        new String(Hex.encodeHex(getDigest("SHA-1", data).digest()))
}

class Sha256Hasher extends Hasher {
    override def hash(data: String): String =
        new String(Hex.encodeHex(getDigest("SHA-256", data).digest()))
}

class Md5Hasher extends Hasher {
    override def hash(data: String): String =
        new String(Hex.encodeHex(getDigest("MD5", data).digest()))
}

abstract class PasswordConverter(hasher: Hasher) {
    def convert(password: String): String
}

class SimplePasswordConverter(hasher: Hasher) extends PasswordConverter(hasher) {
    override def convert(password: String): String =
        hasher.hash(password)
}

class SaltedPasswordConverter(salt: String, hasher: Hasher) extends PasswordConverter(hasher) {
    override def convert(password: String): String =
        hasher.hash(s"${salt}:${password}")
}

object BridgeExample {
    def main(args: Array[String]): Unit = {
        val p1 = new SimplePasswordConverter(new Sha256Hasher)
        val p2 = new SimplePasswordConverter(new Md5Hasher)
        val p3 = new SaltedPasswordConverter("8jsdf32T^$%", new Sha1Hasher)
        val p4 = new SaltedPasswordConverter("8jsdf32T^$%", new Sha256Hasher)
        System.out.println(s"'password' in SHA-256 is: ${p1.convert("password")}")
        System.out.println(s"'1234567890' in MD5 is: ${p2.convert("1234567890")}")
        System.out.println(s"'password' in salted SHA-1 is: ${p3.convert("password")}")
        System.out.println(s"'password' in salted SHA-256 is: ${p4.convert("password")}")
    }
}