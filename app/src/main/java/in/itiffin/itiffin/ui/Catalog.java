package in.itiffin.itiffin.ui;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import in.itiffin.itiffin.Dao.Image;
import in.itiffin.itiffin.MainActivity;
import in.itiffin.itiffin.R;
import in.itiffin.itiffin.custom.CustomActivity;
import in.itiffin.itiffin.custom.CustomFragment;
import in.itiffin.itiffin.model.LazyImageLoadAdapter;

/**
 * Created by Lingaraj on 11/5/2015.
 */
public class Catalog extends CustomActivity{
    ListView list;
    LazyImageLoadAdapter adapter;
    ConnectionDetector connectionDetector;
    Bundle bundle ;
    Bundle b1;
    Intent intent;
    ImageView button1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        bundle =new Bundle();
        bundle.putString("page", "catalog");
        b1=getIntent().getExtras();
        button1=(ImageView)findViewById(R.id.filter1);
/*
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Catalog.this, button1);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_popup, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(Catalog.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });//closing the setOnClickListener method
*/

        connectionDetector= new ConnectionDetector(getApplicationContext());
        if (!connectionDetector.isConnectingToInternet())
        {
            setContentView(R.layout.connectionerror);
            //Toast.makeText(getApplicationContext(), "please connect to internet", Toast.LENGTH_SHORT).show();

            return;
        }

        setContentView(R.layout.product_listing);


        list=(ListView)findViewById(R.id.list);

        // Create custom adapter for listview
        adapter=new LazyImageLoadAdapter(this, mStrings);

        //Set adapter to listview
        list.setAdapter(adapter);

       /*Button b=(Button)findViewById(R.id.btnaddtokart);
       b.setOnClickListener(listener);*/

    }


    @Override
    public void onDestroy()
    {
        // Remove adapter refference from list
        list.setAdapter(null);
        super.onDestroy();
    }

   /* public View.OnClickListener listener=new View.OnClickListener(){
        @Override
        public void onClick(View arg0) {

            //Refresh cache directory downloaded images
            adapter.imageLoader.clearCache();
            adapter.notifyDataSetChanged();
        }
    };*/





    public void onItemClick(int mPosition)
    {
        String tempValues = mStrings[mPosition];

       /* Toast.makeText(this,
                "Image URL : " + tempValues,
                Toast.LENGTH_LONG)
                .show();*/
        intent= new Intent(this, Product_details.class);
        intent.putExtras(bundle);
        startActivity(intent);

      //  finish();


    }



    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);
      /*  RelativeLayout badgeLayout = (RelativeLayout) menu.findItem(R.id.action_notification).getActionView();
        TextView tv = (TextView) badgeLayout.findViewById(R.id.hotlist_hot);
        tv.setText("12");
        tv.setBackgroundDrawable(null);*/


        return true;
    }


  /*  @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //return super.onMenuItemSelected(featureId, item);
        switch (item.getItemId())
        {
            case R.id.action_cart:
                new MyCart();
                return true;
            case R.id.action_notification:
                new Notification();
                return true;
            default:return super.onMenuItemSelected(featureId, item);


        }
    }
*/

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if(v.getId()==R.id.action_notification1)
            intent=new Intent(this,Notification.class);

        if(v.getId()==R.id.btncallus1) {
            String number = "09035617408";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
        }
        if(v.getId()==R.id.btnmyplan) {
            intent=new Intent(this,MyPlan.class);

        }


        intent.putExtras(bundle);
        startActivity(intent);

    }

    /*public boolean onOptionsItemSelected(MenuItem item){

        b1=getIntent().getExtras();




        intent=new Intent(this,MainActivity.class);
        startActivityForResult(intent, 0);
        finish();
        return true;

        *//*switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return  true;
*//*

    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {

                intent=new Intent(this,MainActivity.class);
                startActivityForResult(intent, 0);
                finish();
                return true;

            }
            default:
                return super.onOptionsItemSelected(item);

        }
    }



    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        intent=new Intent(this,MainActivity.class);
        startActivityForResult(intent, 0);
        finish();
    }

    // Image urls used in LazyImageLoadAdapter.java file

    private String[] mStrings={
            "http://mobilestage.itiffin.in/image1/500_kcal_nv.png",
            "http://mobilestage.itiffin.in/image1/500_kcal_nv1.png",
            "http://mobilestage.itiffin.in/image1/500_kcal_nv_2.png",
            "http://mobilestage.itiffin.in/image1/500_kcal_nv_2_1.png",
            "http://mobilestage.itiffin.in/image1/500_kcal_nv_2_2.png",
            "http://mobilestage.itiffin.in/image1/500_kcal_nv_2_3.png",
            "http://mobilestage.itiffin.in/image1/500_kcal_nv_2_4.png",

    };
}