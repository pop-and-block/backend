/*
	client side API to connect back-end and front-end

	TODO:	implement JSON for all markets
*/

import org.json.JSONObject;
import org.json.JSONArray;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class APIc
{
	public static void main(String []args)
	{
		JSONObject chart_stuff = new JSONObject();
		try(InputStream stream = Files.newInputStream(Paths.get("res.json")))
		{
			// Convert stream to string
			String contents = new String(stream.readAllBytes(), StandardCharsets.UTF_8);

			// To print the string content
			// System.out.println(contents);

			JSONObject resJSON = new JSONObject(contents);
			// System.out.println(resJSON);

			JSONArray markets = resJSON.getJSONArray("markets");

			for(int i = 0; i < markets.length(); i++)
			{
				// System.out.println(markets.get(i));
				String curr_market = markets.get(i).toString();
				JSONArray coin_value = new JSONArray(APIw.getJSONEndPoint("trades",curr_market));

				JSONObject coin_allvals = new JSONObject();

				String[] time = new String[coin_value.length()];
				String[] value = new String[coin_value.length()];

				for(int j=0; j<coin_value.length(); j++)
				{ 
					JSONObject Current_stuff = coin_value.getJSONObject(j);
					time[j] = Current_stuff.get("created_at").toString();
					value[j] = Current_stuff.get("price").toString();
				}
				
				coin_allvals.put("time",time);
				coin_allvals.put("value",value);
				chart_stuff.put(curr_market,coin_allvals);
			}
		}
		
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		System.out.println(chart_stuff);
	}
}