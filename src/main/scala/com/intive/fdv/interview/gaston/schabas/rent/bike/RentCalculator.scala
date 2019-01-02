package com.intive.fdv.interview.gaston.schabas.rent.bike

import com.intive.fdv.interview.gaston.schabas.rent.bike.model._

object RentCalculator {

  def calculate(rent: RentType): Double = {
    rent match {
      case individualRent: IndividualRent =>
        val unitPrice = individualRent.unitTime match {
          case Hour => 5
          case Day => 20
          case Week => 60
        }
        unitPrice * individualRent.duration

      case FamiliarRent(rents) =>
        val total = rents.foldLeft(0.0)( (acc, nextIndividualRent) => acc + calculate(nextIndividualRent))
        total * 0.7
    }
  }
}
