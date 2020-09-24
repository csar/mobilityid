val commonSettings = Seq(
  organization := "com.thenewmotion",
  licenses += ("Apache License, Version 2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
)



val specs2 =  "org.specs2" %% "specs2-core" % "4.10.3" % Test

githubTokenSource := TokenSource.Environment("GITHUB_TOKEN") || TokenSource.GitConfig("github.token")
githubOwner := "csar"
githubRepository := "mobilityid"

val `core` = project
  .enablePlugins(OssLibPlugin)
  .settings(
    name := "mobilityid",
    commonSettings,
    initialCommands in console := "import com.thenewmotion.mobilityid._, ContractIdStandard._",
    libraryDependencies ++= Seq(
      specs2
    )
  )

val `interpolators` = project
  .enablePlugins(OssLibPlugin)
  .dependsOn(`core`)
  .settings(
    name := "mobilityid-interpolators",
    commonSettings,
    libraryDependencies ++= Seq(
      // https://mvnrepository.com/artifact/com.propensive/contextual
      "com.propensive" %% "contextual" % "1.2.1",
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      specs2
    )
  )

val `mobilityid` =
  project.in(file("."))
    .enablePlugins(OssLibPlugin)
    .aggregate(
      `core`,
      `interpolators`)
    .settings(
      publish := {}
    )
