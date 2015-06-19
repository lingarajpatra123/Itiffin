package in.itiffin.itiffin;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

import in.itiffin.itiffin.custom.CustomActivity;
import in.itiffin.itiffin.model.Data;
//import in.itiffin.itiffin.ui.About;
//import in.itiffin.itiffin.ui.Contactus;
import in.itiffin.itiffin.ui.About;
import in.itiffin.itiffin.ui.Help;
import in.itiffin.itiffin.ui.Hub;
import in.itiffin.itiffin.ui.LeftNavAdapter;
//import in.itiffin.itiffin.ui.Policies;
//import in.itiffin.itiffin.ui.RateApp;
import in.itiffin.itiffin.ui.Order_Meal;
import in.itiffin.itiffin.ui.Order_Snacks;
import in.itiffin.itiffin.ui.RateApp;
import in.itiffin.itiffin.ui.Terms_Of_Agreement;
import in.itiffin.itiffin.ui.Wellness_Products;
import in.itiffin.itiffin.ui.itiffin_home;
//import in.itiffin.itiffin.ui.helpbmi;


/**
 * The Class MainActivity is the base activity class of the application. This
 * activity is launched after the Splash and it holds all the Fragments used in
 * the app. It also creates the Navigation Drawer on left side.
 */

/**
 * The Class MainActivity is the base activity class of the application. This
 * activity is launched after the Splash and it holds all the Fragments used in
 * the app. It also creates the Navigation Drawer on left side.
 */
public class MainActivity extends CustomActivity {

    /**
     * The drawer layout.
     */
    private DrawerLayout drawerLayout;

    /**
     * ListView for left side drawer.
     */
    private ListView drawerLeft;

    /**
     * The drawer toggle.
     */

    private ActionBarDrawerToggle drawerToggle;

    /**
     * The left navigation list adapter.
     */
    private LeftNavAdapter adapter;



    /* (non-Javadoc)
     * @custom.CustomActivity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupContainer();
        setupDrawer();
    }



   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }
*/


    /**
     * Setup the drawer layout. This method also includes the method calls for
     * setting up the Left side drawer.
     */
    private void setupDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
                GravityCompat.START);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerLayout.callOnClick();
        drawerLayout.closeDrawers();
        drawerLayout.setDrawerListener(drawerToggle);

        setupLeftNavDrawer();
    }

    /**
     * Setup the left navigation drawer/slider. You can add your logic to load
     * the contents to be displayed on the left side drawer. You can also setup
     * the Header and Footer contents of left drawer if you need them.
     */
    private void setupLeftNavDrawer() {
        drawerLeft = (ListView) findViewById(R.id.left_drawer);

        adapter = new LeftNavAdapter(this, getDummyLeftNavItems());
        drawerLeft.setAdapter(adapter);
        drawerLeft.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
                                    long arg3) {
                drawerLayout.closeDrawers();
                launchFragment(pos);
            }
        });

    }

    /**
     * This method returns a list of dummy items for left navigation slider. You
     * can write or replace this method with the actual implementation for list
     * items.
     *
     * @return the dummy items
     */
    private ArrayList<Data> getDummyLeftNavItems() {
        ArrayList<Data> al = new ArrayList<Data>();
        al.add(new Data("Home", R.drawable.ic_nav1, R.drawable.ic_nav1_sel));
        al.add(new Data("Order Meals", R.drawable.ic_nav2, R.drawable.ic_nav2_sel));
        al.add(new Data("Order Snacks", R.drawable.ic_nav4, R.drawable.ic_nav4_sel));
        al.add(new Data("Other Wellness Products", R.drawable.ic_nav5, R.drawable.ic_nav5_sel));
       // al.add(new Data("Your Wellness Chart", R.drawable.ic_nav6, R.drawable.ic_nav6_sel));
        al.add(new Data("Hubs", R.drawable.ic_nav6,R.drawable.ic_nav6_sel));
        al.add(new Data("About", R.drawable.ic_nav6, R.drawable.ic_nav5_sel));
        al.add(new Data("Rate the App", R.drawable.ic_nav6, R.drawable.ic_nav5_sel));
        al.add(new Data("Term of Agreement", R.drawable.ic_nav6, R.drawable.ic_nav5_sel));
        al.add(new Data("Help", R.drawable.ic_nav6, R.drawable.ic_nav5_sel));

        return al;



    }

    /**
     * This method can be used to attach Fragment on activity view for a
     * particular tab position. You can customize this method as per your need.
     *
     * @param pos the position of tab selected.
     */
    public void launchFragment(int pos) {

        Fragment f = null;
        String title = null;
        if (pos == 0) {
            title = "iTiffin";
            f= new itiffin_home();
            f.setArguments(null);
        } else {
            if (pos == 1) {


                title = "Order Meals";
                f = new Order_Meal();

            } else if (pos == 2) {

                title = "Order Snacks";
                f = new Order_Snacks();

            } else if (pos == 3 ) {
                title = "Order Snacks";
                f=new Wellness_Products();

            }/* else if (pos == 4) {
                title = "Wellness Chart";
                f = new Wellness_Chart();
            } */else if (pos == 4) {
                title = "HUB";
                f = new Hub();
            } else if (pos == 5) {

                title = "ABOUT US";
                f = new About();
            }
            else  if(pos==6)
                f= new RateApp();
            else  if(pos==7)
                f= new Terms_Of_Agreement();
            else  if(pos==8)
                f= new Help();
        }

        if (f != null) {
            while (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStackImmediate();
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, f).addToBackStack(title)
                    .commit();
            if (adapter != null && pos >= 0)
                adapter.setSelection(pos);
        }
    }

    /**
     * Setup the container fragment for drawer layout. The current
     * implementation of this method simply calls launchFragment method for tab
     * position 0. You can customize this method as per your need to display
     * specific content.
     */
    private void setupContainer() {
        getSupportFragmentManager().addOnBackStackChangedListener(
                new OnBackStackChangedListener() {

                    @Override
                    public void onBackStackChanged() {
                        setActionBarTitle();
                    }
                });
        launchFragment(0);
    }

    /**
     * Set the action bar title text.
     */
    private void setActionBarTitle() {
        if (drawerLayout.isDrawerOpen(drawerLeft)) {
            getActionBar().setTitle(R.string.menu);
            return;
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
            return;
        String title = getSupportFragmentManager().getBackStackEntryAt(
                getSupportFragmentManager().getBackStackEntryCount() - 1)
                .getName();
        getActionBar().setTitle(title);
        getActionBar().setLogo(R.drawable.logo);
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onPostCreate(android.os.Bundle)
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onConfigurationChanged(android.content.res.Configuration)
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggle
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /* (+non-Javadoc)
     * @see android.support.v4.app.FragmentActivity#onKeyDown(int, android.view.KeyEvent)
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                getSupportFragmentManager().popBackStackImmediate();
            } else
                finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
       finish();
    }


}

