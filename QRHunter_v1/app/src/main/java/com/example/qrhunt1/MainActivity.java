package com.example.qrhunt1;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.qrhunt1.ui.Login.CallbackFragment;
import com.example.qrhunt1.ui.Login.LoginFragment;
import com.example.qrhunt1.ui.Login.SignupFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        //Initialize Firebase Auth
        FirebaseAuth mAuth = FirebaseAuth.getInstance();


        // For Real-time database
//        database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//        myRef.setValue("Hello, World!2");

        // For Firestore add info
        CollectionReference collectionReference = db.collection("users");
        Map<String, String> user = new HashMap<>();
        user.put("DisplayName", "user 2 UserName Test");
        user.put("PassWord","user 2 PassWord Test");
        user.put("ContactInfo","user 2 Hub mall");

        String userName = "User2";

        collectionReference.document(userName)
                .set(user);

//        db.collection("users")
//                .add(user)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                          @Override
//                                          public void onSuccess(DocumentReference documentReference) {
//                                              Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                                          }
//                                      })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG,"Error adding document",e);
//                    }
//                });

        login();
    }

    public void login() {

        // Todo - Try to block the MainActivity Once Login Successful
        // Todo - In Create Account Activity back to MainActivity is possible.
        // Todo - Click On Login Button, Compare With DataBase. Fail: Re prompt Users

        Button loginButton = findViewById(R.id.login_btn);
        TextView create = findViewById(R.id.createnew);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NaviTest.class);
                startActivity(intent);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sign_up.class);
                startActivity(intent);
            }
        });
    }
}