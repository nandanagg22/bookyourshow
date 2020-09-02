## API Endpoints
1. GET api/v1/city ==> List all cities
2. GET /api/v1/theatre ==> List all theaters
3. GET /api/v1/theatre?city=Bangalore ==> List all theaters in a City
4. GET /api/v1/shows?theatreId={theatreId} ==>  List all active shows in a theatere
5. GET /api/v1/shows/{showId}/seats/ ==> List All seats in a show 
6. GET /api/v1/shows/{showId}/bookings/ ==> List All bookings for a show
7. GET /api/v1/shows/{showId}/bookings?status={status}  ==>  List All bookings by status
8. POST /api/v1/order ==> book seats
``` json
[ 
  {
	"showId" :"",
	"userEmail" : "",	
	"seatNumbers": []
  }
]
```