package com.milanapp.paypalpaymentmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {

    private TextView txtId,txtAmmount,txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);
        txtId=findViewById(R.id.txtId);
        txtAmmount=findViewById(R.id.txtAmmount);
        txtStatus=findViewById(R.id.txtStatus);


        Intent intent = getIntent();

        try {
            JSONObject  object = new JSONObject(intent.getStringExtra("paymentdetail"));
            showDeatails(object.getJSONObject("response"),intent.getStringExtra("paymentamount"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void showDeatails(JSONObject response, String paymentamount) {

        try {
            txtId.setText(response.getString("id"));
            txtAmmount.setText(response.getString("state"));
            txtStatus.setText(response.getString(String.format("$%#",paymentamount)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
