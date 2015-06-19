package in.itiffin.itiffin.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.itiffin.itiffin.R;
import in.itiffin.itiffin.custom.CustomFragment;

/**
 * Created by itiffin-it-01 on 12/6/15.
 */
public class Policies extends CustomFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.policies, null);
        return v;
    }
}
