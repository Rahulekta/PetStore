package Store.tests;

import com.github.javafaker.Faker;
import Store.endpoints.StoreEndPoints;

import Store.payload.Store;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreTests {
	
	Faker faker;
	Store storepayload;
	@BeforeClass
	public void SetupData(){
		
		faker=new Faker();
		storepayload=new Store();
		
		storepayload.setId(faker.idNumber().hashCode());
		storepayload.setPetId(faker.number().randomDigitNotZero());
		storepayload.setQuantity(faker.number().randomDigit());
		storepayload.setShipdate(faker.date().toString());
		storepayload.setStatus(faker.expression("placed"));
		//storepayload.setComplete(faker.bool().bool());
		
	}
		@Test(priority=1)
		public void testCreateStore(){
			
			Response response= StoreEndPoints.CreateStore(storepayload);
			response.then().log().all();
			String responsebody=response.getBody().toString();
			Assert.assertEquals(response.getStatusCode(), 200);
			Assert.assertEquals(response.getContentType(), "application/json");
			//assertTrue(responsebody.contains("\"id\": 1306834002")); // Validate presence of id with specific value
	        //assertTrue(responsebody.contains("\"petId\": 3")); // Validate presence of petId with specific value
	        //assertTrue(responsebody.contains("\"quantity\": 6")); // Validate presence of quantity with specific value
	        //assertTrue(responsebody.contains("\"status\": \"placed\"")); // Validate presence of status with specific value
	        //assertTrue(responsebody.contains("\"complete\": false")); // Validate presence of complete with specific value
	        
	        //assertTrue(responsebody.contains("\"id\"")); // Validate presence of id key
	        //assertTrue(responsebody.contains("\"petId\"")); // Validate presence of petId key
	       // assertTrue(responsebody.contains("\"status\"")); // Validate presence of status key
	        //assertTrue(responsebody.contains("\"complete\"")); // Validate presence of complete key
	       // assertTrue(responsebody.contains("\"quantity\""));

	        // Example: Validate that the quantity is greater than zero
	       // int quantity = response.jsonPath().getInt("quantity");
	        //assertTrue(quantity > 0, "Quantity should be greater than zero");
	        
	        //int id=response.jsonPath().getInt("id");
	       // assertTrue(id>0,"id should be greater than zero");
	        
	        
			
			
		}
		@Test(priority=2)
		public void testGetStore() {
			
			Response response= StoreEndPoints.GetStore(this.storepayload.getId());
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
			
			
		
		
	}
		@Test(priority=3)
		public void testDeleteStore() {
			
			Response response= StoreEndPoints.DeleteStore(this.storepayload.getId());
			Assert.assertEquals(response.getStatusCode(), 200);
			
		}
	


}
