package in.itiffin.itiffin.model;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import in.itiffin.itiffin.Dao.GetData;
import in.itiffin.itiffin.Dao.Image;

/**
 * Created by Lingaraj on 19/5/2015.
 */
public class LoadData {

    final GetData getdb = new GetData();
    String data;
    static String[] urls;

    public LoadData(final String url) {
        final  GetData getdb = new GetData();
       new Thread(new Runnable() {
            public void run() {
                data = getdb.getDataFromDB(url);

                        ArrayList<Image> users = parseJSON(data);
                       //addData(users);
                    }
                }).start();


    }
    public ArrayList<Image> parseJSON(String result) {
        ArrayList<Image> users = new ArrayList<Image>();

        try {
            JSONArray jArray = new JSONArray(result);
            urls= new String[jArray.length()];
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                Image image = new Image();

                image.setName(json_data.getString("image_name"));
                image.setUrl(json_data.getString("image_url"));
                urls[i]=json_data.getString("image_url");
                System.out.println("imageurl"+urls[i]);
                users.add(image);

            }

        } catch (JSONException e) {
            //Log.e("log_tag", "Error parsing data " + e.toString());
        }
        return users;
    }

    public String[] getUrls()
    {
        return urls;
    }


}
