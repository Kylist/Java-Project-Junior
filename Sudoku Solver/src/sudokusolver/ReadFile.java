/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;
import java.io.*; 
/**
 *
 * @author KyleTran
 */
class ReadFile { 
public static void main(String args[]) throws IOException { 
FileReader fRead= new FileReader("myfile.txt"); 
int c=0; 
while( (c=fRead.read()) != -1) 
System.out.print( (char) c); 
} 
}
