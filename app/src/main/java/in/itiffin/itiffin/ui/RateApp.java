package in.itiffin.itiffin.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.itiffin.itiffin.MainActivity;
import in.itiffin.itiffin.custom.CustomActivity;
import in.itiffin.itiffin.custom.CustomFragment;

/**
 * Created by user on 24-02-2015.
 */
public class RateApp extends CustomFragment{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String developerName = "itiffin";
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getActivity().getPackageName())));
            super.onPause();
            getActivity().finish();
            //super.onBackPressed(0);
        }
        catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getActivity().getPackageName())));
            getActivity().finish();
        }
        return  getView();
    }


}
