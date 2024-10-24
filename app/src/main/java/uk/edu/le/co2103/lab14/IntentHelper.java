package uk.edu.le.co2103.lab14;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntentHelper {

    public static void openIntent(Context context, String value, Class passTo) {
        //context tells Toast which activity to popup in or activity where it is originating from
        Intent i = new Intent(context, passTo);
        //declares intent w/ context and the class to pass the value to
        String order = value;

        i.putExtra("order", order);
        //pass through the string value with key "order"

        //starts activity
        context.startActivity(i);
    }

    //Creating implicit intent method
    public static void shareIntent(Context context, String order) {
        Intent sendIntent = new Intent();
        //set action to indicate what to do - send

        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, order);

        //sending plain text
        sendIntent.setType("text/plain");

        //show share Sheet
        Intent shareIntent = Intent.createChooser(sendIntent, null);
        context.startActivity(shareIntent);
    }

    public static void shareIntent(Context context, String productName, String customerName, String customerPhone) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);

        //creates bundle and adding multiple values to it
        Bundle shareOrderDetails = new Bundle();
        shareOrderDetails.putString("productName", productName);
        shareOrderDetails.putString("customerName", customerName);
        shareOrderDetails.putString("customerPhone", customerPhone);

        //share whole bundle
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareOrderDetails);
        sendIntent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(sendIntent, null);
        context.startActivity(shareIntent);

    }

}
