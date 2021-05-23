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
		System.out.println(APIc.getMarketJSONData());
	}
}