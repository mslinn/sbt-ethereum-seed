import com.scalapenos.sbt.prompt._
import SbtPrompt.autoImport._

name := "sbt-ethereum-seed"
organization := "eth.anyone"
scalaVersion := "2.12.4"
version := "0.1.0"
licenses := Seq("CC0" -> url("https://creativecommons.org/publicdomain/zero/1.0/legalcode"))

// See https://github.com/agemooij/sbt-prompt
promptTheme :=
  PromptTheme(List(
    text("\neth", fg(green)),
//    userName(fg(26)),
//    text("@", fg(green)),
//    hostName(fg(26)),
    text(" on ", fg(magenta)),
    gitBranch(clean = fg(green), dirty = fg(yellow)),
    text(" in ", fg(magenta)),
    currentProject(fg(red)),
    text("> ", fg(magenta))
  ))

ethJsonRpcUrl := Option(System.getenv("ETH_INFURA_TOKEN"))
  .map { token =>
    // If you do not want to set up your own Ethereum node, and you do not want to use our Ethereum node, you can use an Infura Ethereum node.
    // To do this:
    // 1) Get an Infura token: https://infura.io/#how-to
    // 2) Define an environment variable called ETH_INFURA_TOKEN to hold the token
    //    You might want to set the environment variable in `~/.bashrc`, `~/.profile` or `~/.bash_profile`, like this:
    //    export ETH_INFURA_TOKEN="blahblahblah"
    // The next time you run this project from SBT the token will be used to connect with an Infura Ethereum node.

    // The eth-command-line client uses the token to access an Infura Ethereum node by the following incantation:
    s"http://mainnet.infura.io/$token"
  }.getOrElse {
    Option(System.getenv("ETH_DEFAULT_NODE")) // Define this environment variable with the entire URL for the Ethereum node you wish to use
      .getOrElse { // If neither environment variables are defined, use this value
        //"http://192.168.10.49:8545"
        "http://ethjsonrpc.mchange.com:8545/"
      }
  }


// Steve
// error: not found: value ethPackageScalaStubs
//ethPackageScalaStubs := "eth.anyone.contract"

resolvers ++= Seq(
  "Typesafe releases"   at "http://repo.typesafe.com/typesafe/releases/",
  //"Sonatype releases"   at "https://oss.sonatype.org/service/local/staging/deploy/maven2",
  "Sonhatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

libraryDependencies ++= Seq(
  "com.mchange" %% "consuela" % "0.0.3-SNAPSHOT"
)
