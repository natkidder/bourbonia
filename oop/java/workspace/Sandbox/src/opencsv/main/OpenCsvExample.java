package opencsv.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.opencsv.bean.CsvToBeanBuilder;

import opencsv.bean.Country;

public class OpenCsvExample {

	static final String CHOICES = "1. Load CSV to Country bean\n\n" + "Enter choice: ";
	static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
        csvToCountryList();

	}

	private static void csvToCountryList() {
		String fileName = "country.csv";

        List<Country> beans;
		try {
			beans = new CsvToBeanBuilder(new FileReader(fileName))
			        .withType(Country.class)
			        .build()
			        .parse();
	        beans.forEach(System.out::println);
		} catch (IllegalStateException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
