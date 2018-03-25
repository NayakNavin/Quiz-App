package com.example.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    int score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, totalScore;
    boolean checked1, checked2, checked3, checked4, checked6, checked7, checked8, checked9, checked10;
    String answer5;

    @BindView(R.id.button_4_1)
    CheckBox option_4_1;

    @BindView(R.id.button_4_2)
    CheckBox option_4_2;

    @BindView(R.id.button_4_3)
    CheckBox option_4_3;

    @BindView(R.id.button_4_4)
    CheckBox option_4_4;


    @BindView(R.id.button_6_1)
    CheckBox option_6_1;

    @BindView(R.id.button_6_2)
    CheckBox option_6_2;

    @BindView(R.id.button_6_3)
    CheckBox option_6_3;

    @BindView(R.id.button_6_4)
    CheckBox option_6_4;


    @BindView(R.id.button_8_1)
    CheckBox option_8_1;

    @BindView(R.id.button_8_2)
    CheckBox option_8_2;

    @BindView(R.id.button_8_3)
    CheckBox option_8_3;

    @BindView(R.id.button_8_4)
    CheckBox option_8_4;


    @BindView(R.id.edit_text_q5)
    EditText option5;

    @BindView(R.id.radioGroup1)
    RadioGroup option1;

    @BindView(R.id.radioGroup2)
    RadioGroup option2;

    @BindView(R.id.radioGroup3)
    RadioGroup option3;

    @BindView(R.id.radioGroup7)
    RadioGroup option7;

    @BindView(R.id.radioGroup9)
    RadioGroup option9;

    @BindView(R.id.radioGroup10)
    RadioGroup option10;


    @BindView(R.id.note_q_4)
    TextView noteTextViewQ4;

    @BindView(R.id.note_q_6)
    TextView noteTextViewQ6;

    @BindView(R.id.note_q_8)
    TextView noteTextViewQ8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        noteTextViewQ4.setVisibility(View.INVISIBLE);
        noteTextViewQ6.setVisibility(View.INVISIBLE);
        noteTextViewQ8.setVisibility(View.INVISIBLE);

    }

    public void onCheckedQuestion1(View view) {
        checked1 = ((RadioButton) view).isChecked();

        //  question 1
        switch (view.getId()) {
            case R.id.button_1_1:
                if (checked1) {
                    score1 = 0;
                    break;
                }
            case R.id.button_1_2:
                if (checked1) {
                    score1 = 10;
                    break;
                }
            case R.id.button_1_3:
                if (checked1) {
                    score1 = 0;
                    break;
                }
        }
    }

    public void onCheckedQuestion2(View view) {
        checked2 = ((RadioButton) view).isChecked();

        //  question 2
        switch (view.getId()) {
            case R.id.button_2_1:
                if (checked2) {
                    score2 = 10;
                    break;
                }
            case R.id.button_2_2:
                if (checked2) {
                    score2 = 0;
                    break;
                }
            case R.id.button_2_3:
                if (checked2) {
                    score2 = 0;
                    break;
                }
        }
    }

    public void onCheckedQuestion3(View view) {
        checked3 = ((RadioButton) view).isChecked();

        //  question 3
        switch (view.getId()) {
            case R.id.button_3_1:
                if (checked3) {
                    score3 = 0;
                    break;
                }
            case R.id.button_3_2:
                if (checked3) {
                    score3 = 0;
                    break;
                }
            case R.id.button_3_3:
                if (checked3) {
                    score3 = 10;
                    break;
                }
        }
    }

    public void onCheckedQuestion4(View view) {
        checked4 = option_4_1.isChecked() || option_4_2.isChecked() || option_4_3.isChecked() || option_4_4.isChecked();

        //  question 4
        // Allowing user to select 2 checkbox and informs the user
        int maxChecked = 2;
        int noChecked = 0;

        LinearLayout layout = findViewById(R.id.layout_4);
        for (int i = 0; i < 4; i++) {
            CheckBox item = (CheckBox) layout.getChildAt(i);
            noChecked = item.isChecked() ? noChecked + 1 : noChecked;
        }

        if (noChecked >= maxChecked) {
            noteTextViewQ4.setVisibility(View.VISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                if (!item.isChecked()) {
                    item.setEnabled(false);
                }
            }
        } else {
            noteTextViewQ4.setVisibility(View.INVISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                item.setEnabled(true);
            }
        }
    }

    public void onCheckedQuestion6(View view) {
        checked6 = option_6_1.isChecked() || option_6_2.isChecked() || option_6_3.isChecked() || option_6_4.isChecked();

        //  question 6
        // Allowing user to select 2 checkbox and informs the user
        int maxChecked = 2;
        int noChecked = 0;

        LinearLayout layout = findViewById(R.id.layout_6);
        for (int i = 0; i < 4; i++) {
            CheckBox item = (CheckBox) layout.getChildAt(i);
            noChecked = item.isChecked() ? noChecked + 1 : noChecked;
        }

        if (noChecked >= maxChecked) {
            noteTextViewQ6.setVisibility(View.VISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                if (!item.isChecked()) {
                    item.setEnabled(false);
                }
            }
        } else {
            noteTextViewQ6.setVisibility(View.INVISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                item.setEnabled(true);
            }
        }
    }

    public void onCheckedQuestion7(View view) {
        checked7 = ((RadioButton) view).isChecked();

        //  question 7
        switch (view.getId()) {
            case R.id.button_7_1:
                if (checked7) {
                    score7 = 0;
                    break;
                }
            case R.id.button_7_2:
                if (checked7) {
                    score7 = 0;
                    break;
                }
            case R.id.button_7_3:
                if (checked7) {
                    score7 = 10;
                    break;
                }
            case R.id.button_7_4:
                if (checked7) {
                    score7 = 0;
                    break;
                }
        }

    }

    public void onCheckedQuestion8(View view) {
        checked8 = option_8_1.isChecked() || option_8_2.isChecked() || option_8_3.isChecked() || option_8_4.isChecked();

        //  question 8
        // Allowing user to select 2 checkbox and informs the user
        int maxChecked = 2;
        int noChecked = 0;

        LinearLayout layout = findViewById(R.id.layout_8);
        for (int i = 0; i < 4; i++) {
            CheckBox item = (CheckBox) layout.getChildAt(i);
            noChecked = item.isChecked() ? noChecked + 1 : noChecked;
        }

        if (noChecked >= maxChecked) {
            noteTextViewQ8.setVisibility(View.VISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                if (!item.isChecked()) {
                    item.setEnabled(false);
                }
            }
        } else {
            noteTextViewQ8.setVisibility(View.INVISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                item.setEnabled(true);
            }
        }

    }

    public void onCheckedQuestion9(View view) {
        checked9 = ((RadioButton) view).isChecked();

        //  question 9
        switch (view.getId()) {
            case R.id.button_9_1:
                if (checked9) {
                    score9 = 0;
                    break;
                }
            case R.id.button_9_2:
                if (checked9) {
                    score9 = 10;
                    break;
                }
            case R.id.button_9_3:
                if (checked9) {
                    score9 = 0;
                    break;
                }
            case R.id.button_9_4:
                if (checked9) {
                    score9 = 0;
                    break;
                }
        }
    }

    public void onCheckedQuestion10(View view) {
        checked10 = ((RadioButton) view).isChecked();

        //  question 10
        switch (view.getId()) {
            case R.id.button_10_1:
                if (checked10) {
                    score10 = 10;
                    break;
                }
            case R.id.button_10_2:
                if (checked10) {
                    score10 = 0;
                    break;
                }
            case R.id.button_10_3:
                if (checked10) {
                    score10 = 0;
                    break;
                }
            case R.id.button_10_4:
                if (checked10) {
                    score10 = 0;
                    break;
                }
        }


    }

    // Submit button
    public void clickSubmit(View view) {
        answer5 = option5.getText().toString();
        if (checked1 && checked2 && checked3 && checked4 && checked6 && checked7 && checked8 && checked9 && checked10 && !answer5.equals("")) {


            // question 4
            score4 = 0;
            if (option_4_2.isChecked() && option_4_3.isChecked()) {
                score4 = 10;
            } else if (option_4_2.isChecked() || option_4_3.isChecked()) {
                score4 = 5;
            }


            //  question 5
            if (answer5.toLowerCase().equals("java")) {
                score5 = 10;
            } else
                score5 = 0;


            //  question 6
            score6 = 0;

            if (option_6_3.isChecked() && option_6_4.isChecked()) {
                score6 = 10;
            } else if (option_6_3.isChecked() || option_6_4.isChecked()) {
                score6 = 5;
            }


            //  question 8
            score8 = 0;
            if (option_8_1.isChecked() && option_8_2.isChecked()) {
                score8 = 10;
            } else if (option_8_1.isChecked() || option_8_2.isChecked()) {
                score8 = 5;
            }

            // calculate scores and display the total score.
            totalScore = score1 + score2 + score3 + score4 + score5 + score6 + score7 + score8 + score9 + score10;
            String answer = getString(R.string.your_score_is) + "  " + totalScore;
            Toast.makeText(this, answer, Toast.LENGTH_SHORT).show();
        } else {
            String text = getString(R.string.make_sure_answer_questions);
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }

    // Reset button
    public void clickReset(View view) {
        uncheckRadioGroup(option1);
        uncheckRadioGroup(option2);
        uncheckRadioGroup(option3);
        uncheckRadioGroup(option7);
        uncheckRadioGroup(option9);

        option5.setFocusableInTouchMode(false);
        option5.setFocusable(false);
        option5.setText("");
        option5.setFocusableInTouchMode(true);
        option5.setFocusable(true);
        uncheckCheckBoxes();
        enableCheckBoxes();
//        noScroll();
        hideText();
    }

    // unChecking radioBoxes when reset button is clicked
    private void uncheckRadioGroup(RadioGroup radioGroup) {
        radioGroup.clearCheck();
    }

    // unChecking checkboxes when reset button is clicked
    private void uncheckCheckBoxes() {


        option_4_1.setChecked(false);
        option_4_2.setChecked(false);
        option_4_3.setChecked(false);
        option_4_4.setChecked(false);

        option_6_1.setChecked(false);
        option_6_2.setChecked(false);
        option_6_3.setChecked(false);
        option_6_4.setChecked(false);


        option_8_1.setChecked(false);
        option_8_2.setChecked(false);
        option_8_3.setChecked(false);
        option_8_4.setChecked(false);

    }

    // Enabling disabled checkboxes when reset button is clicked
    private void enableCheckBoxes() {
        option_4_1.setEnabled(true);
        option_4_2.setEnabled(true);
        option_4_3.setEnabled(true);
        option_4_4.setEnabled(true);

        option_6_1.setEnabled(true);
        option_6_2.setEnabled(true);
        option_6_3.setEnabled(true);
        option_6_4.setEnabled(true);

        option_8_1.setEnabled(true);
        option_8_2.setEnabled(true);
        option_8_3.setEnabled(true);
        option_8_4.setEnabled(true);


    }

//    // Setting scrollview to stop scrolling to edit_text_q5 when the reset button is clicked
//    public void noScroll() {
//        ScrollView scroll = findViewById(R.id.no_Scroll);
//        scroll.computeScroll();
//    }

    // Hides Notes textView
    private void hideText() {
        noteTextViewQ4.setVisibility(View.INVISIBLE);
        noteTextViewQ6.setVisibility(View.INVISIBLE);
        noteTextViewQ8.setVisibility(View.INVISIBLE);
    }
}