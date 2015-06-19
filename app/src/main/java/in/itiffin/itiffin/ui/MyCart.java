package in.itiffin.itiffin.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.itiffin.itiffin.Dao.GetData;
import in.itiffin.itiffin.MainActivity;
import in.itiffin.itiffin.R;
import in.itiffin.itiffin.custom.CustomActivity;

/**
 * Created by itiffin-it-01 on 10/6/15.
 */
public class MyCart extends CustomActivity{


    Intent intent;
    Bundle bundle1;
    Bundle bundle;
    String response;
    String result;
    private static final String LOGIN_URL = "http://mobilestage.itiffin.in:8080/myapp/cartresource/cart";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        bundle1 = getIntent().getExtras();
        bundle = new Bundle();
        bundle.putString("page", "mycart");
        setContentView(R.layout.mycart);
        setTouchNClick(R.id.btncallus4);
        setTouchNClick(R.id.btnmyplan4);
        setTouchNClick(R.id.btncheckout);
        setTouchNClick(R.id.btncontinueshopping);
        new CartItem().execute();

        GetData getData = new GetData();
        response=getData.getDataFromDB(LOGIN_URL);
        result=parseJSON(response);
        System.out.println("result" + result);


    }

    public String parseJSON(String result1) {

        String j="";
        try {
            JSONArray jArray = new JSONArray(result1);
            //for (int i = 0; i < jArray.length(); i++) {
            JSONObject json_data = jArray.getJSONObject(0);

            j=json_data.getString("qty");
            Log.v("json response", j);

        } catch (Exception e) {

        }
        finally {
            System.out.print("after return "+ j);
            return j;

        }
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        if(v.getId()==R.id.btncallus5)
        {
            String number = "09035617408";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));

        }
        if(v.getId()==R.id.btnmyplan4)
        {
            intent = new Intent(this, MyPlan.class);

        }
        if(v.getId()==R.id.btncontinueshopping)
        {
            intent = new Intent(this, Catalog.class);

        }
        if(v.getId()==R.id.btncheckout)

            intent = new Intent(this, login.class);

            intent.putExtras(bundle);
            startActivity(intent);
    }


    public boolean onOptionsItemSelected(MenuItem item){

       //onBackPressed();
        /*if(bundle1.getCharSequence("page").equals("Product_details")) {
            intent = new Intent(getApplicationContext(), Product_details.class);
        }
        if(bundle1.getCharSequence("page").equals("itiffin_home")) {
            intent = new Intent(getApplicationContext(), MainActivity.class);
        }
        if(bundle1.getCharSequence("page").equals("catalog")) {
            intent = new Intent(getApplicationContext(), Catalog.class);
        }
        startActivityForResult(intent,0);
        finish();*/

        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
       /* if(bundle1.getCharSequence("page").equals("Product_details")) {
            intent = new Intent(getApplicationContext(), Product_details.class);
        }
        if(bundle1.getCharSequence("page").equals("itiffin_home")) {
            intent = new Intent(getApplicationContext(), MainActivity.class);
        }
        if(bundle1.getCharSequence("page").equals("catalog")) {
            intent = new Intent(getApplicationContext(), Catalog.class);
        }
        startActivity(intent);
        finish();
*/
    }



    class CartItem extends AsyncTask<String, String, String> {
        /**
         * Before starting background thread Show Progress Dialog
         * */
        boolean failure = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
            // here Check for success tag



            try {

                final GetData getData = new GetData();

                response=getData.getDataFromDB(LOGIN_URL);

                result=parseJSON(response);

               System.out.println(result);
            }
            catch (Exception e)
            {
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

                j=json_data.getString("success");
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


        }
    }

}
