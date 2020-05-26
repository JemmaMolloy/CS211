//aim to try and get collisions as low as possible (under 1 million decent)
//stub class given
import java.util.*;
import java.math.*;
import java.math.BigInteger;
import java.lang.Object.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Stub{    
    
    public static void main (String[] args){
        Scanner myscanner = new Scanner(System.in);
        int items = myscanner.nextInt()-1;
        myscanner.nextLine();
        String[] contents = new String[items];
        for(int i=0;i<items;i++){
            contents[i]=myscanner.nextLine();
        }
        String hash = myscanner.nextLine();
        int size=99991;
        Solution mysolution = new Solution();
        String[] hashtable=mysolution.fill(size, contents);
        HashTable mytable = new HashTable(hashtable);

        Solution mysolution2 = new Solution(); //prevents cheating by using memory
        for(int i=0;i<items;i++){
            int rand = (int)(Math.random()*items);
            String temp = contents[i];
            contents[i]=contents[rand];
            contents[rand]=temp;
        }
        int total=0;
        for(int i=0;i<items;i++){
            int slot = mysolution2.find(size, mytable, contents[i]);
            if(!hashtable[slot].equals(contents[i])){
                System.out.println("error!");
            }
        }      
        System.out.println("Collisions: " + mytable.gettotal());
        try{
            System.out.println("Your Receipt: "+sha256(hash+mytable.gettotal()));
        }catch(NoSuchAlgorithmException e){};
    }
    
    public static String sha256(String input) throws NoSuchAlgorithmException {
        byte[] in = hexStringToByteArray(input);
        MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
        byte[] result = mDigest.digest(in);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        if(len%2==1){
            s=s+"@";
            len++;
        }
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
    
    
class HashTable{
    
    private String[] hashTable;
    private int total=0;

    public HashTable(String[] input){
        hashTable = input;
    }

    public boolean check(int slot, String check){
        if(hashTable[slot].equals(check)){
            return true;
        }else{
            total++;
            return false;
        }
    }
    
    public int gettotal(){
        return total;
    }
} 


      
class Solution{
      
    public int find(int size, HashTable mytable, String word){
        
        //fill this in so as to minimize collisions
        //takes in the HashTable object and the word to be found
        //the only thing you can do with the HashTable object is call "check"
        //this method should return the slot in the hashtable where the word is 

        int hashVal=1;
        for(int i=0; i<word.length();i++)
        {
            hashVal = hashVal+1+word.charAt(i);
            hashVal=((1319)*hashVal)%size;
        }
        hashVal = (hashVal*1449)%size;
        while(true)
        {
            if(mytable.check(hashVal, word))
            {
                break;
            } 
            for(int i=0; i<word.length();i++)
            {
                hashVal = hashVal+1+word.charAt(i);
                hashVal=((1797)*hashVal)%size;
            }
        }
        return hashVal;
    }
    
    public String[] fill(int size, String[] array){
        
        //takes in the size of the hashtable, and the array of Strings to be placed in the hashtable
        //this should add all the words into the hashtable using some system
        //then it should return the hashtable array
        String[] hashtable = new String[size];
        for(int i=0;i<size;i++)
        {
            hashtable[i]="";
        }
        for(int i=0;i<array.length;i++)
        {
            String item = array[i];
            int hashVal=1;
            for(int j =0; j<item.length();j++)
            {
                hashVal = hashVal+1+item.charAt(j);
                hashVal=((1319)*hashVal)%size;
            }
            hashVal = (hashVal*1449)%size;
            while(true)
            {
                if(hashtable[hashVal]=="")
                {
                    break;
                } 
                for(int j =0; j<item.length();j++)
                {
                    hashVal = hashVal+1+item.charAt(j);
                    hashVal=((1797)*hashVal)%size;
                }
            }
            hashtable[hashVal]= item;
        }
        return hashtable; 
    }  
}

Test Case 0:

    Collisions: 0

    Your Receipt: c19a797fa1fd590cd2e5b42d1cf5f246e29b91684e2f87404b81dc345c7a56a0


Test Case 1:

    Collisions: 138469

    Your Receipt: 380d9b27ac1ea88f7474ba2b9d2592a02990d6d93e8883f4f6ba0a14e7be4627
