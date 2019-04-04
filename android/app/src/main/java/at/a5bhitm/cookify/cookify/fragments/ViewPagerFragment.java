package at.a5bhitm.cookify.cookify.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import at.a5bhitm.cookify.cookify.R;

public class ViewPagerFragment extends Fragment {

    TextView textView;

    public ViewPagerFragment() {

    }

    @SuppressLint("ValidFragment")
    public ViewPagerFragment(String step) {
        textView = (TextView) getView().findViewById(R.id.step_fragment_text);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.step_viewpager_fragment, null);
    }
}
