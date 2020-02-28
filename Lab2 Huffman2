import java.util.*;

public class HuffmanEncoding {
	public static void main(String args []) throws Exception{
		int temp =0;
		int [] asciiArray = new int [256];
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String [] binArray = new String [line.length()];
		String binNum ="";
		
		PriorityQueue < Tree > PQ =new PriorityQueue < Tree > ();//make a priority queue to hold the forest of trees
		
		for(int i=0; i<line.length(); i++)
		{
			temp = (int)line.charAt(i);//convert to ASCII
			asciiArray[temp]++;//add on to array every time another occurance of number
			
			for(int j=7; j>binNum.length(); j--) // adds leading zeros
			{
				binNum ="0"+binNum;
			}
			binArray[i]=binNum;
		}
		
		for(int i=0; i<asciiArray.length; i++)
		{
			if(asciiArray[i]>0)
			{
				//FILL THIS IN:

                //MAKE THE FOREST OF TREES AND ADD THEM TO THE PQ

                //create a new Tree 
				Tree apple = new Tree();
				apple.root = new Node();
                //set the cumulative frequency of that Tree
                apple.frequency =asciiArray[i];
				//insert the letter as the root node 
                apple.root.letter =(char)i;
                apple.root.smallestLetter =(char)i;
				//add the Tree into the PQ
				PQ.add(apple);
			}
		}
		
		while(PQ.size()>1) //while there are two or more trees left in the forest
		{
			//FILL THIS IN:

            //IMPLEMENT THE HUFFMAN ALGORITHM
			Tree orange = PQ.poll();
			Tree pear = PQ.poll();
			//Node noodle = new Node();
            //when you're making the new combined tree, don't forget to assign a default root node (or else you'll get a null pointer exception)
			Tree apple = new Tree();
			apple.root = new Node();
			
			apple.frequency = orange.frequency + pear.frequency;
            //if you like, to check if everything is working so far, try printing out the letter of the roots of the two trees you're combining
			//remember to check the smallest letter to decide which branch to put on the left, and which on the right
			apple.root.leftChild = orange.root;
			apple.root.rightChild = pear.root;
			
			apple.root.smallestLetter =(char)Math.min(orange.root.smallestLetter, pear.root.smallestLetter);
	
			PQ.add(apple);
		}
		
		//get the codes from the tree(only one left)
		Tree HuffmanTree = PQ.poll(); 
		
		//FILL THIS IN:

        //get all the codes for the letters and print them out
        //call the getCode() method on the HuffmanTree Tree object for each letter in the sentence
		for(int i=0; i<line.length(); i++)
		{
				System.out.print(HuffmanTree.getCode(line.charAt(i)));
		}
	}

}

class Node {


	    public char letter = '@'; //stores letter
	    public char smallestLetter = '@';  //a nice idea is to track the smallest letter in the tree in a special variable like this
					
	    public Node leftChild; // this node's left child
	    public Node rightChild; // this node's right child


	} // end class Node





	class Tree implements Comparable < Tree > {
	    public Node root; // first node of tree
	    public int frequency = 0;

	    public Tree() // constructor
	    {
	        root = null;
	    } // no nodes in tree yet

	    //the PriorityQueue needs to be able to somehow rank the objects in it
	    //thus, the objects in the PriorityQueue must implement an interface called Comparable
	    //the interface requires you to write a compareTo() method so here it is:

	    public int compareTo(Tree object) {
	        if (frequency - object.frequency > 0) { //compare the cumulative frequencies of the tree
	            return 1;
	        } else if (frequency - object.frequency < 0) {
	            return -1; //return 1 or -1 depending on whether these frequencies are bigger or smaller
	        } else {
	            // Sort based on letters
	            char a = this.root.smallestLetter;
	            char b = object.root.smallestLetter;

	            if (a > b) {
	                return 1;
	            } else if (a < b) {
	                return -1;
	            }
	            return 0;
	        }
	    }

	    String path = "error"; //this variable will track the path to the letter we're looking for 

	    public String getCode(char letter) { //we want the code for this letter

	        return this._getCode(letter, this.root, ""); //return the path that results
	    }

	    private String _getCode(char letter, Node current, String path) {
	        if (current == null) {
	            return null;
	        }
	        if (current.letter == letter) {
	            return path;
	        }

	        String leftPath = this._getCode(letter, current.leftChild, path + "0");
	        if (leftPath != null) {
	            return leftPath;
	        }

	        String rightPath = this._getCode(letter, current.rightChild, path + "1");
	        return rightPath;
	    }

	} // end class Tree
