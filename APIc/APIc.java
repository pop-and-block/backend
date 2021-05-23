/*
	client side API to connect back-end and front-end

	TODO:	implement JSON for all markets
*/

import org.json.JSONObject;
import org.json.JSONArray;

public class APIc
{
	public static void main(String []args)
	{
		JSONArray Coin1_Value = new JSONArray(APIw.getJSONEndPoint("trades","ethinr"));


		JSONObject chart_stuff = new JSONObject();
		JSONObject Coin1_FinalValue = new JSONObject();

		String[] time = new String[Coin1_Value.length()];
		String[] value = new String[Coin1_Value.length()];

		for(int i=0; i<Coin1_Value.length(); i++)
		{ 
			JSONObject Current_stuff = Coin1_Value.getJSONObject(i);
			time[i] = Current_stuff.get("created_at").toString();
			value[i] = Current_stuff.get("price").toString();
		}
		
		Coin1_FinalValue.put("time",time);
		Coin1_FinalValue.put("value",value);
		chart_stuff.put("ethinr",Coin1_FinalValue);
		System.out.println(chart_stuff);
	}
}