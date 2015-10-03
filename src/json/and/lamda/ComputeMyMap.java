package json.and.lamda;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface ComputeMyMap<T> {
	void apply(Map<String, Object> t);
	
	default void compute(String key, List<Map<String, Object>> fields) {
		
	}
	
}
