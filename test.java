/*
	Test class for the API methods
*/

import org.json.JSONObject;
import org.json.JSONArray;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class test
{
	public static void main(String []args)
	{
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
				System.out.println(markets.get(i));
		}
		
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}