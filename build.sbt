name := """torneo"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"	

libraryDependencies ++= Seq(
	javaCore,
	javaJpa,
	anorm,
	jdbc,
  	javaJdbc,
  	javaEbean,
  	cache,
  	javaWs,
  	"mysql" % "mysql-connector-java" % "5.1.27"
)