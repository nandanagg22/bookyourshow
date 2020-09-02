# bookyourshow
## execution
1. This is a self contained Spring Boot application
2. Can be easily run by checking out the repo in any IDE and run the *DemoApplication.java* main class
3. Alternatively, the project can be packaged as a jar by executing *mvc clean package* on the project's root folder and running the jar standalone
4. The required JDK to execute is **JDK 11**
5. The App runs by default on port 8080

## sample postman collection
1. The sample postman collection is attached : *bys-collection.postman_collection.json*

## database
1. The App uses in memory **H2 Database**
2. Seed data has been pre-populated. please refer to *data.sql* in the resources folder

## testing the concurrent access flow
1. To mock concurrent access on the booking flow, a *latency()* method is added to *BookingServiceImpl*
2. This will sleep the current thread for 5 seconds to give enough room to send multiple calls 
3. Uncomment line number 42 in *BookingServiceImpl* to enable latency

see : *api-endpoints.md*