## Taxi24 API

### Compiling the project

The project was done using Java, Spring boot, flyway, Maven and Postgres DB. To start you have to change the file ```\taxi24\src\main\resources\application.properties```
file to point to the correct database.
When the database parameters are set you can execute the following command, ```mvn spring-boot:run```. This command will run the database
migration scripts and it will start running the project.

### Database Migration and Seeding

Since this project is using Flyway, I have the DDLs for creating the tables in the following folder ```taxi24\src\main\resources\db\migration\Postgres\```.
These are normal SQL scripts. I have taken advantage of Flyway migrations to also insert the initial data for testing the scripts.

### Using the application
The following end points are accessible for the project. This assumes that the application is running on localhost on port 8080,
if different please change the localhost:8080 to your server and port.

* localhost:8080/api/trip/request - This brings a JSON list of all the drivers in the system.
* localhost:8080/api/drivers/status/AVAILABLE - This brings all drivers with status AVAILABLE. For other statuses for the drivers you
can use any of the following, "AVAILABLE, OFF_DUTY, ON_TRIP, ASSIGNED"
* localhost:8080/api/driver/36 - This gives a single record of the driver if the driver ID exists. If not available a 404 error is thrown.
* localhost:8080/api/driversnear?longitude=145.44114&latitude=-57.25000&radius=3 - This gives a list of drivers within a radius of
3KM from the supplied longitude and latitude. The parameter for radius can be changed so are the parameters for lon/ lat.
* localhost:8080/api/riders - This lists all the riders on the database.
* localhost:8080/api/rider/4 - Gives specific rider.
* localhost:8080/api/trips/status/ON_TRIP - It lists all current trips with the specified status. The statuses are REQUESTED, ASSIGNED, CANCELED, ON_TRIP, COMPLETED
* localhost:8080/api/trip/request - All the above end points are GET. This trip/request is a POST. It posts a JSON to the server with
the riderId, startingLongitude and startingLatitude. Given the parameters the application finds the nearest available driver and assigns the trip.
Assumption was made that the time of the trip request is immidiately the trip is started. A JSON for the trip is returned.
For example the JSON can be as this.
`` {
	"riderId": 37,
	"longitudeStart": -48.094100,
	"latitudeStart": -42.601580
} ``
* localhost:8080/api/trip/complete - This is also a POST method. This one is used to complete/ end any trip and it gives an invoice showing
the distance traveled and the amount to pay. You will have to post a JSON with tripId, finishLongitude, finishLatitude. The JSON
can be as this, `` {
	"tripId": 2,
	"finishLongitude": 145.400040,
	"finishLatitude": -55.257680
} ``