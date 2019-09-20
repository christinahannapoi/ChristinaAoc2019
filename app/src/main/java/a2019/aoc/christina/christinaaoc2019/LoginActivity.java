package a2019.aoc.christina.christinaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //1. properties defentition
    EditText editTextEmail, editTextPassword;
    Button buttonLogin, buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //2. initialize properties
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword= findViewById(R.id.editTextPassword);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);

        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==buttonLogin) {
            if (editTextPassword.getText().toString().equals("")||
                    editTextEmail.getText().toString().equals(""))
            {
                Toast.makeText(this, "Empty Email or Password", Toast.LENGTH_LONG);
            }

            else{
                Intent i = new Intent (this, MainActivity.class);
                i.putExtra("Email", editTextEmail.getText().toString());
                i.putExtra("Password", editTextPassword.getText().toString());
                startActivity(i);
            }

        }
        else{
            Intent i = new Intent (this, SignUpActivity.class);
            startActivity(i);
        }
    }
}
