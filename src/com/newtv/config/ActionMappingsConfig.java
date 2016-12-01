package com.newtv.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ActionMappingsConfig {
	
	private Map<String, PackageConfig> packages = new HashMap<String, PackageConfig>();
	
	
	private List<IncludeConfig> includes = new ArrayList<IncludeConfig>();
	
	public void addPackage(PackageConfig packageConfig){
		packages.put(packageConfig.getNamespace(), packageConfig);
	}
	
	public PackageConfig getPackageByKey(String key){
		return packages.get(key);
	}
	
	public void addInclude(IncludeConfig include){
		includes.add(include);
	}
	
	public List<IncludeConfig> getIncludes(){
		return includes;
	}
}
