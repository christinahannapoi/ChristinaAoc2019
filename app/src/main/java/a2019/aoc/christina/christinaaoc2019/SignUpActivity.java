package a2019.aoc.christina.christinaaoc2019;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Set;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextName, editTextPassword, editTextEmail;
    Button buttonSignUp;
    ImageButton profileImageButton;

    private FirebaseAuth mAuth;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.go2_menu, menu);
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();


        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        profileImageButton = findViewById(R.id.profileImageButton);
        profileImageButton.setOnClickListener(this);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(this);
        Intent i = getIntent();
        if (i.getExtras()!=null)
        {
            profileImageButton.setImageBitmap((Bitmap)i.getExtras().get("image"));
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void signUp(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(SignUpActivity.this, SetGoalActivity.class);
                            i.putExtra("Name", editTextName.getText().toString());
                            i.putExtra("Email", editTextEmail.getText().toString());
                            i.putExtra("Password", editTextPassword.getText().toString());
                            startActivity(i);
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("firebase","createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("firebase", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });


    }

    public void onClick(View v) {
        if (v == buttonSignUp) {
            if (editTextPassword.getText().toString().equals("") ||
                    editTextEmail.getText().toString().equals("") || editTextName.getText().toString().equals("")) {
                Toast.makeText(this, "Empty Name, Email or Password", Toast.LENGTH_LONG);
            } else {
                signUp(editTextEmail.getText().toString(),editTextPassword.getText().toString());
            }
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent goToNextActivity = new Intent(getApplicationContext(), InformationActivity.class);

        switch (item.getItemId()) {
            case R.id.infoItem:
                goToNextActivity = new Intent(getApplicationContext(),InformationActivity.class);
                AlertDialog.Builder Builder;
                Builder = new AlertDialog.Builder(SignUpActivity.this);
                Builder.setMessage("Are you sure you want to leave this page?");
                Builder.setCancelable(false);

                final Intent finalGoToNextActivity = goToNextActivity;
                Builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(finalGoToNextActivity);
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog Alert = Builder.create();
                Alert.show();
                break;
        }
        return true;
    }
}






