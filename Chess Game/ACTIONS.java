import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class ACTIONS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ACTIONS extends Actor
{
   public boolean isGrabbed = false;
   
   public static int turn = 1;
   
   public int PromotionX;
   public int PromotionX2;
   
   public void act()
    {
        turn = 1;
        
       }
        
   public boolean checkforpease1()
    {
      if(isTouching(PEASES1.class))
        {
            
            return true;
        
       }  
       else
       {
         return false;
       }
    }
   public boolean checkforpease2()
    {
      if(isTouching(PEASES2.class))
        {
            
            return true;
           
       }  
       else
       {
         return false;
       }
    }
   public void Schlagen1()
   {
       if(isGrabbed == false)
       {
       World world = getWorld();
       world.removeObject(getOneIntersectingObject(PEASES1.class));
    }
   }
   public void Schlagen2()
   {
       if(isGrabbed == false)
       {
       World world = getWorld();
       world.removeObject(getOneIntersectingObject(PEASES2.class));
    }
   }
   public static void turnW()
   {
       turn = 1;
   }
   public static void turnB()
   {
       turn = 2;
   }  
   public static boolean Whiteturn()
   {
      if(turn == 1)
      {
          return true;
      }
      else
      {
          return false;
      }
   }
   
   }
    
    

