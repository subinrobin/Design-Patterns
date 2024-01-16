package patterns.functional.lens

// case class Lens[X, Y](get: X => Y, set: (X, Y) => X)

import scalaz.Lens

case class Country2(name: String, code: String)
case class City2(name: String, country: Country2)
case class Address2(number: Int, street: String, city: City2)
case class Company2(name: String, address: Address2)
case class User2(name: String, company: Company2, address: Address2)

object User2 {
    val userCompany = Lens.lensu[User2, Company2](
        (u, company) => u.copy(company = company), _.company
    )
    val userAddress = Lens.lensu[User2, Address2](
        (u, address) => u.copy(address = address), _.address
    )
    val companyAddress = Lens.lensu[Company2, Address2](
        (c, address) => c.copy(address = address), _.address
    )
    val addressCity = Lens.lensu[Address2, City2](
        (a, city) => a.copy(city = city), _.city
    )

    val cityCountry = Lens.lensu[City2, Country2](
        (c, country) => c.copy(country = country), _.country
    )
    val countryCode = Lens.lensu[Country2, String](
        (c, code) => c.copy(code = code), _.code
    )
    val userCompanyCountryCodeAndThen = userCompany >=> companyAddress >=> addressCity >=> cityCountry >=> countryCode

    val userCompanyCountryCodeCompose = countryCode <=< cityCountry <=< addressCity <=< companyAddress <=< userCompany
}

object Example {
    import User2._
    def main(args: Array[String]): Unit = {
        val uk = Country2("United Kingdom", "uk")
        val london = City2("London", uk)
        val buckinghamPalace = Address2(1, "Buckingham Palace Road", london)
        val castleBuilders = Company2("Castle Builders", buckinghamPalace)
        val switzerland = Country2("Switzerland", "CH")
        val geneva = City2("geneva", switzerland)
        val genevaAddress = Address2(1, "Geneva Lake", geneva)
        val ivan = User2("Ivan", castleBuilders, genevaAddress)
        System.out.println(ivan)
        System.out.println("Capitalize UK code...")
        val ivanFixed = userCompanyCountryCodeAndThen.mod(_.toUpperCase, ivan)
        System.out.println(ivanFixed)
    }
}