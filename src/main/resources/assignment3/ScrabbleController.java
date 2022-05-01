package assignment3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class ScrabbleController {

    @FXML
    private Button A;

    @FXML
    private Button B;

    @FXML
    private Button C;

    @FXML
    private Button D;

    @FXML
    private Button E;

    @FXML
    private Button F;

    @FXML
    private Button G;

    @FXML
    private Button H;

    @FXML
    private Button I;

    @FXML
    private Button J;

    @FXML
    private Button K;

    @FXML
    private Button L;

    @FXML
    private Button M;

    @FXML
    private Button N;

    @FXML
    private Button O;

    @FXML
    private Button P;

    @FXML
    private Button Q;

    @FXML
    private Button R;

    @FXML
    private Button S;

    @FXML
    private Button T;

    @FXML
    private Button U;

    @FXML
    private Button V;

    @FXML
    private Button W;

    @FXML
    private Button X;

    @FXML
    private Button Y;

    @FXML
    private Button Z;

    @FXML
    private Label a;

    @FXML
    private Label b;

    @FXML
    private Label c;

    @FXML
    private Label d;

    @FXML
    private Label e;

    @FXML
    private Label f;

    @FXML
    private Label g;

    @FXML
    private Label h;

    @FXML
    private Label i;

    @FXML
    private Label j;

    @FXML
    private Label k;

    @FXML
    private Label l;

    @FXML
    private Label m;

    @FXML
    private Label n;

    @FXML
    private Label o;

    @FXML
    private Label p;

    @FXML
    private Label q;

    @FXML
    private Label r;

    @FXML
    private Label s;

    @FXML
    private Label t;

    @FXML
    private Label u;

    @FXML
    private Label v;

    @FXML
    private Label w;

    @FXML
    private Label x;

    @FXML
    private Label y;

    @FXML
    private Label z;

    @FXML
    private TextField userInput;

    @FXML
    private TextField point;

    @FXML
    private TextArea prevWord;

    @FXML
    private Label error;

    ScrabbleModel model;
    //private ArrayList<String> words= new ArrayList<String>();


    //private Button[] buttons= new Button[]{A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z};
    private Label[] letterCount=new Label[]{a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z};

    @FXML
    void showPointValue(MouseEvent event) {

    }


    private String word;






    @FXML
    void submitWord(ActionEvent event) throws IOException {
        word=userInput.getText().trim().toUpperCase();
        if(!model.isGameOver()){
            if(model.isValidWord(word)){

                try{
                    if(model.isValidWordBag(word)){
                        //adding entered word to collection of words
                        model.words.add(word);
                        userInput.setText("");
                        error.setText("");
                        point.setText(Integer.toString(model.pointCount(word)));
                        //checking if the words available are used up and disable if true
                        disableButton();
                        //setting entered word to previous words label
                        prevWord.setText(model.getPreviousWords());
                        //a.setText();
                        char[] wordToChar=word.toCharArray();
                        Set<Character> allKeys=model.availableLetters.keySet();
                        for (char w : wordToChar) {
                            for (Character key : allKeys) {
                                if (key == w) {
                                        String labelName=key.toString().toLowerCase();
                                        for(int i=0;i<letterCount.length;i++){
                                            if(letterCount[i].getId()==labelName){
                                                letterCount[i].setText(String.valueOf(model.availableLetters.get(key)-1));

                                            };
                                        }
                                }
                            }
                        }

                    }
                }catch (IllegalArgumentException e){
                    userInput.setText("");
                    error.setText(e.getMessage());
                }

            }else{
                userInput.setText("");
                setError();
            }
        }else{
            userInput.setText("");
            error.setText("Game over");
        }
    }

    //Setting errors when the button submit is clicked
    public void setError(){

        if(word.length() ==1){
            error.setText("Word is too short");
        }else if(word.trim() ==""){
            error.setText("Word is blank");
        }else if(!word.matches("\\w*([AEIOU])\\w*")){
            error.setText("Word does not contain vowel");
        }else if(word.length()>8){
            error.setText("Word is too long");
        }
    }

    public void disableButton(){
        if(model.availableLetters.get('A') == 0){
            A.setDisable(true);
        }
        if (model.availableLetters.get('B') == 0){
            B.setDisable(true);
        }
        if (model.availableLetters.get('C') == 0){
            C.setDisable(true);
        }
        if (model.availableLetters.get('D') == 0){
            D.setDisable(true);
        }
        if (model.availableLetters.get('E') == 0){
            E.setDisable(true);
        }
        if (model.availableLetters.get('F') == 0){
            F.setDisable(true);
        }
        if (model.availableLetters.get('G') == 0){
            G.setDisable(true);
        }
        if (model.availableLetters.get('H') == 0) {
            H.setDisable(true);
        }
        if (model.availableLetters.get('I') == 0){
            I.setDisable(true);
        }
        if (model.availableLetters.get('J') == 0){
            J.setDisable(true);
        }
        if (model.availableLetters.get('K') == 0){
            K.setDisable(true);
        }
        if (model.availableLetters.get('L') == 0){
            L.setDisable(true);
        }
        if (model.availableLetters.get('M') == 0){
            M.setDisable(true);
        }
        if (model.availableLetters.get('N') == 0){
            N.setDisable(true);
        }
        if (model.availableLetters.get('O') == 0) {
            O.setDisable(true);
        }
        if (model.availableLetters.get('P') == 0){
            P.setDisable(true);
        }
        if (model.availableLetters.get('Q') == 0){
            Q.setDisable(true);
        }
        if (model.availableLetters.get('R') == 0){
            R.setDisable(true);
        }
        if (model.availableLetters.get('S') == 0){
            S.setDisable(true);
        }
        if (model.availableLetters.get('T') == 0){
            T.setDisable(true);
        }
        if (model.availableLetters.get('U') == 0){
            U.setDisable(true);
        }
        if (model.availableLetters.get('V') == 0) {
            V.setDisable(true);
        }
        if (model.availableLetters.get('W') == 0){
            W.setDisable(true);
        }
        if (model.availableLetters.get('X') == 0){
            X.setDisable(true);
        }
        if (model.availableLetters.get('Y') == 0){
            Y.setDisable(true);
        }
        if (model.availableLetters.get('Z') == 0) {
            Z.setDisable(true);
        }
    }

    @FXML
    void enterWord(ActionEvent event) {
        Button source=(Button)event.getSource();
        String wordEnteredTill=userInput.getText();
        String wordEnteredNow=wordEnteredTill+source.getText();
        userInput.setText(wordEnteredNow);
    }

    //when the application is initialized
    @FXML
    void initialize(){
        model=new ScrabbleModel();
        error.setText("");
    }

}
