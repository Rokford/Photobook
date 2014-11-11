package com.mobinautsoftware.photobook;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends FragmentActivity implements CameraFragment.OnFragmentInteractionListener, MapFragment.OnFragmentInteractionListener
{
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.pager);

        FragmentManager fragmentManager = getSupportFragmentManager();

        final CameraFragment cameraFragment = new CameraFragment();

        final MapFragment mapFragment = new MapFragment();

        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager)
        {

            @Override
            public android.support.v4.app.Fragment getItem(int i)
            {
                if (i == 0)
                    return cameraFragment;
                else
                    return mapFragment;
            }

            @Override
            public int getCount()
            {
                return 2;
            }
        });

//        if (savedInstanceState == null)
//        {
//            getFragmentManager().beginTransaction().add(R.id.container, new CameraFragment()).commit();
//        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri)
    {

    }
}
