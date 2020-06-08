/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indextree;

import java.io.*;
import java.util.Scanner;

public class ReadingFromFileExample {
	
	public static void main(String [] args) {

		String fileName = "test.txt";
                //you can try test.txt if waiting for too long
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				System.out.println(line);
                                //System.out.println("hi");
                                
				String[] words = line.split("\\s+");
				for(String word : words){
					word = word.replaceAll(":", "");
					word = word.replaceAll(",", "");
					//System.out.println(word);
				}
			}
			scanner.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
                        System.out.println("fail");
		}
		
	}
}
