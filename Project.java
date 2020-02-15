/* 
A program that simulates a statistics tool, by letting the user 
determine the minimum, the maximum, the range (maximum-minimum), the
mode, the mean (average), and the standard deviation of a set of
numbers. These numbers, that will be stored in an array, respresent
salaries in the $30K-$60K range are to be generated randomly
*/

import java.util.Scanner;
import java.util.Random;

public class Project{
    public static void main (String[]args){
        Scanner in = new Scanner (System.in);
        Random r = new Random();
        
        System.out.println("Enter a number: ");
        System.out.println("1)Populate Array \n2)Display Array \n3)Minimum \n4)Maximum \n5)Range \n6)Mode \n7)Mean \n8)Standard Deviation \n9)Exit");
        
        int choice = in.nextInt();
        while(choice != 9){
        if (choice == 1){
        do{         
          System.out.println("Enter array length: ");   
            int arrayLength = in.nextInt();
            int min = 60000;
            int max = 30000;
            double mean = 0;
            double standardDeviation = 0;
            double initialSum = 0;
            double range = 0;
            int[]sal = new int [arrayLength];

            for(int i=0; i<sal.length; i++){
                sal[i]= r.nextInt(30000)+30001;
                if(sal[i] < min){
                min = sal[i];    
                }
                if(sal[i] > max){
                max = sal[i];
                }
            }
                                            
            do{ 
                System.out.println("Make another choice: ");
                choice = in.nextInt();
                 switch(choice){
                    case 2: 
                     System.out.println("Array: ");
                     for(int i : sal){
                        System.out.println(i + " ");
                    }
                    break;
                    case 3:
                        System.out.println("Minimum = " + min);
                        break;
                    case 4:
                        System.out.println("Maximum = " + max);
                        break;
                    case 5:
                        range = max - min;
                        System.out.println("Range = " + range);
                        break;
                    case 6:
                        int number = 0, repeatNumbers = 0;
                        for ( int i = 0; i < sal.length; ++i){
                            int count = 0;
                        for (int j = 0; j < sal.length; ++j){
                            if (sal[j] == sal[i])
                            count++;
                        }
                        if (count > repeatNumbers){
                            repeatNumbers = count;
                            number = sal[i];
                        }
                        }
                        if(repeatNumbers > 1)
                        System.out.println("Mode: " + number);
                        else
                        System.out.println("No Mode."); 
                        break;
                    case 7:
                        for(double i : sal){
                            mean += i/arrayLength;
                        }
                        System.out.println("Mean = " + mean); 
                        break;
                    case 8:   
                        for(int i : sal){   
                        standardDeviation = Math.pow(i - mean, 2);  
                        initialSum += standardDeviation;
                        }
                        double totalSum = Math.sqrt(initialSum/(arrayLength - 1));
                        System.out.println("Standard Deviation = " + totalSum);
                        break; 
                    } 
                }
                while(choice != 1 && choice != 9);
            }
             while(choice != 9);
        }
        else{
            System.out.println("You must populate an array first. Enter another number: ");
            choice = in.nextInt();
        }
        }
         System.out.println("Exiting the program.");
    }
}
