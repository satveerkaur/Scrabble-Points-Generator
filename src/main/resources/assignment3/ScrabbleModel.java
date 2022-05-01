package assignment3;

import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class ScrabbleModel {
    //String word;
    ArrayList<String> words= new ArrayList<String>();
    private int points =0;

    boolean isValidWord(String word) throws IOException {
        if (word.length() >= 2 && word.length() <= 8 && word.matches("\\w*([AEIOU])\\w*") && word.matches("[A-Z]*") && !words.contains(word)) {
            return true;
        } else{
            return false;

        }

    }

    static final TreeMap<Character,Integer> letterPoints ;
    static {
        letterPoints = new TreeMap<>();
        letterPoints.put('A', 1);
        letterPoints.put('B', 3);
        letterPoints.put('C', 3);
        letterPoints.put('D', 2);
        letterPoints.put('E', 1);
        letterPoints.put('F', 4);
        letterPoints.put('G', 2);
        letterPoints.put('H', 4);
        letterPoints.put('I', 2);
        letterPoints.put('J', 8);
        letterPoints.put('K', 5);
        letterPoints.put('L', 1);
        letterPoints.put('M', 3);
        letterPoints.put('N', 1);
        letterPoints.put('O', 1);
        letterPoints.put('P', 3);
        letterPoints.put('Q', 10);
        letterPoints.put('R', 1);
        letterPoints.put('S', 1);
        letterPoints.put('T', 1);
        letterPoints.put('U', 1);
        letterPoints.put('V', 4);
        letterPoints.put('W', 4);
        letterPoints.put('X', 8);
        letterPoints.put('Y', 4);
        letterPoints.put('Z', 10);
    }

    public TreeMap<Character,Integer> availableLetters;

    {
        availableLetters = new TreeMap<>();
        availableLetters.put('A', 9);
        availableLetters.put('B', 2);
        availableLetters.put('C', 2);
        availableLetters.put('D', 4);
        availableLetters.put('E', 12);
        availableLetters.put('F', 2);
        availableLetters.put('G', 3);
        availableLetters.put('H', 2);
        availableLetters.put('I', 8);
        availableLetters.put('J', 1);
        availableLetters.put('K', 1);
        availableLetters.put('L', 4);
        availableLetters.put('M', 2);
        availableLetters.put('N', 6);
        availableLetters.put('O', 8);
        availableLetters.put('P', 2);
        availableLetters.put('Q', 1);
        availableLetters.put('R', 6);
        availableLetters.put('S', 4);
        availableLetters.put('T', 6);
        availableLetters.put('U', 4);
        availableLetters.put('V', 2);
        availableLetters.put('W', 2);
        availableLetters.put('X', 1);
        availableLetters.put('Y', 2);
        availableLetters.put('Z', 1);
    }
    public boolean isGameOver(){
        Set<Character> allKeys = availableLetters.keySet();
        int availableLetter=0;
        int vowelCount=0;

        for(Character key: allKeys){
            String keyString= Character.toString(key);
            availableLetter+=availableLetters.get(key);
            if(keyString.matches("[AEIOU]")){
                vowelCount+=availableLetters.get(key);
            }
        }
        if(availableLetter ==1 || vowelCount ==0){
            return true;
        }else{
            return false;
        }
    }

    public String getPreviousWords(){
        return String.join(",",words);
    }
    public int pointCount(String word){
        char[] wordToChar =word.toCharArray();
        Set<Character> allKeys = letterPoints.keySet();
        for(char w: wordToChar){
            for(Character key : allKeys){
                if(key==w){
                    points+=letterPoints.get(key);
                }}
        }
        return points;
    }
    boolean isValidWordBag(String word){
        char[] wordToChar = word.toCharArray();
        Set<Character> allKeys=availableLetters.keySet();
        for (char w : wordToChar) {
            for (Character key : allKeys) {
                if (key == w) {
                    if (availableLetters.get(key) > 0) {
                        availableLetters.put(key, availableLetters.get(key) - 1);
                        //String labelName=key.toString().toLowerCase();
                        //countToBeChanged(labelName);
                        break;
                    }
                    else{
                        throw new IllegalArgumentException("Character " + key + " is used up");
                    }
                }
            }
        }
        return true;
    }

//    void countToBeChanged(String name){
//
//    }
}
