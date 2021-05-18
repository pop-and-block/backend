import org.json.JSONObject;

public class test
{
	public static void main(String []args)
	{
		JSONObject APIdata = new JSONObject(APIw.getJSONEndPoint("trades"));
		System.out.println(APIdata);
	}
}