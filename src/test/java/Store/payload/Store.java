package Store.payload;

public class Store {
	
	int id;
	int petId;
	int quantity;
	String Shipdate;
	String status;
	String complete;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getShipdate() {
		return Shipdate;
	}
	public void setShipdate(String shipdate) {
		Shipdate = shipdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String isComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}

}
