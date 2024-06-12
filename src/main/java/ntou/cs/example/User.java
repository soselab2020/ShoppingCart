package ntou.cs.example;

/*
 * Type: Entity and Aggregate Root
 */
public class User {	
	private final String id;
	private final String name;
	private final Address address;
	private final MemberLevel level;
	
	public User(String id, String name, Address address, MemberLevel level) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.level = level;
	}

	public String getId() {
		return id;
	}	

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public MemberLevel getLevel() {
		return level;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", level=" + level + "]";
	}	
	
}
