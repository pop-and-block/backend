/*
	A wrapper package that returns a JSON object from the WazirX API. 

	Don't shove data directly into fronted, please.
*/

//

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class APIw
{
	public static void main(String []args)
	{
		String uri = "https://api.wazirx.com/api/v2/market-status";

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
		
		// Making the HTTP request
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.thenApply(APIw::parse)
			.join();
	}

	public static String parse(String responseBody)
	{
		JSONObject market_stats = new JSONObject(responseBody);

		System.out.println(market_stats);

		return null;
	}
}