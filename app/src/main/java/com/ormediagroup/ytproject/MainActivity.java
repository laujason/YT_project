package com.ormediagroup.ytproject;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabTl,mTabTl_bottom;
    private ViewPager mContentVp,mContentVp_bottom;
//    private RecyclerView mContentRv;

    private List<String> tabIndicators,tabIndicators_bottom;
    private List<Fragment> tabFragments,tabFragments_bottom;
    private ContentPagerAdapter contentAdapter;
//    private ContentPagerAdapter2 bottom_contentAdapter;
    private String[] mTabTitles_top = new String []{"推荐","热点","体育","健康","娱乐","军事","科技","社会","学习"};

    private String[] mTabTitles_bottom = new String []{"Wechat","Contacts","Discover","Me"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabTl =  findViewById(R.id.tl_tab);
        mContentVp =  findViewById(R.id.vp_content);

        /*mTabTl_bottom =  findViewById(R.id.tl_tab_bottom);
        mContentVp_bottom =  findViewById(R.id.vp_content_bottom);*/
//      mContentRv =  findViewById(R.id.rv_content);

        initContent();
        initTab();
    }

    private void initTab(){
        mTabTl.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabTl.setTabTextColors(ContextCompat.getColor(this, R.color.gray), ContextCompat.getColor(this, R.color.white));
        mTabTl.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));
        ViewCompat.setElevation(mTabTl, 10);
        mTabTl.setupWithViewPager(mContentVp);

        /*mTabTl_bottom.setTabMode(TabLayout.MODE_FIXED);
        mTabTl_bottom.setSelectedTabIndicatorHeight(0);
        ViewCompat.setElevation(mTabTl_bottom, 10);
        mTabTl_bottom.setupWithViewPager(mContentVp_bottom);

        for (int i = 0; i < tabIndicators_bottom.size(); i++) {
            TabLayout.Tab itemTab = mTabTl_bottom.getTabAt(i);
            if (itemTab!=null){
                itemTab.setCustomView(R.layout.item_tab_layout_custom);
                TextView itemTv = itemTab.getCustomView().findViewById(R.id.tv_menu_item);
                itemTv.setText(tabIndicators_bottom.get(i));
            }
        }
        mTabTl_bottom.getTabAt(0).getCustomView().setSelected(true);*/

    }

    private void initContent() {
        tabIndicators = new ArrayList<>();
        for (int i = 0; i < mTabTitles_top.length; i++) {
            tabIndicators.add(mTabTitles_top[i]);
        }
        tabFragments = new ArrayList<>();
        for (String s : tabIndicators) {
            tabFragments.add(TabContentFragment.newInstance(s));  //内容
        }
        contentAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        mContentVp.setAdapter(contentAdapter);

        /*tabIndicators_bottom= new ArrayList<>();
        for (int i = 0; i < mTabTitles_bottom.length; i++) {
            tabIndicators_bottom.add(mTabTitles_bottom[i]);
        }
        tabFragments_bottom = new ArrayList<>();
        for (String s : tabIndicators_bottom) {
            tabFragments_bottom.add(TabContentFragment.newInstance(s));
        }
        bottom_contentAdapter = new ContentPagerAdapter2(getSupportFragmentManager());
        mContentVp_bottom.setAdapter(bottom_contentAdapter);*/
    }

    private class ContentPagerAdapter extends FragmentPagerAdapter {

        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return tabFragments.get(position);
        }

        @Override
        public int getCount() {
            return tabIndicators.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabIndicators.get(position);
        }
    }

    /*private class ContentPagerAdapter2 extends FragmentPagerAdapter{
        public ContentPagerAdapter2(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return tabFragments_bottom.get(position);
        }

        @Override
        public int getCount() {
            return tabIndicators_bottom.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return tabIndicators_bottom.get(position);
        }
    }*/

}
