package mx.appdata.roberasd.myapplication.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import mx.appdata.roberasd.myapplication.fragments.CameraFragment;
import mx.appdata.roberasd.myapplication.fragments.ThreadFragment;

/**
 * Created by Roberasd on 03/02/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter{

    private CharSequence mTtiles[] = {"Camara", "Hilos"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return CameraFragment.newInstance();
        else
            return ThreadFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTtiles[position];
    }
}
