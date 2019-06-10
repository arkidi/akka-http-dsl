# akka-http-dsl

### 1. Akka-Http DSL Example
``` bash
akka-http-dsl git:(master) ✗ curl -X POST --data "Chicago, 20.0" http://localhost:8089/v1/temperature
Measurement inserted for Chicago%

akka-http-dsl git:(master) ✗ curl -X POST --data "Madrid, 15.4" http://localhost:8089/v1/temperature
Measurement inserted for Madrid%  

akka-http-dsl git:(master) ✗ curl -X GET http://localhost:8089/v1/temperature
Madrid, 15.4
Chicago, 20.0%  
```

### 2. Akka-HTTP Marshalling, Unmarshalling Example
``` bash
akka-http-dsl git:(master) ✗ curl -X POST --data "140000000 22 22 22" http://localhost:8089/
Speed Measurement now is SpeedMeasurement(140000000,22.0,22.0,22.0)%  

akka-http-dsl git:(master) ✗ curl -X GET http://localhost:8089/
140000000 22.0 22.0 22.0%
``` 