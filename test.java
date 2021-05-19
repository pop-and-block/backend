/*
	Test class for the API methods

	TODO: List all the INR markets
*/

import org.json.JSONObject;

public class test
{
	public static void main(String []args)
	{
		// JSONObject APIdata = new JSONObject(APIw.getJSONEndPoint("trades", "btcusdt"));
		System.out.println(APIw.getJSONEndPoint("trades", "ethinr"));
	}
}