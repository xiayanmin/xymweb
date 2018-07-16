package cn.hnust.wechat;


import org.json.JSONException; 
import org.json.JSONObject; 

public class MenuSetting {

	public static String appId = "wxd3e342b6fa1d4be9";
    public static String appSecret= "52f99f49eab2e061a7d74efe85305a10"; 
    
	public static void main(String[] args) throws JSONException {
		add();
		//delete();
	}

    public static String getAccessToken() throws JSONException{
        NetWorkHelper netHelper = new NetWorkHelper();
        String Url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",appId,appSecret);
        String result = netHelper.getHttpsResponse(Url,"");
        System.out.println(result);
        //JSONObject json = JSONObject.fromObject(result);
        JSONObject json = new JSONObject(result);
        return  json.getString("access_token");
    }
    
    public static void delete() throws JSONException{
    		String s = getAccessToken();
        NetWorkHelper netHelper = new NetWorkHelper();
        String Url = String.format("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=%s", s);
        String result = netHelper.getHttpsResponse(Url,"");
        System.out.println(result);
    }
    
    public static void add() throws JSONException{
    		String s = getAccessToken();
        NetWorkHelper netHelper = new NetWorkHelper();
        String json = "{"
        		+ "\"button\":["
        		+ "{"
        		+ "\"name\":\"Ȥζ����\","
        		+ "\"sub_button\":["
        		+ "{"	
                + "\"type\":\"view\","
                + "\"name\":\"��ʼ����\","
                + "\"url\":\"http://ycxq4y.natappfree.cc/xymweb/test.html\""
                + "}]"
        		+ "},"
        		+ "{"
        		+ "\"name\":\"�ҵ�����\","
        		+ "\"sub_button\":["
        		+ "{"	
                + "\"type\":\"view\","
                + "\"name\":\"��������\","
                + "\"url\":\"http://ycxq4y.natappfree.cc/xymweb/test.html\""
             	+ "},"
             	 + "{"
                 + "\"type\":\"view\","
                 + "\"name\":\"�༶����\","
                 + "\"url\":\"http://ycxq4y.natappfree.cc/xymweb/test.html\""
              	+ "},"
             	+ "{"
                + "\"type\":\"view\","
                + "\"name\":\"����\","
                + "\"url\":\"http://ycxq4y.natappfree.cc/xymweb/test.html\""
             	+ "}]"
        		+ "},"
        		+ "{"
        		+ "\"name\":\"��������\","
        		+ "\"sub_button\":["
        		+ "{"	
                + "\"type\":\"view\","
                + "\"name\":\"������\","
                + "\"url\":\"http://ycxq4y.natappfree.cc/xymweb/test.html\""
                + "},"
             	+ "{"
                + "\"type\":\"view\","
                + "\"name\":\"��ϵ��\","
                + "\"url\":\"http://ycxq4y.natappfree.cc/xymweb/test.html\""
             	+ "}]"
        		+ "}]"
        		+ "}";
        System.out.println(json);
         
        String Url = String.format("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s", s);      
        String result = netHelper.getHttpsResponsePostBody(Url, "POST", json);
        System.out.println(result);
    }
    
}


