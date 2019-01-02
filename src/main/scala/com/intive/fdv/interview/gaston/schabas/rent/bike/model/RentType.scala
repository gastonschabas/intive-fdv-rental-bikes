package com.intive.fdv.interview.gaston.schabas.rent.bike.model

sealed trait RentType

case class IndividualRent(unitTime: TimeUnit, duration: Long) extends RentType
case class FamiliarRent(rents: Seq[IndividualRent]) extends RentType {
  require(rents.size >= 3 && rents.size <= 5, "familiar rent must be greater or equal than 3 rents or less or equal than 5 rents")
}
