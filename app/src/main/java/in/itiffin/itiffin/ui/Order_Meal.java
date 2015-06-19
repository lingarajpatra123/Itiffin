package in.itiffin.itiffin.ui;

import android.content.Intent;
import android.os.Bundle;

import in.itiffin.itiffin.custom.CustomFragment;

/**
 * Created by itiffin-it-01 on 12/6/15.
 */
public class Order_Meal extends CustomFragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(getActivity(),Catalog.class));

    }
}
