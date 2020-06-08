/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guess;
import java.util.ArrayList;
import java.util.Scanner;
public class Guess {
    public int num1;
    public int num2;
    public int num3;
    public String result;
    public void tostring(){
        System.out.println(num1 + " " + num2+" "+num3+" "+result);        
    }
    public void setResult(String a){
        result =a;
    }
    public boolean test(){
        if (num1+num2==num3){
            return true;
        }
        else {
            return false;
        }
    }
    public Guess(int a,int b,int c){
        num1=a;num2=b;num3=c;
    }

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Guess> list = new ArrayList<>();
        int[] intList = new int[3];
        
        System.out.println("Guess 3 numbers, separated by space: ");
        String input = scan.nextLine();
        
        
        while (!"answer".equals(input) & !"previous".equals(input)){
        String[] inputArray =input.split(" ");
        
        if (inputArray.length!=3){
            System.out.println("Your input was not suitable\nGuess 3 numbers, separated by space: ");
            input = scan.nextLine();
        }
        
        else if (inputArray.length == 3){                                
            
            try{intList[0]=Integer.parseInt(inputArray[0]);
                intList[1]=Integer.parseInt(inputArray[1]);
                intList[2]=Integer.parseInt(inputArray[2]);

            } catch (NumberFormatException e) {
               System.out.println("Your input was not suitable\nGuess 3 numbers, separated by space: ");
               input = scan.nextLine();
            }
            Guess guess = new Guess(intList[0],intList[1],intList[2]);
            list.add(guess);
            if (guess.test()==true){
                System.out.println("Yes");
                guess.setResult("Yes");
            }
            else if(guess.test()==false){ 
                System.out.println("No");
                guess.setResult("No");
            }
            System.out.println("Guess 3 numbers, separated by space: ");
            input = scan.nextLine();
            } 
        }
    
    if ("previous".equals(input)){
        for(int i=0;i<list.size();i++){
            (list.get(i)).tostring();
        }
        System.out.println("Guess 3 numbers, separated by space: ");
        input = scan.nextLine();
    }
    if ("answer".equals(input)){
            System.out.println("Guess the 3 numbers that you think will follow the rule: ");
            input = scan.nextLine();
            String[] resultArray =input.split(" ");
            intList[0]=Integer.parseInt(resultArray[0]);
            intList[1]=Integer.parseInt(resultArray[1]);
            intList[2]=Integer.parseInt(resultArray[2]);
            if(intList[0]+intList[1]==intList[2]){
                System.out.println("You guessed correctly.");
            }
            else{
                System.out.println("You guessed wrong.");
            }
            System.exit(0);
        }        
    }
}

