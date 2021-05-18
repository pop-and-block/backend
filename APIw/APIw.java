/*
	A wrapper package that returns a JSON object from the WazirX API. Returns one of the four API endpoints
	1. MARKET STATUS
	2. MARKET TICKER
	3. MARKET DEPTH
	4. MARKET TRADE HISTORY

	Don't shove data directly into the front-end, please.

	Note to self: You CAN'T pass JSONObjects between funtions. Use strings instead, duh

	TODO: 	1. Fix DEPTH and TRADES endpoint (need to mention market)
			2. Make it async
*/

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONArray;

public final class APIw
{
	// Non-changing vars
	private static final String[] endpoints = {"market-status", "tickers", "depth", "trades"};
	private static final String uri = "https://api.wazirx.com/api/v2/";

	private static String getJSONFromURI(String uri)
	{
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
		
		try
		{
			// Making the HTTP request
			HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body().toString();
		}

		catch(Exception e)
		{
			System.out.println("Something bad happened: " + e);
			return null;
		}
	}

	public static String getJSONEndPoint(String endpoint)
	{
		boolean isEndPoint = false;
		
		for(String cur_endpoint : endpoints)
		{
			if(cur_endpoint.equals(endpoint))
			{
				isEndPoint = true;
				break;
			}
		}

		// Terminate program if invalid enpoint is found
		if(!isEndPoint)
		{
			System.out.println("Invalid endpoint entered!! Terminating application immediately!");
			System.exit(0);
		}

		return getJSONFromURI(uri + endpoint);
	}
}