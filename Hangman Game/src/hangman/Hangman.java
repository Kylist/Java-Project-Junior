package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hangman {
    
    String guesses;
    int length;
    int maxGuesses;
    char [] print;
    Set<String> list;
    
        public Hangman(int length, int maxGuesses, Set<String> list){
            this.list = list;
            this.guesses = "";
            this.length = length;
            this.maxGuesses = maxGuesses;
            this.print = new char [length];
            for (int a = 0; a < length; a++){
                this.print[a] = '_';
            }
        }
        public void playGame(){
            Scanner in = new Scanner(System.in);
            char input;
            //System.out.println("Starting list size is: " + list.size()); //debug code
            removeNotLength(list, length); //remove any words from the list that aren't of the length specified by the user
            //System.out.println("The size of the list with only words of length " + length + " is: " + list.size()); //debug code
            
            while (list.size() > 1 && maxGuesses > 0){ //cheat as long as there is more than 1 word in the list
                //System.out.println("List size is: " + list.size()); //debug code

                do {
                    System.out.println(currentWord());
                    System.out.println(toString());
                    System.out.println("Please enter your next guess.");
                    input = in.next().charAt(0);
                } while (guesses.indexOf(input) != -1);  //make sure they enter a char they haven't used
                if (canRemoveChar(list, input)){ //if you can remove all words with guessed char then remove them and deduct from maxGuesses
                    System.out.println("Sorry, the word does not contain " + input);
                    removeChar(list, input);
                    guesses += input + " ";
                    maxGuesses--;
                } else { //If only words with guessed char remain in the list
                    System.out.println("The word contains a " + input);
                    removeMoreThanChar(list, input, 1); //remove any words with more than 1 instance of the char
                    int indexOfMost = positionWithMostChar(list, input); //find the index where that char occurs the most in the given list
                    removeExceptPosition(list, input, indexOfMost); //remove any words that do not have that char at that index
                    guesses += input + " ";
                    if(list.size() == 1){ //make sure it's not the last word because there may be duplicates of the given char
                        String wordToGuess = list.iterator().next();
                        updatePrint(wordToGuess, input);
                    } else{
                        print[indexOfMost] = input;
                    }
                }
            }
            
            String wordToGuess = list.iterator().next();
            
            while (checkWord() && maxGuesses > 0){ //just play hangman without cheating
                do {
                    System.out.println(toString());
                    System.out.println("The current word is: " + currentWord());
                    System.out.println("Please enter your next guess.");
                    input = in.next().charAt(0);
                } while (guesses.indexOf(input) != -1);  //make sure they enter a char they haven't used
                if (wordToGuess.indexOf(input) == -1){
                    System.out.println("Sorry, the word does not contain " + input);
                    guesses += input + " ";
                    maxGuesses--;
                } else {
                    System.out.println("The word contains a " + input);
                    updatePrint(wordToGuess, input);
                }
                
            }
           System.out.println(toString());
           System.out.println("The word was: " + wordToGuess);
           if (!checkWord()){
               System.out.println("You win!");
           } else {
               System.out.println("You lose.");
           }
            
            
        }
        @Override
        public String toString(){ //gives the remaining guesses and what letters have already been guessed
            
            return "You have " + this.maxGuesses + " guesses remaining.\n" + "You have guessed: " + this.guesses;
        }
        
        public String currentWord(){ //just prints the print[] array in a nicer way
            String toReturn = "";
            for (int a = 0; a<length; a++){
                toReturn += print[a] + " ";
            }
            return toReturn;
        }
        public void updatePrint(String word, char c){ //used for when there is only one word left. Adds any instances of a given char to print[] based off of the remaining word.
            char [] temp = word.toCharArray();
            for(int a = 0; a < temp.length; a++){
                if (temp[a] == c){
                    print[a] = c;
                }
            }
            
        }
        
        public boolean checkWord(){ //returns true if the full word hasn't been guessed yet
            for (int a = 0; a < length; a++){
                if (print[a] == '_'){
                   return true; 
                }
            }
            return false;
        }
    
        public void removeExceptPosition(Set<String> list, char c, int index){ //removes any words from the set that don't have the given char at the given index
            for (Iterator<String> iterator = list.iterator(); iterator.hasNext();){
                if (list.size() == 1){ //break out of loop if there is only 1 word left
                    return;
                }
                char s [] = iterator.next().toCharArray();
                if (s[index] != c){
                    iterator.remove();
                }
            }
            
        }
    
        public int positionWithMostChar(Set<String> list, char c){ //return the index of where a given char shows up the most in a list of words
            int index = 0;
            int [] a = new int[length];
            for (int k = 0; k < a.length; k++){
                a[k] = 0;
            }
            
            for (Iterator<String> iterator = list.iterator(); iterator.hasNext();){
                char s [] = iterator.next().toCharArray();
                for (int l = 0; l < s.length; l++){
                    if (s[l] == c){
                        a[l]++;
                    }
                }
            }
            
            for (int k = 0; k < a.length; k++){
                if (a[k] > a[index]){
                    index = k;
                }
            }
            
            return index;
        }
    
        public void removeMoreThanChar(Set<String> list, char c, int a){ //remove every word that has more than given integer of a char. Ex. if c = 'a' and a = 1, it would remove "aardvark" but not "apple"
            for (Iterator<String> iterator = list.iterator(); iterator.hasNext();){
                if (list.size() == 1){ //break out of loop if there is only 1 word left
                    return;
                }
                int count = 0;
                char s [] = iterator.next().toCharArray();
                for (char b : s){
                    if (b == c){
                        count++;
                    }
                    if (count > a){
                        iterator.remove();
                        break;
                    }
                }
            }
        }
        public void removeChar(Set<String> list, char c){ //remove every word from the list that contains the given char
            for (Iterator<String> iterator = list.iterator(); iterator.hasNext();){
                if (list.size() == 1){ //break out of loop if there is only 1 word left
                    return;
                }
                String s = iterator.next();
                if (s.indexOf(c) != -1){
                    iterator.remove();
                }
            }
        }
        

        public static boolean checkLength(Set<String> list, int length){ //check if there are any words of given length in the list
            for (Iterator<String> iterator = list.iterator(); iterator.hasNext();){
                String s = iterator.next();
                if (s.length() == length){
                    return true;
                }
            }
            return false;
        }
        public void removeNotLength(Set<String> list, int length){ //remove any words from the list that aren't of given length
            for (Iterator<String> iterator = list.iterator(); iterator.hasNext();){
                if (list.size() == 1){ //break out of loop if there is only 1 word left
                    return;
                }
                String s = iterator.next();
                if (s.length() != length){
                    iterator.remove();
                }
            }
        }
        public boolean canRemoveChar(Set<String> list, char c){ //check that there is at least 1 word in the list that doesn't contain the given char
            for (Iterator<String> iterator = list.iterator(); iterator.hasNext();){
                String s = iterator.next();
                if (s.indexOf(c) == -1){
                    return true;
                }
            }
            return false;
        }
        
    
        public static void addFromFile(String fileName, Set<String> list){
        int lineNumber = 1;
        try {
                    Scanner scanner = new Scanner(new File(fileName));
                    while(scanner.hasNextLine()){
                            String line = scanner.nextLine();
                            String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                            for(String word : words){
                                    //System.out.println(word);  //call add method here
                                    list.add(word);

                            }
                            lineNumber++;
                    }
                    scanner.close();

            } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
            }
            //System.out.println(lineNumber);
    }

    public static void main(String[] args) {
        Set<String> list = new HashSet<>();
        addFromFile("dictionary.txt", list);
        Scanner in = new Scanner(System.in);
        int length;
        do {
            System.out.println("Please enter a valid word length.");
            length = in.nextInt();
            
        } while (!checkLength(list, length));
        System.out.println("Please enter how many guesses you would like.");
        int guess = in.nextInt();
        
        Hangman test = new Hangman(length, guess, list);
        test.playGame();

        
    }
    
}
