package com.example.android_final;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;

import static com.example.android_final.MainActivity.EXTRA_MESSAGE;

public class DisplayMessageActivity extends AppCompatActivity {
    static String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
    }
    public void sleep(View view){
        Intent intent = new Intent(this, setting_activity.class);
        intent.putExtra("type","sleep");
        startActivity(intent);
    }
    public void sport(View view){
        Intent intent = new Intent(this, setting_activity.class);
        intent.putExtra("type","sport");
        startActivity(intent);
    }
    public void pill(View view){
        Intent intent = new Intent(this, setting_activity.class);
        intent.putExtra("type","pill");
        startActivity(intent);
    }
    public void reminder(View view){
        Intent intent = new Intent(this, setting_activity.class);
        intent.putExtra("type","reminder");
        startActivity(intent);
    }
}
