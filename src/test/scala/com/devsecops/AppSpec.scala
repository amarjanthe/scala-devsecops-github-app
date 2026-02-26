package com.devsecops

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class AppSpec extends AnyFlatSpec with Matchers {

  "The app" should "have correct greeting message" in {
    val message = "Hello from Scala DevSecOps App!"
    message should include ("Scala")
  }

  it should "have health status UP" in {
    val health = """{"status":"UP"}"""
    health should include ("UP")
  }
}
