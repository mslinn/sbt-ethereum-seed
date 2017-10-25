name := "sbt-ethereum-seed"
organization := "eth.anyone"
scalaVersion := "2.12.4"
version := "0.1.0"
licenses := Seq("CC0" -> url("https://creativecommons.org/publicdomain/zero/1.0/legalcode"))

if (Option(System.getenv("INFURA_TOKEN")).isDefined) {
  // If you do not want to set up your own Ethereum node, and you do not want to use our Ethereum node, you can use an Infura Ethereum node.
  // To do this:
  // 1) Get an Infura token: https://infura.io/#how-to.
  // 2) Define an environment variable called INFURA_TOKEN to hold the token.
  //    You might want to set the environment variable in `~/.bashrc`, `~/.profile` or `~/.bash_profile`, like this:
  //    export INFURA_TOKEN="blahblahblah"
  // The next time you run this project from SBT the token will be used to connect with an Infura Ethereum node.

  // The eth-command-line client uses the token to access an Infura Ethereum node by the following incantation:
  ethJsonRpcUrl := s"http://mainnet.infura.io/${ sys.env("INFURA_TOKEN") }"
} else {
  ethJsonRpcUrl := "http://ethjsonrpc.mchange.com:8545/"
  //ethJsonRpcUrl := "http://192.168.10.49:8545"
}

// Steve
// error: not found: value ethPackageScalaStubs
//ethPackageScalaStubs := "eth.anyone.contract"

resolvers ++= Seq(
  "Typesafe releases"   at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype releases"   at "https://oss.sonatype.org/service/local/staging/deploy/maven2",
  "Sonhatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

libraryDependencies ++= Seq(
  "com.mchange" %% "consuela" % "0.0.3-SNAPSHOT"
)
