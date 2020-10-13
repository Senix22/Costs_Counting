package com.senix22.costs_counting;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.HashMap;
import android.widget.Toast;


public class StartActivity extends AppCompatActivity {

    private static final String TAG = StartActivity.class.getName();

    public EditText etPrice, etProduct;
    public Button sumBut, btnAdd;
    public TextView textView;
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button)findViewById(R.id.btnadd);
        etPrice = (EditText) findViewById(R.id.etFName);
        etProduct = (EditText) findViewById(R.id.etLName);
        textView = (TextView) findViewById(R.id.text);

        sumBut = (Button) findViewById(R.id.buttonSum);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToHashMap(etPrice.getText().toString(), etProduct.getText().toString());
                ((EditText) findViewById(R.id.etFName)).setText("");
            }
        });
        sumBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, CountingResultActivity.class);
                intent.putExtra("map", map);

                startActivity(intent);

            }
        });
    }

    private void addToHashMap(String priceString, String product) {
        try {
        int price = Integer.parseInt(priceString);


            if (map.containsKey(product)) {

                Integer currentSum = map.get(product);
                map.put(product, price + currentSum);

            } else {


                map.put(product, price);
            }
        }catch (NullPointerException e){
            Toast.makeText(getApplicationContext(),"Fill the line",Toast.LENGTH_LONG).show();

        }


    }
}