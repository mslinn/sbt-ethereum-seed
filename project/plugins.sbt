// only necessary while using a SNAPSHOT version of sbt-ethereum
resolvers += ("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")

addSbtPlugin("com.mchange" % "sbt-ethereum" % "latest.snapshot")
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC12")
