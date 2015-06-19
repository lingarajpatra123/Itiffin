package in.itiffin.itiffin.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.itiffin.itiffin.R;
import in.itiffin.itiffin.custom.CustomActivity;
import in.itiffin.itiffin.model.JSONParser;
import in.itiffin.itiffin.model.Validator;

/**
 * Created by user on 19-04-2015.
 */
public class signup extends CustomActivity {

    EditText txtname;
    EditText txtmobile;
    EditText txtemailid;
    EditText txtpassword;
    EditText txtretypepassword;
    String uname;
    String emailid;
    String mobile;
    String password;
    String cpassword;


    private static int RESULT_LOAD_IMAGE = 1;
    ImageView imgprofile;
    private ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();
    private static final String LOGIN_URL = "http://mobilestage.itiffin.in/user/register";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup);



        txtname = (EditText) findViewById(R.id.txtusername);
        txtemailid = (EditText) findViewById(R.id.txtemailid1);
        txtpassword = (EditText) findViewById(R.id.txtpassword1);
        txtmobile=(EditText)findViewById(R.id.txtmobile);
        txtretypepassword = (EditText) findViewById(R.id.txtretypepassword);
        //  imgprofile = (ImageView) findViewById(R.id.imgprofile);
        setTouchNClick(R.id.btnsave);


        //setTouchNClick(R.id.btnsignup);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        Validator validator = new Validator();
        uname=txtname.getText().toString();
        emailid=txtemailid.getText().toString();
        mobile=txtmobile.getText().toString();
        password=txtpassword.getText().toString();
        cpassword=txtretypepassword.getText().toString();

        if (v.getId() == R.id.btnsave) {
           // new AttemptSignUp().execute();

            if((validator.isEmpty(uname.length())==true) || (validator.isEmpty(emailid.length())==true)|| (validator.isEmpty(mobile.length())==true) || (validator.isEmpty(password.length())==true) || (validator.isEmpty(cpassword.length())==true))
                Toast.makeText(signup.this, "Field should not be blank", Toast.LENGTH_SHORT).show();
            else if(validator.validamail(emailid)==false)
                Toast.makeText(signup.this, "Enter Valid Mail Id", Toast.LENGTH_SHORT).show();
            else if(validator.minLength(6,password.length())==false)
                Toast.makeText(signup.this, "Minimum length of password is 6", Toast.LENGTH_SHORT).show();
            else if(validator.match(password,cpassword)==true)
                Toast.makeText(signup.this, "Password Not Matched", Toast.LENGTH_SHORT).show();
            else {
                startActivity(new Intent(this, login.class));
                finish();
            }

        }


    }

    class AttemptSignUp extends AsyncTask<String, String, String> {
        /**
         * Before starting background thread Show Progress Dialog
         */
        boolean failure = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(signup.this);
            pDialog.setMessage("Attempting for signup...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
            int success;
            uname = txtname.getText().toString();
            mobile = txtmobile.getText().toString();
            emailid = txtemailid.getText().toString();
            password = txtpassword.getText().toString();
            cpassword = txtretypepassword.getText().toString();




            try {

                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("name", uname));
                params.add(new BasicNameValuePair("mobile", mobile));
                params.add(new BasicNameValuePair("emailid", emailid));
                params.add(new BasicNameValuePair("password", password));
                params.add(new BasicNameValuePair("retypepassword", cpassword));

                Log.d("request!", "starting");

                JSONObject json = jsonParser.makeHttpRequest(
                        LOGIN_URL, "POST", params);

                // checking  log for json response
                Log.d("Login attempt", json.toString());

                // success tag for json
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("Success Prof Created!", json.toString());

                    Intent intent = new Intent(signup.this, confirmation.class);

                    // this finish() method is used to tell android os that we are done with current //activity now! Moving to other activity
                    startActivity(intent);
                    return json.getString(TAG_MESSAGE);
                } else {

                    return json.getString(TAG_MESSAGE);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String message) {
            pDialog.dismiss();
            if (message != null){
                Toast.makeText(signup.this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
