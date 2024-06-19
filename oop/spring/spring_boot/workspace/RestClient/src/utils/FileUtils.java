package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.Student;

public class FileUtils {

	public static List<Student>  csvToList(String filepath)  {
		List<Student> students = new ArrayList<Student>();
		try {
			Scanner s = new Scanner(new File(filepath));
			while (s.hasNext()) {
				String[] student = s.next().split(",");
				System.out.println(student[0]); //////
				students.add(new Student(student[0],student[1]));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
}
