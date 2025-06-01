package com.example.testapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(new Phone(1, "Abdelali","0607080900"));
        phoneList.add(new Phone(2, "Ahmed","0607080988"));
        phoneList.add(new Phone(3, "Samir","06073830900"));
        phoneList.add(new Phone(1, "Abdelali","0607080900"));
        phoneList.add(new Phone(2, "Ahmed","0607080988"));
        phoneList.add(new Phone(3, "Samir","06073830900"));
        phoneList.add(new Phone(1, "Abdelali","0607080900"));
        phoneList.add(new Phone(2, "Ahmed","0607080988"));
        phoneList.add(new Phone(3, "Samir","06073830900"));
        phoneList.add(new Phone(1, "Abdelali","0607080900"));
        phoneList.add(new Phone(2, "Ahmed","0607080988"));
        phoneList.add(new Phone(3, "Samir","06073830900"));
        phoneList.add(new Phone(1, "Abdelali","0607080900"));
        phoneList.add(new Phone(2, "Ahmed","0607080988"));
        phoneList.add(new Phone(3, "Samir","06073830900"));
        phoneList.add(new Phone(1, "Abdelali","0607080900"));
        phoneList.add(new Phone(2, "Ahmed","0607080988"));
        phoneList.add(new Phone(3, "Samir","06073830900"));

        PhoneBookAdapter phoneBookAdapter = new PhoneBookAdapter(phoneList);
        RecyclerView rvNumbers = findViewById(R.id.rv_numbers);
        rvNumbers.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        rvNumbers.setAdapter(phoneBookAdapter);

        EditText edtName = findViewById(R.id.edt_name);
        EditText edtPhone = findViewById(R.id.edt_phone);
        Button btnSave = findViewById(R.id.btn_save);
        // Listener du bouton Save
        btnSave.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String phone = edtPhone.getText().toString().trim();

            if (!name.isEmpty() && !phone.isEmpty()) {
                Phone newPhone = new Phone(phoneList.size() + 1, name, phone);
                phoneList.add(newPhone);
                phoneBookAdapter.notifyItemInserted(phoneList.size() - 1);

                edtName.setText("");
                edtPhone.setText("");
            }
            });
    }
}