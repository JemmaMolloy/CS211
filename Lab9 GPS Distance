import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        double M1 = scan.nextDouble();
        double M2 = scan.nextDouble();
        double W1 = scan.nextDouble();
        double W2 = scan.nextDouble();
        double radius = 6371;

        int distance = distance(M1,M2,W1,W2,radius);

        if(distance%100<=51)//round down
        {
            distance=(distance/100)*100;
        }
        else//round up
        {
            distance=((distance+99)/100)*100;
        }
        System.out.println(distance);
    }

    public static int distance(double M1, double M2, double W1, double W2, double radius)
    {
        if(M1==W1&&M2==W2)//if the same no distance
        {
            return 0;
        }
        //to radians
        double lat1 = M1/(180/3.141);
        double lat2 = W1/(180/3.141);
        double lon1 = M2/(180/3.141);
        double lon2 = W2/(180/3.141);

        //formula
        double num1= Math.sin(lat1)*Math.sin(lat2);
        double num2= Math.cos(lat1)*Math.cos(lat2);
        double distance=Math.acos(num1+num2*Math.cos(lon1-lon2))*radius;

        return (int)distance;
    }
}
