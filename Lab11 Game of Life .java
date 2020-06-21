//based on Conway's Game of Life
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int board[][]=new int[20][20];
        int counter=0;
        for(int i=0;i<20;i++)
        {
            String input = scan.nextLine();
            for(int j=0;j<20;j++)
            {
                board[i][j]=Integer.parseInt(input.substring(j,j+1)); 
            }
        }
        while(num>0)
        {
            int happy[][]=new int[20][20];
            for(int i=0;i<20;i++)
            {
                for(int j=0;j<20;j++)
                {
                    int count = count(board,i,j);
                    if(board[i][j]==1&&count<2)
                    {
                        happy[i][j]=0;
                    }
                    else if(board[i][j]==1&&count>3)
                    {
                        happy[i][j]=0;
                    }
                    else if(board[i][j]==0&&count==3)
                    {
                        happy[i][j]=1;
                    }
                    else{
                        happy[i][j]=board[i][j];
                    }
                }
                
            }
            board=happy;
            num--;
        }
        
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<20;j++)
            {
                if(board[i][j]==1)
                {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
    public static int count(int board[][],int i, int j)
    {
        int count=0;
        try{
            if(board[i][j-1]==1)
            {
                count++;
            }
        }catch(IndexOutOfBoundsException e){}
        try{
            if(board[i-1][j-1]==1)
            {
                count++;
            }
        }catch(IndexOutOfBoundsException e){}
        try{
            if(board[i-1][j]==1)
            {
                count++;
            }
        }catch(IndexOutOfBoundsException e){}
        try{
            if(board[i-1][j+1]==1)
            {
                count++;
            }
        }catch(IndexOutOfBoundsException e){}
        try{
            if(board[i][j+1]==1)
            {
                count++;
            }
        }catch(IndexOutOfBoundsException e){}
        try{
            if(board[i+1][j+1]==1)
            {
                count++;
            }
        }catch(IndexOutOfBoundsException e){}
        try{
            if(board[i+1][j]==1)
            {
                count++;
            }
        }catch(IndexOutOfBoundsException e){}
        try{
            if(board[i+1][j-1]==1)
            {
                count++;
            }
        }catch(IndexOutOfBoundsException e){}
        
        return count;
    }   
}
