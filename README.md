# Repo to calculate Total Area

### Requirements
1) Java version 17 or higher
2) Maven version 3.8 or higher

### Building Project
You can build the project with Maven using command `mvn package`
run the tests using command `mvn test`

### Total Area Function
Currently, the project allows String array as input that aggregates the total area of the shapes based on type described in the ENUM.
The constraint being the shape paramters are neither null nor blank in which case the default area is calculated 0.
Similarly, if the type of the shape is not one of the ENUM the area is default to 0.
Lastly, if there is any issue with data integrity like the String object is not a JSON format or data has NULL then the data is not considered for calculating total area.