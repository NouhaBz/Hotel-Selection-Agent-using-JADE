package jade.test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
/problem and problimatique 

/**
 *
 * @author dz
 */
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class HTMLReader {
    
    public ArrayList<Hotel> L_hotel = new ArrayList<Hotel>();
    public ArrayList<Hotel> Booking_hotel = new ArrayList<Hotel>(); 
    public ArrayList<Hotel> Trivago_hotel = new ArrayList<Hotel>(); 
    public ArrayList<Hotel> Trip_hotel = new ArrayList<Hotel>(); 
    
       public void readHTML(String Path,int i) throws IOException{
           String path = Path ;//"C:\\Users\\dz\\OneDrive\\Desktop\\m2\\taia\\tp\\jade test\\src\\jade\\test\\h.html";
           String stringHTML = new String (Files.readAllBytes(Paths.get(path))); // reading html file 
           
           //data-testid=\"property-card\"
           //trivago class="_8AwSku yOKUw_"
           //class="with-decorator-wrap-v8"
           String PS="";
         
           if(i==0){
               PS="data-testid=\"property-card\"";
           }
           if(i==1){
               PS="class=\"_8AwSku yOKUw_\"";
           }
           if(i==2){//class=\"with-decorator-wrap-v8\"
               PS="class=\"with-decorator-wrap-v8\"";
           }
          // switch (i){
            //   case (0):PS="data-testid=\"property-card\"";
              // case(1):PS="class=\"_8AwSku yOKUw_\"";
               //case(2):PS="class=\"with-decorator-wrap-v8\"";
           //}
           
           
           int H =0;
           boolean H_isfound = false ;
           //reading from each card 
           while ((H = stringHTML.indexOf(PS,H )) != -1){

               H_isfound = true ;
               String name = Pname(stringHTML ,H,i);
               String site = Psite(stringHTML ,H,i);
               String rating = Prating(stringHTML ,H,i);
               String stars = Pstars(stringHTML ,H,i);
               //trip rating of 5 make it of 10 
               if (i==2){
                   rating =Double.toString((Double.parseDouble(rating)*2));
               }
               
               Hotel HL = new Hotel(name,site,rating,stars);
               if(i==0){
                   Booking_hotel.add(HL);
               }
               if(i==1){
                   Trivago_hotel.add(HL);
               }
               if(i==2){
                   Trip_hotel.add(HL);
               }
                   
               
           
                L_hotel.add(HL);
                H += name.length() ;
                
               
           }
           //displayH();
           
           
           
           if (!H_isfound){
               System.out.println("didnt found hotel in the file ");
            }
           
       }
       
       public void displayH(){
           int ch =1;
           System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~**  Booking Hotel List  **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
           for(Hotel h : Booking_hotel){
               
             System.out.println("number :"+ch+"\n"+ h.toString());
             ch++;
           } 
           ch =1;
           System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~**  Trivago Hotel List  **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
           for(Hotel h : Trivago_hotel){
             System.out.println("number :"+ch+"\n"+ h.toString());
             ch++;
           } 
           ch =1;
           System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~**   Trip Hotel List    **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
           for(Hotel h : Trip_hotel){
             System.out.println("number :"+ch+"\n"+ h.toString());
             ch++;
           } 
       }
       
        
       //trivago : <span title="citizenM Paris Gare de Lyon" itemprop="name"></span>
       //trip :<span class="name" >Novotel Paris Orly Rungis</span>
       private String Pname (String P , int h, int i){
           String Pname ="";
           String Pend ="";
           switch (i){
               case 0: Pname ="<div data-testid=\"title\" class=\"f6431b446c a15b38c233\">";
                       Pend ="</div>";
                       break;
               case 1: Pname ="itemprop=\"name\">";
                       Pend ="</span";
                       break;
               case 2: Pname ="<span class=\"name\">";
                       Pend ="</span"; 
                       break;
               default :
                   throw new IllegalArgumentException("Invalid case index: " + i);
         } 
           
           return getP(P, Pname,Pend , h);
       }
       
       
       
       //booking <h3 class="aab71f8e4e"><a href="https://www.booking.com/hotel/lu
       //trip :<link rel="canonical" href="https://us.trip.com/hotels/city/fr/paris.html" />
       ///<meta property="og:url"/content="https://ar.trivago.com/en-145/odr/hotels-paris-france?search=200-22235"/>
       
       
       private String Psite (String P , int h,int i){
           
           String Psite ="";
           String Pend ="";
           switch (i){
               case 0: Psite ="<h3 class=\"aab71f8e4e\"><a href=\"";
                       Pend ="/lu";
                       break;
               case 1: Psite ="<img src=\"";
                       Pend ="/c_fill,";
                       break;
               case 2: Psite ="<link rel=\"canonical\"href=\"";
                       Pend ="\""; 
                       break;
               default :
                   throw new IllegalArgumentException("Invalid case index: " + i);
         } 
           
           return getP(P, Psite ,Pend , h);
       }
       
       //trip :  <span class="real">3.8</span > /// of 5
       //trivago : <span class="SmLAfp Eqg9Bk Dtphjk EXnXoV"  itemprop="ratingValue">7.9</span>
       private String Prating  (String P , int h,int i){
           String Prating ="";
           String Pend ="";
           switch (i){
               case 0: Prating ="<div class=\"ac4a7896c7\">Scored ";
                       Pend ="</div>";
                       break;
               case 1: Prating ="class=\"SmLAfp Eqg9Bk Dtphjk EXnXoV\"itemprop=\"ratingValue\">";
                       Pend ="</span";
                       break;
               case 2: Prating ="<span class=\"real\">";
                       Pend ="</span"; 
                       break;
               default :
                   throw new IllegalArgumentException("Invalid case index: " + i);
         } 
           
          
           return getP(P, Prating, Pend, h);
       }
       //trip :<div class="more-star-repeat">
                                     // <i
                                       // style="color: #ffb400"
                                        //type="ic_new_star"
                                        //class="u-icon u-icon-ic_new_star own-star"
                                      //></i>
       
       //trivago :<meta
                                   //     itemprop="ratingValue"content="2" />
       private String Pstars (String P , int h,int i){
           String Pstars ="";
           String Pend ="";
           String S ="";
           switch (i){
               case 0: Pstars ="<div class=\"b3f3c831be\" tabindex=\"0\" aria-label=\"";
                       Pend ="out";
                       S=getP(P, Pstars,Pend, h);
                       break;
               case 1: Pstars ="itemprop=\"ratingValue\"content=\"";
                       Pend ="\" />";
                       S=getP(P, Pstars,Pend, h);
                       break;
               case 2: Pstars ="<div class=\"more-star-repeat\">";
                       Pend ="</div>"; 
                       String stars=getP(P, Pstars, Pend, h);
                       S=countstars(stars); 
                       break;
               default :
                   throw new IllegalArgumentException("Invalid case index: " + i);
         } 
           
          
           return S;
       }
       
       
       private String getP(String P ,String start , String end , int h){
           int s =P.indexOf(start,h);
          // System.out.println("s ;"+s);
           if (s ==-1){
               return "0";
           }
           
           s+= start.length();
         //  System.out.println("s ;"+s);
           int e = P.indexOf(end , s);
          // System.out.println("e ;"+e);
            return (e != -1) ? P.substring(s, e).trim() : "0";
          
           
                   
       }
  /*     
       public void Beast_H(){
        ArrayList<Hotel> MLH = new ArrayList<Hotel>();
        
        
             
            Hotel Mhs = Collections.max(L_hotel,Comparator.comparingDouble(h -> Double.parseDouble(h.getstars())) );
        
        double MS =Double.parseDouble(Mhs.getstars());
        
        for (Hotel h:L_hotel){
            if(Double.parseDouble(h.getstars())== MS){
                MLH.add(h);
            }
        }
        
        Hotel Mh = Collections.max(MLH,Comparator.comparingDouble(h -> Double.parseDouble(h.getrating())) );
        
        System.out.println("Best hotel :\n"+Mh.toString());
    }*/
       
       public void Beast_H_inlist(){
System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##  Booking Websit  ## ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        ArrayList<Hotel> MLH = new ArrayList<Hotel>();
        ArrayList<Hotel> BMLH = new ArrayList<Hotel>();
            Hotel Mhs = Collections.max(Booking_hotel,Comparator.comparingDouble(h -> Double.parseDouble(h.getstars())) );
            
        double MS =Double.parseDouble(Mhs.getstars());
        for (Hotel h:Booking_hotel){
            if(Double.parseDouble(h.getstars())== MS){
                MLH.add(h);
            }
        }
        Hotel Mh1 = Collections.max(MLH,Comparator.comparingDouble(h -> Double.parseDouble(h.getrating())) );
        BMLH.add(Mh1);
        System.out.println("\n Best hotel in Booking :\n"+Mh1.toString());
        
  //###################################################################################################################
System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##  Trivago Websit  ##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  
  
        MLH.removeAll(MLH);
         Mhs = Collections.max(Trivago_hotel,Comparator.comparingDouble(h -> Double.parseDouble(h.getstars())) );
         MS =Double.parseDouble(Mhs.getstars());
        for (Hotel h:Trivago_hotel){
            if(Double.parseDouble(h.getstars())== MS){
                MLH.add(h);
            }
        }
        
        Hotel Mh2 = Collections.max(MLH,Comparator.comparingDouble(h -> Double.parseDouble(h.getrating())) );
         BMLH.add(Mh2);
        System.out.println("\n Best hotel in Trivago :\n"+Mh2.toString());
 //###################################################################################################################
 
System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##  Trip Websit  ##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

 
        MLH.removeAll(MLH);
        
        Mhs = Collections.max(Trip_hotel,Comparator.comparingDouble(h -> Double.parseDouble(h.getstars())) );
         MS =Double.parseDouble(Mhs.getstars());
        for (Hotel h:Trip_hotel){
            if(Double.parseDouble(h.getstars())== MS){
                MLH.add(h);
            }
        }
        Hotel Mh3 = Collections.max(MLH,Comparator.comparingDouble(h -> Double.parseDouble(h.getrating())) );
        BMLH.add(Mh2);
        System.out.println("\n Best hotel in Trip :\n"+Mh3.toString());
        
System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##  The Best Hotel  ##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        MLH.removeAll(MLH);
        Hotel BH =Collections.max(BMLH,Comparator.comparingDouble(h -> Double.parseDouble(h.getstars())));
        double BS =Double.parseDouble(Mhs.getstars());
        MLH.add(BH);
        for (Hotel h:Trip_hotel){
            if(Double.parseDouble(h.getstars())== BS){
                MLH.add(h);
            }
        }
        Hotel BHR = Collections.max(MLH,Comparator.comparingDouble(h -> Double.parseDouble(h.getrating())) );
        System.out.println("\n Best hotel  :\n"+BHR.toString());
    }
       

       
       
       private String countstars(String str ){
           String color ="#ffb400";
           int count =0;
           int id =0;
           
           while ((id = str.indexOf(color ,id)) !=-1){
               count++;
               id+=color.length();
           }
           
          return Integer.toString(count) ;
           
       }
       
    
}
