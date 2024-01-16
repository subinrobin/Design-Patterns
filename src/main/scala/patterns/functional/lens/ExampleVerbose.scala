package patterns.functional.lens

case class Country(name: String, code: String)
case class City(name: String, country: Country)
case class Address(number: Int, street: String, city: City)
case class Company(name: String, address: Address)
case class User(name: String, company: Company, address: Address)

object UserVerboseExample {
    def main(args: Array[String]): Unit = {
        val uk = Country("United Kingdom", "uk")
        val london = City("London", uk)
        val buckinghamPalace = Address(1, "Buckingham Palace Road", london)
        val castleBuilders = Company("Castle Builders", buckinghamPalace)
        val switzerland = Country("Switzerland", "CH")
        val geneva = City("geneva", switzerland)
        val genevaAddress = Address(1, "Geneva Lake", geneva)
        val ivan = User("Ivan", castleBuilders, genevaAddress)
        System.out.println(ivan)
        System.out.println("Capitalize UK code...")
        val ivanFixed = ivan.copy(
            company = ivan.company.copy(
                address = ivan.company.address.copy(
                    city = ivan.company.address.city.copy(
                        country = ivan.company.address.city.country.copy(
                            code = ivan.company.address.city.country.code.toUpperCase
                        )
                    )
                )
            )
        )
        System.out.println(ivanFixed)
    }
}
