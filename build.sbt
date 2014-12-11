name := """torneo"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"	

libraryDependencies ++= Seq(
	javaCore,
	javaJpa,
  	javaJdbc,
  	javaEbean,
  	javaWs,
	jdbc,
	anorm,
  	cache,
  	"mysql" % "mysql-connector-java" % "5.1.27",
  	"org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final"
)