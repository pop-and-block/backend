/*
	A wrapper package that returns a JSON object from the WazirX API. 

	Don't shove data directly into fronted, please.
*/

//

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIW
{
	public static void main(String []args)
	{
		String uri = "https://api.wazirx.com/api/v2/market-status";

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
		
		// Making the HTTP request
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.thenAccept(System.out::println)
			.join();
	}
}