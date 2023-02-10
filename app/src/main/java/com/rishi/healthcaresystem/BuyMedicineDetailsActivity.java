package com.rishi.healthcaresystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyMedicineDetailsActivity extends AppCompatActivity {
    TextView tvPackageName,tvToatalCost;
    EditText edDetails;
    Button btnBMDback,btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);

        tvPackageName = findViewById(R.id.textViewBMDTitle);
        edDetails = findViewById(R.id.editTextBMDTextMultiline);
        edDetails.setKeyListener(null);
        tvToatalCost = findViewById(R.id.textViewBMDTotalCost);
        btnBMDback = findViewById(R.id.buttonMNDB);
        btnAdd = findViewById(R.id.buttonBMDCart);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvToatalCost.setText("Total Cost : " +intent.getStringExtra("text3")+"-/");

        btnBMDback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineDetailsActivity.this,BuyMedicineactivity.class));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(),"healthcare",null,1);

                if (db.checkCart(username,product)==1){
                    Toast.makeText(BuyMedicineDetailsActivity.this, "Product Already Added", Toast.LENGTH_SHORT).show();
                }else {
                    db.addcart(username,product,price,"lab");
                    Toast.makeText(BuyMedicineDetailsActivity.this, "Record inserted to a Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedicineDetailsActivity.this,BuyMedicineactivity.class));
                }
            }
        });


    }
}