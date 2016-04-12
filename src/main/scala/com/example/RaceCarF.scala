package com.example

import scala.util.Random

object RaceCarF {

  var time = 5
  val car_positions = scala.collection.mutable.Seq(1, 1, 1)
  val r = new Random

  def move_cars() = {
    for(i <- car_positions.indices)
      if (r.nextInt(10) > 3)
        car_positions(i) += 1
  }

  def draw_car(car_position: Int) = println("-" * car_position)

  def run_step_of_race() = {
    time -= 1
    move_cars()
  }

  def draw() = {
    println(s"time = $time")
    for (car_position <- car_positions) {
      draw_car(car_position)
    }
  }

  def main(args: Array[String]) {
    while(time > 0) {
      run_step_of_race()
      draw()
    }
  }
}
