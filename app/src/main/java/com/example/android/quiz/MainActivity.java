package com.example.android.quiz;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

@TargetApi(21)
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

    /**
     * @param activity method to hide soft keyboard
     */
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        assert inputMethodManager != null;
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI(findViewById(R.id.scroll));
        ButterKnife.bind(this);
        noteTextViewQ4.setVisibility(View.INVISIBLE);
        noteTextViewQ6.setVisibility(View.INVISIBLE);
        noteTextViewQ8.setVisibility(View.INVISIBLE);
    }

    /**
     * Question 1
     *
     * @param view Checks radioButtons and assign respective values
     *             Correct answer = 10 points
     *             Wrong answer = 0 points
     */
    public void onCheckedQuestion1(View view) {
        // Assigning radioButtons to a variable
        checked1 = ((RadioButton) view).isChecked();
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

    /**
     * Question 2
     *
     * @param view Checks radioButtons and assign respective values
     *             Correct answer = 10 points
     *             Wrong answer = 0 points
     */
    public void onCheckedQuestion2(View view) {
        // Assigning radioButtons to a variable
        checked2 = ((RadioButton) view).isChecked();
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

    /**
     * Question 3
     *
     * @param view Checks radioButtons and assign respective values
     *             Correct answer = 10 points
     *             Wrong answer = 0 points
     */
    public void onCheckedQuestion3(View view) {
        // Assigning radioButtons to a variable
        checked3 = ((RadioButton) view).isChecked();
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

    /**
     * Question 4
     *
     * @param view checks checkBoxes selected and allows user to select only 2 checkBoxes
     *             Correct answer = 5 points each
     *             Wrong answer = 0 points
     *             There are 2 correct answers.
     */
    public void onCheckedQuestion4(View view) {
        // Assigning checkBoxes to a variable
        checked4 = option_4_1.isChecked() || option_4_2.isChecked() || option_4_3.isChecked() || option_4_4.isChecked();

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

    /**
     * Question 6
     *
     * @param view checks checkBoxes selected and allows user to select only 2 checkBoxes
     *             Correct answer = 5 points each
     *             Wrong answer = 0 points
     *             There are 2 correct answers.
     */
    public void onCheckedQuestion6(View view) {
        // Assigning checkBoxes to a variable
        checked6 = option_6_1.isChecked() || option_6_2.isChecked() || option_6_3.isChecked() || option_6_4.isChecked();

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

    /**
     * Question 7
     *
     * @param view Checks radioButtons and assign respective values
     *             Correct answer = 10 points
     *             Wrong answer = 0 points
     */
    public void onCheckedQuestion7(View view) {
        // Assigning radioButtons to a variable
        checked7 = ((RadioButton) view).isChecked();
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

    /**
     * Question 8
     *
     * @param view checks checkBoxes selected and allows user to select only 2 checkBoxes
     *             Correct answer = 5 points each
     *             Wrong answer = 0 points
     *             There are 2 correct answers.
     */
    public void onCheckedQuestion8(View view) {
        // Assigning checkBoxes to a variable
        checked8 = option_8_1.isChecked() || option_8_2.isChecked() || option_8_3.isChecked() || option_8_4.isChecked();

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

    /**
     * Question 9
     *
     * @param view Checks radioButtons and assign respective values
     *             Correct answer = 10 points
     *             Wrong answer = 0 points
     */
    public void onCheckedQuestion9(View view) {
        // Assigning radioButtons to a variable
        checked9 = ((RadioButton) view).isChecked();
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

    /**
     * Question 10
     *
     * @param view Checks radioButtons and assign respective values
     *             Correct answer = 10 points
     *             Wrong answer = 0 points
     */
    public void onCheckedQuestion10(View view) {
        // Assigning radioButtons to a variable
        checked10 = ((RadioButton) view).isChecked();
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

    /**
     * @param view Calculates the total score and display the same.
     *             Also informs the user to answer all questions
     */
    public void clickSubmit(View view) {
        answer5 = option5.getText().toString();
        if (checked1 && checked2 && checked3 && checked4 && checked6 && checked7 && checked8 && checked9 && checked10 && !answer5.equals("")) {
            // question 4
            // Checks the checkBoxes and assign 10 points if it is correct or 5 points if partially correct
            if (option_4_2.isChecked() && option_4_3.isChecked()) {
                score4 = 10;
            } else if (option_4_2.isChecked() || option_4_3.isChecked()) {
                score4 = 5;
            }
            // question 5
            // Checks the text and assign 10 points if it is correct
            if (answer5.toLowerCase().equals("java")) {
                score5 = 10;
            } else
                score5 = 0;

            // question 6
            // Checks the checkBoxes and assign 10 points if it is correct or 5 points if partially correct
            if (option_6_3.isChecked() && option_6_4.isChecked()) {
                score6 = 10;
            } else if (option_6_3.isChecked() || option_6_4.isChecked()) {
                score6 = 5;
            }
            // question 8
            // Checks the checkBoxes and assign 10 points if it is correct or 5 points if partially correct
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

    /**
     * @param view Reset radioButtons, checkBoxes and editText
     *             Hide noteTextView
     */
    public void clickReset(View view) {
        uncheckRadioGroup(option1);
        uncheckRadioGroup(option2);
        uncheckRadioGroup(option3);
        uncheckRadioGroup(option7);
        uncheckRadioGroup(option9);
        uncheckRadioGroup(option10);
        option5.setText("");
        uncheckCheckBoxes();
        enableCheckBoxes();
        hideText();
    }

    /**
     * @param radioGroup unChecking radioBoxes when reset button is clicked
     */
    private void uncheckRadioGroup(RadioGroup radioGroup) {
        radioGroup.clearCheck();
    }

    /**
     * unChecking checkBoxes when reset button is clicked
     */
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

    /**
     * Enabling disabled checkBoxes when reset button is clicked
     */
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

    /**
     * Hiding Notes textView when reset button is clicked
     */
    private void hideText() {
        noteTextViewQ4.setVisibility(View.INVISIBLE);
        noteTextViewQ6.setVisibility(View.INVISIBLE);
        noteTextViewQ8.setVisibility(View.INVISIBLE);
    }

    /**
     * @param view method to hide soft keyboard when clicked outside editText
     */
    public void setupUI(View view) {
        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new OnTouchListener() {
                @SuppressLint("ClickableViewAccessibility")
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(MainActivity.this);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }
}
