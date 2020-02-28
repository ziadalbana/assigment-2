/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Alex
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int i;int max=0;
        char c;
        Scanner scan=new Scanner(System.in);
        game mode=new game();
        String[] wordsarr;
        wordsarr=mode.readFile();
        mode.setDictionary(wordsarr);
        mode.firstsetorginal();
        String word=mode.getOrginal();
        mode.setMaxWrongGuesses(3);
        char hidword[]=new char[word.length()];
        for ( i=0;i<word.length();i++){
            hidword[i]='-';
        }
        mode.setHiddenword(hidword);
        System.out.println(mode.getHiddenword());
        max=mode.getMaxWrongGuesses();
        
        while(mode.getLose()<=max&&mode.getWin()<word.length()){
            c=scan.next().charAt(0);
            System.out.println(mode.guess(c));
            System.out.println("lose:"+mode.getLose());
            System.out.println("win:"+mode.getWin());
        }
    }
    
}
