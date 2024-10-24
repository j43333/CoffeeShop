package uk.edu.le.co2103.lab14;
//run through Main Activity as it runs that way, not through app??
//also seems that there is too much on the main thread as it is running slow and crashing at times
//in logcat it says: Skipped 39 frames!  The application may be doing too much work on its main thread.

import static uk.edu.le.co2103.lab14.R.*;
import static uk.edu.le.co2103.lab14.R.id;
import static uk.edu.le.co2103.lab14.R.id.*;
import static uk.edu.le.co2103.lab14.R.id.img_sb6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView img_s1;
    private ImageView img_s2;
    private ImageView img_s3;
    private ImageView img_s4;
    private ImageView img_s5;
    private ImageView img_s6;
    private Order order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        order = new Order();

        img_s1  = findViewById(R.id.img_sb1);
        img_s2  = findViewById(R.id.img_sb2);
        img_s3  = findViewById(R.id.img_sb3);
        img_s4  = findViewById(R.id.img_sb4);
        img_s5  = findViewById(R.id.img_sb5);
        img_s6  = findViewById(R.id.img_sb6);

        img_s1.setOnClickListener(this);
        img_s2.setOnClickListener(this);
        img_s3.setOnClickListener(this);
        img_s4.setOnClickListener(this);
        img_s5.setOnClickListener(this);
        img_s6.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v){
        switch(v.getId())
        {
            //toast is a lil popup and the param is: activity it appears in (MainActivity), displayed text, how long msg is shown
            //SPENT TIME ON THE CASE STATEMENTS BECAUSE CASE ONLY TAKES FINAL ARGS AND THESE ARE NOT
            //SO I HAD TO ADD: android.nonFinalResIds=false to gradle.properties URGHHH
            case R.id.img_sb1:
                order.setProductName("Soy Latte");
                break;
            case R.id.img_sb2:
                order.setProductName("Chocco Frappe");
                break;
            case R.id.img_sb3:
                order.setProductName("Bottled Americano");
                break;
            case R.id.img_sb4:
                order.setProductName("Rainbow Frappe");
                break;
            case R.id.img_sb5:
                order.setProductName("Caramel Frapp");
                break;
            case R.id.img_sb6:
                order.setProductName("Black Forest Frapp");
                break;
        }
        Toast.makeText(MainActivity.this, "MMM" + order.getProductName(), Toast.LENGTH_SHORT).show();
        IntentHelper.openIntent(this, order.getProductName(), OrderDetailActivity.class);
        //gets the product name  and sends it to OrderDetailsActivity class
    }
}
