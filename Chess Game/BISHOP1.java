import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class BISHOP2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BISHOP1 extends PEASES1
{
    int oldX;
    int oldY;
    int x1;
    int y1;
    int x2;
    int y2;
    int x3;
    int y3;
    int x4;
    int y4;
    
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
        Bishopmove1();
    }
    public BISHOP1()
    {
        GreenfootImage myImage = getImage();
        int myNewHight = (int)myImage.getHeight() / 6;
        int myNewWidth = (int)myImage.getWidth() / 6;
        myImage.scale(myNewWidth, myNewWidth);
    }
    public void Bishopmove1()
    {
       if(turn ==1)
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
            if(checkforpease2() == true)
           {
              Schlagen2();
              turnB();
              isGrabbed = false;
           }else
             {
               turnB();
               isGrabbed = false;
             }
         }
          else 
         {
           this.setLocation(oldX,oldY);
           isGrabbed = false;
          }
        }
       if(Greenfoot.mouseDragEnded(this) && checkforpease1() == true)
        {
           this.setLocation(oldX,oldY);
           isGrabbed = false;
           turn = 1;
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
           
           newX3 = oldX + i;
           newY3 = oldY - i;
           
           newX4 = oldX - i;
           newY4 = oldY + i;
           
           if(newX1 == endX && newY1 == endY)
           {
               valid = true;
               for(int j = 1;j<9;j++)
               {
                   x1 = newX1 - j;
                   y1 = newY1 - j;
                   if(x1 == oldX && y1 == oldY)
                   {
                       break;
                   }
                   if(!world.getObjectsAt(x1, y1, ACTIONS.class).isEmpty())
                   {
                       valid = false;
                   }
               }
               if(oldX == endX && oldY == endY)
               {
                   valid = false;
               }
               break;
           }
           if(newX2 == endX && newY2 == endY)
           {
               valid = true;
               for(int z = 1;z<9;z++)
               {
                   x2 = newX2 + z;
                   y2= newY2 + z;
                   if(x2 == oldX && y2 == oldY)
                   {
                       break;
                   }
                   if(!world.getObjectsAt(x2, y2, ACTIONS.class).isEmpty())
                   {
                       valid = false;
                   }
               }
               if(oldX == endX && oldY == endY)
               {
                   valid = false;
               }
               break;
           }
           if(newX3 == endX && newY3 == endY)
           {
               valid = true;
               for(int p = 1;p<9;p++)
               {
                   x3 = newX3 - p;
                   y3 = newY3 + p;
                   if(x3 == oldX && y3 == oldY)
                   {
                       break;
                   }
                   if(!world.getObjectsAt(x3, y3, ACTIONS.class).isEmpty())
                   {
                       valid = false;
                   }
               }
               if(oldX == endX && oldY == endY)
               {
                   valid = false;
               }
               break;
           }
           if(newX4 == endX && newY4 == endY)
           {
               valid = true;
               for(int t = 1;t<9;t++)
               {
                   x4 = newX4 + t;
                   y4 = newY4 - t;
                   if(x4 == oldX && y4 == oldY)
                   {
                       break;
                   }
                   if(!world.getObjectsAt(x4, y4, ACTIONS.class).isEmpty())
                   {
                       valid = false;
                   }
               }
               if(oldX == endX && oldY == endY)
               {
                   valid = false;
               }
               break;
           }
           /*
            * //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            * Vorherige Versuche: Figur kann nicht über eine andere Figur spriengen.
            * //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           if(newX1 == endX && newY1 == endY)
            {
              valid = true;
                for(int o = 1; o<Math.abs(endX-oldX) ;o++)
              {
                if(!world.getObjectsAt(endX - o, endY - o, ACTIONS.class).isEmpty())                   
                {
                       valid = false;
                }
                else
                   {
                       valid = true;
                   }
                }
              if(oldX == endX && oldY == endY)
               {
                   valid = false;
               }
              break;
            }
           else if(newX2 == endX && newY2 == endY)
            {
              valid = true;
                for(int j = 1; j<Math.abs(oldX-endX) ;j++)
              {
                if(!world.getObjectsAt(endX + j, endY + j, ACTIONS.class).isEmpty())
                {
                       valid = false;
                }
                else
                   {
                       valid = true;
                   }
                }
              if(oldX == endX && oldY == endY)
               {
                   valid = false;
               }
              break;
            }
           else if(newX3 == endX && newY3 == endY)
            {
              valid = true;
                for(int t = 1;t<Math.abs(endX-oldX);t++)
              {
                  for(int u = 1;u<Math.abs(oldY-endY);u++)
                  {
                     if(!world.getObjectsAt(endX - t, endY + u, ACTIONS.class).isEmpty())
                   {
                      valid = false; 
                   }
                   else
                   {
                       valid = true;
                   }
                }
              }
              if(oldX == endX && oldY == endY)
               {
                   valid = false;
               }
              break;
            }
           else if(newX4 == endX && newY4 == endY)
            {
              valid = true;
                for(int r = 1;r<Math.abs(oldX-endX);r++)
              {
                  for(int s = 1;s<Math.abs(endY-oldY) ;s++)
                  {
                     if(!world.getObjectsAt(endX + r, endY - s, ACTIONS.class).isEmpty())
                   {
                       valid = false;
                   }
                   else
                   {
                       valid = true;
                   }
                }
              }
              if(oldX == endX && oldY == endY)
               {
                   valid = false;
               }
              break;
            }
            
           /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           
             if(newX1 == endX && newY1 == endY)
           {
               valid = true;
               while(newX1 != oldX && newY1 != oldY)
               {
                   newX1 = newX1 - i;
                   newY1 = newY1 - i;
                   if(!world.getObjectsAt(newX1, newY1, PEASES1.class).isEmpty())
                   {
                       valid = false;
                   }
                   else
                   {
                       valid = true;
                   }
               }
           }
           if(newX2 == endX && newY2 == endY)
           {
               valid = true;
               while(newX2 != oldX && newY2 != oldY)
               {
                   newX2 = newX2 + i;
                   newY2 = newY2 + i;
                   if(!world.getObjectsAt(newX2, newY2, PEASES1.class).isEmpty())
                   {
                       valid = false;
                   }
                   else
                   {
                       valid = true;
                   }
               }
           }
           if(newX3 == endX && newY3 == endY)
           {
               valid = true;
               while(newX3 != oldX && newY3 != oldY)
               {
                   newX3 = newX3 - i;
                   newY3 = newY3 + i;
                   if(!world.getObjectsAt(newX3, newY3, PEASES1.class).isEmpty())
                   {
                       valid = false;
                   }
                   else
                   {
                       valid = true;
                   }
               }
           }
           if(newX4 == endX && newY4 == endY)
           {
               valid = true;
               while(newX4 != oldX && newY4 != oldY)
               {
                   newX4 = newX4 + i;
                   newY4 = newY4 - i;
                   if(!world.getObjectsAt(newX4, newY4, PEASES1.class).isEmpty())
                   {
                       valid = false;
                   }
                   else
                   {
                       valid = true;
                   }
               }
            }
            */
            }
        }
}