package TestsCases

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {


  val httpProtocol = http.baseUrl(url = "https://stage.gtw.pwc.com/").header( name = "user-agent", value = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36")
  val  header_1 = Map{
    "accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9";
    "accept-encoding" -> "gzip, deflate, br"
  }

  val scn = scenario( scenarioName = "navigating to application").exec(http( requestName = "navigating to application")
    .get("/gtw/#/client-landing-page?client_key=56").headers(header_1)).pause(duration = 10)
  setUp(scn.inject(atOnceUsers(2))).protocols(httpProtocol)
}


