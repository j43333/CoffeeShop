package uk.edu.le.co2103.lab14;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OrderDetailActivity extends AppCompatActivity {

    private EditText CustName;
    private EditText CustPhone;
    private TextView placedOrder;
    private String orderedValue;
    private ImageView imgOrderedDrink;
    private FloatingActionButton fab;
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_detail);
        order = new Order();
        fab = findViewById(R.id.fab_order);
        placedOrder = findViewById(R.id.txt_placeOrder);
        CustName = findViewById(R.id.custName);
        CustPhone = findViewById(R.id.custPhoneNum);
        imgOrderedDrink = findViewById(R.id.chosenDrink);

        //get ordered value from intent
        orderedValue = getIntent().getStringExtra("order");

        //set ordered value on text view
        placedOrder.setText(orderedValue);

        switch(orderedValue){
            case "Soy Latte":
                imgOrderedDrink.setImageResource(R.drawable.sb1);
                break;
            case "Chocco Frappe":
                imgOrderedDrink.setImageResource(R.drawable.sb2);
                break;
            case "Bottled Americano":
                imgOrderedDrink.setImageResource(R.drawable.sb3);
                break;
            case "Rainbow Frapp":
                imgOrderedDrink.setImageResource(R.drawable.sb4);
                break;
            case "Caramel Frapp":
                imgOrderedDrink.setImageResource(R.drawable.sb5);
                break;
            case "Black Forest Frapp":
                imgOrderedDrink.setImageResource(R.drawable.sb6);
                break;
        }
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                IntentHelper.shareIntent(OrderDetailActivity.this, orderedValue);
            }
        });
    }

}