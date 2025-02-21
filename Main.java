package jade.test;

/**
 *
 * @author dz
 */
import jade.core.AID;
import jade.test.HTMLReader;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

import jade.lang.acl.ACLMessage;

public class Main extends Agent {
    HTMLReader HR = new HTMLReader();
    String AG1 = "Agent2";
    AID id = new AID(AG1 ,AID.ISLOCALNAME );
    
    
    @Override
    protected void setup() {
        System.out.println("This is Agent : *" + getLocalName() + "*     started............................");
        String[] paths ={
            "C:\\Users\\dz\\OneDrive\\Desktop\\m2\\taia\\tp\\jade test\\src\\jade\\test\\hBooking.html",
            "C:\\Users\\dz\\OneDrive\\Desktop\\m2\\taia\\tp\\jade test\\src\\jade\\test\\hTrivago.html",    
            "C:\\Users\\dz\\OneDrive\\Desktop\\m2\\taia\\tp\\jade test\\src\\jade\\test\\hTrip.html"
                
        };
        
       
      
               
               try {
                  for(int i =0 ;i<paths.length ;i++){
                      
                       HR.readHTML(paths[i],i);
                       // HR.displayH();
                        
                   }
                  
                  HR.displayH();
                  System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~**  BEST HOTELS IN PARIS  **~~~~~~~~~~~~~~~~~~~~~~~\n");
                  HR.Beast_H_inlist();
                 
                  //HR.Beast_H();
                   
                   
                    //HR.readHTML(File_path2);
                    //HR.readHTML(File_path3);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
           
        }
        
      
        
       
    
    
    
}
