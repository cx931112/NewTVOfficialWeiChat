package com.newtv.weixin.util;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class ParseXmlGetMapUtil {
public static HashMap<String,String> map=new HashMap<String,String>();
public static HashMap<String,String> ParseXmlGetMap(HttpServletRequest request){
	SAXReader saxreader=new SAXReader();
	try {
		Document document=saxreader.read(request.getInputStream());
		Element element=document.getRootElement();
		return getMapByElement(element);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		return null;
	} 
	
}

public static HashMap<String,String> getMapByElement(Element element){
	List<Element> elements=element.elements();
          for(Element e:elements){
        	  if(e.elements().size()>0){
        		  getMapByElement(e);
        	  }
        	  map.put(e.getName(), e.getText());
        	  
          }
	return map;
	
}

}
