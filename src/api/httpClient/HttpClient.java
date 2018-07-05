package api.httpClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.StringJoiner;
import javax.net.ssl.HttpsURLConnection;

public class HttpClient {

	protected final String USER_AGENT = "Mozilla/5.0";
	protected StringJoiner urlParameters;
	private HashMap<String, String> parameters;
	private HashMap<String, String> headers;

	public HttpClient() {
		this.parameters = new HashMap<>();
		this.headers = new HashMap<>();
	}
    
	// add Headers method
	public void addHeader(String key, String value) {
		headers.put(key, value);
	}
    // add Parameters method
	public void addParameter(String key, String value) {
		parameters.put(key, value);
	}

	// HTTP GET request
	protected void sendHttp(String url) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}

	// HTTP POST, PUT, DELETE request
	protected void sendHttp(String url, HttpMethod method) throws MalformedURLException, IOException {
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		String methodType;

		// add request header
		switch (method) {
		case GET: {
			throw new IllegalArgumentException("Not a Valid HTTP method");
		}
		case POST: {
			methodType = HttpMethod.POST.value;
			break;
		}
		case PUT: {
			methodType = HttpMethod.PUT.value;
			break;
		}
		case DELETE: {
			methodType = HttpMethod.DELETE.value;
			break;
		}
		default: { // added TOP_RIGHT but forgot about it?
			throw new IllegalArgumentException("Not a Valid HTTP method");

		}
		}
		// add the method type
		con.setRequestMethod(methodType);
		// add a default user agent, can be overwritten
		con.setRequestProperty("User-Agent", USER_AGENT);

		if (!headers.isEmpty()) {
			System.out.println("List of Headers");
			for (HashMap.Entry<String, String> entry : headers.entrySet()) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
				con.setRequestProperty(entry.getKey(), entry.getValue());
			}
		}

		// Send post request
		con.setDoOutput(true);

		if (!parameters.isEmpty()) {
			urlParameters = new StringJoiner("&");
			System.out.println("List of Parameters");
			for (HashMap.Entry<String, String> entry : parameters.entrySet()) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
				urlParameters.add(entry.getKey() + "=" + entry.getValue());
			}
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters.toString());
			wr.flush();
			wr.close();
		}

		int responseCode = con.getResponseCode();
		System.out.println("\nSending '" + methodType + "' request to URL : " + url);
		if (urlParameters != null) {
			System.out.println("Post parameters : " + urlParameters);
		}
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
	}
}
