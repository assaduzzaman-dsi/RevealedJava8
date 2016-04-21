package json.and.lamda;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonFileMapExample {
    public static void main(String[] args) {
    	System.out.println("available processor::::::::::::::::::::::::" + Runtime.getRuntime().availableProcessors());
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");
		
		System.out.println("00................" + System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism"));

	try {

		ObjectMapper mapper = new ObjectMapper();
		
		// read JSON from a file
		Map<String, Object> map = mapper.readValue(
			new File("render.json"),
			new TypeReference<Map<String, Object>>() {
		});

//

	Map page = (Map)((List)((Map)((Map)map.get("ServiceRequest")).get("Params")).get("sections")).get(0);
	
	
	long time = System.currentTimeMillis();
//	setOptionDataLamda(page);
	System.out.println("time1" + (System.currentTimeMillis() - time));
	time = System.nanoTime();
	setOptionData(page);
	System.out.println("return ------------------------------::>>normal" + (System.nanoTime() - time));
	
	System.out.println(page);
	
	System.out.println("######################################################");
	time = System.nanoTime();
	setOptionReal(page);
	System.out.println("return ------------------------------::>>functional lamda:::" + (System.nanoTime() - time));
	System.out.println("craizy---->>" + page);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
    }
    
	
	private  static void setOptionDataLamda(Map<String,Object> page) {
		List<Map<String,Object>> groups = (List)page.get("groups");
		
		groups.parallelStream().forEach((group) -> {
			List<Map<String,Object>> fields = (List)group.get("fields");
			
			fields.parallelStream().forEach((field) -> {
				String options = (String) field.get("options");
				
				if(null != options && !options.isEmpty()) {
					List<Map<String,Object>> optionData = new ArrayList<>(); 
					optionData.add(getOptionData("",""));
					String [] optionsArray = options.split(",");
					for(String data : optionsArray) {
						optionData.add(getOptionData(data, data));
					}
					
					field.put("OptionsData", optionData);
				}
			});
		});
	}

	private  static void setOptionReal(Map<String,Object> page) {
		((List<Map<String,Object>>)page.get("groups")).parallelStream().filter(x -> x.containsKey("fields")).forEach(JsonFileMapExample::find);
	}	
	
	
	
	private static void find(Map <String,Object> field) {
		String options = (String) field.get("options");
		
		options = "assad,ruhi";
		
		if(null != options && !options.isEmpty()) {
			List<Map<String,Object>> optionData = new ArrayList<>(); 
			optionData.add(getOptionData("",""));
			String [] optionsArray = options.split(",");
			for(String data : optionsArray) {
				optionData.add(getOptionData(data, data));
			}
			
			field.put("OptionsData", optionData);
		}	
	}
	
	
	private  static void setOptionData(Map<String,Object> page) {
		List<Map<String,Object>> groups = (List)page.get("groups");
		
		for(Map group : groups) {
			List<Map<String,Object>> fields = (List)group.get("fields");
			
			for(Map field : fields) {
				String options = (String) field.get("options");
				
				if(null != options && !options.isEmpty()) {
					List<Map<String,Object>> optionData = new ArrayList<>(); 
					optionData.add(getOptionData("",""));
					String [] optionsArray = options.split(",");
					for(String data : optionsArray) {
						optionData.add(getOptionData(data, data));
					}
					
					field.put("OptionsData", optionData);
				}
			}
		}
	}
	
	static Map<String,Object > getOptionData(String value$, String description$) {
		Map<String,Object> optionDataValue = new HashMap<>();
		optionDataValue.put("IsDefault", false);
		optionDataValue.put("IsBlank", false);
		optionDataValue.put("Description", value$);
		optionDataValue.put("Value", description$);
		
		return optionDataValue;
		
	}
}