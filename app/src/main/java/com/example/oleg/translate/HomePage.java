package com.example.oleg.translate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HomePage extends Fragment {

    public HomePage()
    {

    }

    public static HomePage newInstance()
    {
        return new HomePage();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_home_fragment, container, false);
    }


}
