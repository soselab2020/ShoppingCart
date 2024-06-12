package ntou.cs.example;

/*
 * Type: Value Object
 */
public class Address {
	private final String receiverName;
	private final String address;
	private final String contactPhoneNumber;
	
	public Address() {
		this("none", "none", "12345678");
	}

	public Address(String receiverName, String address, String contactPhoneNumber) {		
		this.receiverName = receiverName;
		this.address = address;
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getAddress() {
		return address;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	@Override
	public String toString() {
		return "Address [receiverName=" + receiverName + ", address=" + address + ", contactPhoneNumber="
				+ contactPhoneNumber + "]";
	}	
	
}
