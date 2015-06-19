package in.itiffin.itiffin.ui;

//import android.app.FragmentTransaction;
import android.content.Intent;

        import android.os.Bundle;
        import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

        import in.itiffin.itiffin.R;
import in.itiffin.itiffin.custom.CustomFragment;

/**
 * The Class Home is the Fragment class that is launched when the user clicks on
 * Home option in Left navigation drawer and this is also used as a default
 * fragment for MainActivity. It simply shows an Edittext to enter the address.
 * You need to write actual code for searching the contents based on the address
 * entered by user.
 */
public class Home extends CustomFragment {

/*
    */
/* (non-Javadoc)
     * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
android.view.ViewGroup, android.os.Bundle)
     *//*

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home, null);

        setTouchNClick(v.findViewById(R.id.home_enter));

        return v;
    }

    */
/* (non-Javadoc)
     * in.itiffin.itiffin.custom.CustomFragment#onClick(android.view.View)
     *//*

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == R.id.home_enter) {
            Intent intent = new Intent(getActivity(),itiffin_home.class);
            startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
            //((MainActivity) getActivity()).launchFragment(1);

        }
    }
*/

}