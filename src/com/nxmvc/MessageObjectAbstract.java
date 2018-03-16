package com.nxmvc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * file description: this file defines a class to represent the message package to save data comes from
 *      user interface and menu. All the data saves in a map.
 *      
 * @author Z003RWCR
 *
 */
public abstract class MessageObjectAbstract {
		
	private Map<String, List<Object>> dataMap;
	
	/**
	 * set an attribute to the message package
	 * @param attributeName
	 * @param theObject
	 */
	public void SetAttribute(String attributeName, Object theObject)
	{
		dataMap.put(attributeName, Arrays.asList(theObject));
	}
	
	/**
	 * get an attribute from message package if there is such an attribute
	 * @param attributeName
	 * @return the attribute if there is such attribute. return null if there is no such attribute
	 */
	public Object getAttribute(String attributeName)
	{
		List<Object> objects = dataMap.get(attributeName);
		if(objects.size() > 0)
		{
			return objects.get(0);
		}
		return null;
	}
	
	/**
	 * description: this method is used to add new attribute value for the list attribute.
	 *              if there is list attribute with attribute name add a new value for this attribute
	 *              if there is no list attribute with attribute name add a new attribute 
	 * @param attributeName
	 * @param theObject
	 */
	public void AddAttribute(String attributeName, Object theObject)
	{
		List<Object> objects = dataMap.get(attributeName);
		if(objects.size() > 0)
		{
			objects.add(theObject);
			dataMap.put(attributeName, objects);
		}
		else
		{
			dataMap.put(attributeName, Arrays.asList(theObject));
		}
	}
	
	/**
	 * description: set the attribute as given list value no matter there is attribute named attribute name
	 * @param attributeName
	 * @param objects
	 */
	public void SetListAttribute(String attributeName, List<Object> theObjects)
	{
		dataMap.put(attributeName, theObjects);
	}
	
	/**
	 * description: this method returns a list objects named attributeName
	 * @param attributeName
	 * @return
	 */
	public List<Object> getListAttribute(String attributeName)
	{
		return dataMap.get(attributeName);
	}
}
