package com.rishi.healthcaresystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineactivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Uprise-03 1000IU Capsule","","","","50"},
                    {"HealthVit Chromium Picolinate 200mcg Capsule","","","","305"},
                    {"Vitamin B Complex Capsule","","","","450"},
                    {"Anti-Inhibitor Coagulant Complex (FEIBA)","","","","500"},
                    {"Dolo 650","","","","35"},
                    {"G-CSF (Filgrastim)","","","","1200"},
                    {"Heparin Lock Flush for children and young adults","","","","1250"},
                    {"Leucovorin with high dose methotrexate (HDMTX)","","","","750"},
                    {"Ritonavir","","","","500"},

            };
    private  String[] package_details = {
            "iagnosis or treatment of Teeth strong, Reducing Fatigue, mascular pain, boosting immunity, Cardio Vascular Diseases\n" +
                    "Reducing Stress and muscular pain\n" +
                    "Boosting immunity against a infections",
            "Chromium may help regulate blood sugar",
            "B vitamins used to treat or prevent vitamin deficiency due to poor diet, certain illnesses, alcoholism, or during pregnancy.\n"+
                    "Helps in formation of a red blood\n"+
                    "Maintain Healthy Nerviours system",
            "Anti-inhibitor coagulant complex injection is used to control bleeding episodes or bleeding during surgery in patients with hemophilia A and hemophilia B.",
            "Dolo 650 can be used for headaches, mild to high fevers, and any other type of bodily aches.\n" +
                    "It is usually prescribed by doctors in case of recurrent high fevers.\n" +
                    "Dolo 650 medicine can also be used for toothaches and certain types of inner or middle ear pains.",
            "G-CSF is used in patients who have certain cancers and neutropenia caused by some types of chemotherapy and in patients who have severe chronic neutropenia that is not caused by cancer treatment\n"+
                    " It is also used before an autologous stem cell transplant. G-CSF helps the bone marrow make more white blood cells.",
            "Heparin is an anticoagulant (AN ty koh AG yoo lent), a medicine that helps keep blood clots from forming",
            "High Dose Methotrexate Rescue· Megaloblastic Anemia Due to Folate Deficiency ",
            "Ritonavir is used along with other medications to treat human immunodeficiency virus (HIV) infection."
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicineactivity);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonMNDB);
        btnGoToCart = findViewById(R.id.buttonBMDCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineactivity.this,HomeActivity.class));
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineactivity.this,CartBuyMedicineActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i <packages.length; i++) {
            item = new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total cost: "+packages[i][4]+"-/");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(BuyMedicineactivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[position][0]);
                it.putExtra("text2",package_details[position]);
                it.putExtra("text3",packages[position][4]);
                startActivity(it);
            }
        });

    }
}