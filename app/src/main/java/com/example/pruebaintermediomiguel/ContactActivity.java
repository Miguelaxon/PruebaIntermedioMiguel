package com.example.pruebaintermediomiguel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pruebaintermediomiguel.databinding.ActivityContactBinding;

public class ContactActivity extends AppCompatActivity {
    private ActivityContactBinding eBinding;
    Intent linkIntent = new Intent(Intent.ACTION_VIEW);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eBinding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(eBinding.getRoot());

        eBinding.imageViewLin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkIntent.setData(Uri.parse("http://www.linkedin.com/in/miguelantonioahumadacaamaño"));
                startActivity(linkIntent);
            }
        });

        eBinding.imageViewFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkIntent.setData(Uri.parse("https://www.facebook.com/Miguel.El.Bulla/"));
                startActivity(linkIntent);
            }
        });

        eBinding.imageViewPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareWhatsApp("Hola, gracias por contactar, \ndeje su mensaje para contactarnos.");
            }
        });
    }
    public void shareWhatsApp(String mensaje){
        linkIntent = new Intent(Intent.ACTION_SEND);
        linkIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        linkIntent.setType("text/plain");
        linkIntent.setPackage("com.whatsapp");
        //linkIntent.setPackage("https://wa.me/56951316411");
        //linkIntent.setPackage("https://api.whatsapp.com/send?phone=56951316411");
        startActivity(linkIntent);
    }
}