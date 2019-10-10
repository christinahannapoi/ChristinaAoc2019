package a2019.aoc.christina.christinaaoc2019;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int CAMERA_REQUEST = 0;
    Button cameraButton, button2;
    ImageView imageView;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        cameraButton.findViewById(R.id.cameraButton);
        button2.findViewById(R.id.button2);
        imageView.findViewById(R.id.imageView);

        cameraButton.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == cameraButton)
        {
            Intent i = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,CAMERA_REQUEST);
        }
    }

    public void onActivityResult (int requestCode, int resultCode, Intent data)
    {
        if (requestCode==CAMERA_REQUEST && resultCode== Activity.RESULT_OK)
        {
            bitmap = (Bitmap) data.getExtras().get(" Data ");
            imageView.setImageBitmap(bitmap);
        }
    }
}
