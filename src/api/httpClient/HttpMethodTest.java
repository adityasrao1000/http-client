package api.httpClient;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HttpMethodTest {
  
	@Test
	public void testGET() {
		assertEquals(HttpMethod.GET.value, "GET" );
	}
	
	@Test
	public void testPOST() {
		assertEquals(HttpMethod.POST.value, "POST" );
	}
	
	@Test
	public void testPUT() {
		assertEquals(HttpMethod.PUT.value, "PUT" );
	}
	
	@Test
	public void testDELETE() {
		assertEquals(HttpMethod.DELETE.value, "DELETE" );
	}
}
