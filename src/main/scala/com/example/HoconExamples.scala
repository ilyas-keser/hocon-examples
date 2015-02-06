package com.example

import com.typesafe.config.ConfigFactory
import scala.collection.JavaConversions._

object HoconExamples {
  
  private lazy val conf = ConfigFactory.load()
    
  def main(args: Array[String]): Unit = {
    
    // 1. Basics
    //basics()
    
    // 2. Environment variables
    //envVars()
    
    // 3. Concatenation & Substitution
    //conSub()
    
    // 4. Object merge
    //basics()

    // Debugging: to show where each value came from
    println( conf.root().render() )

    // Debugging: to list loaded conf files use following Java system property
    // -Dconfig.trace=loads
  }
  
  def basics() = {
    
    val appName: String = conf.getString("app.name")
    println("App name is: " + appName)
    
    val version = conf.getDouble("app.version")
    println("App version: " + version)
    
    val majorVersion: Int = conf.getInt("app.majorVersion")
    val minorVersion: Int = conf.getInt("app.minorVersion")
    println(s"majorVersion + minorVersion is ${majorVersion + minorVersion}")
    
    val featureList = conf.getStringList("app.features")
    println( featureList.mkString("Features: [", ", ", "]") )
    
    val plugins = conf.getStringList("app.plugins")
    println( plugins.mkString("Plugins: [", ", ", "]") )
    
  }
  
  
  def envVars() = {
    val dbUsername = conf.getString("db.username")
    val dbPassword = conf.getString("db.password")
    val dbDataDir = conf.getString("db.dataDir")
    
    println(s"\nDatabase username: ${dbUsername}\n password: ${dbPassword}\n data directory: ${dbDataDir}\n")
  }
  
  
  def conSub() = {
    // array concat example
    val path = conf.getStringList("pathList")
    println( path.mkString("Path list: [", ",  ", "]") )
    
    // object concat example
    val generic: com.typesafe.config.ConfigObject = conf.getObject("data-center-generic")
    val east = conf.getObject("data-center-east")
    val west = conf.getObject("data-center-west")
    println(s"generic: ${generic}")
    println(s"east: ${east}")
    println(s"west: ${west}")
  }
}
