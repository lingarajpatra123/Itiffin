package in.itiffin.itiffin.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.view.MenuItem;
import android.view.View;

import in.itiffin.itiffin.R;
import in.itiffin.itiffin.custom.CustomActivity;

/**
 * Created by itiffin-it-01 on 13/6/15.
 */
public class Checkout extends CustomActivity {

    Bundle bundle;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getIntent().getExtras();
        bundle = new Bundle();
        bundle.putString("page","Checkout");

        setContentView(R.layout.shipping);
        setTouchNClick(R.id.btncallus6);
        setTouchNClick(R.id.btnmyplan5);
        setTouchNClick(R.id.btnpaynow);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        if(v.getId()==R.id.btncallus6)
        {
            String number = "09035617408";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));


        }
        if(v.getId()==R.id.btnmyplan5)
        {
            intent = new Intent(this,MyPlan.class);
        }

        if(v.getId()==R.id.btnpaynow)
            intent = new Intent(this,Payment_Gateway.class);
            intent.putExtras(bundle);
            startActivity(intent);

    }


    public boolean onOptionsItemSelected(MenuItem item){

       /* if(bundle.getCharSequence("page").equals("mycart")) {
            intent = new Intent(getApplicationContext(), MyCart.class);
        }

        startActivityForResult(intent,0);
        // finish();
        return true;*/


        switch (item.getItemId()) {
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

    }

}
