name := "GatlingMeetup"

version := "0.1"

scalaVersion := "2.12.7"

enablePlugins(GatlingPlugin)

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.0.1",
  "io.gatling"            % "gatling-test-framework"    % "3.0.1"
)