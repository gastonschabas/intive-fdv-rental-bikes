# Interview intive-FDV

## Rental Bikes

A company rents bikes under following options:

1. Rental by hour, charging $5 per hour
2. Rental by day, charging $20 a day
3. Rental by week, charging $60 a week
4. Family Rental, is a promotion that can include from 3 to 5 Rentals (of any type) with a discount of 30% of the total price

## Assigment

1. Implement a set of classes to model this domain and logic
2. Add automated tests to ensure a coverage over 85%
3. Use GitHub to store and version your code
4. Apply all the recommended practices you would use in a real project
5. Add a README.md file to the root of your repository to explain: your design, the development practices you applied 
and how run the tests.

Note: we don't expect any kind of application, just a set of classes with its automated tests.

### Design

- `RentCalculator`: it's an object who has a method called `calculate` that has the logic to calculate the total price. It receives a 
parameter of `RentType`
- `RentType`: it's a base sealed trait to be extended by the types of rents. In this case `IndividualRent` and 
`FamiliarRent`. The sealed word makes that only the classes in the same file could extend it. This make it easier when 
you need to make a pattern matching, because the compiler will show you a warning if you are not considering some use 
case. Also, if you need to add a new type of rent, a new case class can be extended and add to the cases of pattern 
matching.
- `IndividualRent`: it's a case class that has the `unitType` of type `TimeUnit` and the `duration` of type `Long` as
parameters
- `FamiliarRent`: it's a case class that has the list of rents
- `TimeUnit`: it's a base sealed trait to be extended by the types of time units. In this case `Hour`, `Day` and `Week`.
- `Hour`, `Day` and `Week`: they're case objects that show which unit is selected for the rent

### Prerequisites

- java 1.8
- scala 2.12
- sbt 1.2.7

## Run tests

```sbt test```
