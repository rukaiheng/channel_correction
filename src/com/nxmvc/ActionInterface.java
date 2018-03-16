package com.nxmvc;

import java.rmi.RemoteException;

import nxopen.NXException;
import nxopen.NXMessageBox.DialogType;
import nxopen.Session;
import nxopen.SessionFactory;
import nxopen.UI;

public abstract class ActionInterface {
	
	public static UI theUI = null;
	public static Session theSession = null;
	
	//save the request and response
	public static Request request = null;
	public static Response response = null;
	
	{
		try {
			//initialize the static variables
			theUI = (UI)SessionFactory.get("UI");
			theSession = (Session)SessionFactory.get("Session");
			
		} catch (NXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DoAction() throws RemoteException, NXException
	{
		theUI.nxmessageBox().show("application", DialogType.INFORMATION, "there is no user application action invoked.");
	}
	
	/**
	 * description: this interface was use to forward the action to a dialog
	 * @param dlxName
	 */
	public void forward(String dlxName)
	{
		//1. get class name of current instance
		String theClassName = this.getClass().getName();
		//2. get the upper level class
		//request.getAttribute("class")
	}
}
