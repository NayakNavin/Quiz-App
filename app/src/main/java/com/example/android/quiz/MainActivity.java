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

    @BindView(R.id.button41)
    CheckBox mCheckBox41;

    @BindView(R.id.button42)
    CheckBox mCheckBox42;

    @BindView(R.id.button43)
    CheckBox mCheckBox43;

    @BindView(R.id.button44)
    CheckBox mCheckBox44;


    @BindView(R.id.button61)
    CheckBox mCheckBox61;

    @BindView(R.id.button62)
    CheckBox mCheckBox62;

    @BindView(R.id.button63)
    CheckBox mCheckBox63;

    @BindView(R.id.button64)
    CheckBox mCheckBox64;


    @BindView(R.id.button71)
    CheckBox mCheckBox71;

    @BindView(R.id.button72)
    CheckBox mCheckBox72;

    @BindView(R.id.button73)
    CheckBox mCheckBox73;

    @BindView(R.id.button74)
    CheckBox mCheckBox74;


    @BindView(R.id.button101)
    CheckBox mCheckBox101;

    @BindView(R.id.button102)
    CheckBox mCheckBox102;

    @BindView(R.id.button103)
    CheckBox mCheckBox103;

    @BindView(R.id.button104)
    CheckBox mCheckBox104;


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
    TextView noteTextView4;

    @BindView(R.id.note_q_6)
    TextView noteTextView6;

    @BindView(R.id.note_q_7)
    TextView noteTextView7;

    @BindView(R.id.note_q_10)
    TextView noteTextView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        noteTextView4.setVisibility(View.INVISIBLE);
        noteTextView6.setVisibility(View.INVISIBLE);
        noteTextView7.setVisibility(View.INVISIBLE);
        noteTextView10.setVisibility(View.INVISIBLE);
    }

    public void onCheckedQuestion1(View view) {
        checked1 = ((RadioButton) view).isChecked();

        //  question 1
        switch (view.getId()) {
            case R.id.button11:
                if (checked1) {
                    score1 = 0;
                    break;
                }
            case R.id.button12:
                if (checked1) {
                    score1 = 10;
                    break;
                }
            case R.id.button13:
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
            case R.id.button21:
                if (checked2) {
                    score2 = 10;
                    break;
                }
            case R.id.button22:
                if (checked2) {
                    score2 = 0;
                    break;
                }
            case R.id.button23:
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
            case R.id.button31:
                if (checked3) {
                    score3 = 0;
                    break;
                }
            case R.id.button32:
                if (checked3) {
                    score3 = 0;
                    break;
                }
            case R.id.button33:
                if (checked3) {
                    score3 = 10;
                    break;
                }
        }
    }

    public void onCheckedQuestion4(View view) {
        checked4 = mCheckBox41.isChecked() || mCheckBox42.isChecked() || mCheckBox43.isChecked() || mCheckBox44.isChecked();

        // Allowing user to select 2 checkbox and informs the user
        int maxChecked = 2;
        int noChecked = 0;

        LinearLayout layout = findViewById(R.id.layout_4);
        for (int i = 0; i < 4; i++) {
            CheckBox item = (CheckBox) layout.getChildAt(i);
            noChecked = item.isChecked() ? noChecked + 1 : noChecked;
        }

        if (noChecked >= maxChecked) {
            noteTextView4.setVisibility(View.VISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                if (!item.isChecked()) {
                    item.setEnabled(false);
                }
            }
        } else {
            noteTextView4.setVisibility(View.INVISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                item.setEnabled(true);
            }
        }
    }

    public void onCheckedQuestion6(View view) {
        checked6 = mCheckBox61.isChecked() || mCheckBox62.isChecked() || mCheckBox63.isChecked() || mCheckBox64.isChecked();

        // Allowing user to select 1 checkbox and informs the user
        int maxChecked = 1;
        int noChecked = 0;

        LinearLayout layout = findViewById(R.id.layout_6);
        for (int i = 0; i < 4; i++) {
            CheckBox item = (CheckBox) layout.getChildAt(i);
            noChecked = item.isChecked() ? noChecked + 1 : noChecked;
        }

        if (noChecked >= maxChecked) {
            noteTextView6.setVisibility(View.VISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                if (!item.isChecked()) {
                    item.setEnabled(false);
                }
            }
        } else {
            noteTextView6.setVisibility(View.INVISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                item.setEnabled(true);
            }
        }
    }

    public void onCheckedQuestion7(View view) {
        checked7 = mCheckBox71.isChecked() || mCheckBox72.isChecked() || mCheckBox73.isChecked() || mCheckBox74.isChecked();

        // Allowing user to select 1 checkbox and informs the user
        int maxChecked = 1;
        int noChecked = 0;

        LinearLayout layout = findViewById(R.id.layout_7);
        for (int i = 0; i < 4; i++) {
            CheckBox item = (CheckBox) layout.getChildAt(i);
            noChecked = item.isChecked() ? noChecked + 1 : noChecked;
        }

        if (noChecked >= maxChecked) {
            noteTextView7.setVisibility(View.VISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                if (!item.isChecked()) {
                    item.setEnabled(false);
                }
            }
        } else {
            noteTextView7.setVisibility(View.INVISIBLE);
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
            case R.id.button81:
                if (checked8) {
                    score8 = 0;
                    break;
                }
            case R.id.button12:
                if (checked1) {
                    score8 = 0;
                    break;
                }
            case R.id.button83:
                if (checked8) {
                    score8 = 0;
                    break;
                }
            case R.id.button84:
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
            case R.id.button91:
                if (checked9) {
                    score9 = 0;
                    break;
                }
            case R.id.button92:
                if (checked9) {
                    score9 = 10;
                    break;
                }
            case R.id.button93:
                if (checked9) {
                    score9 = 0;
                    break;
                }
            case R.id.button94:
                if (checked9) {
                    score9 = 0;
                    break;
                }
        }
    }

    public void onCheckedQuestion10(View view) {
        checked10 = mCheckBox101.isChecked() || mCheckBox102.isChecked() || mCheckBox103.isChecked() || mCheckBox104.isChecked();

        // Allowing user to select 1 checkbox and informs the user
        int maxChecked = 1;
        int noChecked = 0;

        LinearLayout layout = findViewById(R.id.layout_10);
        for (int i = 0; i < 4; i++) {
            CheckBox item = (CheckBox) layout.getChildAt(i);
            noChecked = item.isChecked() ? noChecked + 1 : noChecked;
        }

        if (noChecked >= maxChecked) {
            noteTextView10.setVisibility(View.VISIBLE);
            for (int i = 0; i < 4; i++) {
                CheckBox item = (CheckBox) layout.getChildAt(i);
                if (!item.isChecked()) {
                    item.setEnabled(false);
                }
            }
        } else {
            noteTextView10.setVisibility(View.INVISIBLE);
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
            if (mCheckBox42.isChecked() && mCheckBox43.isChecked()) {
                score4 = 10;
            } else if (mCheckBox42.isChecked() || mCheckBox43.isChecked()) {
                score4 = 5;
            }


            //  question 5
            if (answer5.toLowerCase().equals("java")) {
                score5 = 10;
            } else
                score5 = 0;


            //  question 6
            score6 = 0;
            if (mCheckBox64.isChecked()) {
                score6 = 10;
            } else {
                score6 = 0;
            }


            //  question 7
            score7 = 0;
            if (mCheckBox73.isChecked()) {
                score7 = 10;
            } else {
                score7 = 0;
            }


            //  question 10
            score10 = 0;
            if (mCheckBox101.isChecked()) {
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
        mCheckBox41.setChecked(false);
        mCheckBox42.setChecked(false);
        mCheckBox43.setChecked(false);
        mCheckBox44.setChecked(false);

        mCheckBox61.setChecked(false);
        mCheckBox62.setChecked(false);
        mCheckBox63.setChecked(false);
        mCheckBox64.setChecked(false);

        mCheckBox71.setChecked(false);
        mCheckBox72.setChecked(false);
        mCheckBox73.setChecked(false);
        mCheckBox74.setChecked(false);

        mCheckBox101.setChecked(false);
        mCheckBox102.setChecked(false);
        mCheckBox103.setChecked(false);
        mCheckBox104.setChecked(false);
    }

    // Enabling disabled checkboxes when reset button is clicked
    private void enableCheckBoxes() {
        mCheckBox41.setEnabled(true);
        mCheckBox42.setEnabled(true);
        mCheckBox43.setEnabled(true);
        mCheckBox44.setEnabled(true);

        mCheckBox61.setEnabled(true);
        mCheckBox62.setEnabled(true);
        mCheckBox63.setEnabled(true);
        mCheckBox64.setEnabled(true);

        mCheckBox71.setEnabled(true);
        mCheckBox72.setEnabled(true);
        mCheckBox73.setEnabled(true);
        mCheckBox74.setEnabled(true);

        mCheckBox101.setEnabled(true);
        mCheckBox102.setEnabled(true);
        mCheckBox103.setEnabled(true);
        mCheckBox104.setEnabled(true);
    }

    // Setting scrollview to stop scrolling to edit_text_q5 when the reset button is clicked
    public void noScroll() {
        ScrollView scroll = findViewById(R.id.no_Scroll);
        scroll.computeScroll();
    }

    // Hides Notes textview
    private void hideText() {
        noteTextView4.setVisibility(View.INVISIBLE);
        noteTextView6.setVisibility(View.INVISIBLE);
        noteTextView7.setVisibility(View.INVISIBLE);
        noteTextView10.setVisibility(View.INVISIBLE);
    }
}