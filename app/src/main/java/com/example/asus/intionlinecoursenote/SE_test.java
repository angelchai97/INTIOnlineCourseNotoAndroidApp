package com.example.asus.intionlinecoursenote;

public class SE_test {
    private int SE_Test_id;
    private boolean SE_Answer_True;

    public SE_test (int textResId, boolean answerTrue){
        SE_Test_id = textResId;
        SE_Answer_True = answerTrue;
    }

    public int getText_id() {
        return SE_Test_id;
    }

    public void setText_id(int textResId) {
        SE_Test_id = textResId;
    }

    public boolean isAnswer_True() {
        return SE_Answer_True;
    }

    public void setAnswer_True(boolean answerTrue) {
        SE_Answer_True = answerTrue;
    }
}

