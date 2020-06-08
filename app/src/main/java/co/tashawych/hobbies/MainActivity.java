package co.tashawych.hobbies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDrawingActivity(View view) {
        Intent drawingActivityIntent = new Intent(getApplicationContext(), DrawingActivity.class);
        startActivity(drawingActivityIntent);
    }
}