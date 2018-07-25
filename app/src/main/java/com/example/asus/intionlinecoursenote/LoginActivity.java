package com.example.asus.intionlinecoursenote;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
// UI references.
    private EditText mPasswordView,mUsernameView;
    private View mProgressView;
    private View mLoginFormView;

    public final static String MESSAGE_KEY ="com.example.asus.intionlinecoursenote.message_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mUsernameView = (EditText) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);



        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                String UserName = mUsernameView.getText().toString();
                String Pwd = mPasswordView.getText().toString();
                if(UserName.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Sorry,User Name cannot be empty.", Toast.LENGTH_LONG).show();
                }
                else if(Pwd.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Sorry,Password cannot be empty.", Toast.LENGTH_LONG).show();
                }
                else if (UserName.equalsIgnoreCase("student001") && Pwd.equals("std001")) {
                    Intent MainIntent = new Intent(LoginActivity.this, Student_Navigation.class);
                    startActivity(MainIntent);
                    Toast.makeText(LoginActivity.this, "You are Sign in Successfuly.", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(LoginActivity.this, "Sorry,User Name or Password is incorrect.", Toast.LENGTH_LONG).show();
                }

            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }
}

