package Helper;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation
{
    // Function to check string is empty
    public static boolean isEmpty(String input)
    {
        if(input.equals("")) return true;
        else return false;
    }
    // Function to check string is proper length or not
    public static boolean isProperLength(String input,int length )
    {
        if(input.length()==length)
            return true;
        else
            return false;
    }
    // Function to check string is alphanumeric or not
    public static boolean isAlphaNumeric(String str)
    {
        // Regex to check string is alphanumeric or not.
        String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the string is empty
        // return false
        if (str == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given string
        // and regular expression.
        Matcher m = p.matcher(str);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }
    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((!str.equals(""))
                && (str != null)
                && (str.matches("^[a-zA-Z]*$")));
    }
    public static boolean isMinimumLength(String input,int length )
    {
        if(input.length()<=length)
            return true;
        else
            return false;
    }
    public static boolean isValidEmail(String email)
    {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.matches(emailPattern))
            return true;
            else
                return false;


    }

    public abstract static class TextValidator implements TextWatcher {
        private final TextInputLayout teamInputLayout;

        public TextValidator(TextInputLayout teamInputLayout) {
            this.teamInputLayout=teamInputLayout;
        }

        public abstract void validate(TextInputLayout teamInputLayout, String text);

        @Override
        final public void afterTextChanged(Editable s) {
            String text = teamInputLayout.getEditText().getText().toString().trim();
            validate(teamInputLayout, text);
        }

        @Override
        final public void beforeTextChanged(CharSequence s, int start, int count, int after) { /* Don't care */ }

        @Override
        final public void onTextChanged(CharSequence s, int start, int before, int count) { /* Don't care */ }
    }

}
