import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PAWN1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PAWN2 extends PEASES2
{
    int oldX;
    int oldY;
    
    private boolean valid = false;
    private boolean isGrabbed = false;
    private boolean move1 = true;
    
    public boolean PromoteMe = false;
    
    
    int newY1;
    int newY2;
    
    int newX1;
    int newX2;
    
    int endX;
    int endY;
    
    
    public void act()
    {
        Pawnmove2();
    }
    public PAWN2()
    {
        GreenfootImage myImage = getImage();
        int myNewHight = (int)myImage.getHeight() / 6;
        int myNewWidth = (int)myImage.getWidth() / 6;
        myImage.scale(myNewWidth, myNewWidth);
    }
    public void Pawnmove2()
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
               turnW();
               isGrabbed = false;
               move1 = false;
               
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
      for(int i = 0;i<7;i++)
      {
               if(Greenfoot.mouseDragEnded(this) && valid == true && endX == i && endY == 7)
               {
                   PromotionX2 = i;
                   
                   getWorld().addObject(new QUEEN2(), PromotionX2, 7);
                   getWorld().removeObject(this);
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
        
        newY1 = oldY + 1;
        newY2 = oldY + 2;
        
        if((oldX==endX && oldY==endY) )
        {
            valid = false;
        }
        if(oldX==endX && newY1==endY && checkforpease1() == false)
        {
          valid = true;
          
            }
        else if(oldX==endX && newY2==endY && move1 == true && checkforpease1() == false && getWorld().getObjectsAt(oldX, newY1, ACTIONS.class).isEmpty())
        {
            valid = true;
           
            }
        
        newX1 = oldX - 1;
        newX2 = oldX + 1;
        
        if((newX1==endX && newY1==endY) && checkforpease1() == true)
        {
            valid = true;
            Schlagen1();
            this.setLocation(newX1, newY1);
           
            }
        if((newX2==endX && newY1==endY) && checkforpease1() == true)
        {
            valid = true;
            Schlagen1();
            this.setLocation(newX2, newY1);
           
            }
        }
    
    }