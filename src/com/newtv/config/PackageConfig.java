package com.newtv.config;

import java.util.HashMap;
import java.util.Map;


public class PackageConfig {
	
	private String name;
	
	private String namespace;
	
	private Map<String,ActionConfig> actions = new HashMap<String, ActionConfig>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public void addAction(ActionConfig action){
		actions.put(action.getName(), action);
	}
	
	public ActionConfig getActionByKey(String key){
		return actions.get(key);
	}
}
