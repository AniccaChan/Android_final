package com.example.android_final;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;

import java.time.LocalDate;
import java.util.Calendar;

public class setting_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_activity);
        Intent intent = getIntent();
        String type;
        type =  intent.getStringExtra("type");
        ImageView imageview = findViewById(R.id.imageView2);
        switch (type){
            case "sleep":
                imageview.setImageDrawable(getResources().getDrawable(R.drawable.sleep));
                break;
            case "sport":
                imageview.setImageDrawable(getResources().getDrawable(R.drawable.sport));
                break;
            case "pill":
                imageview.setImageDrawable(getResources().getDrawable(R.drawable.pill));
                break;
            case "reminder":
                imageview.setImageDrawable(getResources().getDrawable(R.drawable.reminder));
                break;
        }
    }
    public class dialog extends Dialog{
        public dialog(Context context){
            super(context);
        }

    }
    public void show(View view){
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int day = today.getDayOfYear();
        int year = Calendar.getInstance().getWeekYear();
        DatePickerDialog pickerDialog = new DatePickerDialog(this,

                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    }
                }, year, month, day);
        pickerDialog.show();
    }


}

