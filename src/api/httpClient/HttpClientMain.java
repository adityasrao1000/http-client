package api.httpClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class HttpClientMain {
	public static void main(String[] args) throws Exception {

		HttpClient http = new HttpClient();
		System.out.println("Enter a number to invoke a method");
		System.out.println("GET 1, POST 2");
		System.out.println("PUT 3, DELETE 4");

		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		sc.nextLine();

		String url;
		switch (option) {
		case 1:
			System.out.println("Enter the url for GET request");
			url = sc.nextLine();
			http.sendHttp(url);
			break;
		case 2:
			createRequest(HttpMethod.POST);
			break;
		case 3:
			createRequest(HttpMethod.PUT);
			break;
		case 4:
			createRequest(HttpMethod.DELETE);
			break;
		default:
			System.out.println("Incorrect option");
		}
		sc.close();
	}

	static void createRequest(HttpMethod method) throws MalformedURLException, IOException {
		HttpClient http = new HttpClient();
		Scanner sc = new Scanner(System.in);
		String url;
        String addHeader;
        String addParameter;
        
		System.out.println("Enter the url for " + method.value + " request");
		url = sc.nextLine();
	

		System.out.println("Do you want to add a header? Enter 1 if yes");
		addHeader = sc.nextLine();
		while (addHeader.equals("1")) {
			String key = "";
			String value = "";
			System.out.println("Enter key");
			key = sc.nextLine();
			System.out.println("Enter value");
			value = sc.nextLine();
			http.addHeader(key, value);
			System.out.println("Add another header? Enter 1 if yes");
			addHeader = sc.nextLine();
		}

		System.out.println("Do you want to add a parameter? Enter 1 if yes");
		addParameter = sc.nextLine();
		while (addParameter.equals("1")) {
			String key = "";
			String value = "";
			System.out.println("Enter key");
			key = sc.nextLine();
			System.out.println("Enter value");
			value = sc.nextLine();
			http.addParameter(key, value);
			System.out.println("Add another parameter? Enter 1 if yes");
			addParameter = sc.nextLine();
		}
		sc.close();
		http.sendHttp(url, method);
	}
}
