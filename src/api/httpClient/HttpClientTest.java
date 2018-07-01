package api.httpClient;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class HttpClientTest {

	HttpClient client;

	@Before
	public void initialize() {
		client = new HttpClient();
	}

	@Test
	public void testInitial() {
		assertEquals(client.urlParameters, null);
	}

	@Test(expected = java.net.UnknownHostException.class)
	public void testGet1() throws Exception {
		// some site that does not exist
		client.sendHttp("https://asdddsfdrfrffovkvsomesite.com");
	}

	@Test
	public void testGet2() throws Exception {
		client.sendHttp("https://www.google.com");
	}

	@Test(expected = java.net.UnknownHostException.class)
	public void doPost() throws Exception {
		HashMap<String, String> para = new HashMap<>();
		para.put("agent", "windows");
		client.sendHttp("https://assdassfffjrjfbehff.co", HttpMethod.POST, para, new HashMap<>());
	}

	@Test
	public void testPost() throws Exception {
		client.sendHttp("https://jsonplaceholder.typicode.com/posts", HttpMethod.POST, new HashMap<>(),
				new HashMap<>());
		assertEquals(client.urlParameters, null);
	}

	@Test
	public void testPostWithParameter() throws Exception {
		HashMap<String, String> para = new HashMap<>();
		para.put("agent", "windows");
		client.sendHttp("https://jsonplaceholder.typicode.com/posts", HttpMethod.POST, para, new HashMap<>());
		assertEquals(client.urlParameters.toString(), "agent=windows");
	}

	@Test
	public void testPostWithHeader() throws Exception {
		HashMap<String, String> header = new HashMap<>();
		header.put("agent", "windows");
		client.sendHttp("https://jsonplaceholder.typicode.com/posts", HttpMethod.POST, new HashMap<>(), header);
		assertEquals(client.urlParameters, null);
	}

	@Test
	public void testPostWithMultipleParameters() throws Exception {
		HashMap<String, String> para = new HashMap<>();
		para.put("agent", "windows");
		para.put("user", "person");
		client.sendHttp("https://jsonplaceholder.typicode.com/posts", HttpMethod.POST, para, new HashMap<>());
		assertEquals(client.urlParameters.toString(), "agent=windows&user=person");
	}

	@Test
	public void testPut() throws Exception {
		client.sendHttp("https://jsonplaceholder.typicode.com/posts/1", HttpMethod.PUT, new HashMap<>(),
				new HashMap<>());
		assertEquals(client.urlParameters, null);
	}

	@Test
	public void testPutWithParameter() throws Exception {
		HashMap<String, String> para = new HashMap<>();
		para.put("agent", "windows");
		client.sendHttp("https://jsonplaceholder.typicode.com/posts/1", HttpMethod.PUT, para, new HashMap<>());
		assertEquals(client.urlParameters.toString(), "agent=windows");
	}

	@Test
	public void testPutWithHeader() throws Exception {
		HashMap<String, String> header = new HashMap<>();
		header.put("agent", "windows");
		client.sendHttp("https://jsonplaceholder.typicode.com/posts/1", HttpMethod.PUT, new HashMap<>(), header);
		assertEquals(client.urlParameters, null);
	}

	@Test
	public void testPutWithMultipleParameters() throws Exception {
		HashMap<String, String> para = new HashMap<>();
		para.put("agent", "windows");
		para.put("user", "person");
		client.sendHttp("https://jsonplaceholder.typicode.com/posts/1", HttpMethod.PUT, para, new HashMap<>());
		assertEquals(client.urlParameters.toString(), "agent=windows&user=person");
	}
}
