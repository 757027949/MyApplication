package asd.com.myapplication;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import asd.com.fragment.DetailFragment;

public class Activity4 extends AppCompatActivity {
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);



//设置ViewPager
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(mViewPager);

//给TabLayout增加Tab, 并关联ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.addTab(tabLayout.newTab().setText("内容简介0"));
//        tabLayout.addTab(tabLayout.newTab().setText("作者简介0"));
//        tabLayout.addTab(tabLayout.newTab().setText("目录0"));
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager mViewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(DetailFragment.newInstance("内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介"), "内容简介1");
        adapter.addFragment(DetailFragment.newInstance("作者简介"), "作者简介1");
        adapter.addFragment(DetailFragment.newInstance("目录"), "目录1");
        adapter.addFragment(DetailFragment.newInstance("目录"), "目录1");
        adapter.addFragment(DetailFragment.newInstance("目录"), "目录1");
        adapter.addFragment(DetailFragment.newInstance("目录"), "目录1");
        adapter.addFragment(DetailFragment.newInstance("目录"), "目录1");
        adapter.addFragment(DetailFragment.newInstance("目录"), "目录1");
        adapter.addFragment(DetailFragment.newInstance("目录"), "目录1");
        adapter.addFragment(DetailFragment.newInstance("目录"), "目录1");
        mViewPager.setAdapter(adapter);
    }

    static class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
