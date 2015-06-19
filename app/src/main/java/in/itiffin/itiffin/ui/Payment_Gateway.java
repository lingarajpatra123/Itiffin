package in.itiffin.itiffin.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import in.itiffin.itiffin.R;
import in.itiffin.itiffin.custom.CustomActivity;

/**
 * Created by itiffin-it-01 on 13/6/15.
 */
public class Payment_Gateway extends CustomActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_gateway);
        setTouchNClick(R.id.btnpaynow);
        setTouchNClick(R.id.btncallus6);
        setTouchNClick(R.id.btnmyplan5);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if(v.getId()==R.id.btnpaynow)
        {

            startActivity(new Intent(this,Payment_Processing.class));
            finish();

        }
    }
}
