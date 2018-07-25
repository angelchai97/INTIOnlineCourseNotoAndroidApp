package com.example.asus.intionlinecoursenote;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Android_allquestion extends AppCompatActivity {

    private Button mtrueBtn;
    private Button mfalseBtn;
    private Button mNextBtn;

    private TextView mQuestion_textView;
    private static final String KEY_INDEX = "index";

    private Android_test[] mQuestion_bank = new Android_test[] {
            new Android_test(R.string.android_question1, false),
            new Android_test(R.string.android_question2, true),
            new Android_test(R.string.android_question3, false),
            new Android_test(R.string.android_question4, true),
            new Android_test(R.string.android_question5, false),
    };

    private int mCurrentIndex = 0;

    private void updateAndroidQuestion(){
        int androidQuestion = mQuestion_bank[mCurrentIndex].getText_id();
        mQuestion_textView.setText(androidQuestion);
    }
    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsCorrect = mQuestion_bank[mCurrentIndex].isAnswer_True();

        int answerMessageResId=0;
        if (userPressedTrue == answerIsCorrect){
            answerMessageResId =R.string.right_toast;
        }else{
            answerMessageResId =R.string.wrong_toast;
        }

        Toast.makeText(this,answerMessageResId, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_allquestion);

        mQuestion_textView = (TextView) findViewById(R.id.android_question_text_view);

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
                mCurrentIndex = (mCurrentIndex + 1)% mQuestion_bank.length;
                updateAndroidQuestion();
            }
        });

        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0);
        }
        updateAndroidQuestion();
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
