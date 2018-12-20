package at.a5bhitm.cookify.cookify.adapters;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.widget.TextView;

import at.a5bhitm.cookify.cookify.R;
import at.a5bhitm.cookify.cookify.fragments.ViewPagerFragment;

public class StepViewPagerAdapter extends FragmentStatePagerAdapter {

    public int count;
    public String[] steps;

    public StepViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // REVERSE ARRAY OF STEPS FIRST!

    @Override
    public Fragment getItem(int position) {
        /*if (position == getCount()) {
            // Go back to recipe / drink.
        } else {
            return new ViewPagerFragment();
        }*/
        return new ViewPagerFragment(steps[position]);
    }

    @Override
    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setSteps(String[] steps) {
        this.steps = steps;
        setCount(steps.length);
        notifyDataSetChanged();
        Log.d("STEPS", "Steps: " + steps.length);
    }
}
