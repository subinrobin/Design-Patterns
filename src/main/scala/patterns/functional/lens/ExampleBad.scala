package patterns.functional.lens

case class Country1(var name: String, var code: String)
case class City1(var name: String, var country: Country1)
case class Address1(var number: Int, var street: String, var city: City1)
case class Company1(var name: String, var address: Address1)
case class User1(var name: String, var company: Company1, var address: Address1)

object UserBadExample {
    def main(args: Array[String]): Unit = {
        val uk = Country1("United Kingdom", "uk")
        val london = City1("London", uk)
        val buckinghamPalace = Address1(1, "Buckingham Palace Road", london)
        val castleBuilders = Company1("Castle Builders", buckinghamPalace)
        val switzerland = Country1("Switzerland", "CH")
        val geneva = City1("geneva", switzerland)
        val genevaAddress = Address1(1, "Geneva Lake", geneva)
        val ivan = User1("Ivan", castleBuilders, genevaAddress)
        System.out.println(ivan)
        System.out.println("Capitalize UK code...")
        ivan.company.address.city.country.code = ivan.company.address.city.country.code.toUpperCase
        System.out.println(ivan)
    }
}