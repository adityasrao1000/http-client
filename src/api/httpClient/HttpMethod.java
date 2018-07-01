package api.httpClient;

public enum HttpMethod {
	GET("GET"), POST("POST"), PUT("PUT"), DELETE("DELETE");

	public String value;

	private HttpMethod(String value) {
		this.value = value;
	}
}
