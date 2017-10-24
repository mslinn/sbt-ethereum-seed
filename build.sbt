name := "sbt-ethereum-seed"
organization := "eth.anyone"
scalaVersion := "2.12.4"
version := "0.0.1"

// You must define an environment variable called INFURA_TOKEN in order for this project to work
ethJsonRpcUrl := s"http://mainnet.infura.io/${ sys.env("INFURA_TOKEN") }"
//ethJsonRpcUrl := "http://192.168.10.49:8545"

ethPackageScalaStubs := "eth.anyone.contract"

resolvers ++= Seq(
  "Typesafe releases"   at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype releases"   at "https://oss.sonatype.org/service/local/staging/deploy/maven2",
  "Sonhatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

libraryDependencies ++= Seq(
  "com.mchange" %% "consuela" % "0.0.3-SNAPSHOT"
)
