package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    String[] listItems;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.txtView);
        Button showDialog = findViewById(R.id.showsnackbarbtn);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listItems = new String[]{"Item 1", "Item 2", "Item 3"};
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity2.this);
                mBuilder.setTitle("Choose an item");
                mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView.setText(listItems[i]);
                        dialogInterface.dismiss();
                    }
                });
                // Set the neutral/cancel button click listener
                mBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when click the neutral button
                        dialog.cancel();
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();

            }
        });

    }

}