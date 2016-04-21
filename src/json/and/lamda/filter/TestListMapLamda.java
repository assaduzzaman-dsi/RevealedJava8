package json.and.lamda.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TestListMapLamda {
	static List list = new ArrayList<>();
	static List<Map<String,Object>> pages = new ArrayList<>();
	static Map<String,Object> pageIdWithPageInstanceId = new HashMap<>();
	
	static {
		Map userRole1 = new HashMap();
		userRole1.put("ID", 1);
		userRole1.put("Name", "student");
		Map userRole2 = new HashMap();
		userRole2.put("ID", 2);
		userRole2.put("Name", "public");
		Map userRole3 = new HashMap();
		userRole3.put("ID", 3);
		userRole3.put("Name", "recommender");
		
		Map userRole4 = new HashMap();
		userRole4.put("ID", 4);
		userRole4.put("Name", "student");
		
		
		list.add(userRole1);
		list.add(userRole2);
		list.add(userRole3);
		list.add(userRole4);
		
		Map<String,Object> page1 = new HashMap<>();
		page1.put("PageID", "PID1001");
		Map<String,Object>  page2 = new HashMap<>();
		page2.put("PageID", "PID1208");
		Map<String,Object>  page3 = new HashMap<>();
		page3.put("PageID", "PID1212");
		Map<String,Object>  page4 = new HashMap<>();
		page4.put("PageID", "PID1214");
		Map<String,Object>  page5 = new HashMap<>();
		page5.put("PageID", "PID15555");
		
		pages.add(page1);
		pages.add(page2);
		pages.add(page3);
		pages.add(page4);
		pages.add(page5);
		
		pageIdWithPageInstanceId.put("PID1212", 100);
		pageIdWithPageInstanceId.put("PID1001", 200);
		pageIdWithPageInstanceId.put("PID15555", 300);
		pageIdWithPageInstanceId.put("PID1208", 800);
		
		
	}
	
	/*
	 * "PageID" : "PID1001",
	 * "PageID" : "PID1208",
	 * "PageID" : "PID1212",
	 */
	
	public static void main(String [] args) {
		
		Object logicalRole = "xxx";
		
		Optional<Map> optional = list.stream().map(s -> s).filter(m -> ((Map) m).get("Name").equals(logicalRole)).findFirst();
		
		System.out.println("is present::" + optional.isPresent() + " value " );
		
		test();
		
		testMethodReference();
	}
	
	
	
	public static void test() {
		
		System.out.println("in testXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

		pages.stream().filter(page -> null != pageIdWithPageInstanceId.get(page.get("PageID"))).forEach(page ->{
			page.put("UserInstanceID", 1111);
    		System.out.println("page::" + page);
    	});		

    	System.out.println("in testXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" + pages);
	}
	
	public static void testMethodReference() {
		
		TestListMapLamda tt = new TestListMapLamda();
		
		pages.stream().filter(page -> null != pageIdWithPageInstanceId.get(page.get("PageID"))).forEach( tt::execute);		

		System.out.println("in methodrefffffffffffffffffffffffffffffffffffffffff" + pages);
		
	}
	
	public void execute(Map<String,Object> page) {
		
		System.out.println("this this interface with instance method::");
		page.put("UserInstanceID", 1111);
		System.out.println("hashmap::" + page);
	}
	
	
}
