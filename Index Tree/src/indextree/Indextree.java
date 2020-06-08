/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indextree;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Your class. Notice how it has no generics.
// This is because we use generics when we have no idea what kind of data we are getting
// Here we know we are getting two pieces of data:  a string and a line number
public class Indextree {

	// This is your root 
	// again, your root does not use generics because you know your nodes
	// hold strings, an int, and a list of integers
	private IndexNode root;
	
	// Make your constructor
	// It doesn't need to do anything
	
	// complete the methods below
	
	// this is your wrapper method
	// it takes in two pieces of data rather than one
	// call your recursive add method
	public void add(String word, int lineNumber){
	this.root=add(this.root,word,lineNumber);	
	}
	
	
	
                
	// your recursive method for add
	// Think about how this is slightly different the the regular add method
	// When you add the word to the index, if it already exists, 
	// you want to  add it to the IndexNode that already exists
	// otherwise make a new indexNode
	private IndexNode add(IndexNode root, String word, int lineNumber){
	if(root==null){
            return new IndexNode(word,lineNumber);
        }
        else if(word.compareTo(root.word)<0){
            root.left=add(root.left,word,lineNumber);
             
            return root;
        }
        else if(word.compareTo(root.word)==0){
           
            root.list+=lineNumber;
            
        return root;
        }
        else if(word.compareTo(root.word)>0){
            root.right=add(root.right,word,lineNumber);
          
            return root;
        }
            return null;
	}
	
	
	
	
	// returns true if the word is in the index
	public boolean contains(String word){
	return contains(this.root,word);	
            
	}
        
        private boolean contains(IndexNode root,String word){
            if(root==null){return false;}
            int comre=word.compareTo(root.word);
            if(comre==0){
                return true;
            }
            else if(comre<0){
                return contains(root.left,word);
            }
            else{return contains(root.right,word);
        }}
        
	
	// call your recursive method
	// use book as guide
	public void delete(String word){
		root=delete(root,word);
	}
	
	// your recursive case
	// remove the word and all the entries for the word
	// This should be no different than the regular technique.
	private IndexNode delete(IndexNode root, String word){
	if(root==null){
            return null;}
         int comre=word.compareTo(root.word);
	if(comre<0){
            root=delete(root.left,word);
        return root;}
        
        else if(comre>0){
    root=delete(root.right,word);
    
      }
      else {	
 if(root.left == null && root.right == null) {
 		return null;
 			} 
 			else if(root.left != null && root.right == null) {
 			return root.left;
 			} else if(root.left == null && root.right != null) {
 				return root.right;
 			} else {
 				if(root.left.right == null) {
 					root.word = root.left.word;
				root.left = root.left.left;
 					return root;
			} 
                               else {
					IndexNode parent = root.left;
					IndexNode pred = root.left.right;
 					while(pred.right != null) {
 						parent = parent.right;
 						pred = pred.right;
 					}
 					root.word = pred.word;
 					parent.right = pred.left;
 					return root;
                                }
                        }
        }
        return null;}
	
	
	// prints all the words in the index in inorder order
	// To successfully print it out
	// this should print out each word followed by the number of occurrences and the list of all occurrences
	// each word and its data gets its own line
	
        public void printIndex(){
            printIndex(root);
        }
        
        public void printIndex(IndexNode root){
            if(root==null){
                System.out.print("");
                }
            else{
                printIndex(root.left);
                System.out.println(root.toString());
                printIndex(root.right);
            
            
		
	}}
	
	public static void main(String[] args){

            Indextree index = new Indextree();
		
		// add all the words to the tree
		String fileName = "test.txt";
                
		try {
			Scanner scanner = new Scanner(new File(fileName));
			int i=1;
                        while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				//System.out.println(line);
                               
                               
                                
     String[] words = line.split("\\s+");				
    for(String word : words){
    word = word.replaceAll(":", "");
    word = word.replaceAll(",", "");
index.add(word,i);



				}
			i++;}
			scanner.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();}
                        
		// print out the index
		
		// test removing a word from the index


      index.printIndex();

      
        }}
