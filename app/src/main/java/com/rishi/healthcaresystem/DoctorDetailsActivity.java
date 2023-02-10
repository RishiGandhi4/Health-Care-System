package com.rishi.healthcaresystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private  String[][] doctor_details1 =
            {
                    {"Doctor Name : Rishi Gandhi","Hospital Address : Surat", "Exp : 5yrs","Mobile No:9876543560","600"},
                    {"Doctor Name : Krish KanKeshwar","Hospital Address : Mumbai", "Exp : 5yrs","Mobile No:98769843560","900"},
                    {"Doctor Name : Jenil Gajiwala","Hospital Address : Pune", "Exp : 1yrs","Mobile No:9876588860","300"},
                    {"Doctor Name : Dev Patel","Hospital Address : Nepal", "Exp : 5yrs","Mobile No:7776543560","500"},
                    {"Doctor Name : Rudra Jariwala ","Hospital Address : Surat", "Exp : 5yrs","Mobile No:9876333560","800"},
            };

    private  String[][] doctor_details2 =
            {
                    {"Doctor Name : Neelam Patil","Hospital Address : Pimpri", "Exp : 5yrs","Mobile No:9864543560","600"},
                    {"Doctor Name : Zeel Jariwala","Hospital Address : Mumbai", "Exp : 5yrs","Mobile No:9888843560","900"},
                    {"Doctor Name : Drashti Rangrage","Hospital Address : Limbayat", "Exp : 1yrs","Mobile No:9876588860","100"},
                    {"Doctor Name : Vishal pankaj","Hospital Address : Nepal", "Exp : 5yrs","Mobile No:7778843560","500"},
                    {"Doctor Name : Minaksh jadeja","Hospital Address : Surat", "Exp : 5yrs","Mobile No:9866333560","800"},
            };

    private  String[][] doctor_details3 =
            {
                    {"Doctor Name : Riddhi jadeja","Hospital Address : Surat", "Exp : 5yrs","Mobile No:9876444560","600"},
                    {"Doctor Name : prince mukshwala","Hospital Address : Mumbai", "Exp : 5yrs","Mobile No:98755553560","900"},
                    {"Doctor Name : Dimple mehta","Hospital Address : Pune", "Exp : 1yrs","Mobile No:9856565860","300"},
                    {"Doctor Name : Dev Dalia","Hospital Address : Nepal", "Exp : 5yrs","Mobile No:7777868960","500"},
                    {"Doctor Name : Priyanshu Malaviya","Hospital Address : Surat", "Exp : 5yrs","Mobile No:9876453260","800"},
            };

    private  String[][] doctor_details4 =
            {
                    {"Doctor Name : Rishabh Rangraje","Hospital Address : Surat", "Exp : 5yrs","Mobile No:9876543560","600"},
                    {"Doctor Name : Vatsal Nanavati","Hospital Address : Mumbai", "Exp : 5yrs","Mobile No:98769843560","900"},
                    {"Doctor Name : Parth Pawa","Hospital Address : Pune", "Exp : 1yrs","Mobile No:9876588860","300"},
                    {"Doctor Name : Baban Bam","Hospital Address : Nepal", "Exp : 5yrs","Mobile No:7776543560","500"},
                    {"Doctor Name : Mukesh Rana ","Hospital Address : Surat", "Exp : 5yrs","Mobile No:9876333560","800"},
            };

    private  String[][] doctor_details5 =
            {
                    {"Doctor Name : Dhruvit Patel","Hospital Address : Surat", "Exp : 5yrs","Mobile No:9876543560","600"},
                    {"Doctor Name : Priyanshi Parmar","Hospital Address : Mumbai", "Exp : 5yrs","Mobile No:98769843560","900"},
                    {"Doctor Name : Nistha Rangrage","Hospital Address : Pune", "Exp : 1yrs","Mobile No:9876588860","300"},
                    {"Doctor Name : Bhavya Patel","Hospital Address : Nepal", "Exp : 5yrs","Mobile No:7776543560","500"},
                    {"Doctor Name : lalu Prasad ","Hospital Address : Surat", "Exp : 5yrs","Mobile No:9876333560","800"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewBMDTitle);
        btn = findViewById(R.id.buttonMNDB);
        
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physician")==0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity2.class));
            }
        });

        list = new ArrayList();
        //we will use a hasMap to set above 5 columns we split the whole string and divide that string and copy it to the saperate them into seprete obj of hasMap
        for (int i = 0; i <doctor_details.length; i++) {
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees: "+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );

        ListView  lst = findViewById(R.id.listViewBM);
        lst.setAdapter(sa);

      lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
              it.putExtra("text1",title);
              it.putExtra("text2",doctor_details[position][0]);
              it.putExtra("text3",doctor_details[position][1]);
              it.putExtra("text4",doctor_details[position][3]);
              it.putExtra("text5",doctor_details[position][4]);
              startActivity(it);
          }
      });
    }
}