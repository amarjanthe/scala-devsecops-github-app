package com.devsecops

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.Materializer
import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object App extends App {

  implicit val system: ActorSystem = ActorSystem("devsecops-system")
  implicit val materializer: Materializer = Materializer(system)
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  val route =
    pathSingleSlash {
      get {
        complete("Hello from Scala DevSecOps App!")
      }
    } ~
    path("health") {
      get {
        complete("""{"status":"UP"}""")
      }
    } ~
    path("api" / "users") {
      get {
        complete(
          """
          [
            {"id":1,"name":"Amar","role":"DevOps Engineer"},
            {"id":2,"name":"Alice","role":"Backend Developer"},
            {"id":3,"name":"Bob","role":"Security Engineer"}
          ]
          """
        )
      }
    }

  Http().newServerAt("0.0.0.0", 8080).bind(route)

  println("Server running at http://localhost:8080/")

  // ✅ KEEP APPLICATION ALIVE (Docker safe)
  Await.result(system.whenTerminated, Duration.Inf)
}
