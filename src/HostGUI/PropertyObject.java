package HostGUI;


/*
 * This class constructs Property objects and is the helper class
 * for other classes relating to Properties.
 */
public class PropertyObject {

	private int property_id;
	private String shortName;
	private String description;
	private int guestCapacity;
	private int host_id;
	private int address_id;

	//Constructor for property objects
	public PropertyObject(int property_id, int address_id, int host_id, String description, String shortName,
			int guestCapacity) {
		this.property_id = property_id;
		this.address_id = address_id;
		this.host_id = host_id;
		this.description = description;
		this.shortName = shortName;
		this.guestCapacity = guestCapacity;
	}

	//Getters and setters for information relating to properties
	public int getPropertyId() {
		return property_id;
	}

	public int getAddressId() {
		return address_id;
	}

	public int getHostId() {
		return host_id;
	}

	public String getDescription() {
		return description;
	}

	public String getShortName() {
		return shortName;
	}

	public int getGuestCapacity() {
		return guestCapacity;
	}
}