package com.example.android_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    static int on_create =0;
    public static final String EXTRA_MESSAGE = "com.example.Android_final.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(on_create != 0){
            Intent intent = getIntent();
            set(intent);
        }
        on_create++;

    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);//must store the new intent unless getIntent() will return the old one
        set(intent);
    }
    public void set(Intent intent){
        String type = intent.getStringExtra("Type");
        String day = intent.getStringExtra("Day");
        String month = intent.getStringExtra("Month");
        String hour = intent.getStringExtra("Hour");
        String minute = intent.getStringExtra("Minute");
        ImageView imageView = findViewById(R.id.Image1);
        TextView textView = findViewById(R.id.Text1);
        String print = month + "月" + day+ "日\n" + hour + "點" + minute + "分";
        textView.setText(print);
        //imageView.setImageDrawable(getDrawable(R.drawable.sleep));
        imageView.setVisibility(View.VISIBLE );
        FrameLayout frameLayout = findViewById(R.id.frameLayout2);
        frameLayout.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        switch (type){
            case "sleep":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sleep));
                break;
            case "sport":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.sport));
                break;
            case "pill":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pill));
                break;
            case "reminder":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.reminder));
                break;
            default:
                break;

        }
    }

    public void Show(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }

}
