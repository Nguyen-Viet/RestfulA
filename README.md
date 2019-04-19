# RestfulA
RestfulA is a simple RESTful service that perform 2 GET and 1 POST operation with following endpoints:
1. GET : http://<server_url>/math/add?n1=<numeric param 1>&n2=<numeric param 2> 
2. POST : http://<server_url>/math/add 
3. GET : http://<server_url>/airports 

## Technologies used
* Java 11
* JSON.simple
* Jersey 2.28
* Tomcat 9.0.19
* JUnit 5 (Jupiter)

## How you can run this project
There are a few option you can run to try out the project yourself. But before that you need to register for your API ID and API Key at 
https://developer.flightstats.com/api-docs/airports/v1 and replace my REST_URI variable with yours. As my ID and Key will be expired. 
1. Compile a war file and deploy it to your application server of choice. Use Postman or your browser to test the endpoint.
2. Add the project into your IDE of choice and run application on your server. Use Postman or your browser to test the endpoint.


## To Unit Test
To run the unit test I created add the project to your choice of IDE, right click the test classes in test package and run test.

## Sample output
At endpoint http://<server_url>/airports 
```json
{
    "airports": [
        {
            "city": "Bay Springs",
            "name": "Thigpen",
            "active": true
        },
        {
            "city": "Bridgeton",
            "name": "Bucks",
            "active": true
        },
        {
            "city": "Livingston",
            "name": "Livingston Municipal",
            "active": true
        },
        {
            "city": "Mc Kenzie Bridge",
            "name": "Mc Kenzie Bridge State",
            "active": true
        },
        {
            "city": "Colorado Springs",
            "name": "Meadow Lake",
            "active": true
        },
```
.........

At endpoint 
* GET : http://<server_url>/math/add?n1=<numeric param 1>&n2=<numeric param 2> 
* POST : http://<server_url>/math/add 
```json
{
    "value": 3
}
```
