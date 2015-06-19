package in.itiffin.itiffin.ui;

import android.os.Bundle;

import in.itiffin.itiffin.MainActivity;
import in.itiffin.itiffin.R;
import in.itiffin.itiffin.custom.CustomActivity;

/**
 * Created by itiffin-it-01 on 13/6/15.
 */
public class Payment_Processing extends CustomActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_processing);
        finish();

    }
    @Override
    public void onBackPressed() {
        //
       // super.onBackPressed();
        //finish();


    }

}
