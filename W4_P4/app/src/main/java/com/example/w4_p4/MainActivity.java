package com.example.w4_p4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.gesture.GestureOverlayView.ORIENTATION_HORIZONTAL;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> words = new ArrayList<String>(Arrays.asList("ORANGE", "BOSTON", "LION", "OAK", "BASEBALL"));
    private String chosenword;
    private int letterremmain;
    private int hangman;
    private int userscore;
    private int index;
    private int hint_count;
    private char[] textViews;
    private TextView word_space_filler;
    private TextView hint_view;
    private String display;
    private ArrayList<Character> checker;
    private int lettercount;
    private char[] display2;
    private char[] correspond;
    private boolean q;


    private boolean landscape_orientation = false;
    private Button a_button;
    private Button b_button;
    private Button c_button;
    private Button d_button;
    private Button e_button;
    private Button f_button;
    private Button g_button;
    private Button h_button;
    private Button i_button;
    private Button j_button;
    private Button k_button;
    private Button l_button;
    private Button m_button;
    private Button n_button;
    private Button o_button;
    private Button p_button;
    private Button q_button;
    private Button r_button;
    private Button s_button;
    private Button t_button;
    private Button u_button;
    private Button v_button;
    private Button w_button;
    private Button x_button;
    private Button y_button;
    private Button z_button;
    private Button new_game_button;
    private Button hint_button;
    private Button[] letter_buttons;

    private LinearLayout word_spaces_view;
    private ImageView hangman_head;
    private ImageView hangman_body;
    private ImageView hangman_left_arm;
    private ImageView hangman_right_arm;
    private ImageView hangman_left_leg;
    private ImageView hangman_right_leg;


    private void checkLetter(char letter) { //Check if clicked letter is in the word
        if (chosenword.indexOf(letter) != -1) {
            findletter(letter);
            letterremmain = letterremmain - lettercount;
            userscore += 5;
        }
        else{
            hangmanCheck();
            updateMan();
        }
        wincheck();

    }

    private void giveHint(){ //Each word has three hints, and then the hint button gets disabled
        switch (chosenword){
            case "ORANGE":
                if(hint_count == 0){
                    hint_view.setText(R.string.orange_hint_1);
                    Toast.makeText(getApplicationContext(), "Two hints remaining", Toast.LENGTH_SHORT).show();
                    hint_count++;
                    hangmanCheck();
                    updateMan();
                }
                else if(hint_count == 1){
                    hint_view.setText(R.string.orange_hint_2);
                    Toast.makeText(getApplicationContext(), "One hint remaining", Toast.LENGTH_SHORT).show();
                    hint_count++;
                    hangmanCheck();
                    updateMan();
                }
                else{
                    hint_view.setText(R.string.orange_hint_3);
                    hint_button.setEnabled(false);
                    hangmanCheck();
                    updateMan();
                    Toast.makeText(getApplicationContext(), "No hints remaining", Toast.LENGTH_SHORT).show();
                }
                break;

            case "OAK":
                if(hint_count == 0){
                    hint_view.setText(R.string.oak_hint_1);
                    Toast.makeText(getApplicationContext(), "Two hints remaining", Toast.LENGTH_SHORT).show();
                    hint_count++;
                    hangmanCheck();
                    updateMan();
                }
                else if(hint_count == 1){
                    hint_view.setText(R.string.oak_hint_2);
                    Toast.makeText(getApplicationContext(), "One hint remaining", Toast.LENGTH_SHORT).show();
                    hint_count++;
                    hangmanCheck();
                    updateMan();
                }
                else{
                    hint_view.setText(R.string.oak_hint_3);
                    hint_button.setEnabled(false);
                    Toast.makeText(getApplicationContext(), "No hints remaining", Toast.LENGTH_SHORT).show();
                    hangmanCheck();
                    updateMan();
                }
                break;

            case "BOSTON":
                if(hint_count == 0){
                    hint_view.setText(R.string.boston_hint_1);
                    Toast.makeText(getApplicationContext(), "Two hints remaining", Toast.LENGTH_SHORT).show();
                    hint_count++;
                    hangmanCheck();
                    updateMan();
                }
                else if(hint_count == 1){
                    hint_view.setText(R.string.boston_hint_2);
                    Toast.makeText(getApplicationContext(), "One hint remaining", Toast.LENGTH_SHORT).show();
                    hint_count++;
                    hangmanCheck();
                    updateMan();
                }
                else{
                    hint_view.setText(R.string.boston_hint_3);
                    hint_button.setEnabled(false);
                    Toast.makeText(getApplicationContext(), "No hints remaining", Toast.LENGTH_SHORT).show();
                    hangmanCheck();
                    updateMan();
                }
                break;

            case "LION":
                if(hint_count == 0){
                    hint_view.setText(R.string.lion_hint_1);
                    Toast.makeText(getApplicationContext(), "Two hints remaining", Toast.LENGTH_SHORT).show();
                    hint_count++;
                    hangmanCheck();
                    updateMan();
                }
                else if(hint_count == 1){
                    hint_view.setText(R.string.lion_hint_2);
                    Toast.makeText(getApplicationContext(), "One hint remaining", Toast.LENGTH_SHORT).show();
                    hint_count++;
                    hangmanCheck();
                    updateMan();
                }
                else{
                    hint_view.setText(R.string.lion_hint_3);
                    hint_button.setEnabled(false);
                    Toast.makeText(getApplicationContext(), "No hints remaining", Toast.LENGTH_SHORT).show();
                    hangmanCheck();
                    updateMan();
                }
                break;

            case "BASEBALL":
                if(hint_count == 0){
                    hint_view.setText(R.string.baseball_hint_1);
                    Toast.makeText(getApplicationContext(), "Two hints remaining", Toast.LENGTH_SHORT).show();
                    hint_count++;
                    hangmanCheck();
                    updateMan();
                }
                else if(hint_count == 1){
                    hint_view.setText(R.string.baseball_hint_2);
                    Toast.makeText(getApplicationContext(), "One hint remaining", Toast.LENGTH_SHORT).show();
                    hint_count++;
                    hangmanCheck();
                    updateMan();
                }
                else{
                    hint_view.setText(R.string.baseball_hint_3);
                    hint_button.setEnabled(false);
                    Toast.makeText(getApplicationContext(), "No hints remaining", Toast.LENGTH_SHORT).show();
                    hangmanCheck();
                    updateMan();
                }
                break;
        }
    }

    private void resetHints() { //Resets hint count and re-enables hint button. Will be changed to better deal with landscape vs. portrait orientation
        if(landscape_orientation) {

            hint_count = 0;
            hint_button.setEnabled(true);
            hint_view.setText("");
            int hint_view_width = hint_view.getWidth();
            hint_view.setMaxWidth(hint_view_width);

        }
    }

    private void outputfix(char[] c) {      // this is used so that we have space between each '_'
        for (int i = 0; i < c.length; i++) {
            if (i % 2 == 0) {
                c[i] = '_';
            } else {
                c[i] = ' ';
            }
        }
    }

    //see if the user entered the correct letter, if they did, update the textview
    private void findletter(char c){
        lettercount = 0;
        for(int i = 0; i < correspond.length;i++){
            if (correspond[i] == c) {
                display2[i*2] = c;
                lettercount++;
            }

        }
        word_space_filler.setText(new String(display2) );

    }

    //initializing the basic state of the game
    private void initialize() {
        Collections.shuffle(words);
        chosenword = words.get(index);
        q=false;
        index = 0;
        hangman = 0;
        userscore = 0;
    }
    // this function provide the user with the next word they need to guess
    private void nextword() {
        index++;
        chosenword = words.get(index);
        letterremmain = chosenword.length(); // the two counters here is for checking if the user have guessed all the letter of a word
        lettercount = 0;
        display2 = new char[checker.size()*2];
        outputfix(display2);
        checkerinitialize(chosenword);
        resetbutton();
        resetHints();
    }
    // check if the user have lost the game or not
    private void hangmanCheck() {
        if (hangman < 6) hangman++;
    }

    // This function checks if there are still words left that the user haven't try to guess yet, if they didn't give them the next word,
    // if the did shuffle the list of words

    // this function is to get a char array that will later be used to help print the asnwers everytime the user gets a letter correct
    private void checkerinitialize(String checker2) {
        checker = new ArrayList<Character>();
        for (char ch : checker2.toCharArray()) {
            checker.add(ch);
        }
        correspond = new char[checker.size()];
        for (int k = 0; k < checker.size(); k++) {
            correspond[k] = checker.get(k);
        }
    }

    //This function is to display the "_ _ _ _ _"

    private void displayword() {
//        chosenword = words.get(index);
        letterremmain = chosenword.length();
        lettercount = 0;
        checkerinitialize(chosenword);

        textViews = new char[letterremmain];
        display = "";
        for (int i = 0; i < textViews.length; i++) {
            display+="_ ";
        }
        display2 = new char[chosenword.length()*2];
        outputfix(display2);
        word_space_filler.setText(display);

    }

    //check if the player have guessed the words correctly, if they did give them a new word
    private void wincheck(){
        if(letterremmain == 0) {
            Toast.makeText(getApplicationContext(), String.format("Congradulations! You win! Score: %d", userscore), Toast.LENGTH_LONG).show();
            hangman = 0;
            updateMan();
            userscore = 0;
            resetbutton();
            if (index < words.size() - 1) {
                q = true;
                nextword();
                displayword();
            }
            else{
                Toast.makeText(getApplicationContext(), "You've guessed all of our words!\nShuffling words and restarting the game!", Toast.LENGTH_LONG).show();
                initialize();
                displayword();
                updateMan();
                resetbutton();
                resetHints();
            }
        }

    }

    private void resetbutton(){
        for (int i = 0; i < letter_buttons.length; i++) {
            final int index = i; //Java told me to create a new Final int variable instead of just using the i from the for loop
            letter_buttons[index].setEnabled(true);
        }
    }

    // this function determines what stage the player is on
    private void updateMan() {
        ImageView stand = (ImageView) findViewById(R.id.hangman_stand);
        ImageView head = (ImageView) findViewById(R.id.hangman_head);
        ImageView body = (ImageView) findViewById(R.id.hangman_body);
        ImageView leftarm = (ImageView) findViewById(R.id.hangman_left_arm);
        ImageView rightarm = (ImageView) findViewById(R.id.hangman_right_arm);
        ImageView rightleg = (ImageView) findViewById(R.id.hangman_right_leg);
        ImageView leftleg = (ImageView) findViewById(R.id.hangman_left_leg);
        switch (hangman) {
            case 0:   // no wrong answers, only pole showing
                stand.setVisibility(View.VISIBLE);
                head.setVisibility(View.INVISIBLE);
                body.setVisibility(View.INVISIBLE);
                leftarm.setVisibility(View.INVISIBLE);
                rightarm.setVisibility(View.INVISIBLE);
                rightleg.setVisibility(View.INVISIBLE);
                leftleg.setVisibility(View.INVISIBLE);

                break;
            case 1: //one wrong answer head shows so on and so forth until the whole body shows in case 6
                stand.setVisibility(View.VISIBLE);
                head.setVisibility(View.VISIBLE);
                body.setVisibility(View.INVISIBLE);
                leftarm.setVisibility(View.INVISIBLE);
                rightarm.setVisibility(View.INVISIBLE);
                rightleg.setVisibility(View.INVISIBLE);
                leftleg.setVisibility(View.INVISIBLE);
                break;
            case 2:
                stand.setVisibility(View.VISIBLE);
                head.setVisibility(View.VISIBLE);
                body.setVisibility(View.VISIBLE);
                leftarm.setVisibility(View.INVISIBLE);
                rightarm.setVisibility(View.INVISIBLE);
                rightleg.setVisibility(View.INVISIBLE);
                leftleg.setVisibility(View.INVISIBLE);
                break;
            case 3:
                stand.setVisibility(View.VISIBLE);
                head.setVisibility(View.VISIBLE);
                body.setVisibility(View.VISIBLE);
                leftarm.setVisibility(View.VISIBLE);
                rightarm.setVisibility(View.INVISIBLE);
                rightleg.setVisibility(View.INVISIBLE);
                leftleg.setVisibility(View.INVISIBLE);
                break;
            case 4:
                stand.setVisibility(View.VISIBLE);
                head.setVisibility(View.VISIBLE);
                body.setVisibility(View.VISIBLE);
                leftarm.setVisibility(View.VISIBLE);
                rightarm.setVisibility(View.VISIBLE);
                rightleg.setVisibility(View.INVISIBLE);
                leftleg.setVisibility(View.INVISIBLE);
                break;
            case 5:
                stand.setVisibility(View.VISIBLE);
                head.setVisibility(View.VISIBLE);
                body.setVisibility(View.VISIBLE);
                leftarm.setVisibility(View.VISIBLE);
                rightarm.setVisibility(View.VISIBLE);
                rightleg.setVisibility(View.VISIBLE);
                leftleg.setVisibility(View.INVISIBLE);
                break;
            case 6:    //since the player has lost the game at this point, they need to press the new game button if they want to play again
                stand.setVisibility(View.VISIBLE);
                head.setVisibility(View.VISIBLE);
                body.setVisibility(View.VISIBLE);
                leftarm.setVisibility(View.VISIBLE);
                rightarm.setVisibility(View.VISIBLE);
                rightleg.setVisibility(View.VISIBLE);
                leftleg.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), String.format("You lost! Score: %d\n Please press new game to play again", userscore), Toast.LENGTH_LONG).show();
                if(landscape_orientation){
                    hint_button.setEnabled(false);
                }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initiating the buttons
        a_button = (Button) findViewById(R.id.a_button);
        b_button = (Button) findViewById(R.id.b_button);
        c_button = (Button) findViewById(R.id.c_button);
        d_button = (Button) findViewById(R.id.d_button);
        e_button = (Button) findViewById(R.id.e_button);
        f_button = (Button) findViewById(R.id.f_button);
        g_button = (Button) findViewById(R.id.g_button);
        h_button = (Button) findViewById(R.id.h_button);
        i_button = (Button) findViewById(R.id.i_button);
        j_button = (Button) findViewById(R.id.j_button);
        k_button = (Button) findViewById(R.id.k_button);
        l_button = (Button) findViewById(R.id.l_button);
        m_button = (Button) findViewById(R.id.m_button);
        n_button = (Button) findViewById(R.id.n_button);
        o_button = (Button) findViewById(R.id.o_button);
        p_button = (Button) findViewById(R.id.p_button);
        q_button = (Button) findViewById(R.id.q_button);
        r_button = (Button) findViewById(R.id.r_button);
        s_button = (Button) findViewById(R.id.s_button);
        t_button = (Button) findViewById(R.id.t_button);
        u_button = (Button) findViewById(R.id.u_button);
        v_button = (Button) findViewById(R.id.v_button);
        w_button = (Button) findViewById(R.id.w_button);
        x_button = (Button) findViewById(R.id.x_button);
        y_button = (Button) findViewById(R.id.y_button);
        z_button = (Button) findViewById(R.id.z_button);

        //Instantiating the other things
        word_spaces_view = (LinearLayout) findViewById(R.id.word_spaces_view);
        word_space_filler= (TextView) findViewById(R.id.word_spaces_filler);
        new_game_button = (Button) findViewById(R.id.new_game_button);
        hangman_body = (ImageView) findViewById(R.id.hangman_body);
        hangman_head = (ImageView) findViewById(R.id.hangman_head);
        hangman_left_arm = (ImageView) findViewById(R.id.hangman_left_arm);
        hangman_right_arm = (ImageView) findViewById(R.id.hangman_right_arm);
        hangman_left_leg = (ImageView) findViewById(R.id.hangman_left_leg);
        hangman_right_leg = (ImageView) findViewById(R.id.hangman_right_leg);
        int orientation = MainActivity.this.getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) { //Instantiate hint button and view only if in landscape mode.
            landscape_orientation = true;
            hint_button = (Button) findViewById(R.id.hint_button);
            hint_view = (TextView) findViewById(R.id.hint_view);
            hint_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    giveHint();
                }
            });
        }
        if(savedInstanceState==null) {
            initialize();
            updateMan();
            displayword();
            resetHints();
        }

        // Initiating array for the letter buttons
        letter_buttons = new Button[] {
                a_button, b_button, c_button, d_button, e_button, f_button, g_button, h_button, i_button,
                j_button, k_button, l_button, m_button, n_button, o_button, p_button, q_button, r_button,
                s_button, t_button, u_button, v_button, w_button, x_button, y_button, z_button
        };

        for(int i = 0; i < letter_buttons.length; i++){
            final int index = i; //Java told me to create a new Final int variable instead of just using the i from the for loop
            letter_buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { //Setting the on-clock listener for all buttons at once with a loop
                    checkLetter(letter_buttons[index].getText().charAt(0));
                    letter_buttons[index].setEnabled(false);
                    if(q){       //the boolean handles the case when the last letter use to complete the correct guess of the world doesn't
                                         // become disabled on the next word.
                        letter_buttons[index].setEnabled(true);
                    }
                    q = false;
                }
            });
        }

        new_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initialize();
                displayword();
                updateMan();
                resetbutton();
                resetHints();

            }
        });

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        //checker ArrayList<Character>
        //No option for ArrayList<Character>. Need to change the type of checker
        outState.putCharArray("correspond", correspond);
        outState.putCharArray("display2", display2);
        outState.putCharArray("textViews",textViews);
        outState.putBoolean("landscape_orientation", landscape_orientation);
        outState.putBoolean("q", q);
        outState.putInt("hangman", hangman);
        outState.putInt("hint_count", hint_count);
        outState.putInt("letterremain", letterremmain);
        outState.putInt("lettercount", lettercount);
        outState.putInt("userscore", userscore);
        outState.putString("chosenword", chosenword);
        outState.putInt("index",index);
        outState.putCharSequence("wordSpaceFillerText",word_space_filler.getText());
        outState.putString("display",display);
        char[] checkerArray = new char[checker.size()];
        for(int i = 0; i<checker.size();i++)
            checkerArray[i]=checker.get(i);
        outState.putCharArray("checker",checkerArray);




        if(landscape_orientation) {
            outState.putString("hint_view", hint_view.getText().toString());
        }

        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

        correspond = savedInstanceState.getCharArray("correspond");
        display2 = savedInstanceState.getCharArray("display2");
        textViews = savedInstanceState.getCharArray("textViews");
        landscape_orientation = savedInstanceState.getBoolean("landscape_orientation");

        q = savedInstanceState.getBoolean("q");
        hangman = savedInstanceState.getInt("hangman");
        hint_count = savedInstanceState.getInt("hint_count");
        letterremmain = savedInstanceState.getInt("letterremain");
        lettercount = savedInstanceState.getInt("lettercount");
        userscore = savedInstanceState.getInt("userscore");
        chosenword = savedInstanceState.getString("chosenword");

        index = savedInstanceState.getInt("index");
        word_space_filler.setText(savedInstanceState.getCharSequence("wordSpaceFillerText"));

        display = savedInstanceState.getString("display");

        if(landscape_orientation){
            hint_view.setText(savedInstanceState.getString("hint_view"));
        }
        char[] chars = savedInstanceState.getCharArray("checker");
        checker = new ArrayList<>();
        for(char c: chars){
            checker.add(c);
        }
        //Issue: When the screen rotates, initialize() in onCreate gets called, which resets everything and reshuffles the words
        //regardless of what I bring back from the outState bundle. Need to find a way to change the way the game is initialized
        //so that the word the player was on can stay even when app is created and destroyed.

//        displayword(); //Issue with calling this function.
        updateMan();

        super.onRestoreInstanceState(savedInstanceState);
    }


}