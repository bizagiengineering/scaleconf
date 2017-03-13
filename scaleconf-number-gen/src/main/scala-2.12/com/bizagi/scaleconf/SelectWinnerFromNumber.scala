package com.bizagi.scaleconf

/**
  * Created by dev-williame on 3/13/17.
  */
object SelectWinnerFromNumber extends App {

  val random = scala.util.Random

  private val list = scala.io.Source.fromFile("scaleconf.txt").getLines().map(_.toInt).toIndexedSeq
  val value = list(random.nextInt(list.size + 1))
  println(value)
}
