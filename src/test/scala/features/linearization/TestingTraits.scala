package features.linearization

import features.mixinCompositions.A
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

// class DoubledMultiplierIdentityTest
//     extends AnyFlatSpec
//     with Matchers
//     with DoubledMultiplierIdentity

class DoubledMultiplierIdentityTest extends AnyFlatSpec with Matchers {

    // using class for testing trait
    class DoubledMultiplierIdentityClass extends DoubledMultiplierIdentity

    val instance = new DoubledMultiplierIdentityClass

    "identity" should "return 2 * 1" in {
        instance.identity should equal(2)
    }
}

class TraitATest extends AnyFlatSpec with Matchers with A {

    // mixing into test class
    "hello" should "greet properly." in {
        hello() should equal("Hello, I am trait A!")
    }
}

class TraitACaseScopeTest extends AnyFlatSpec with Matchers {

    // mixing into test cases
    "hello" should "greet properly." in new A {
        hello() should equal("Hello, I am trait A!")
    }
}
