package in.itiffin.itiffin.custom;

import android.app.ActionBar;
import android.content.Intent;
import android.media.RemoteControlClient;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.itiffin.itiffin.R;
import in.itiffin.itiffin.ui.MyCart;
import in.itiffin.itiffin.ui.MyPlan;
import in.itiffin.itiffin.ui.Notification;
import in.itiffin.itiffin.ui.login;
import in.itiffin.itiffin.utils.TouchEffect;


/**
 * This is a common activity that all other activities of the app can extend to
 * inherit the common behaviors like implementing a common interface that can be
 * used in all child activities.
 */
public class CustomActivity extends FragmentActivity implements OnClickListener
{

	static TextView tv;
	/**
	 * Apply this Constant as touch listener for views to provide alpha touch
	 * effect. The view must have a Non-Transparent background.
	 */


	Intent intent;
	Bundle bundle;
	public static final TouchEffect TOUCH = new TouchEffect();

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	/* (non-Javadoc)
         * @see android.app.Activity#onCreate(android.os.Bundle)
         */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setupActionBar();


	}

	/**
	 * This method will setup the top title bar (Action bar) content and display
	 * values. It will also setup the custom background theme for ActionBar. You
	 * can override this method to change the behavior of ActionBar for
	 * particular Activity
	 */
	protected void setupActionBar()
	{
		final ActionBar actionBar = getActionBar();
		if (actionBar == null)
			return;
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayUseLogoEnabled(true);
		actionBar.setLogo(R.drawable.itiffin);
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.black_semi_trans_strip));
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setTitle(R.string.app_name);


	}

	/**
	 * Sets the touch and click listener for a view with given id.
	 * 
	 * @param id
	 *            the id
	 * @return the view on which listeners applied
	 */
	public View setTouchNClick(int id)
	{

		View v = setClick(id);
		if (v != null)
			v.setOnTouchListener(TOUCH);
		return v;
	}

	/**
	 * Sets the click listener for a view with given id.
	 * 
	 * @param id
	 *            the id
	 * @return the view on which listener is applied
	 */
	public View setClick(int id)
	{

		View v = findViewById(id);
		if (v != null)
			v.setOnClickListener(this);
		return v;
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v)
	{

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();

		inflater.inflate(R.menu.main_activity_actions, menu);


		if(tv==null) {
			RelativeLayout badgeLayout = (RelativeLayout) menu.findItem(R.id.action_notification).getActionView();
			tv = (TextView) badgeLayout.findViewById(R.id.hotlist_hot);
			tv.setText("12");
		}

		/*menu.findItem(R.id.action_notification).getActionView().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

					System.out.println("clicked");
					tv.setEnabled(false);
					tv.setBackground(null);
					tv.setBackgroundDrawable(null);
					tv.setText(null);
					intent = new Intent(getApplicationContext(), Notification.class);
					startActivity(intent);

			}
		});*/
		//getActionBar().setCustomView(R.layout.menu_example);
		//getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_HOME_AS_UP);
		//getActionBar().setIcon(android.R.color.transparent);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

      /*  if(item.getItemId()==R.id.action_cart)
            Toast.makeText(this,
                    "Item clicked: " +"",
                    Toast.LENGTH_LONG)
                    .show();*/

		bundle = new Bundle();

		bundle.putString("menu",getApplicationContext().toString());
		switch (item.getItemId())
		{
			case R.id.action_cart: {
				intent= new Intent(this, MyCart.class);
				bundle.putString("next_page","MyCart.class");
				intent.putExtras(bundle);
				startActivity(intent);
				return true;
			}
			case R.id.action_notification: {
				intent= new Intent(this, Notification.class);
				startActivity(intent);
				return true;
			}
				case R.id.action_login: {

				intent= new Intent(this, login.class);
				intent.putExtras(bundle);
				startActivity(intent);
				return true;
				}
			case R.id.myplan: {
				intent= new Intent(this, MyPlan.class);
				startActivity(intent);
				return true;
			}


				case android.R.id.home:	{
					NavUtils.navigateUpFromSameTask(this);
					return true;
			}
			default: return super.onOptionsItemSelected(item);
		}




	}
	/*@Override
	public bst	break;
			case R.id.action_notification:
				startActivity(new Intent(this,Notification.class));

				// Toast.makeText(this, "home pressed", Toast.LENGTH_LONG).show();
				break;

		}

		return true;
	}
	*/
}
