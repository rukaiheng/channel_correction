package com.nxmvc;

import java.rmi.RemoteException;

import nxopen.BaseSession;
import nxopen.NXException;
import nxopen.SessionFactory;
import nxopen.UI;

/**
 * file description: this file defines the entry for NX application. 
 * @author Kaiheng Lu
 *
 */

public class ApplicationEntry {

	static UI theUI = null;
	//------------------------------- DIALOG LAUNCHING ---------------------------------
    //
    //    Before invoking this application one needs to open any part/empty part in NX
    //    because of the behavior of the blocks.
    //
    //    Make sure the dlx file is in one of the following locations:
    //        1.) From where NX session is launched
    //        2.) $UGII_USER_DIR/application
    //        3.) For released applications, using UGII_CUSTOM_DIRECTORY_FILE is highly
    //            recommended. This variable is set to a full directory path to a file 
    //            containing a list of root directories for all custom applications.
    //            e.g., UGII_CUSTOM_DIRECTORY_FILE=$UGII_ROOT_DIR\menus\custom_dirs.dat
    //
    //    You can create the dialog using one of the following way:
    //
    //    1. USER EXIT
    //
    //        1) Create the Shared Library -- Refer "Block Styler programmer's guide"
    //        2) Invoke the Shared Library through File->Execute->NX Open menu.
    //
    //------------------------------------------------------------------------------
    public static void main(String [] argv) throws Exception
    {
        try
        {
           theUI = (UI) SessionFactory.get("UI");
        }
        catch(Exception ex)
        {
            //---- Enter your exception handling code here -----
             theUI.nxmessageBox().show("Block Styler", nxopen.NXMessageBox.DialogType.INFORMATION, ex.getMessage());
        }
    }
    
    //------------------------------------------------------------------------------
    // This method specifies how a shared image is unloaded from memory
    // within NX. This method gives you the capability to unload an
    // internal NX Open application or user  exit from NX. Specify any
    // one of the three constants as a return value to determine the type
    // of unload to perform:
    //
    //
    //    Immediately : unload the library as soon as the automation program has completed
    //    Explicitly  : unload the library from the "Unload Shared Image" dialog
    //    AtTermination : unload the library when the NX session terminates
    //
    //
    // NOTE:  A program which associates NX Open applications with the menubar
    // MUST NOT use this option since it will UNLOAD your NX Open application image
    // from the menubar.
    //------------------------------------------------------------------------------
     public static final int getUnloadOption()
    {
        return BaseSession.LibraryUnloadOption.EXPLICITLY;
    }
    
    //------------------------------------------------------------------------------
    // Following method cleanup any housekeeping chores that may be needed.
    // This method is automatically called by NX.
    //------------------------------------------------------------------------------
    public static void onUnload() throws NXException, RemoteException
    {
        try
        {
        }
        catch(Exception ex)
        {
            //---- Enter your exception handling code here -----
             theUI.nxmessageBox().show("Block Styler", nxopen.NXMessageBox.DialogType.INFORMATION, ex.getMessage());
        }
    }
}
