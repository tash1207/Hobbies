package co.tashawych.hobbies;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

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

    public void uploadDrawing(View view) {
        // TODO: Implement
    }

    public void saveDrawing(View view) {
        this.showSaveDialog();
    }

    private void showSaveDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Name your masterpiece!");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                drawingCanvas.setDrawingCacheEnabled(true);
                String drawingName = input.getText().toString();
                String imgSaved = MediaStore.Images.Media.insertImage(
                        getContentResolver(), drawingCanvas.getDrawingCache(),
                        drawingName != "" ? drawingName : "Drawing" + ".png", "drawing");
                Toast.makeText(getApplicationContext(),
                        imgSaved != null ? "Drawing saved!" : "Error occurred",
                        Toast.LENGTH_SHORT).show();
                drawingCanvas.destroyDrawingCache();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
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