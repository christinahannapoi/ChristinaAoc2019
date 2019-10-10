package a2019.aoc.christina.christinaaoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.Intent;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextName, editTextPassword, editTextEmail;
    Button buttonSignUp;
    ImageButton imageButtonProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


            editTextName = findViewById(R.id.editTextName);
            editTextEmail = findViewById(R.id.editTextEmail);
            editTextPassword = findViewById(R.id.editTextPassword);
            imageButtonProfile = findViewById(R.id.imageButtonProfile);
            imageButtonProfile.setOnClickListener(this);
            buttonSignUp = findViewById(R.id.buttonSignUp);
            buttonSignUp.setOnClickListener(this);

    }
        public void onClick (View v)
        {
            if (v == buttonSignUp) {
                if (editTextPassword.getText().toString().equals("") ||
                        editTextEmail.getText().toString().equals("") || editTextName.getText().toString().equals("")) {
                    Toast.makeText(this, "Empty Name, Email or Password", Toast.LENGTH_LONG);
                } else {
                    Intent i = new Intent(this, SetGoalActivity.class);
                    i.putExtra("Name", editTextName.getText().toString());
                    i.putExtra("Email", editTextEmail.getText().toString());
                    i.putExtra("Password", editTextPassword.getText().toString());
                    startActivity(i);
                }
            }
            if (v==imageButtonProfile)
            {
                Intent i = new Intent(this, CameraActivity.class);
                startActivity(i);
            }

            }

        }




