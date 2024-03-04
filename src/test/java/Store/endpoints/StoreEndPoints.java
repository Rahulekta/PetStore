package Store.endpoints;

import static io.restassured.RestAssured.given;

import Store.endpoints.Url;
import Store.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class StoreEndPoints {

public static Response CreateStore(Store payload){
		
		Response response=given()
		 .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		.when()
		.post(Url.post_url);
		
		return response;
	}

public static Response GetStore(int orderId) {
	Response response=given()
			   .pathParam("orderId", orderId)
			.when()
			.get(Url.get_url);
			
			return response;
}

public static Response DeleteStore(int orderId) {
	
	Response response=given()
			   .pathParam("orderId", orderId)
			.when()
			.delete(Url.delete_url);
			
			return response;
}
	
}

