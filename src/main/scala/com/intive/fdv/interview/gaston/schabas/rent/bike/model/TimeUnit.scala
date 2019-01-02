package com.intive.fdv.interview.gaston.schabas.rent.bike.model

sealed trait TimeUnit

case object Hour extends TimeUnit
case object Day extends TimeUnit
case object Week extends TimeUnit
