package dataprovider;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;






public class NSDataProvider {

	static String file1="E:\\demo\\tools\\dataProvider\\1.xls";
	static String file2="E:\\demo\\tools\\dataProvider\\1.txt";
	static String sheet="Sheet2";

	@DataProvider(name="txTDataMethod")
    public Object[][] txTDataMethod() {
        List<Map<String, String>> result = TxtDataHelper.getDataList(file2);
        Object[][] files = new Object[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            files[i] = new Object[]{result.get(i)};
        }
        return files;
    }
	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel(file1,sheet);
	}

	@DataProvider(name="words")
	public  Object[] getWords(){
		return new  Object[] 
			{"文字和图片动态"}
			;
	}
	@DataProvider(name="photos")
	public  Object[] getPhotos(){
		return new  Object[] 
			{"3个图片动态"}
			;
	}
	
	
	
//    @Test(dataProvider = "txTDataMethod")
//    public void test(Map<String,String> param) {
//        System.out.println(param.get("userName")+"\t"+param.get("passWord"));
//    }
//	
//	@Test(dataProvider ="excel")
//	public void getE(String a,String b) {
//		System.out.println(a+" "+b);
//	}	
}
