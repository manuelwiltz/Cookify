package at.a5bhitm.cookify.cookify.adapters;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import at.a5bhitm.cookify.cookify.fragments.ViewPagerFragment;

public class StepViewPagerAdapter extends FragmentStatePagerAdapter {

    public StepViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /*
    * REVERSE ARRAY OF STEPS FIRST!
     */

    @Override
    public Fragment getItem(int position) {
        /*if (position == getCount()) {
            // Go back to recipe / drink.
        } else {
            return new ViewPagerFragment();
        }*/
        return new ViewPagerFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
