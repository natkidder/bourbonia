package opencsv.bean;

import com.opencsv.bean.CsvBindByName;

public class Country {
    @CsvBindByName(column = "start ip")
    private String startIp;

    @CsvBindByName(column = "end ip")
    private String endIp;

    @CsvBindByName(column = "country code")
    private String countryCode;

    @CsvBindByName(column = "country")
    private String country;

    // note it's an quantitative type
    @CsvBindByName(column = "population")
    private int population;

	public String getStartIp() {
		return startIp;
	}

	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}

	public String getEndIp() {
		return endIp;
	}

	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country [startIp=" + startIp + ", endIp=" + endIp + ", countryCode=" + countryCode + ", country="
				+ country + ", population=" + population + "]";
	}
	
}
