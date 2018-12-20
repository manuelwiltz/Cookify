package at.a5bhitm.cookify.cookify.activities;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import at.a5bhitm.cookify.cookify.R;
import at.a5bhitm.cookify.cookify.adapters.StepViewPagerAdapter;

public class StepActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private StepViewPagerAdapter stepViewPagerAdapter;
    private String[] steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);

        viewPager = (ViewPager) findViewById(R.id.step_viewPager);
        stepViewPagerAdapter = new StepViewPagerAdapter(getSupportFragmentManager());
        viewPager.setPageTransformer(true, new StepCardStackTransformer());
        viewPager.setOffscreenPageLimit(stepViewPagerAdapter.getCount());
        viewPager.setAdapter(stepViewPagerAdapter);

        String[] steps = getIntent().getExtras().getStringArray("steps");
        stepViewPagerAdapter.setSteps(steps);

    }

    private class StepCardStackTransformer implements ViewPager.PageTransformer {
        @Override
        public void transformPage(@NonNull View page, float position) {
            if (position >= 0) {
                page.setScaleX(0.8f - 0.02f * position);
                page.setScaleY(0.8f);

                page.setTranslationX(-page.getWidth() * position);
                page.setTranslationY(30 * position);
            }
        }
    }
}
