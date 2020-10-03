package com.example.w4_p4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
    private Button[] letter_buttons;

    private LinearLayout word_spaces_view;
    private Button new_game_button;
    private Button hint_button;
    private ImageView hangman_head;
    private ImageView hangman_body;
    private ImageView hangman_left_arm;
    private ImageView hangman_right_arm;
    private ImageView hangman_left_leg;
    private ImageView hangman_right_leg;

    private void checkLetter(String letter) { //Check if clicked letter is in the word

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

        //Initiating the other things
        word_spaces_view = (LinearLayout) findViewById(R.id.word_spaces_view);
        new_game_button = (Button) findViewById(R.id.new_game_button);
        hint_button = (Button) findViewById(R.id.hint_button);
        hangman_body = (ImageView) findViewById(R.id.hangman_body);
        hangman_head = (ImageView) findViewById(R.id.hangman_head);
        hangman_left_arm = (ImageView) findViewById(R.id.hangman_left_arm);
        hangman_right_arm = (ImageView) findViewById(R.id.hangman_right_arm);
        hangman_left_leg = (ImageView) findViewById(R.id.hangman_left_leg);
        hangman_right_leg = (ImageView) findViewById(R.id.hangman_right_leg);

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
                    checkLetter(letter_buttons[index].getText().toString());
                }
            });
        }

        new_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // new game functionality
            }
        });

        hint_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // hint functionality
            }
        });

    }

}