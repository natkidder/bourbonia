package main;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import beans.Student;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import utils.FileUtils;

/*
 * https://stackoverflow.com/questions/23456488/how-to-use-okhttp-to-make-a-post-request
 * https://mkyong.com/java/okhttp-how-to-send-http-requests/
 */
public class MassEnrollStudents {

	static Scanner scanner = new Scanner(System.in);
	private static final OkHttpClient httpClient = new OkHttpClient();
	static final String BASE_URL = "http://localhost:8090";
	static final String CHOICES = "1. Locate a Student Synchronously\n" +
			"2. Locate a Student Asynchronously (does not work)\n" +
			"3. Add a Student via Form Parameters (does not work)\n" +
			"4. Add a Student via JSON\n" + 
			"5. Remove a Student\n\n"  +
			"6. Mass Enroll Students\n"  +
			"7. Return all Students\n\n" + 
			"Enter choice: ";

	public static void main(String[] args) {
		System.out.println(CHOICES);
		int choice = scanner.nextInt();
		int id = 0;
		String name = null;
		String passportNumber = null;
		switch(choice) {
		case 1:
			System.out.println("Enter the ID of the student you wish to pull: ");
			id = scanner.nextInt();
			getSyncSingleStudent(id);
			break;
		case 2:
			System.out.println("Enter the ID of the student you wish to pull: ");
			id = scanner.nextInt();
			try {
				getAsyncSingleStudent(id);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("Enter the name of the new student (no spaces): ");
			name = scanner.next();
			System.out.println("Enter the passport number of the new student: ");
			passportNumber = scanner.next();
			enrollSingleStudentFormParams(name, passportNumber);
			break;
		case 4:
			System.out.println("Enter the name of the new student (no spaces): ");
			name = scanner.next();
			System.out.println("Enter the passport number of the new student: ");
			passportNumber = scanner.next();
			enrollSingleStudentFormJSON(name, passportNumber);
			break;
		case 5:
			System.out.println("Enter the ID of the student you wish to remove: ");
			id = scanner.nextInt();
			deleteSingleStudent(id);
			break;
		case 6:
			List<Student> students = FileUtils.csvToList("source.csv");
			for (Student student : students) {
				enrollSingleStudentFormJSON(student.getName(), student.getPassportNumber());
			}
			break;		
		default:
			System.exit(1);
		}
	}

	private static void getSyncSingleStudent(int id) {
		Request request = new Request.Builder()
				.url(BASE_URL+"/students/"+id)
				.build();
		try {
			Response response = httpClient.newCall(request).execute();
			if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

			// Get response headers
			Headers responseHeaders = response.headers();
			for (int i = 0; i < responseHeaders.size(); i++) {
				System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
			}
			// Get response body
			System.out.println(response.body().string());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * does not send the call apparently
	 */
	private static void getAsyncSingleStudent(int id) throws IOException {
		Request request = new Request.Builder()
				.url(BASE_URL+"/students/"+id)
				.build();

		httpClient.newCall(request).enqueue(new Callback() {
			public void onFailure(Call call, IOException e) {
				System.out.println("async-010"); ///////
				e.printStackTrace();
			}

			public void onResponse(Call call, Response response) throws IOException {
				System.out.println("async-020"); ///////

				try {
					ResponseBody responseBody = response.body();
					if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

					// Get response headers
					Headers responseHeaders = response.headers();
					for (int i = 0, size = responseHeaders.size(); i < size; i++) {
						System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
					}

					// Get response body
					System.out.println(responseBody.string());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		System.out.println("async-030"); ///////

	}

	/*
	 * does not work
	 */
	private static void enrollSingleStudentFormParams(String name, String passportNumber) {
		RequestBody formBody = new FormBody.Builder()
				.add("name", name)
				.add("passportNumber", passportNumber)
				.build();

		formBody.contentType();

		Request request = new Request.Builder()
				.url("http://localhost:8090/students")
				.addHeader("User-Agent", "OkHttp Bot")
				.post(formBody)
				.build();

		try {
			Response response = httpClient.newCall(request).execute();

			if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

			// Get response body
			System.out.println(response.body().string());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void enrollSingleStudentFormJSON(String name, String passportNumber) {
		// json formatted data
		String json = new StringBuilder()
				.append("{")
				.append("\"name\":\""+name+"\",")
				.append("\"passportNumber\":\""+passportNumber+"\"")
				.append("}").toString();

		// json request body
		RequestBody body = RequestBody.create(
				json,
				MediaType.parse("application/json; charset=utf-8")
				);
		Request request = new Request.Builder()
				.url(BASE_URL+"/students")
				.post(body)
				.build();
		try {
			Response response = httpClient.newCall(request).execute();
			if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
			// Get response body
			System.out.println(response.body().string());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void deleteSingleStudent(int id) {
		Request request = new Request.Builder()
				.url(BASE_URL+"/students/"+id)
				.delete()
				.build();
		try {
			Response response = httpClient.newCall(request).execute();
			if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

			// Get response headers
			Headers responseHeaders = response.headers();
			for (int i = 0; i < responseHeaders.size(); i++) {
				System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
			}
			// Get response body
			System.out.println(response.body().string());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
