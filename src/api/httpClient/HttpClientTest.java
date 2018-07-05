package api.httpClient;

import static org.junit.Assert.assertEquals;
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
		client.addParameter("agent", "windows");
		client.sendHttp("https://assdassfffjrjfbehff.co", HttpMethod.POST);
	}

	@Test
	public void testPost() throws Exception {
		client.sendHttp("https://jsonplaceholder.typicode.com/posts");
		assertEquals(client.urlParameters, null);
	}

	@Test
	public void testPostWithParameter() throws Exception {
		client.addParameter("agent", "windows");
		client.sendHttp("https://jsonplaceholder.typicode.com/posts", HttpMethod.POST);
		assertEquals(client.urlParameters.toString(), "agent=windows");
	}

	@Test
	public void testPostWithHeader() throws Exception {
		client.addHeader("agent", "windows");
		client.sendHttp("https://jsonplaceholder.typicode.com/posts", HttpMethod.POST);
		assertEquals(client.urlParameters, null);
	}

	@Test
	public void testPostWithMultipleParameters() throws Exception {
		client.addParameter("agent", "windows");
		client.addParameter("user", "person");
		client.sendHttp("https://jsonplaceholder.typicode.com/posts", HttpMethod.POST);
		assertEquals(client.urlParameters.toString(), "agent=windows&user=person");
	}

	@Test
	public void testPut() throws Exception {
		client.sendHttp("https://jsonplaceholder.typicode.com/posts/1", HttpMethod.PUT);
		assertEquals(client.urlParameters, null);
	}

	@Test
	public void testPutWithParameter() throws Exception {
		client.addParameter("agent", "windows");
		client.sendHttp("https://jsonplaceholder.typicode.com/posts/1", HttpMethod.PUT);
		assertEquals(client.urlParameters.toString(), "agent=windows");
	}

	@Test
	public void testPutWithHeader() throws Exception {
		client.addHeader("agent", "windows");
		client.sendHttp("https://jsonplaceholder.typicode.com/posts/1", HttpMethod.PUT);
		assertEquals(client.urlParameters, null);
	}

	@Test
	public void testPutWithMultipleParameters() throws Exception {
		client.addParameter("agent", "windows");
		client.addParameter("user", "person");
		client.sendHttp("https://jsonplaceholder.typicode.com/posts/1", HttpMethod.PUT);
		assertEquals(client.urlParameters.toString(), "agent=windows&user=person");
	}
}
