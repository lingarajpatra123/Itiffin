package in.itiffin.itiffin.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;

import in.itiffin.itiffin.R;
import in.itiffin.itiffin.custom.CustomActivity;

/**
 * Created by user on 21-05-2015.
 */
public class Product_details extends CustomActivity {

    Bundle bundle ;
    Bundle b1;
    Intent intent;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getActionBar().setDisplayHomeAsUpEnabled(true);

        bundle = new Bundle();
        bundle.putString("page", "product_details");
        b1=getIntent().getExtras();

        ratingBar=(RatingBar)findViewById(R.id.MyRating);


        setContentView(R.layout.product_details1);

       /* ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                String rateValue = String.valueOf(ratingBar.getRating());
                System.out.println("Rate for Module is" + rateValue);
            }
        });*/
        // setTouchNClick(R.id.btnordernow);
        setTouchNClick(R.id.btnaddkart1);
        setTouchNClick(R.id.btncallus4);
        setTouchNClick(R.id.btnmyplan3);
        setTouchNClick(R.id.btnaddkart1);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);

        if(v.getId()==R.id.btncallus4)
        {
            String number = "09035617408";
            intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
        }
        if(v.getId()==R.id.btnmyplan3)
        {
            intent = new Intent(this,MyPlan.class);

        }
        if(v.getId()==R.id.btnaddkart1)
        {
            intent = new Intent(this,MyCart.class);

        }
        intent.putExtras(bundle);
        startActivity(intent);

    }


    public boolean onOptionsItemSelected(MenuItem item) {

      /* if(b1.getCharSequence("page").equals("catalog")) {
            intent = new Intent(getApplicationContext(), Catalog.class);
        }

        startActivityForResult(intent,1);
        finish();*/
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case R.id.action_cart: {
                intent = new Intent(this, MyCart.class);
                bundle.putString("next_page", "MyCart.class");
                intent.putExtras(bundle);
                startActivity(intent);
                return true;
            }
            case R.id.action_notification: {

                intent = new Intent(this, Notification.class);
                startActivity(intent);
                return true;
            }


            case R.id.action_login: {


                intent = new Intent(this, login.class);
                intent.putExtras(bundle);
                startActivity(intent);
                return true;
            }
            case R.id.myplan: {
                intent = new Intent(this, MyPlan.class);
                startActivity(intent);
                return true;
            }
            case android.R.id.home: {
                NavUtils.navigateUpFromSameTask(this);
                return true;
            }
        }
            return true;


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        /*intent = new Intent(this, Catalog.class);
        startActivity(intent);
        finish();*/

    }
}
