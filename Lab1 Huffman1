import java.util.*;

public class Huffman {

  public static void main (String[] args) {
    int temp =0;
    int[]asciiArray=new int[256];
    Scanner scan = new Scanner(System.in);
    String line = scan.nextLine();
    String [] binArray = new String [line.length()];

    for(int i =0; i< line.length();i++){

      temp = (int)line.charAt(i);//given in lecture to convert to ASCII
      asciiArray[temp]++;//add one to array every time another occurrence of number
      String binNum=Integer.toBinaryString(temp);//convert to Binary
      for(int j=7; j>binNum.length(); j--) // adds leading zeros
			{
				binNum ="0"+binNum;
			}
      binArray[i]=binNum;
    }
    for(int i =0;i<binArray.length;i++)//print with space
    {
      System.out.print(binArray[i]+" ");

    }
    System.out.println();

    for(int i =0; i<asciiArray.length;i++)//print how many times - not 0 times
    {

      if(asciiArray[i]==1){
          System.out.println("'" + ((char)i) + "' " + "appeared 1 time.");
      }
      else if(asciiArray[i]>1){
          System.out.println("'" + ((char)i) + "' " + "appeared " + asciiArray[i] + " times.");
      }
    }
  }
}

