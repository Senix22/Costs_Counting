package com.senix22.costs_counting;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.*;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.stream.IntStream;

public class CountingResultActivity extends AppCompatActivity {
    private static String TAG = CountingResultActivity.class.getSimpleName();
    int sum;
    private LayoutInflater mInflater;
    TextView tvView, text2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        tvView = (TextView) findViewById(R.id.tvView);
        text2 = (TextView) findViewById(R.id.Text2);

        ListView listView = (ListView) findViewById(R.id.listView);

//        Bundle extras = getIntent().getExtras();
        Intent intent = getIntent();
        HashMap<String, Integer> hashMap = (HashMap<String,Integer >) intent.getSerializableExtra("map");
        // MyAdapter adapter = new MyAdapter(hashMap);
        Log.e(TAG, hashMap.toString());
//        MyAdapter adapter;
//        adapter = new ArrayAdapter(this,hashMap);
//        listView.setAdapter(adapter);


        //get value from hash to new list
        //Sum for all time
        ArrayList<Integer>  priceSum = new ArrayList<>(hashMap.values());

        doSum(priceSum);
        Log.e(TAG, String.valueOf(priceSum));
        Log.e(TAG, String.valueOf(sum));
//        View view = mInflater.inflate(R.layout.)




        tvView.setText("Ur sum = " + String.valueOf(sum));
        tvView.setTextSize(32);
        //tvView.setText(priceSum.toString());
        text2.setText(hashMap.toString());


//        price = extras.getInt("map");
//        priceSum.add(price);
//        intent.getIntegerArrayListExtra(String.valueOf(hashMap));




        // tvView.setText(hashMap.get("key"));
        //int price = intent.getIntExtra("price",10);

        //  String product = intent.getStringExtra("product");

    }
    public void doSum(ArrayList<Integer>  priceSum) {

        for (int i : priceSum) {
            sum += i;

        }

    }
}