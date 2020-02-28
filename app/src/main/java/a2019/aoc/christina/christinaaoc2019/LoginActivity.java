package a2019.aoc.christina.christinaaoc2019;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //1. properties defentition
    private FirebaseAuth mAuth;
    EditText editTextEmail, editTextPassword;
    Button buttonLogin, buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        //2. initialize properties
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword= findViewById(R.id.editTextPassword);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);

        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.go2_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent goToNextActivity = new Intent (getApplicationContext(), LoginActivity.class);

        switch (item.getItemId()) {
            case R.id.infoItem:
                goToNextActivity = new Intent(getApplicationContext(), InformationActivity.class);
                AlertDialog.Builder Builder3;
                Builder3 = new AlertDialog.Builder(LoginActivity.this);
                Builder3.setMessage("Are you sure you want to leave this page?");
                Builder3.setCancelable(false);

                final Intent finalGoToNextActivity2 = goToNextActivity;
                Builder3.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(finalGoToNextActivity2);
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog Alert3 = Builder3.create();
                Alert3.show();
                break;
        }
        return true;
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
                SignIn(editTextEmail.getText().toString(),editTextPassword.getText().toString());
            }

        }
        if (v==buttonSignUp) {
            Intent i2 = new Intent (this, SignUpActivity.class);
            startActivity(i2);
        }
    }
    public void SignIn(String email,String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                        //    Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                          //  updateUI(user);
                            Intent i = new Intent (LoginActivity.this,MainCounterActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                          //  Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        //    updateUI(null);
                        }

                        // ...
                    }
                });
    }
}
