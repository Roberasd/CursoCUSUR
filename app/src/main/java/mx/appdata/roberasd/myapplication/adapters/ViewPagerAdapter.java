package mx.appdata.roberasd.myapplication.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import mx.appdata.roberasd.myapplication.fragments.CameraFragment;
import mx.appdata.roberasd.myapplication.fragments.CardViewFragment;
import mx.appdata.roberasd.myapplication.fragments.CustomListViewFragment;
import mx.appdata.roberasd.myapplication.fragments.ThreadFragment;

/**
 * Created by Roberasd on 03/02/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter{

    private CharSequence mTtiles[] = {
            "Camara", "Hilos", "Lista", "Card"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return CameraFragment.newInstance();
            case 1:
                return ThreadFragment.newInstance();
            case 2:
                return CustomListViewFragment.newInstance();
            case 3:
                return  CardViewFragment.newInstance();

            default:
                return CameraFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTtiles[position];
    }
}
