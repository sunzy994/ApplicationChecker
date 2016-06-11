package cmcm.com.applicationchecker;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by sunzy on 16-6-10.
 */
public class AppFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public AppFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new AppFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", i);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getStringArray(R.array.goup_titles)[position];
    }
}
