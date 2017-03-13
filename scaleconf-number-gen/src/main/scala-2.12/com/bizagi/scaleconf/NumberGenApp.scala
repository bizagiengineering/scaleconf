package com.bizagi.scaleconf

import java.nio.file.Paths

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{FileIO, Source}
import akka.util.ByteString

/**
  * Created by dev-williame on 3/10/17.
  */
object NumberGenApp extends App {

  implicit val system = ActorSystem("HelloWorld")
  implicit val materializer = ActorMaterializer()

  val random = scala.util.Random
  val filter = Stream.from(0)
    .map(_ => random.nextInt(9999))
    .filter(x => x > 1000)
    .distinct
    .take(300)
    .toList
    .sorted

  val (greater, equal, _) = filter.foldLeft((true, 0, 0)) { (t, v) =>
    println(v, t._2, t._1)
    if (v > t._3)
      (true, v, v)
    else
      (false, t._2, v)
  }

  if (!greater)
    throw new RuntimeException(s"equal number $equal")

  Source(filter)
    .map(num => ByteString(s"$num\n"))
    .runWith(FileIO.toPath(Paths.get("scaleconf.txt")))
}
