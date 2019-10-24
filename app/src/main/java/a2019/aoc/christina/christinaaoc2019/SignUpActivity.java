package a2019.aoc.christina.christinaaoc2019;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextName, editTextPassword, editTextEmail;
    Button buttonSignUp, infoButton;
    ImageButton imageButtonProfile;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();

            editTextName = findViewById(R.id.editTextName);
            editTextEmail = findViewById(R.id.editTextEmail);
            editTextPassword = findViewById(R.id.editTextPassword);
            imageButtonProfile = findViewById(R.id.imageButtonProfile);
            imageButtonProfile.setOnClickListener(this);
            buttonSignUp = findViewById(R.id.buttonSignUp);
            buttonSignUp.setOnClickListener(this);
            infoButton = findViewById(R.id.infoButton);
            infoButton.setOnClickListener(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public  void signUp(String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {

        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
           if (task.isSuccessful()) {
                            Intent i = new Intent(SignUpActivity.this, SetGoalActivity.class);
                            i.putExtra("Name", editTextName.getText().toString());
                            i.putExtra("Email", editTextEmail.getText().toString());
                            i.putExtra("Password", editTextPassword.getText().toString());
                            startActivity(i);
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("firebase", "createUserWithEmail:success");
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
        public void onClick (View v)
        {
            if (v == buttonSignUp) {
                if (editTextPassword.getText().toString().equals("") ||
                        editTextEmail.getText().toString().equals("") || editTextName.getText().toString().equals("")) {
                    Toast.makeText(this, "Empty Name, Email or Password", Toast.LENGTH_LONG);
                } else {

                }
            }
            if (v==imageButtonProfile)
            {
                Intent i2 = new Intent(this, CameraActivity.class);
                startActivity(i2);
            }
            if (v==infoButton)
            {
                Intent i3 = new Intent (this, InformationActivity.class);
                startActivity(i3);
            }

        }

}




