package com.example.asus.intionlinecoursenote;

public class Android_test {
    private int Android_Test_id;
    private boolean Android_Answer_True;

    public Android_test (int textResId, boolean answerTrue){
        Android_Test_id = textResId;
        Android_Answer_True = answerTrue;
    }

    public int getText_id() {
        return Android_Test_id;
    }

    public void setText_id(int textResId) {
        Android_Test_id = textResId;
    }

    public boolean isAnswer_True() {
        return Android_Answer_True;
    }

    public void setAnswer_True(boolean answerTrue) {
        Android_Answer_True = answerTrue;
    }
}
