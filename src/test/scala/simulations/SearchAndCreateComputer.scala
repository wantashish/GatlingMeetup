
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.core.filter.BlackList
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class SearchAndCreateComputer extends Simulation {

	val httpProtocol = http
		.baseUrl("http://computer-database.gatling.io")
		.inferHtmlResources(BlackList(Seq(""".*\.css.*""")))
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:63.0) Gecko/20100101 Firefox/63.0")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_8 = Map(
		"Accept" -> "*/*",
		"Pragma" -> "no-cache")


	val scn = scenario("SearchAndCreateComputer")
		.exec(http("Get Home Page")
			.get("/computers")
			.headers(headers_0)
			.check(status.is(200)))
		.exec(http("Search")
			.get("/computers?f=Gatling+computer")
			.headers(headers_0)
			.check(status.is(200)))
		.exec(http("Get Create form")
			.get("/computers/new")
			.headers(headers_0)
			.check(status.is(200)))
		.exec(http("Post Create form")
			.post("/computers")
			.headers(headers_0)
			.formParam("name", "Gatling computer v1")
			.formParam("introduced", "2010-10-01")
			.formParam("discontinued", "2018-11-10")
			.formParam("company", "12")
			.check(status.is(200)))

	setUp(scn.inject(
		rampUsersPerSec(0) to 10 during(2 minutes),
		constantUsersPerSec(10) during(7 minutes),
		rampUsersPerSec(10) to 0 during(1 minute)
	)).protocols(httpProtocol)
}