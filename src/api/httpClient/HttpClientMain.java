package api.httpClient;

import java.util.HashMap;
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
		String addHeader;
		HashMap<String, String> headers;
        
		String addParameter;
		HashMap<String, String> parameters;
		
		String key;
		String value;
		switch (option) {
		case 1:
			System.out.println("Enter the url for GET request");
			url = sc.nextLine();
			http.sendHttp(url);
			break;
		case 2:
			System.out.println("Enter the url for POST request");
			url = sc.nextLine();

			System.out.println("Do you want to add a header? Enter 1 if yes");
			addHeader = sc.nextLine();
			headers = new HashMap<String, String>();
			while (addHeader.equals("1")) {
				System.out.println("Enter key");
				key = sc.nextLine();
				System.out.println("Enter value");
				value = sc.nextLine();
				headers.put(key, value);
				System.out.println("Add another header? Enter 1 if yes");
				addHeader = sc.nextLine();
			}
			
			System.out.println("Do you want to add a parameter? Enter 1 if yes");
			addParameter = sc.nextLine();
			parameters = new HashMap<String, String>();
			while (addParameter.equals("1")) {
				System.out.println("Enter key");
				key = sc.nextLine();
				System.out.println("Enter value");
				value = sc.nextLine();
				parameters.put(key, value);
				System.out.println("Add another header? Enter 1 if yes");
				addParameter = sc.nextLine();
			}

			http.sendHttp(url, HttpMethod.POST, parameters, headers);
			break;
		case 3:
			System.out.println("Enter the url for PUT request");
			url = sc.nextLine();

			System.out.println("Do you want to add a header? Enter 1 if yes");
			addHeader = sc.nextLine();
			headers = new HashMap<String, String>();
			while (addHeader.equals("1")) {
				System.out.println("Enter key");
				key = sc.nextLine();
				System.out.println("Enter value");
				value = sc.nextLine();
				headers.put(key, value);
				System.out.println("Add another header? Enter 1 if yes");
				addHeader = sc.nextLine();
			}
			
			System.out.println("Do you want to add a parameter? Enter 1 if yes");
			addParameter = sc.nextLine();
			parameters = new HashMap<String, String>();
			while (addParameter.equals("1")) {
				System.out.println("Enter key");
				key = sc.nextLine();
				System.out.println("Enter value");
				value = sc.nextLine();
				parameters.put(key, value);
				System.out.println("Add another header? Enter 1 if yes");
				addParameter = sc.nextLine();
			}

			http.sendHttp(url, HttpMethod.PUT, parameters, headers);
			break;
		case 4:
			System.out.println("Enter the url for DELETE request");
			url = sc.nextLine();

			System.out.println("Do you want to add a header? Enter 1 if yes");
			addHeader = sc.nextLine();
			headers = new HashMap<String, String>();
			while (addHeader.equals("1")) {
				System.out.println("Enter key");
				key = sc.nextLine();
				System.out.println("Enter value");
				value = sc.nextLine();
				headers.put(key, value);
				System.out.println("Add another header? Enter 1 if yes");
				addHeader = sc.nextLine();
			}
			
			System.out.println("Do you want to add a parameter? Enter 1 if yes");
			addParameter = sc.nextLine();
			parameters = new HashMap<String, String>();
			while (addParameter.equals("1")) {
				System.out.println("Enter key");
				key = sc.nextLine();
				System.out.println("Enter value");
				value = sc.nextLine();
				parameters.put(key, value);
				System.out.println("Add another header? Enter 1 if yes");
				addParameter = sc.nextLine();
			}

			http.sendHttp(url, HttpMethod.DELETE, parameters, headers);
			break;
		default:
			System.out.println("Incorrect option");
		}
		sc.close();
	}
}
