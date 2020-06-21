//play hangman as well as possible
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
        int num = Integer.parseInt(myscanner.nextLine());
        String[] dictionary = new String[num];
        for(int i=0;i<num;i++){
            dictionary[i]=myscanner.nextLine();
        }
        String hash = dictionary[num-1]+(int)(Math.random()*100);
        int games = 100;
        int score = 0;
        for(int x=0;x<games;x++){

            Random r = new Random();
            String target = dictionary[r.nextInt(num)];

            String blackout="";
            for(int i=0;i<target.length();i++){
                blackout=blackout+"_";
            }

            Brain mybrain = new Brain(dictionary, blackout);
            int lives=8;

            boolean running = true;

            while(running){
                char guess = mybrain.guessLetter();
                String original = mybrain.hiddenWord;
                char[] arrayform = original.toCharArray();
                for(int i=0;i<target.length();i++){
                    if(target.charAt(i)==guess){
                        arrayform[i]=guess;
                    }
                }
                String newform = "";
                for(int i=0;i<target.length();i++){
                    newform=newform+arrayform[i];
                }
                mybrain.hiddenWord=newform;
                if(newform.equals(original)){
                    lives=lives-1;
                }
                if(lives==0){
                    running=false;
                }
                if(mybrain.hiddenWord.equals(target)){
                    running=false;
                    score=score+1;
                }
            }
        }
        System.out.println("You got "+score+" correct out of 100");
        try{
            System.out.println("Your Receipt: "+sha256(hash+score));
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

class Brain{
    
    public String[] dictionary;
    public String hiddenWord="_____";
    ArrayList<String> array = new ArrayList<String>();
    ArrayList<Character> guessed = new ArrayList<Character>();
    int turn =0;
    
    public Brain(String[] wordlist, String target){
        dictionary = wordlist;
        hiddenWord = target;
        
        for(int i =0; i<dictionary.length;i++)
        {
            if(dictionary[i].length()==hiddenWord.length())
            {
                array.add(dictionary[i]);
            }
        }
    }
      
    public char guessLetter(){
        
        //fill this in so as to guess the hiddenWord with the least number of guesses
        //keep track of your used letters so you're using a new letter
        //check the hiddenWord so you can see what letters are known and which ones are unknown 
        //unknown characters are marked with an underscore ("_")
        //this method should return a character that is a good guess
        turn++;
        
        
        ArrayList<String> array1 = new ArrayList<>(); //create temparary array list for reduced words
        for(int i =0; i<array.size();i++)
        {
            for(int j =0; j<array.get(i).length();j++)
            {
                if (hiddenWord.charAt(j) != '_') 
                {
                    if (array.get(i).charAt(j) != hiddenWord.charAt(j)) //if letters don't match
                    {
                        array.set(i, null);//goodbye word
                        break;
                    }
                    
                } 
   
            } 
            if(array.get(i)!=null)
            {
                array1.add(array.get(i));
            }   
        }
        array = array1;

        int arraycommon[] =new int[256];
        for(int i =0; i<array.size();i++)
        {
            String word = array.get(i);
            if(word!=null)
            {
                for(int j =0; j < word.length();j++)//getting frequency of letters
                {
                    char b = word.charAt(j);
                    int temp = (int)b;
                    arraycommon[temp]++;
                    if(guessed.contains(b))//if already used
                    {
                        arraycommon[temp]=0;//set frequency to 0
                    }
                }
            }
            
        }
        int current =0;
        int largest =0;
        int common=0;
        for(int i =0; i<arraycommon.length;i++) // find largest frequency
        {
            current = arraycommon[i];
            if(current>=largest)
            {
                largest=current;
                common=i;
            }
            else if(current == largest)//if same-random
            {
                Random rand = new Random();
                int r = rand.nextInt(2);
                if(r==1)
                {
                    largest=current;
                    common=i;
                }
            }
            
        }
        char a = (char)common;
        if(turn==1) // first letter to be guessed based on length of word
        {
            if(hiddenWord.length()<5)
            {
                a = 'a';
            }
            if(hiddenWord.length()==5)
            {
                a = 's';
            }
            if(hiddenWord.length()>5&&hiddenWord.length()<13)
            {
                a = 'e';
            }
            if(hiddenWord.length()>=13&&hiddenWord.length()<=20)
            {
                a= 'i';
            }
        }
        guessed.add(a); //add to used letter array list
        return a;
    }        
}

    You got 100 correct out of 100

    Your Receipt: 306c4cdf296b99ccf7dcba7fc55153bbe1c08674184680edaa14c74516988ba9
