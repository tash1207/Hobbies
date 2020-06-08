package co.tashawych.hobbies;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class DrawingActivity extends AppCompatActivity {

    private DrawingCanvas drawingCanvas;
    private Button selectedPaintColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

        drawingCanvas = findViewById(R.id.drawingCanvas);
        LinearLayout paintColors = findViewById(R.id.paintColors);
        selectedPaintColor = (Button) paintColors.getChildAt(0);
    }

    public void setPaintColor(View view) {
        if (selectedPaintColor != view) {
            String color = view.getTag().toString();
            drawingCanvas.setColor(color);

            selectedPaintColor.setBackgroundResource(0);
            selectedPaintColor = (Button) view;
            selectedPaintColor.setBackgroundResource(R.drawable.selected_button);
        }
    }
}