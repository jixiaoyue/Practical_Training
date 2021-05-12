package dataprovider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TxtDataHelper {
	 public static List<Map<String, String>>  getDataList(String filePath){
	        List<Map<String, String>> list=new ArrayList<Map<String, String>>();;
	        FileInputStream fileInputStream = null;
	        try {
	            fileInputStream = new FileInputStream(filePath);
	            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
	            BufferedReader br = new BufferedReader(inputStreamReader);
	            for (String line = br.readLine(); line != null; line = br.readLine()) {
	                Map<String, String> map = new HashMap<>();
	                String key=line.split(",")[0];
	                String value=line.split(",")[1];
	                map.put("userName",key);
	                map.put("passWord",value);
	                list.add(map);
	            }
	            br.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;

	    }

	    

}
