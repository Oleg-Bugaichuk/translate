package com.example.oleg.translate;
import android.os.AsyncTask;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class RequestForLang extends AsyncTask<String, Void, String>
{
    String rezult;

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params)
    {

        //Делаем запрос к API
        try
        {
            String Url = "https://translate.yandex.net/api/v1.5/tr/getLangs";
            String Parametrs = params[0] + "&" + params[1];
            byte data[] = null;
            InputStream inputStream = null;


            URL yandexUrl = new URL(Url);
            HttpsURLConnection connection = (HttpsURLConnection) yandexUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            OutputStream outputStream = connection.getOutputStream();
            data = Parametrs.getBytes("UTF-8");
            outputStream.write(data);
            data = null;

            connection.connect();
            int responceCode = connection.getResponseCode();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            if(responceCode == 200)
            {
                inputStream = connection.getInputStream();
                byte[] buffer = new byte[8192];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1)
                {
                    byteArrayOutputStream.write(buffer,0, bytesRead);
                    data = byteArrayOutputStream.toByteArray();
                    rezult = new String(data, "UTF-8");
                }

            }

        }
        catch (Exception e)
        {
            Log.e("Error", e.toString());
        }


        //Парсим полученный XML

        rezult = parseXml(rezult);


        return rezult;
    }

    @Override
    protected void onPostExecute(String aVoid)
    {
        super.onPostExecute(aVoid);
    }



    private String parseXml(String xml)
    {
        try
        {
            XmlPullParser xmlPullParser = prepareXpp(xml);
        }

        catch (XmlPullParserException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    XmlPullParser prepareXpp(String xml) throws XmlPullParserException
    {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(new StringReader(xml));

        return xpp;
    }
}
