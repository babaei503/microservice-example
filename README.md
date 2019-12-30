# Spring Boot Microservices using Feign, Ribbon, Eureka

```
1. Uconvert Microsevice
2. UnitConversion Microservice
3. Eureka Naming Server
```

## Uconvert Microsevice:

Uconvert Service is the Service Provider. It provides unit convert values for various units.

An example request and response is shown below:

GET to http://localhost:8000/unit-convert/from/M/to/FT

```
{
	"id":10004,
	"from":"CM",
	"to":"M",
	"conversionMultiple":0.01,
	"port":8000
}
```

The request above is the unit convert value for CM to M. In the response, conversionMultiple is 0.01.


## UnitConversion Microservice:

Unit Conversion Service (UCS) can convert a bucket of units into another unit. It uses the Uconvert Service to get current unit convert values. UCS is the Service Consumer.

An example request and response is shown below:

GET to http://localhost:8100/unit-converter-feign/from/M/to/FT/quantity/5

```
{
	"id":10001,
	"from":"M",
	"to":"FT",
	"conversionMultiple":3.28,
	"quantity":5,
	"totalCalculatedAmount":16.40,
	"port":8000
}
```

The request above is to find the value of 5 M in FT. The totalCalculatedAmount is 16.40 FT.


## Eureka Naming Server and Ribbon:

Based on the load, we can have multiple instances of the Unit Conversion Service and Uconvert service running.
And the number of instances for each service might vary with time.
We will use Ribbon for Load Balancing and Eureka Naming server for registering all microservices.