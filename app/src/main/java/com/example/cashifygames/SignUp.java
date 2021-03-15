package com.example.cashifygames;

import PojoClasses.*;
import Helper.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;


public class SignUp extends AppCompatActivity  implements View.OnClickListener  {
    private TextInputLayout teamNameEditText,mobileEditText,pinEditText;
    private TextView fieldEmptyTextView;
    private Button signUpButton,logInButton;
    private  User user;
    private ConnectivityManager connectivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        //binding Widget With to Object
        teamNameEditText=findViewById(R.id.signUpTeamName);
        mobileEditText=findViewById(R.id.signUpMobile);
        pinEditText=findViewById(R.id.signUpPin);
        fieldEmptyTextView=findViewById(R.id.signUpFieldEmpty);
        signUpButton=findViewById(R.id.signUpsignUpButton);

        logInButton=findViewById(R.id.signUpLogInButton);



        //adding OnClick Event
        signUpButton.setOnClickListener(this);
        logInButton.setOnClickListener(this);


        teamNameEditText.getEditText().addTextChangedListener(new Validation.TextValidator(teamNameEditText)
        {

            @Override
            public void validate(TextInputLayout textInputLayout, String text) {
                if(Validation.isEmpty(text)) {

                    textInputLayout.setError("Field can't be empty");
                   // signUpButton.setEnabled(false);
                }
                else if(!Validation.isMinimumLength(text,10))
                {
                    textInputLayout.setError("Max Team Name size is 10");
                   // signUpButton.setEnabled(false);
                }
                else if(!(Validation.isStringOnlyAlphabet(text)||Validation.isAlphaNumeric(text)))
                {
                    textInputLayout.setError("Team Should be Text or Alpha Numeric");
                   // signUpButton.setEnabled(false);
                }
                else
                {
                    textInputLayout.setErrorEnabled(false);
                    fieldEmptyTextView.setVisibility(View.GONE);

                }
            }
        });
        mobileEditText.getEditText().addTextChangedListener(new Validation.TextValidator(mobileEditText) {
            @Override
            public void validate(TextInputLayout textInputLayout, String text) {
                 if(Validation.isEmpty(text))
                {
                    textInputLayout.setError("Field can't be empty");

                }
                else if(!Validation.isProperLength(text,10))
                {
                    textInputLayout.setError("Mobile No Should be 10 Digits.");

                }

                else
                {
                    textInputLayout.setErrorEnabled(false);
                    fieldEmptyTextView.setVisibility(View.GONE);

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
                    fieldEmptyTextView.setVisibility(View.GONE);

                }
            }
        });


    }


    @Override
    public void onClick(View view) {

        if (view == signUpButton) {

            //userSignUp method to be called
            userSignUp();


        } else if (view == logInButton) {

            //Go to the SignIn Activity
            startActivity(new Intent(this, SignIn.class));

        }
    }

    //Getting Data from UI
    private User getDataFromUI()
    {
        user= new User(teamNameEditText.getEditText().getText().toString().trim(),mobileEditText.getEditText().getText().toString().trim(),pinEditText.getEditText().getText().toString().trim());
        return user;




    }
    //validate Input Field
    private  boolean validateInputField() {
     if(teamNameEditText.getEditText().getText().toString().equals("") || mobileEditText.getEditText().getText().toString().equals("")||pinEditText.getEditText().getText().toString().equals(""))
     {
         fieldEmptyTextView.setVisibility(View.VISIBLE);
         return false;
     }
     else if(teamNameEditText.isErrorEnabled()||mobileEditText.isErrorEnabled()||pinEditText.isErrorEnabled())
     {
         fieldEmptyTextView.setVisibility(View.GONE);
         return false;
     }
     else
     {
         fieldEmptyTextView.setVisibility(View.GONE);
         return true;
     }


    }

   //sign up method
    private void userSignUp()
    {
        //SignUpCode will be executed
       // validateInputField();
        //getDataFromUI();
        //getDataFromUI();
        if(!checkingInternetStatus())
        {
            Snackbar.make(findViewById(R.id.signUpUser),"No Internet Connection..",Snackbar.LENGTH_LONG).show();
        }
        else if(validateInputField())
        {
            customToastSuccess("     Sign Up Successful     ");
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


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
    //method
    private boolean checkingInternetStatus()
    {
        connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null)
        {
            return  true;
        }
        else return false;
    }
}
