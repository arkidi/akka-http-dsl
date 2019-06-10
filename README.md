# akka-http-dsl

``` bash
akka-http-dsl git:(master) ✗ curl -X POST --data "Chicago, 20.0" http://localhost:8089/v1/temperature
Measurement inserted for Chicago%

akka-http-dsl git:(master) ✗ curl -X POST --data "Madrid, 15.4" http://localhost:8089/v1/temperature
Measurement inserted for Madrid%  

akka-http-dsl git:(master) ✗ curl -X GET http://localhost:8089/v1/temperature
Madrid, 15.4
Chicago, 20.0%  
```