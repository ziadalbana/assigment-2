/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.io.*;
import java.util.Random;
import java.util.*;

/**
 *
 * @author Alex
 */
public class game implements IHangman{
    private String orginal;
    private char c;
    private char[] hiddenword;
    private int maxwrong;
    private int win=0;
    private int lose=0;
    private String[] array;

    public String[] getArray() {
        return array;
    }
    public game(){    
    }
    public game (String orginal){
        this.orginal=orginal;
    }
    
    public char[] getHiddenword() {
        return hiddenword;
    }
    public String firstsetorginal(){
         return this.orginal=selectRandomSecretWord();
    }
    public void setOrginal(String orginal) {
        this.orginal = orginal;
    }
    public void setHiddenword(char[] hiddenword) {
        this.hiddenword = hiddenword;
    } public String getOrginal() {
        return orginal;
    }
    public char getC() {
        return c;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }
    public String[] readFile() throws FileNotFoundException, IOException{
        int size=0;
        
            FileReader f1=new FileReader("C:\\Users\\Alex\\Desktop\\programing lab\\hangman\\src\\hangman\\text.txt");
            BufferedReader f=new BufferedReader(f1);
            
            //Reading Content from the file line by line
            //the array will have the lines of the file

            while(f.readLine()!=null){
                size++;
            }
            f.close();
            f1=new FileReader("C:\\Users\\Alex\\Desktop\\programing lab\\hangman\\src\\hangman\\text.txt");
            f=new BufferedReader(f1);
             String[] wordsarr=new String[size];
            
            for (int i=0;i<size;i++){
                wordsarr[i] = f.readLine();
            }
            f.close();
       
       return wordsarr;
        }
    @Override
        public void setDictionary(String[] words){
            this.array=words;
        }
    
    
   /* public String[] readFile() throws FileNotFoundException{
       Scanner x = null;
       int counter=0;int i=0;
       
     try{
         x=new Scanner(new File("text.txt"));
     }catch(Exception e){
         System.out.println("File not found");
     }
     while(x.hasNext()){
         counter++;
     }
     String[] wordsarr=new String[counter];
     for(i=0;i<counter;i++){
         wordsarr[i]=x.next();
     }
     x.close();
     return wordsarr;
    }*/
    
    @Override
    public String selectRandomSecretWord(){
        String[] arr=getArray();
        Random r=new Random();
        int randomNumber=r.nextInt(arr.length);
        String secretword=arr[randomNumber];
        return secretword;
    }
    @Override
    public String guess(char c){
        String sybmol;int win=0;int lose=0;int counter=0;
        win=getWin();
        lose=getLose();
        String word=getOrginal();
        char hidword[]=new char[word.length()];
        hidword=getHiddenword();
        int i=0;
       for(i=0;i<word.length();i++){
           if(word.charAt(i)==c){
                 hidword[i]=c;
                 win++;   
           }else if(word.charAt(i)!=c){
               counter++;
           }
       }
       counter=counter/word.length();
       lose+=counter;
      setHiddenword(hidword);
      setWin(win);
      setLose(lose);
      sybmol=String.valueOf(hidword);
      return sybmol;
    }
    @Override
    public void setMaxWrongGuesses(int n){
        if(n>0){
         this.maxwrong=n;}
        else if(n>=0){
         this.maxwrong=1;
        }
    }
    public int getMaxWrongGuesses(){
        return this.maxwrong;
    }
}  
