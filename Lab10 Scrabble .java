//find largest possible word from given letters
import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner myscanner = new Scanner(System.in);
        String letters = myscanner.nextLine();
        String array[] = new String[216555];
        for(int i=0;i<216555;i++){
            array[i]=myscanner.nextLine();
        }
        System.out.println(findLength(letters,array));
    }
        

    public static int findLength(String letters, String[] array){
        
        
        ArrayList<String> candidates = new ArrayList<String>();//for all possible words
        for(int i =0;i<array.length;i++)
        {
            int count =0;
            ArrayList<Character> used = new ArrayList<Character>();//characters possible to use
            for(int j =0;j<letters.length();j++)
            {
                used.add(letters.charAt(j));
            }
            
            for(int j =0;j<array[i].length();j++)
            {
                
                char wordletter=array[i].charAt(j);
                if(used.contains(wordletter))//if find a matching character remove it from list
                {
                    int position = used.indexOf(wordletter);
                    used.remove(position);
                    count++;//add to count for finding a matching letter
                    
                }
            } 
            if(count==array[i].length())//if amount of matching letters found equals length of word
            {
                candidates.add(array[i]);
                
            }
        }
        int largest =0;
        for(int i =0; i<candidates.size();i++)//find word with largest length
        {
            
            if(candidates.get(i).length()>largest)
            {
                largest=candidates.get(i).length();
            }
        }
        return largest;
    }

