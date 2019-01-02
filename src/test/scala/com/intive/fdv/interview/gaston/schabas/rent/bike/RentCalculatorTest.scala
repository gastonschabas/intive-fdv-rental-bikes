package com.intive.fdv.interview.gaston.schabas.rent.bike

import com.intive.fdv.interview.gaston.schabas.rent.bike.model._
import org.scalatest.{FunSuite, Matchers}

class RentCalculatorTest extends FunSuite with Matchers {

  val individualRent3Hours = IndividualRent(Hour, 3)
  val individualRent5Days = IndividualRent(Day, 5)
  val individualRent2Weeks = IndividualRent(Week, 2)

  test("3 hours of a rented bike should be 15") {
    val result = RentCalculator.calculate(individualRent3Hours)
    result should be(15)
  }

  test("5 days of a rented bike should be 100") {
    val result = RentCalculator.calculate(individualRent5Days)
    result should be(100)
  }

  test("2 weeks of a rented bike should be 120") {
    val result = RentCalculator.calculate(individualRent2Weeks)
    result should be(120)
  }

  test("2 weeks, 3 hours  and 5 days of a familiar rented bikes should be 220") {
    val result = RentCalculator.calculate(FamiliarRent(Seq(individualRent2Weeks, individualRent3Hours, individualRent5Days)))
    result should be(164.5)
  }

  test("familiar rented bike should has at least 3 rents") {
    an [IllegalArgumentException] should be thrownBy(RentCalculator.calculate(FamiliarRent(Seq(individualRent2Weeks, individualRent3Hours))))
  }

  test("familiar rented bike should has no more than 5 rents") {
    an [IllegalArgumentException] should be thrownBy(RentCalculator.calculate(FamiliarRent(Seq(
                                                                                  individualRent3Hours, individualRent2Weeks, individualRent5Days,
                                                                                  individualRent3Hours, individualRent2Weeks, individualRent5Days))))
  }

}
