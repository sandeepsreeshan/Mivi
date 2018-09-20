package com.sandeep.mivi.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sandeep.mivi.R;
import com.sandeep.mivi.model.CollectionResponse;

import java.io.IOException;
import java.io.InputStream;

import static com.sandeep.mivi.utils.Utils.isValidEmail;
import static com.sandeep.mivi.utils.Utils.validateEditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etEmail, etPassword;
    Button btnSubmit;
    CollectionResponse collectionResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        handleEvents();


    }

    private void handleEvents() {
        String json = loadJSONFromAsset();
        Gson gson = new Gson();
        collectionResponse = gson.fromJson(json, CollectionResponse.class);
        btnSubmit.setOnClickListener(this);

    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("collection.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void doLogin() {

        if (validateEditText(etEmail, getApplicationContext()))
            if (validateEditText(etPassword, getApplicationContext()))
                if (isValidEmail(etEmail.getText().toString()))
                    postLogin();
                else
                    etEmail.setError("Email Not Valid");
            else
                etPassword.setError("Enter Password");
        else
            etEmail.setError("Enter Email");
    }

    private void postLogin() {
        if (etEmail.getText().toString().equals(collectionResponse.getData().getAttributes().getEmailAddress()) &&
                etPassword.getText().toString().equals("123456")) {
            Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
            startActivity(intent);
            finish();

        }else {
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }


    }

    private void initViews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:
                doLogin();

                break;

        }
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        View view = getCurrentFocus();
        boolean ret = super.dispatchTouchEvent(event);

        if (view instanceof EditText) {
            View w = getCurrentFocus();
            int scrcoords[] = new int[2];
            w.getLocationOnScreen(scrcoords);
            float x = event.getRawX() + w.getLeft() - scrcoords[0];
            float y = event.getRawY() + w.getTop() - scrcoords[1];

            if (event.getAction() == MotionEvent.ACTION_UP
                    && (x < w.getLeft() || x >= w.getRight()
                    || y < w.getTop() || y > w.getBottom())) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        }
        return ret;
    }
}
