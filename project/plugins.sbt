resolvers += "TNM" at "https://nexus.thenewmotion.com/content/groups/public"

addSbtPlugin("com.newmotion" % "sbt-build-seed" % "5.1.0")

// https://github.com/rtimush/sbt-updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.4.0")

addSbtPlugin("com.codecommit" % "sbt-github-packages" % "0.5.2")