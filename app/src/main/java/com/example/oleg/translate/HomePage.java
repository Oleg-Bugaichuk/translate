package com.example.oleg.translate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;


public class HomePage extends Fragment
{


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
        //тест запроса в яндекс
        View thisView = inflater.inflate(R.layout.activity_home_fragment, null);

        Button requestButton = (Button) thisView.findViewById(R.id.request);

        requestButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                RequestForLang requestForLang = new RequestForLang();
                requestForLang.execute("key=trnsl.1.1.20181025T153939Z.02e3108b8b5c8d2c.de432e6f3097b04ddfe68c14e9eeb2896591496d", "ui=ru");

            }
        });

        return thisView;
    }
}
