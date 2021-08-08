package com.example.gate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class workers extends AppCompatActivity {
    private EditText nameEdt, phoneNumberEdt, detailEdt,vehicleNumberEdt, blockEdt,entryTimeEdt;
    private String name, phoneNumber, detail, vehicleNumber, block, entryTime;
    Button submit;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workers);

        nameEdt = findViewById(R.id.editTextTextPersonName);
        phoneNumberEdt = findViewById(R.id.editTextNumberPassword);
        detailEdt = findViewById(R.id.editTextTextPersonName2);
        blockEdt = findViewById(R.id.editTextTextPersonName4);
        vehicleNumberEdt = findViewById(R.id.editTextTextPersonName3);
        entryTimeEdt = findViewById(R.id.editTextTextPersonName5);
        submit = findViewById(R.id.visitorbutton);
        db = FirebaseFirestore.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting data from edittext fields.
                name = nameEdt.getText().toString();
                phoneNumber = phoneNumberEdt.getText().toString();
                detail = detailEdt.getText().toString();
                vehicleNumber = vehicleNumberEdt.getText().toString();
                block = blockEdt.getText().toString();
                entryTime = entryTimeEdt.getText().toString();

                // validating the text fields if empty or not.
                if (TextUtils.isEmpty(name)) {
                    nameEdt.setError("Please enter Worker's Name");
                } else if (TextUtils.isEmpty(phoneNumber)) {
                    phoneNumberEdt.setError("Please enter Phone Number");
                } else if (TextUtils.isEmpty(detail)) {
                    detailEdt.setError("Please enter Work Type ");
                }else if (TextUtils.isEmpty(block)) {
                    blockEdt.setError("Please enter Block ");
                }else if (TextUtils.isEmpty(entryTime)) {
                    entryTimeEdt.setError("Please enter Entry Time ");
                } else {
                    // calling method to add data to Firebase Firestore.
                    addDataToFirestore(name,phoneNumber,detail,vehicleNumber,block,entryTime);
                }
            }
        });
    }

    private void addDataToFirestore(String name, String phoneNumber, String detail, String vehicleNumber,String block,String entryTime) {

        // creating a collection reference
        // for our Firebase Firetore database.
        CollectionReference dbEntry = db.collection("Entry");

        // adding our data to our courier object class.
        entryData entryData = new entryData(name,phoneNumber,detail,vehicleNumber,block,entryTime);

        // below method is use to add data to Firebase Firestore.
        dbEntry.add(entryData).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // after the data addition is successful
                // we are displaying a success toast message.
                Toast.makeText(workers.this, "Your Worker's Entry has been added successfully", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                Toast.makeText(workers.this, "Fail to add entry \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }
}