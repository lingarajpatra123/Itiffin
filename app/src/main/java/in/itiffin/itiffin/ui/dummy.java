package in.itiffin.itiffin.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import in.itiffin.itiffin.Dao.GetData;
import in.itiffin.itiffin.Dao.GetImage;
import in.itiffin.itiffin.Dao.Image;
import in.itiffin.itiffin.R;
import in.itiffin.itiffin.custom.CustomActivity;

/**
 * Created by user on 24-04-2015.
 */
public class dummy extends CustomActivity {

/*
    String data = "";
    TableLayout tl;
    TableRow tr;
    Button button;
    String url="http://mobilestage.itiffin.in/MyProject/getimages.php";
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.v("ADebugTag", "MainActivity:onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummy);

        tl = (TableLayout) findViewById(R.id.maintable);

        //final GetImage getdb = new GetImage();



        final  GetData getdb = new GetData();
        new Thread(new Runnable() {
            public void run() {
                data = getdb.getDataFromDB(url);
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        ArrayList<Image> users = parseJSON(data);
                        addData(users);
                    }
                });

            }
        }).start();
    }

    public ArrayList<Image> parseJSON(String result) {
        ArrayList<Image> users = new ArrayList<Image>();
        try {
            JSONArray jArray = new JSONArray(result);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                Image image = new Image();

                image.setName(json_data.getString("image_name"));
                image.setUrl(json_data.getString("image_url"));
                users.add(image);
            }
        } catch (JSONException e) {
            //Log.e("log_tag", "Error parsing data " + e.toString());
        }
        return users;
    }

    void addHeader(){
        */
/** Create a TableRow dynamically **//*

        tr = new TableRow(this);

        */
/** Creating a Button to add to the row **//*

        button = new Button(this);
        button.setText("Name");
        button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,


        TableRow.LayoutParams.WRAP_CONTENT));
        button.setPadding(5, 5, 5, 5);
        button.setBackgroundColor(Color.RED);
        LinearLayout Ll = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(5, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(button,params);
        tr.addView((View)Ll); // Adding Button to tablerow.

        */
/** Creating Qty Button **//*

        Button place = new Button(this);
        place.setText("URL");
        place.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        place.setPadding(5, 5, 5, 5);
        place.setBackgroundColor(Color.RED);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(place,params);
        tr.addView((View)Ll); // Adding Button to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));
    }

    @SuppressWarnings({ "rawtypes" })
    public void addData(ArrayList<Image> users) {

        addHeader();

            for (Iterator i = users.iterator(); i.hasNext();) {

                Image p = (Image) i.next();

            */
/** Create a TableRow dynamically **//*

            tr = new TableRow(this);

            */
/** Creating a Button to add to the row **//*

            button = new Button(this);
            button.setText(p.getName());
            // button.setText(p.getPlace());
            button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            button.setPadding(5, 5, 5, 5);
            button.setBackgroundColor(Color.GRAY);

            LinearLayout Ll = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(button,params);
            tr.addView((View)Ll); // Adding Button to tablerow.

            */
/** Creating Qty Button **//*

            Button place = new Button(this);
            place.setText(p.getUrl());
            place.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            place.setPadding(5, 5, 5, 5);
            place.setBackgroundColor(Color.GRAY);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(place,params);
            tr.addView((View)Ll); // Adding Button to tablerow.

            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
        }
    }
*/
}
