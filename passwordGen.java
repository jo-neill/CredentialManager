/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credentialmanager;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author zzt5046
 */
public class passwordGen {
    
    	static String password = "";
	static Random rand = new Random();
	
	public static void main(String [] args){
		
		Scanner in = new Scanner(System.in);
		System.out.println("How many characters long?");
		int length = in.nextInt();
		
		for(int i = 0; i < length; i++){
			int x = rand.nextInt(2);
			if(x == 0){
				letterGen();
			}
			else if(x == 1){
				numberGen();
			}
		}
                System.out.println("Your password is: " + password);
	}
	
	public static void letterGen(){
                final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int randomNum = (rand.nextInt((26 - 1) + 1) + 1)-1;
                password = password + alphabet.charAt(randomNum);
	}
	
	public static void numberGen(){
		int randomNum = rand.nextInt((9 - 1) + 1) + 1;
                password = password + randomNum;
	}
}

