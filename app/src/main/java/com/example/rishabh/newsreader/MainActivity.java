package com.example.rishabh.newsreader;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> headings = new ArrayList<String>();
    ArrayList<String> content = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    SQLiteDatabase newsdb;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* db = new Database(getApplicationContext());
        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ArticleAvtivity.class);
                intent.putExtra("content", content.get(position));
                startActivity(intent);
            }
        });


        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, headings);
        listView.setAdapter(arrayAdapter);


        //updateFeed();
      /*  DownloadTask task = new DownloadTask();
        try {
            task.execute("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

  /*  public void updateFeed() {
        headings = db.getHeading();
        content = db.getContent();
        arrayAdapter.notifyDataSetChanged();
    }
    */

/*
    class DownloadTask extends AsyncTask<String, Void ,String>{

        @Override
        protected String doInBackground(String... strings) {

            String result="";
            URL url;
            URLConnection connection= null;
/*
            try {
                url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                InputStream in = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();
                if (data != -1) {
                    char current = (char) data;
                    result += current;
                    reader.read();
                }

                JSONArray jsonArray = new JSONArray(result);
                int numberOfNews = 20;
                if (jsonArray.length() < 20)
                    numberOfNews = jsonArray.length();
                for (int i = 0; i < numberOfNews; i++) {
                    String articleId = jsonArray.getString(i);
                    url = new URL("https://hacker-news.firebaseio.com/v0/item/" + articleId + ".json?print=pretty");
                    connection = (HttpURLConnection) url.openConnection();
                    in = connection.getInputStream();
                    reader = new InputStreamReader(in);
                    String articleInfo = "";
                    data = reader.read();
                    while (data != -1) {
                        char current = (char) data;
                        articleInfo += current;
                    }
                    JSONObject article = new JSONObject(articleInfo);

                    if (!article.isNull("title") && !article.isNull("url")) {
                        String title = article.getString("title");
                        String articleUrl = article.getString("url");


                        url = new URL("https://hacker-news.firebaseio.com/v0/item/" + articleId + ".json?print=pretty");
                        connection = (HttpURLConnection) url.openConnection();
                        in = connection.getInputStream();
                        reader = new InputStreamReader(in);
                        String articleContent = "";
                        data = reader.read();
                        while (data != -1) {
                            char current = (char) data;
                            articleInfo += current;
                        }
                        db.addData(articleId, title, articleContent);
                    }

                }
                } catch(Exception e){
                    e.printStackTrace();
                }
*/
            //return null;
        }
/*
        @Override
        protected void onPostExecute(String s) {
            updateFeed();
            super.onPostExecute(s);
        }
    }
}*/
