/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author Alex
 */
public interface IHangman {
    void setDictionary(String[] words);
    public String selectRandomSecretWord();
    public String guess(char c);
    void setMaxWrongGuesses(int max);
    
}
