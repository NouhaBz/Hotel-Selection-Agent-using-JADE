package jade.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dz
 */
public class Hotel {
    
       String name;
       String site ;
       String rating ;
       String stars ;
        
       public Hotel (String name , String site ,String rating ,String stars ){
           this.name =name ;
           this.site = site ;
           this.rating = rating ;
           this.stars = stars ;
       }
       
       public String getstars(){
           return this.stars;
       }
       public String getrating(){
           return this.rating;
       }
       
       
       @Override
       public String toString(){
         return "\n ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^  \nhotel name :"+ name +   "\n site :"+ site +"\n rating "+rating +"\n stars "+stars +"\n ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^  \n";
       }
    
       
       
       
          
}
