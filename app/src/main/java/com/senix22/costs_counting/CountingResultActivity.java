package com.senix22.costs_counting;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CountingResultActivity extends AppCompatActivity {
    private static String TAG = CountingResultActivity.class.getSimpleName();
    int sum;
    private LayoutInflater mInflater;
    private   TextView tvView, text2;
    private StringBuilder builder = new StringBuilder();
   private Button finishBut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        tvView = (TextView) findViewById(R.id.tvView);
        text2 = (TextView) findViewById(R.id.Text2);
        finishBut = (Button)findViewById(R.id.finishBut);
        Intent intent = getIntent();
        HashMap<String, Integer> hashMap = (HashMap<String,Integer >) intent.getSerializableExtra("map");

        Log.d(TAG, hashMap.toString());



        //get value from hash to new list
        //Sum for all time
        ArrayList<Integer>  priceSum = new ArrayList<>(hashMap.values());

        doSum(priceSum);
        parseMapInteString(hashMap);
        Log.d(TAG, String.valueOf(priceSum));
        Log.d(TAG, String.valueOf(builder));



        text2.setText("Ur sum = " + String.valueOf(sum));
        text2.setTextSize(32);

        tvView.setText(builder);
        tvView.setTextSize(24);
        tvView.setTextColor(Color.BLUE);

    finishBut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    });

    }
    public void doSum(ArrayList<Integer>  priceSum) {

        for (int i : priceSum) {
            sum += i;

        }

    }
    private String  parseMapInteString(HashMap<String, Integer>map){

        for(Map.Entry<String, Integer> pair: map.entrySet()){
            builder.append(pair.getKey() + " : " +  + pair.getValue() + "  "+ "\n");
        }
        return builder.toString();
    }
}