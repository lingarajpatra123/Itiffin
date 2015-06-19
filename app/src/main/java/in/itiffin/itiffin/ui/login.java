package in.itiffin.itiffin.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.itiffin.itiffin.Dao.GetData;
import in.itiffin.itiffin.R;
import in.itiffin.itiffin.custom.CustomActivity;
import in.itiffin.itiffin.model.JSONParser;
import in.itiffin.itiffin.model.Validator;

/**
 * Created by user on 19-04-2015.
 */
public class login extends CustomActivity {

    EditText txtemailid;
    EditText txtpassword;
    private ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();
    private static final String LOGIN_URL = "http://mobilestage.itiffin.in:8080/myapp/login";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    String response;
    String result;
    int j;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    Bundle bundle;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bundle= getIntent().getExtras();

        setContentView(R.layout.login);
        txtemailid=(EditText)findViewById(R.id.txtemailid);
        txtpassword=(EditText)findViewById(R.id.txtpassword);


        setTouchNClick(R.id.btnlogin);
        setTouchNClick(R.id.btnsignup);
    }
    @Override
    public void onClick(View v) {
        super.onClick(v);

        Bundle bundle=getIntent().getExtras();
        Validator validator = new Validator();
        if(v.getId()==R.id.btnlogin) {
            String semail, spassword;
            semail = txtemailid.getText().toString();
            spassword = txtpassword.getText().toString();

            if((validator.isEmpty(semail.length())==true ) || (validator.isEmpty(spassword.length())==true ))
                Toast.makeText(login.this, "Field should not be blank", Toast.LENGTH_SHORT).show();
            else if(validator.validamail(semail)==false)
                Toast.makeText(login.this, "Enter valid mail", Toast.LENGTH_SHORT).show();

            else {
                new AttemptLogin().execute();
                //intent = new Intent(this,Checkout.class);
                //startActivity(intent);
                //finish();


            }
        }



       if(v.getId()==R.id.btnsignup)
        {

                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
                finish();

        }
    }


    public boolean onOptionsItemSelected(MenuItem item){

       /* if(bundle.getCharSequence("page").equals("mycart")) {
            intent = new Intent(getApplicationContext(), MyCart.class);
        }

        startActivityForResult(intent,0);
        // finish();
        return true;*/


       /* switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                                    // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }
        return  super.onOptionsItemSelected(item);
*/

        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }


    class AttemptLogin extends AsyncTask<String, String, String> {
        /**
         * Before starting background thread Show Progress Dialog
         * */
                boolean failure = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(login.this);
            pDialog.setMessage("Attempting for login...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
            // here Check for success tag


            String username = txtemailid.getText().toString();
            String password = txtpassword.getText().toString();
            try {

                final List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("username", username));
                params.add(new BasicNameValuePair("password", password));

                Log.v(username,password);
                final GetData getData = new GetData();
                        System.out.println("Background");
                        response=getData.getDataFromDB(params,LOGIN_URL);

                      result=parseJSON(response);

              if (result.equals("0")==true) {
                    Log.d("Successfully Login!","");

                    Intent intent = new Intent(login.this,confirmation.class);
                    startActivity(intent);
                    finish();
                   // return json.getString(TAG_MESSAGE);
                }
               else{
                        Toast.makeText(login.this,"Invalie Username and password",Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e)
            {
                System.out.print(j);
                e.printStackTrace();
            }

            return null;
        }

        public String parseJSON(String result1) {

          String j="";
            try {
                JSONArray jArray = new JSONArray(result1);
                //for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json_data = jArray.getJSONObject(0);

                     j=json_data.getString("statusCode");
                     Log.v("json response",j);

            } catch (Exception e) {

            }
            finally {
                System.out.print("after return "+ j);
                return j;

            }
           }
        /**
         * Once the background process is done we need to  Dismiss the progress dialog asap
         * **/
        protected void onPostExecute(String message) {

            pDialog.dismiss();
            if (message != null){
                Toast.makeText(login.this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}