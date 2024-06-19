package web;

public enum Salutation  {
	MR("Mr."), MS("Ms.");

	private final String description;

	// enum constructors are always private
	private Salutation(String description)  {
		this.description = description;
	}

	public String getDescription()  {
		return this.description;
	}
}
