package in.itiffin.itiffin.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by itiffin-it-01 on 16/6/15.
 */
public class Validator {

    public boolean isEmpty(int i)
    {
        if (i==0)
            return true;
        return false;
    }
    public boolean match(String string1, String string2)
    {
        if (string1.equals(string2)==false)
        return  true;
        return false;
    }
    public  boolean validamail(String mail)
    {
        String  Email_Pattern=(

                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$");
        Pattern pattern= Pattern.compile(Email_Pattern);
        Matcher matcher=pattern.matcher(mail);
        return matcher.matches();


    }
    public  boolean minLength(int minlength,int inputlength)
    {
        if(inputlength<minlength)
        return false;
        return true;
    }
    public  boolean maxLength(int maxlength,int inputlength)
    {
        if (inputlength>maxlength)
        return  false;
        return true;
    }

}
