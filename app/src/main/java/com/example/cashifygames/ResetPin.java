package com.example.cashifygames;

import PojoClasses.User;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResetPin extends AppCompatActivity implements View.OnClickListener {
    private EditText mobileEditText,pinEditText;
    private Button resetPinButton,signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pin);

        //finding view Widget to Object
        mobileEditText=findViewById(R.id.resetPinMobile);
        resetPinButton=findViewById(R.id.resetPinResetPinButton);
        signUpButton=findViewById(R.id.resetPinSignUpButton);

        //adding OnclickEvent
        resetPinButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);


    }

    //getData From UI
    private String getDataFromUI()
    {


        return  mobileEditText.getText().toString();
    }

    @Override
    public void onClick(View view) {
        if (view==resetPinButton)
        {
            //pin will be Reset

        }
        else if(view==signUpButton)
        {
            startActivity(new Intent(getApplicationContext(),SignUp.class));

        }

    }
}
