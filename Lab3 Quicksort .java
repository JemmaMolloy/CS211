import java.util.*;

public class Solution
{
    public static void main(String args [])
    {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int amount = Integer.parseInt(scan.nextLine());
        String [] myarray = new String[amount];
        
        for(int i =0; i<myarray.length;i++)
        {
            myarray[i]=scan.nextLine();
        }
        String [] array = new String[amount];
        for(int i =0; i<myarray.length;i++)//shuffle array
        {
            
            int randomPosition = rand.nextInt(amount);
            if(array[randomPosition]!=null)//if position already filled
            {
                i--;
            }
            else
            {
                array[randomPosition] = myarray[i];
            }
            
        }
        
        sort(array,0,amount-1);
        
        for(int i =0; i< array.length;i++)//print array
        {
            System.out.println(array[i]);
        }
    }
    
    public static void sort(String [] array, int first, int last)
    {
        
        int partition = partitionIt(array, first, last); //split at pivot
        
        if(partition-1>first)//to right of pivot
        {
            sort(array, first, partition-1);
        }
        if(partition+1<last)//to left of pivot
        {
            sort(array, partition+1, last);
        }
    }
    
    public static int partitionIt(String [] array, int first, int last)
    {
        String pivot = array[last];//pivot is last element
        
        for(int i =first; i<last;i++)
        {
            //if pivot is bigger swap current with first
            if(compare(array[i],pivot))
            {
                String temp = array[first];
                array[first] = array[i];
                array[i] =temp;
                first++;
            }
        }
        // swap first with pivot
        String temp = array[first];
        array[first] = pivot;
        array[last] = temp;
        
        return first; // new pivot
    }
    
    public static boolean compare(String value,String pivot)
    {
        int valargest1=0;
        int pivlargest2 =0;
        
        //getting ascii sum current word
        for(int i =0; i<value.length();i++)
        {
           valargest1 = (int)value.charAt(i) + valargest1;
        }
        //getting ascii sum pivot
        for(int i =0; i<pivot.length();i++)
        {
                pivlargest2 = (int)pivot.charAt(i) + pivlargest2;
        }
        //puts largest ascii sum last
        if(valargest1< pivlargest2)
        {
            return true;
        }
        //if same check alphabetical
        else if(valargest1==pivlargest2)
        {
            if(value.compareTo(pivot)<0)
            {
                return true;
            }
        }
        return false;
    }
}
