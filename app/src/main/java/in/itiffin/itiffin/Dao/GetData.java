package in.itiffin.itiffin.Dao;


/**
 * Created by Lingaraj on 22/4/2015.
 */
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GetData {

    public GetData() {
        Log.v("ADebugTag", "GetDataFromDB()");

    }

    public String getDataFromDB(List<NameValuePair> params,String url) {
        HttpPost httppost;
        HttpClient httpclient;
        String response = null;
        InputStream inputStream = null;
        HttpEntity entity=null;
        Log.v("ADebugTag", "Before HttpPost");
        try {

            /**
             * Post the request
             */
            httpclient = new DefaultHttpClient();
            httppost = new HttpPost(url); // change this to your URL.....
            //httppost.addHeader(BasicScheme.authenticate(new UsernamePasswordCredentials("stageitiffin", "Itiffinadmin"),"UTF-8", false));
            Log.v("ADebugTag", "After HttpPost");


            httppost.setEntity(new UrlEncodedFormEntity(params));

            HttpResponse httpResponse = httpclient.execute(httppost);
            Log.v("ADebugTag1", httpResponse.toString());

            entity = httpResponse.getEntity();
            //final String response = httpclient.execute(httppost,responseHandler);
            //response = EntityUtils.toString(entity);
            inputStream = entity.getContent();
//            Log.v("ADebugTag2", response.toString());

            ///return response.trim();

        } catch (Exception e) {
            Log.e("Log tag", "Error in http connection" + e.toString());
            //return "error";
        }
        /**
         * Convert response to string
         */

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
            inputStream.close();

            response = sb.toString();
        } catch (Exception exception) {
            Log.e("log_tag", "Error converting result " + exception.toString());
        }
        /**
         * Parse json data
         *
         */
        return response;

    }

    public String getDataFromDB(String str) {
        HttpGet httppost;
        HttpClient httpclient;
        String response = null;
        InputStream inputStream = null;
        HttpEntity entity=null;
        Log.v("ADebugTag", "Before HttpPost");
        try {

            /**
             * Post the request
             */
            httpclient = new DefaultHttpClient();
            httppost = new HttpGet(str); // change this to your URL.....
           // httppost.addHeader(BasicScheme.authenticate(new UsernamePasswordCredentials("stageitiffin", "Itiffinadmin"), "UTF-8", false));
            Log.v("ADebugTag", "After HttpPost");
            //httppost.setEntity(new UrlEncodedFormEntity(params));

    /* ResponseHandler<String> responseHandler = new BasicResponseHandler();
     Log.v("ADebugTag1", responseHandler.toString());*/
            HttpResponse httpResponse = httpclient.execute(httppost);
            Log.v("ADebugTag1", httpResponse.toString());
            entity = httpResponse.getEntity();
            //final String response = httpclient.execute(httppost,responseHandler);
            response = EntityUtils.toString(entity);
            inputStream = entity.getContent();
            /*Log.v("ADebugTag2", response.toString());

            return response.trim();*/

        } catch (Exception e) {
            Log.e("Log tag", "Error in http connection" + e.toString());
            //return "error";
        }
        /**
         * Convert response to string
         */

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
            inputStream.close();

            response = sb.toString();
        } catch (Exception exception) {
            Log.e("log_tag", "Error converting result " + exception.toString());
        }
        /**
         * Parse json data
         *
         */
        return response;

    }
}

