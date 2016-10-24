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
    
    	String password;
	static Random rand=new Random();
	
	public static void main(String [] args){
		
		Scanner in = new Scanner(System.in);
		System.out.print("How many characters long?");
		int length = in.nextInt();
		
		for(int i = 0; i < length; i++){
			int x=rand.nextInt(1);
			if(x == 0){
				letterGen();
			}
			else if(x == 1){
				numberGen();
			}
		}
	}
	
	public static void letterGen(){
		int randomNum = rand.nextInt((26 - 1) + 1) + 1;
	}
	
	public static void numberGen(){
		int randomNum = rand.nextInt((9 - 1) + 1) + 1;
	}
}

