/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indextree;

import java.util.List;

/**
 *
 * @author KyleTran
 */

    
import java.util.List;

public class IndexNode  {

	// The word for this entry
	String word;
	// The number of occurrences for this word
	
	// A list of line numbers for this word.
	 String list=""; 
	
	
	
	IndexNode left;
	IndexNode right;
	
	
	// Constructors
	// Constructor should take in a word and a line number
	// it should initialize the list and set occurrences to 1
	
	public IndexNode(String a,int b){
            word=a;
           
            list+=b;
   
        }
	
	
	// Complete This
	// return the word, the number of occurrences, and the lines it appears on.
	// string must be one line
	
	public String toString(){
	String a= word+" appears "+list.length()+" times.Appears on lines:";
        String b="";
        for(int i=0;i<list.length();i++){
            b+=list.charAt(i)+",";
        }
        
            return (a+b);
	}
	
	
	public static void main(String []args){
          
         
        }
}