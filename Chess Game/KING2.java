import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KING1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KING2 extends PEASES2
{
    int oldX;
    int oldY;
    
    private boolean valid = false;
    private boolean isGrabbed = false;
    
    int newX1;
    int newY1;
    
    int newX2;
    int newY2;
    
    int newX3;
    int newY3;
    
    int newX4;
    int newY4;
    
    int endX;
    int endY;
    public void act()
    {
        Kingmove2();
    }
    public KING2()
    {
        GreenfootImage myImage = getImage();
        int myNewHight = (int)myImage.getHeight() / 6;
        int myNewWidth = (int)myImage.getWidth() / 6;
        myImage.scale(myNewWidth, myNewWidth);
    }
    public void Kingmove2()
    {
       if(turn == 2)
      {  
       Lock();
       if (Greenfoot.mousePressed(this) && !isGrabbed)
        {
          isGrabbed = true;
    
          World world = getWorld();
          MouseInfo mi = Greenfoot.getMouseInfo();
          world.removeObject(this);
          world.addObject(this, mi.getX(), mi.getY());
          return;
        } 
       if ((Greenfoot.mouseDragged(this)) && isGrabbed)
       {
         MouseInfo mi = Greenfoot.getMouseInfo();
         setLocation(mi.getX(), mi.getY());
         
         return;
       }
       if(Greenfoot.mouseDragEnded(this) && isGrabbed)
        {
         MouseInfo mi = Greenfoot.getMouseInfo();
         endX = mi.getX();
         endY = mi.getY();
         
         Validmoves();
         if(valid == true)
          {
            if(checkforpease1() == true)
           {
              Schlagen1();
              turnW();
              isGrabbed = false;
           }else
             {
               turnW();
               isGrabbed = false;
             }
         }
          else 
         {
           this.setLocation(oldX,oldY);
           isGrabbed = false;
          }
        }
       if(Greenfoot.mouseDragEnded(this) && checkforpease2() == true)
        {
           this.setLocation(oldX,oldY);
           isGrabbed = false;
           turn = 2;
        }
         }
      }
    public void Lock()
    {
        if(!isGrabbed)
        {
           oldX = getX();
           oldY = getY();
        }
    }
    public int KingPX()
    {
        return getX();
    }
    public int KingPY()
    {
        return getY();
    }
    public void Validmoves()
    {
        Lock();
        valid = false;
        
        newX1 = oldX + 1;
        newY1 = oldY + 1;
           
        newX2 = oldX - 1;
        newY2 = oldY - 1;
           
        newX3 = oldX + 1;
        newY3 = oldY - 1;
           
        newX4 = oldX - 1;
        newY4 = oldY + 1;
         
        if((newX1==endX && newY1==endY) || (newX2==endX && newY2==endY) || (newX3==endX && newY3==endY) || (newX4==endX && newY4==endY) || (newX1==endX && oldY==endY) || (newX2==endX && oldY==endY) || (oldX==endX && newY1==endY) || (oldX==endX && newY2==endY))
        {
            valid = true;
        }
      }
}
