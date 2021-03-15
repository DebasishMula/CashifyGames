package com.example.cashifygames;

import Helper.Validation;
import PojoClasses.User;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class SignIn extends AppCompatActivity implements View.OnClickListener{
    private TextInputLayout mobileEditText,pinEditText;
    private Button signUpButton,logInButton,clickHereButton;
    private TextView fieldEmptyTextView;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //binding view Widget to Object
        mobileEditText=findViewById(R.id.signInMobile);
        pinEditText=findViewById(R.id.signInPin);
        fieldEmptyTextView=findViewById(R.id.signInFieldEmpty);
        logInButton=findViewById(R.id.signInLogInButton);
        signUpButton=findViewById(R.id.signInSignUpButton);
        clickHereButton=findViewById(R.id.signInClickHereButton);
        logInButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
        clickHereButton.setOnClickListener(this);

        mobileEditText.getEditText().addTextChangedListener(new Validation.TextValidator(mobileEditText) {
            @Override
            public void validate(TextInputLayout textInputLayout, String text) {
                if(!Validation.isProperLength(text,10))
                {
                    textInputLayout.setError("Mobile No Should be 10 Digits.");

                }
                else if(Validation.isEmpty(text))
                {
                    textInputLayout.setError("Field can't be empty");

                }
                else
                {
                    textInputLayout.setErrorEnabled(false);

                }
            }
        });
        pinEditText.getEditText().addTextChangedListener(new Validation.TextValidator(pinEditText) {
            @Override
            public void validate(TextInputLayout textInputLayout, String text) {
                if(Validation.isEmpty(text))
                {
                    textInputLayout.setError("Field can't be empty");

                }

                else if(!Validation.isProperLength(text,4))
                {

                    textInputLayout.setError(" Pin should be 4 Digits");
                }
                else
                {
                    textInputLayout.setErrorEnabled(false);

                }
            }
        });

    }

    //Getting Data from UI
    private User getDataFromUI()
    {
        user=new User();
        user.setMobile(mobileEditText.getEditText().getText().toString().trim());
        user.setPin(pinEditText. getEditText(). getText().toString().trim());

        return  user;

    }

    //validate Input Field
    private boolean validateInputField() {
        if( mobileEditText.getEditText().getText().toString().equals("")||pinEditText.getEditText().getText().toString().equals(""))
        {
            fieldEmptyTextView.setVisibility(View.VISIBLE);
            return false;
        }
        else
        {
            fieldEmptyTextView.setVisibility(View.GONE);
            return true;
        }
    }
    @Override
    public void onClick(View view) {
        if (view==logInButton)
        {
            //userSign method will be called
            userSignIn();

        }
        else if(view==signUpButton)
        {
            //Go to The signUp Activity
            startActivity(new Intent(getApplicationContext(),SignUp.class));
        }
        else if(view==clickHereButton)
        {
            //Forgot Pin Wil be Executed
            startActivity(new Intent(getApplicationContext(),ResetPin.class));
        }
    }

    private void userSignIn() {
        validateInputField();
        getDataFromUI();

        //signInCode will be Executed
    }

    //method to show custom toast
    private void customToastSuccess(String toastMessage)
    {
        LayoutInflater inflater=getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_success, (ViewGroup) findViewById(R.id.custom_toast_layout_success));
        TextView tv = (TextView) layout.findViewById(R.id.txtvw);
        tv.setText(toastMessage);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
