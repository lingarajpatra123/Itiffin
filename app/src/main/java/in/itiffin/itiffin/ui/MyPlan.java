package in.itiffin.itiffin.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

import in.itiffin.itiffin.R;
import in.itiffin.itiffin.custom.CustomActivity;

/**
 * Created by itiffin-it-01 on 10/6/15.
 */
public class MyPlan extends CustomActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.myplan1);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;

    }

}
