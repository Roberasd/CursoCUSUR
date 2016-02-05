package mx.appdata.roberasd.myapplication.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import mx.appdata.roberasd.myapplication.R;
import mx.appdata.roberasd.myapplication.adapters.ViewPagerAdapter;
import mx.appdata.roberasd.myapplication.utils.SlidingTabLayout;

public class SectionsActivity extends AppCompatActivity {

    private ViewPagerAdapter adapter;
    private ViewPager pager;
    private SlidingTabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);

        pager.setAdapter(adapter);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.custom);
            }

            @Override
            public int getDividerColor(int position) {
                return 0;
            }
        });

        tabs.setViewPager(pager);

    }
}
