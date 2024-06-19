package web;

/**
* Typesafe enumeration for salutation for individuals
*/
public enum Salutation {
	MR("Mr."), MS("Ms.");

	private final String description;

	/**
	* enum constructors are always private
	* @param description human-readable description for the enum value
	*/
	private Salutation(String description)  {
		this.description = description;
	}

	/**
	* Returns the description associated with this enumeration instance
	* @return the human-readable description of the element
	*/
	public String getDescription() {
		return this.description;
	}
}
