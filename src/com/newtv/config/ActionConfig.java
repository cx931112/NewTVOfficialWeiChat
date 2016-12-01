package com.newtv.config;

import java.util.HashMap;
import java.util.Map;



public class ActionConfig {
	
	private String name;
	
	private String classPath;
	
	private String method;
	
	private String forward;
	
	private Map<String,ResultConfig> results = new HashMap<String, ResultConfig>();
	
	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public ResultConfig getResultByKey(String key) {
		return results.get(key);
	}

	public void addResult(ResultConfig result) {
		results.put(result.getName(), result);
	}
	
	
}
