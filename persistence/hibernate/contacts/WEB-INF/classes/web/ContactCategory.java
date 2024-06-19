package web;

public enum ContactCategory {
	HIRE_MGR("Hiring Manager"),
	ICC("In-Company Contact"),
	REF("Reference"),
	HR("HR Person"),
	HH("Headhunter"),
	BA("Business Acquantance"),
	PA("Personal Acquantance"),
	COLLEAGUE("Former Colleague");

	private final String description;

	private ContactCategory(String value) {
		this.description = value;
	}

	public String getDescription()  {
		return description;
	}
}
