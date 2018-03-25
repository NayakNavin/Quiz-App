package com.example.android.quiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.button;
import static android.R.attr.scrollIndicators;
import static android.R.attr.switchMinWidth;
import static android.R.attr.x;
import static butterknife.ButterKnife.findById;

import com.example.android.quiz.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {
    int score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, totalScore;
    boolean checked1, checked2, checked3, checked4, checked6, checked7, checked8, checked9, checked10;
    String answer5;

    @BindView(R.id.button_4_1)
    CheckBox mCheckBox_4_1;

    @BindView(R.id.button_4_2)
    CheckBox mCheckBox_4_2;

    @BindView(R.id.button_4_3)
    CheckBox mCheckBox_4_3;

    @BindView(R.id.button_4_4)
    CheckBox mCheckBox_4_4;


    @BindView(R.id.button_6_1)
    CheckBox mCheckBox_6_1;

    @BindView(R.id.button_6_2)
    CheckBox mCheckBox_6_2;

    @BindView(R.id.button_6_3)
    CheckBox mCheckBox_6_3;

    @BindView(R.id.button_6_4)
    CheckBox mCheckBox_6_4;


    @BindView(R.id.button_7_1)
    CheckBox mCheckBox_7_1;

    @BindView(R.id.button_7_2)
    CheckBox mCheckBox_7_2;

    @BindView(R.id.button_7_3)
    CheckBox mCheckBox_7_3;

    @BindView(R.id.button_7_4)
    CheckBox mCheckBox_7_4;


    @BindView(R.id.button_10_1)
    CheckBox mCheckBox_10_1;

    @BindView(R.id.button_10_2)
    CheckBox mCheckBox_10_2;

    @BindView(R.id.button_10_3)
    CheckBox mCheckBox_10_3;

    @BindView(R.id.button_10_4)
    CheckBox mCheckBox_10_4;


    @BindView(R.id.edit_text_q5)
    EditText mEditTextQ5;

    @BindView(R.id.radiogroup1)
    RadioGroup mRadioGroup1;

    @BindView(R.id.radiogroup2)
    RadioGroup mRadioGroup2;

    @BindView(R.id.radiogroup3)
    RadioGroup mRadioGroup3;

    @BindView(R.id.radiogroup8)
    RadioGroup mRadioGroup8;

    @BindView(R.id.radiogroup9)
    RadioGroup mRadioGroup9;


    @BindView(R.id.note_q_4)
    TextView noteTextViewQ4;

    @BindView(R.id.note_q_6)
    TextView noteTextViewQ6;

    @BindView(R.id.note_q_7)
    TextView noteTextViewQ7;

    @BindView(R.id.note_q_10)
    TextView noteTextViewQ10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        noteTextViewQ4.setVisibility(View.INVISIBLE);
        noteTextViewQ6.setVisibility(View.INVISIBLE);
        noteTextViewQ7.setVisibility(View.INVISIBLE);
        noteTextViewQ10.setVisibility(View.INVISIBLE);
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
        checked4 = mCheckBox_4_1.isChecked() || mCheckBox_4_2.isChecked() || mCheckBox_4_3.isChecked() || mCheckBox_4_4.isChecked();

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
        checked6 = mCheckBox_6_1.isChecked() || mCheckBox_6_2.isChecked() || mCheckBox_6_3.isChecked() || mCheckBox_6_4.isChecked();

        // Allowing user to select 1 checkbox and informs the user
        int maxChecked = 1;
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
        checked7 = mCheckBox_7_1.isChecked() || mCheckBox_7_2.isChecked() || mCheckBox_7_3.isChecked() || mCheckBox_7_4.isChecked();

        // Allowing user to select 1 checkbox and informs the user
        int maxChecked = 1;
        int noChecked = 0;

        LinearLayout layout = findViewById(R.id.layout_7);
        for (int i = 0; i < 4; i++) {
            CheckBox item = (CheckBox) layout.getChildAt(i);
            noChecked = item.isChecked() ? noChecked + 1 : noChecked;
        }

        if (noChecked >= maxChecked) {
            noteTextViewQ7.setVisibility(View.VISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                if (!item.isChecked()) {
                    item.setEnabled(false);
                }
            }
        } else {
            noteTextViewQ7.setVisibility(View.INVISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                item.setEnabled(true);
            }
        }
    }

    public void onCheckedQuestion8(View view) {
        checked8 = ((RadioButton) view).isChecked();

        //  question 8
        switch (view.getId()) {
            case R.id.button_8_1:
                if (checked8) {
                    score8 = 0;
                    break;
                }
            case R.id.button_8_2:
                if (checked1) {
                    score8 = 0;
                    break;
                }
            case R.id.button_8_3:
                if (checked8) {
                    score8 = 0;
                    break;
                }
            case R.id.button_8_4:
                if (checked8) {
                    score8 = 10;
                    break;
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
        checked10 = mCheckBox_10_1.isChecked() || mCheckBox_10_2.isChecked() || mCheckBox_10_3.isChecked() || mCheckBox_10_4.isChecked();

        // Allowing user to select 1 checkbox and informs the user
        int maxChecked = 1;
        int noChecked = 0;

        LinearLayout layout = findViewById(R.id.layout_10);
        for (int i = 0; i < 4; i++) {
            CheckBox item = (CheckBox) layout.getChildAt(i);
            noChecked = item.isChecked() ? noChecked + 1 : noChecked;
        }

        if (noChecked >= maxChecked) {
            noteTextViewQ10.setVisibility(View.VISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                if (!item.isChecked()) {
                    item.setEnabled(false);
                }
            }
        } else {
            noteTextViewQ10.setVisibility(View.INVISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                item.setEnabled(true);
            }
        }
    }

    // Submit button
    public void clickSubmit(View view) {
        answer5 = mEditTextQ5.getText().toString();
        if (checked1 && checked2 && checked3 && checked4 && checked6 && checked7 && checked8 && checked9 && checked10 && !answer5.equals("")) {


            // question 4
            score4 = 0;
            if (mCheckBox_4_2.isChecked() && mCheckBox_4_3.isChecked()) {
                score4 = 10;
            } else if (mCheckBox_4_2.isChecked() || mCheckBox_4_3.isChecked()) {
                score4 = 5;
            }


            //  question 5
            if (answer5.toLowerCase().equals("java")) {
                score5 = 10;
            } else
                score5 = 0;


            //  question 6
            score6 = 0;
            if (mCheckBox_6_4.isChecked()) {
                score6 = 10;
            } else {
                score6 = 0;
            }


            //  question 7
            score7 = 0;
            if (mCheckBox_7_3.isChecked()) {
                score7 = 10;
            } else {
                score7 = 0;
            }


            //  question 10
            score10 = 0;
            if (mCheckBox_10_1.isChecked()) {
                score10 = 10;
            } else {
                score10 = 0;
            }


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
        uncheckRadioGroup(mRadioGroup1);
        uncheckRadioGroup(mRadioGroup2);
        uncheckRadioGroup(mRadioGroup3);
        uncheckRadioGroup(mRadioGroup8);
        uncheckRadioGroup(mRadioGroup9);
        mEditTextQ5.setText("");
        uncheckCheckBoxes();
        enableCheckBoxes();
        noScroll();
        hideText();
    }

    // Unchechking Radioboxes when reset button is clicked
    private void uncheckRadioGroup(RadioGroup radioGroup) {
        radioGroup.clearCheck();
    }

    // Unchechking checkboxes when reset button is clicked
    private void uncheckCheckBoxes() {
        mCheckBox_4_1.setChecked(false);
        mCheckBox_4_2.setChecked(false);
        mCheckBox_4_3.setChecked(false);
        mCheckBox_4_4.setChecked(false);

        mCheckBox_6_1.setChecked(false);
        mCheckBox_6_2.setChecked(false);
        mCheckBox_6_3.setChecked(false);
        mCheckBox_6_4.setChecked(false);

        mCheckBox_7_1.setChecked(false);
        mCheckBox_7_2.setChecked(false);
        mCheckBox_7_3.setChecked(false);
        mCheckBox_7_4.setChecked(false);

        mCheckBox_10_1.setChecked(false);
        mCheckBox_10_2.setChecked(false);
        mCheckBox_10_3.setChecked(false);
        mCheckBox_10_4.setChecked(false);
    }

    // Enabling disabled checkboxes when reset button is clicked
    private void enableCheckBoxes() {
        mCheckBox_4_1.setEnabled(true);
        mCheckBox_4_2.setEnabled(true);
        mCheckBox_4_3.setEnabled(true);
        mCheckBox_4_4.setEnabled(true);

        mCheckBox_6_1.setEnabled(true);
        mCheckBox_6_2.setEnabled(true);
        mCheckBox_6_3.setEnabled(true);
        mCheckBox_6_4.setEnabled(true);

        mCheckBox_7_1.setEnabled(true);
        mCheckBox_7_2.setEnabled(true);
        mCheckBox_7_3.setEnabled(true);
        mCheckBox_7_4.setEnabled(true);

        mCheckBox_10_1.setEnabled(true);
        mCheckBox_10_2.setEnabled(true);
        mCheckBox_10_3.setEnabled(true);
        mCheckBox_10_4.setEnabled(true);
    }

    // Setting scrollview to stop scrolling to edit_text_q5 when the reset button is clicked
    public void noScroll() {
        ScrollView scroll = findViewById(R.id.no_Scroll);
        scroll.computeScroll();
    }

    // Hides Notes textview
    private void hideText() {
        noteTextViewQ4.setVisibility(View.INVISIBLE);
        noteTextViewQ6.setVisibility(View.INVISIBLE);
        noteTextViewQ7.setVisibility(View.INVISIBLE);
        noteTextViewQ10.setVisibility(View.INVISIBLE);
    }
}