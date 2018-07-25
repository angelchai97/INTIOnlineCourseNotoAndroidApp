package com.example.asus.intionlinecoursenote;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SE_allquestion extends AppCompatActivity {

    private Button mtrueBtn;
    private Button mfalseBtn;
    private Button mNextBtn;

    private TextView mQuestion_textView;
    private static final String KEY_INDEX = "index";

    private SE_test[] mQuestion_Bank = new SE_test[] {
            new SE_test(R.string.se_question1, true),
            new SE_test(R.string.se_question2, false),
            new SE_test(R.string.se_question3, false),
            new SE_test(R.string.se_question4, false),
            new SE_test(R.string.se_question5, true),
    };

    private int mCurrentIndex = 0;

    private void updateSEQuestion(){
        int SEQuestion = mQuestion_Bank[mCurrentIndex].getText_id();
        mQuestion_textView.setText(SEQuestion);
    }
    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsCorrect = mQuestion_Bank[mCurrentIndex].isAnswer_True();

        int SEMessageResId=0;
        if (userPressedTrue == answerIsCorrect){
            SEMessageResId =R.string.right_toast;
        }else{
            SEMessageResId =R.string.wrong_toast;
        }

        Toast.makeText(this,SEMessageResId, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_se_allquestion);

        mQuestion_textView = (TextView) findViewById(R.id.se_question_text_view);

        mtrueBtn = (Button) findViewById(R.id.true_button);
        mtrueBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(true);
            }

        });
        mfalseBtn = (Button) findViewById(R.id.false_button);
        mfalseBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(false);
            }

        });

        mNextBtn = (Button) findViewById(R.id.next_button);
        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1)% mQuestion_Bank.length;
                updateSEQuestion();
            }
        });

        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0);
        }
        updateSEQuestion();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode != Activity.RESULT_OK){
            return;
        }

    }
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }
}
