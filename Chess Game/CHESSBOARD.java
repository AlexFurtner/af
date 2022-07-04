
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CHESSBOARD extends World
{
    BISHOP1 bishop1n1;
    BISHOP1 bishop1n2;
    BISHOP2 bishop2n1;
    BISHOP2 bishop2n2;
    //--------------------------------------------------------------------------------------
    KING1 king1n1;
    KING2 king2n1;
    //--------------------------------------------------------------------------------------
    KNIGHT1 knight1n1;
    KNIGHT1 knight1n2;
    KNIGHT2 knight2n1;
    KNIGHT2 knight2n2;
    //--------------------------------------------------------------------------------------
    PAWN1 pawn1n1;
    PAWN1 pawn1n2;
    PAWN1 pawn1n3;
    PAWN1 pawn1n4;
    PAWN1 pawn1n5;
    PAWN1 pawn1n6;
    PAWN1 pawn1n7;
    PAWN1 pawn1n8;
    PAWN2 pawn2n1;
    PAWN2 pawn2n2;
    PAWN2 pawn2n3;
    PAWN2 pawn2n4;
    PAWN2 pawn2n5;
    PAWN2 pawn2n6;
    PAWN2 pawn2n7;
    PAWN2 pawn2n8;
    //----------------------------------------------------------------------------------------
    QUEEN1 queen1n1;
    QUEEN2 queen2n1;
    //---------------------------------------------------------------------------------------
    ROCK1 rock1n1;
    ROCK1 rock1n2;
    ROCK2 rock2n1;
    ROCK2 rock2n2;
    //----------------------------------------------------------------------------------------
    int boardX [] [] = new int [9] [9]; 
    int boardY [] [] = new int [9] [9]; 
    public int WhoWon = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public CHESSBOARD()
    {    
        super(8, 8, 50);
        ACTIONS actor = new ACTIONS();
        actor.turn = 1;
        
        boardX [1] [1] = 0;
        boardX [1] [2] = 1; 
        boardX [1] [3] = 2;
        boardX [1] [4] = 3;
        boardX [1] [5] = 4;
        boardX [1] [6] = 5;
        boardX [1] [7] = 6;
        boardX [1] [8] = 7;
        
        for(int i = 1; i<9 ;i=i+1)
        {
           boardY [1] [i] = 0; 
        }
        
        boardX [2] [1] = 0;
        boardX [2] [2] = 1;
        boardX [2] [3] = 2;
        boardX [2] [4] = 3;
        boardX [2] [5] = 4;
        boardX [2] [6] = 5;
        boardX [2] [7] = 6;
        boardX [2] [8] = 7;
        
         for(int i = 1; i<9 ;i=i+1)
        {
           boardY [2] [i] = 1; 
        }
        
        boardX [3] [1] = 0;
        boardX [3] [2] = 1;
        boardX [3] [3] = 2;
        boardX [3] [4] = 3;
        boardX [3] [5] = 4;
        boardX [3] [6] = 5;
        boardX [3] [7] = 6;
        boardX [3] [8] = 7;
        
         for(int i = 1; i<9 ;i=i+1)
        {
           boardY [3] [i] = 2; 
        }
        
        boardX [4] [1] = 0;
        boardX [4] [2] = 1;
        boardX [4] [3] = 2;
        boardX [4] [4] = 3;
        boardX [4] [5] = 4;
        boardX [4] [6] = 5;
        boardX [4] [7] = 6;
        boardX [4] [8] = 7;
        
         for(int i = 1; i<9 ;i=i+1)
        {
           boardY [4] [i] = 3; 
        }
        
        boardX [5] [1] = 0;
        boardX [5] [2] = 1;
        boardX [5] [3] = 2;
        boardX [5] [4] = 3;
        boardX [5] [5] = 4;
        boardX [5] [6] = 5;
        boardX [5] [7] = 6;
        boardX [5] [8] = 7;
        
         for(int i = 1; i<9 ;i=i+1)
        {
           boardY [5] [i] = 4; 
        }
        
        boardX [6] [1] = 0;
        boardX [6] [2] = 1;
        boardX [6] [3] = 2;
        boardX [6] [4] = 3;
        boardX [6] [5] = 4;
        boardX [6] [6] = 5;
        boardX [6] [7] = 6;
        boardX [6] [8] = 7;
        
         for(int i = 1; i<9 ;i=i+1)
        {
           boardY [6] [i] = 5; 
        }
        
        boardX [7] [1] = 0;
        boardX [7] [2] = 1;
        boardX [7] [3] = 2;
        boardX [7] [4] = 3;
        boardX [7] [5] = 4;
        boardX [7] [6] = 5;
        boardX [7] [7] = 6;
        boardX [7] [8] = 7;
        
         for(int i = 1; i<9 ;i=i+1)
        {
           boardY [7] [i] = 6; 
        }
        
        boardX [8] [1] = 0;
        boardX [8] [2] = 1;
        boardX [8] [3] = 2;
        boardX [8] [4] = 3;
        boardX [8] [5] = 4;
        boardX [8] [6] = 5;
        boardX [8] [7] = 6;
        boardX [8] [8] = 7;
        
         for(int i = 1; i<9 ;i=i+1)
        {
           boardY [8] [i] = 7; 
        }
        
        this.FillWorld();
        
        
        
        }
        
    public void FillWorld()
    {
        bishop2n1 = new BISHOP2();
        this.addObject(bishop2n1, boardX [1] [3] ,boardY [1] [3] );
              
        bishop2n2 = new BISHOP2();
        this.addObject(bishop2n2, boardX [1] [6] ,boardY [1] [6]);
        
        bishop1n1 = new BISHOP1();
        this.addObject(bishop1n1, boardX [8] [3] ,boardY [8] [3]);
        
        bishop1n2 = new BISHOP1();
        this.addObject(bishop1n2, boardX [8] [6] ,boardY [8] [6]);
        //-----------------------------------------------------------------------------------
        king2n1 = new KING2();
        this.addObject(king2n1, boardX [1] [5] ,boardY [1] [5]);
        king1n1 = new KING1();
        this.addObject(king1n1, boardX [8] [5] ,boardY [8] [5]);
        //-----------------------------------------------------------------------------------
        knight2n1 = new KNIGHT2();
        this.addObject(knight2n1, boardX [1] [2] ,boardY [1] [2]);
        
        knight2n2 = new KNIGHT2();
        this.addObject(knight2n2, boardX [1] [7] ,boardY [1] [7]);
        
        knight1n1 = new KNIGHT1();
        this.addObject(knight1n1, boardX [8] [2] ,boardY [8] [2]);
        
        knight1n2 = new KNIGHT1();
        this.addObject(knight1n2, boardX [8] [7] ,boardY [8] [7]);
        //-----------------------------------------------------------------------------------
        queen2n1 = new QUEEN2();
        this.addObject(queen2n1, boardX [1] [4],boardY [1] [4]);
        queen1n1 = new QUEEN1();
        this.addObject(queen1n1, boardX [8] [4] ,boardY [8] [4]);
        //-----------------------------------------------------------------------------------
        rock2n1 = new ROCK2();
        this.addObject(rock2n1, boardX [1] [1] ,boardY [1] [1]);
        
        rock2n2 = new ROCK2();
        this.addObject(rock2n2, boardX [1] [8] ,boardY [1] [8]);
        
        rock1n1 = new ROCK1();
        this.addObject(rock1n1, boardX [8] [1] ,boardY [8] [1]);
        
        rock1n2 = new ROCK1();
        this.addObject(rock1n2, boardX [8] [8] ,boardY [8] [8]);
        //-----------------------------------------------------------------------------------
        pawn2n1 = new PAWN2();
        this.addObject(pawn2n1, boardX [2] [1] ,boardY [2] [1]);
        
        pawn2n2 = new PAWN2();
        this.addObject(pawn2n2, boardX [2] [2] ,boardY [2] [2]);
        
        pawn2n3 = new PAWN2();
        this.addObject(pawn2n3, boardX [2] [3] ,boardY [2] [3]);
        
        pawn2n4 = new PAWN2();
        this.addObject(pawn2n4, boardX [2] [4] ,boardY [2] [4]);
        
        pawn2n5 = new PAWN2();
        this.addObject(pawn2n5, boardX [2] [5] ,boardY [2] [5]);
        
        pawn2n6 = new PAWN2();
        this.addObject(pawn2n6, boardX [2] [6] ,boardY [2] [6]);
        
        pawn2n7 = new PAWN2();
        this.addObject(pawn2n7, boardX [2] [7] ,boardY [2] [7]);
        
        pawn2n8 = new PAWN2();
        this.addObject(pawn2n8, boardX [2] [8] ,boardY [2] [8]);
        //-----------------------------------------------------------------------------------
        pawn1n1 = new PAWN1();
        this.addObject(pawn1n1, boardX [7] [1] ,boardY [7] [1]);
        
        pawn1n2 = new PAWN1();
        this.addObject(pawn1n2, boardX [7] [2] ,boardY [7] [2]);
        
        pawn1n3 = new PAWN1();
        this.addObject(pawn1n3, boardX [7] [3] ,boardY [7] [3]);
        
        pawn1n4 = new PAWN1();
        this.addObject(pawn1n4, boardX [7] [4] ,boardY [7] [4]);
        
        pawn1n5 = new PAWN1();
        this.addObject(pawn1n5, boardX [7] [5] ,boardY [7] [5]);
        
        pawn1n6 = new PAWN1();
        this.addObject(pawn1n6, boardX [7] [6] ,boardY [7] [6]);
        
        pawn1n7 = new PAWN1();
        this.addObject(pawn1n7, boardX [7] [7] ,boardY [7] [7]);
        
        pawn1n8 = new PAWN1();
        this.addObject(pawn1n8, boardX [7] [8], boardY [7] [8]);
        //-----------------------------------------------------------------------------------
        
    }
    }
