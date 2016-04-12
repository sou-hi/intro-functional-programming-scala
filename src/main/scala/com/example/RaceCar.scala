package com.example

import scala.util.Random

object RaceCar {

  def main(args: Array[String]) {
    var time = 5
    val car_positions = scala.collection.mutable.Seq(1, 1, 1)
    val r = new Random

    while(time > 0) {

      println(s"time = $time")
      time -= 1

      for(i <- car_positions.indices) {
        // move car
        if (r.nextInt(10) > 3) {
          car_positions(i) += 1
        }

        // draw car
        println("-" * car_positions(i))
      }
    }
  }
}
