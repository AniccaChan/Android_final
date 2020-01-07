package com.example.android_final;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;

import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.w3c.dom.Text;

import java.sql.Time;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Calendar;

public class setting_activity extends AppCompatActivity {

    String Month;
    String Day;
    String Hour;
    String Minute;
    String Type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_activity);
        Intent intent = getIntent();
        String type;
        type =  intent.getStringExtra("type");
        Type = type;
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
                default:
                    break;

        }
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        final TextView textView = findViewById(R.id.textView);
        final TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String selected = textView.getText() + String.valueOf(hourOfDay) + "點" + minute +"分";
                        Hour = String.valueOf(hourOfDay);
                        Minute = String.valueOf(minute);
                        textView.setText(selected);
                    }
                },hour,minute,false);
        DatePickerDialog pickerDialog = new DatePickerDialog(this,

                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date = (month+1) + "月" +dayOfMonth +"日";
                        Month = String.valueOf(month +1);
                        Day = String.valueOf(dayOfMonth);
                        textView.setText(date);
                        timePickerDialog.show();
                    }
                },year, month, day);
        pickerDialog.show();

    }
    public void OK(View view){
        Intent goback = new Intent(this,MainActivity.class);
        goback.putExtra("Hour",Hour);
        goback.putExtra("Minute",Minute);
        goback.putExtra("Day",Day);
        goback.putExtra("Month",Month);
        goback.putExtra("Type",Type);
        startActivity(goback);
    }
    public void record(View view){

    }
    public void play(View view){

    }


}

