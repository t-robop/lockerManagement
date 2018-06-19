package org.t_robop.locker_management;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


/*****
 * http://tech.pjin.jp/blog/2016/03/03/android-design-support-library%E3%82%92%E4%BD%BF%E3%81%86-%EF%BC%883%EF%BC%89tablayout/ を参考にして作りました
 *****/

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TabLayoutにタブを追加  Tabの名前は下のgetPageTitleで付与してるのでここではつけない
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        //ここでは、タブを三個生成してる
        for(int i = 0;i<4;i++) {
            tabLayout.addTab(tabLayout.newTab().setText(""));
        }
        //ViewPagerの宣言
        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        tabLayout.setupWithViewPager(viewPager);
    }

    //ViewPagerが切り替わるたびに下のgetItemで取得したFragmentを呼び出して画面を生成
    //基本いじらなくてよい
    private class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //ここでFragmentの分岐
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;

            //Tabを追加するときは、ここにcaseを追加・削除する
            //逆に上でTabを追加し忘れないように注意
            switch (position) {
                case 0:
                    //例えばここでは1個目のタブに表示させたいフラグメントを指定する
                    //case1では2個目のタブ、case2では3個目のタブに表示させたいフラグメントを指定
                    //ここでは特に変える必要もないので全部同じフラグメントを指定して全部同じ内容を表示させている
                    fragment = new MainActivityFragment();
                    break;
                case 1:
                    fragment = new Locker2Fragment();
                    break;
                case 2:
                    fragment = new MainActivityFragment();
                    break;
                case 3:
                    fragment = new MainActivityFragment();
                    break;
                default:
                    break;
            }
            return fragment;
        }

        //Tabの最大数を指定する
        //ここを増やさないと、いくら上でタブやCaseを追加したところでタブは増えない
        @Override
        public int getCount() {
            return 4;
        }

        //ここでタブの名前を指定
        @Override
        public CharSequence getPageTitle(int position) {
            return "ロッカー"+ (position+1);
        }
    }

}
