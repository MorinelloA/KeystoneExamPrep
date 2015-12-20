package com.keystoneexamprep.view.utility;

import com.keystoneexamprep.driver.Log4JInit;
import javax.swing.UIManager;

import com.keystoneexamprep.view.mainjframe.MainJFrameView;
import com.keystoneexamprep.view.mainjframe.MainJFrameController;
import org.apache.log4j.Logger;

/**
 * ViewDriver.java
 *
 * Driver class that starts the GUI (View) of the Keystone Exam Prep application.
 */
public class ViewDriver {
    static Logger log = Logger.getLogger("com.KeystoneExamPrep");
    /** Creates a new instance of ViewDriver */
    public ViewDriver() 
    {
       try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }
       catch (Exception e) {
         e.printStackTrace();
       }
       // Following MVC approach here.

        //create view class
        MainJFrameView mainJFrame = new MainJFrameView();
       
        // Create Controller class and set the view
        MainJFrameController mainJFrameController = new MainJFrameController(mainJFrame);
        
    }
    
  /**
  * View entry point.
  *
  * @param args String[] - Arguments that can be passed to the Application
  */
 public static void main(String[] args) {
     Log4JInit.initializeLog4J();
   new ViewDriver();
 }
    
}