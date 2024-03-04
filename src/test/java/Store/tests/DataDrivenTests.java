package Store.tests;

import Store.payload.Store;
import Store.utilities.DataProviders;
import io.restassured.response.Response;

import org.testng.Assert;

import org.testng.annotations.Test;

import Store.endpoints.*;

public class DataDrivenTests {
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostStore(String id, String petid, String quantity, String Shipdate, String status, String complete) {
	
	
	Store storepayload=new Store();
	
	storepayload.setId(Integer.parseInt(id));
	storepayload.setPetId(Integer.parseInt(petid));
	storepayload.setQuantity(Integer.parseInt(quantity));
	storepayload.setShipdate(Shipdate);
	storepayload.setStatus(status);
	storepayload.setComplete(complete);
	
	Response response=StoreEndPoints.CreateStore(storepayload);
	Assert.assertEquals(response.getStatusCode(), 200);
}
	@Test(priority=2, dataProvider="id", dataProviderClass=DataProviders.class)
	public void testDeleteStore(String id) {
		
		Response response= StoreEndPoints.DeleteStore(Integer.parseInt(id));
		response.getStatusCode();
		//Assert.assertEquals(response.getStatusCode(), 200);

}
}
