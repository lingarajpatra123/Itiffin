package in.itiffin.itiffin.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.itiffin.itiffin.MainActivity;
import in.itiffin.itiffin.R;
import in.itiffin.itiffin.custom.CustomFragment;

/**
 * Created by user on 20-04-2015.
 */
public class itiffin_home extends CustomFragment {

    Intent i;
    ImageView imageView;
    Bundle bundle;

    private int hot_number = 0;
    private TextView ui_hot = null;
    Menu menu ;
    private static final String TAG_SUCCESS = "success";
    ConnectionDetector connectionDetector;



    private static final String TA0G_MESSAGE = "message";

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bundle= new Bundle();
        bundle.putString("page", "itiffin_home");

        View v = inflater.inflate(R.layout.itiffin_home, null);
        setHasOptionsMenu(true);
      //  setContentView(R.layout.itiffin_home);


       connectionDetector= new ConnectionDetector(getActivity());
        if (!connectionDetector.isConnectingToInternet())
        {
             v = inflater.inflate(R.layout.connectionerror,null);

            //Toast.makeText(getApplicationContext(), "please connect to internet", Toast.LENGTH_SHORT).show();

            return v;
        }

        //  tl = (TableLayout) findViewById(R.id.maintable);


        setTouchNClick(v.findViewById(R.id.imglunch));
        setTouchNClick(v.findViewById(R.id.imgdinner));
        setTouchNClick(v.findViewById(R.id.imgsalad));
        setTouchNClick(v.findViewById(R.id.imgicuisine));
        setTouchNClick(v.findViewById(R.id.imgccusine));
        setTouchNClick(v.findViewById(R.id.imgiatta));
        setTouchNClick(v.findViewById(R.id.imgmbox));
        setTouchNClick(v.findViewById(R.id.imgwmeals));
        setTouchNClick(v.findViewById(R.id.imgdmeals));
        setTouchNClick(v.findViewById(R.id.btncallus));
        setTouchNClick(v.findViewById(R.id.btnmyplan2));

       // return  v;


       // Button b=(Button)v.findViewById(R.id.button1);
        //b.setOnClickListener(listener);
        return  v;
    }



    @Override
    public void onClick(View v) {
        super.onClick(v);




        if(v.getId()==R.id.imglunch) {
             i = new Intent(getActivity(),  Catalog.class);


            // finish();
        }
        if(v.getId()==R.id.imgdinner) {
            i = new Intent(getActivity(), Catalog.class);

            //    finish();
        }
        if(v.getId()==R.id.imgsalad) {
             i = new Intent(getActivity(), Catalog.class);

            //   finish();
        }
        if(v.getId()==R.id.imgicuisine) {
             i = new Intent(getActivity(), Catalog.class);

            //   finish();
        }
        if(v.getId()==R.id.imgccusine) {
             i = new Intent(getActivity(), Catalog.class);

            //   finish();
        }
        if(v.getId()==R.id.imgiatta) {
             i = new Intent(getActivity(), Catalog.class);

            //   finish();
        }
        if(v.getId()==R.id.imgmbox) {
             i = new Intent(getActivity(), Catalog.class);

            //   finish();
        }
        if(v.getId()==R.id.imgwmeals) {
             i = new Intent(getActivity(), Catalog.class);

            //   finish();
        }
        if(v.getId()==R.id.imgdmeals) {
             i = new Intent(getActivity(), Catalog.class);

            //   finish();
        }
        if(v.getId()==R.id.btncallus)
        {
            String number = "09035617408";
            i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel:" + number));

        }
        if(v.getId()==R.id.btnmyplan2)
        {

            i= new Intent(getActivity(),MyPlan.class);

        }

        i.putExtras(bundle);
        startActivity(i);
      //  getActivity().finish();
    }


    /*@Override
    public void onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);
        RelativeLayout badgeLayout = (RelativeLayout) menu.findItem(R.id.action_notification).getActionView();
        TextView tv = (TextView) badgeLayout.findViewById(R.id.hotlist_hot);
        tv.setText("12");
    }*/
   /* @Override
    public void onBackPressed(int i) {
        //
         super.onBackPressed(i);



    }*/
}
