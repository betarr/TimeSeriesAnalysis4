package enums;

import java.util.ArrayList;
import java.util.List;

public enum GenerateFunction {
	SIN(EnumsConfig.GENERATE_FUNCTION_SIN),
	COSINE(EnumsConfig.GENERATE_FUNCTION_COSIN);
	
	private String name;
	
	GenerateFunction(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static List<String> getNames() {
		List<String> result = new ArrayList<String>();
		GenerateFunction[] functions = GenerateFunction.values();
		for (GenerateFunction function : functions) {
			result.add(function.getName());
		}
		return result;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
