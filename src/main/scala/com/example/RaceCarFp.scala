package com.example

import scala.util.Random

case class State(time: Int, car_positions: Seq[Int])

object RaceCarFp {

  def random: Int = Random.nextInt(5)

  def move_cars(car_positions: Seq[Int]) = car_positions.map { x => if(random > 3) x + 1 else x }

  def output_car(car_position: Int) = "_" * car_position

  def run_step_of_race(state: State): State = state.copy(state.time - 1, car_positions = move_cars(state.car_positions))

  def draw(state: State) = {
    println(s"time = ${state.time}")
    state.car_positions.map(n => println(output_car(n)))
  }

  def race(state: State): Option[State] = {
    draw(state)
    if(state.time > 0)
      race(run_step_of_race(state))
    else
      None
  }

  def main(args: Array[String]) {
    race(State(5, Seq(1, 1, 1)))
  }
}
