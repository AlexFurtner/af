import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ROCK1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ROCK2 extends PEASES2
{
    int oldX;
    int oldY;
    int x1;
    int y1;
    int x2;
    int y2;
    
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
      Rockmove2();
    }
    public ROCK2()
    {
        GreenfootImage myImage = getImage();
        int myNewHight = (int)myImage.getHeight() / 6;
        int myNewWidth = (int)myImage.getWidth() / 6;
        myImage.scale(myNewWidth, myNewWidth);
    }
    public void Rockmove2()
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
    public void Validmoves()
    {
        Lock();
        valid = false;
        World world = getWorld();
        for(int i = 1;i<9; i = i + 1)
        {
           newX1 = oldX + i;
           newY1 = oldY + i;
           
           newX2 = oldX - i;
           newY2 = oldY - i;
           
           if(oldX == endX && oldY == endY)
               {
                   valid = false;
                   break;
               }
           if(newX1 == endX && oldY == endY)
           {
               valid = true;
               for(int j = 1;j<9;j++)
               {
                   x1 = newX1 - j;
                   if(x1 == oldX && oldY == endY)
                   {
                       break;
                   }
                   if(!world.getObjectsAt(x1, oldY, ACTIONS.class).isEmpty())
                   {
                       valid = false;
                   }
               }
               break;
           }
           if(newX2 == endX && oldY == endY)
           {
               valid = true;
               for(int z = 1;z<9;z++)
               {
                   x2 = newX2 + z;
                   if(x2 == oldX && oldY == endY)
                   {
                       break;
                   }
                   if(!world.getObjectsAt(x2, oldY, ACTIONS.class).isEmpty())
                   {
                       valid = false;
                   }
               }
               break;
           }
           if(oldX == endX && newY1 == endY)
           {
               valid = true;
               for(int p = 1;p<9;p++)
               {
                   y1 = newY1 - p;
                   if(y1 == oldY && oldX == endX)
                   {
                       break;
                   }
                   if(!world.getObjectsAt(oldX, y1, ACTIONS.class).isEmpty())
                   {
                       valid = false;
                   }
               }
               break;
           }
           if(oldX == endX && newY2 == endY)
           {
               valid = true;
               for(int t = 1;t<9;t++)
               {
                   y2 = newY2 + t;
                   if(y2 == oldY && oldX == endX)
                   {
                       break;
                   }
                   if(!world.getObjectsAt(oldX, y2, ACTIONS.class).isEmpty())
                   {
                       valid = false;
                   }
               }
               break;
           }
       }
   }
}
