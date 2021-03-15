package com.example.cashifygames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Otp extends AppCompatActivity implements View.OnClickListener {
    private EditText otpEditText;
    Button  doneButton,clickHereButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        //binding view Widget with object
        otpEditText=findViewById(R.id.otpOtp);
        doneButton=findViewById(R.id.otpDoneButton);

        //adding event to Buttons
        clickHereButton=findViewById(R.id.otpClickHereButton);
        doneButton.setOnClickListener(this);


    }
    //get Data from UI
     private String getDataFromUI()
     {
         return  otpEditText.getText().toString();
     }

     //making click event to Button
    @Override
    public void onClick(View view) {
        if (view==doneButton)
        {
            //otp will be checked
        }
        else if (view==clickHereButton)
        {

            //otp will be resent

        }

    }
    private  void checkingOTP()
    {
        //OTP  will be Checked
    }
}
