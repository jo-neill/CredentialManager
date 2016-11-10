package credentialmanager;

import java.util.Random;

public class Generator {
    
    	private String password = "";
	private Random rand = new Random();
	private GeneratorView genView;
        
        public Generator(){
            this.genView = new GeneratorView(this);
        }
	public String getPassword(int length){
            for(int i = 0; i < length; i++){
		int x = rand.nextInt(2);
		if(x == 0)
                    generateLetter();
		else if(x == 1)
                    generateNumber();
            }
            return password;
	}
	
	private void generateLetter(){
                final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int randomNum = (rand.nextInt((26 - 1) + 1) + 1)-1;
                password += alphabet.charAt(randomNum);
	}
	
	private void generateNumber(){
		int randomNum = rand.nextInt((9 - 1) + 1) + 1;
                password = password + randomNum;
	}
}