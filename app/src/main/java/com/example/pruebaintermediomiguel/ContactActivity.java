package com.example.pruebaintermediomiguel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
                if (linkIntent == null){
                    Toast.makeText(ContactActivity.this,
                            "LinkedIn no se puede abrir o no está instalado",
                            Toast.LENGTH_LONG);
                } else {
                    startActivity(linkIntent);
                }
            }
        });

        eBinding.imageViewFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkIntent.setData(Uri.parse("https://www.facebook.com/Miguel.El.Bulla/"));
                if (linkIntent == null){
                    Toast.makeText(ContactActivity.this,
                            "Facebook no se puede abrir o no está instalado",
                            Toast.LENGTH_LONG);
                } else {
                    startActivity(linkIntent);
                }
            }
        });

        eBinding.imageViewPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCall();
            }
        });

        eBinding.imageViewWAPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageWhatsApp();
            }
        });

        eBinding.imageViewLin.setTooltipText("LinkedIn Miguel Ahumada");
        eBinding.imageViewFace.setTooltipText("FaceBook Miguel Ahumada");
        eBinding.imageViewWAPP.setTooltipText("WhatsApp Miguel Ahumada");
        eBinding.imageViewPhone.setTooltipText("Llamada a Miguel Ahumada");
    }

    public void onClickCall() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:56951316411"));
        startActivity(intent);
    }

    public void sendMessageWhatsApp(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        String uri = "whatsapp://send?phone=56951316411";
        intent.setData(Uri.parse(uri));
        intent.setPackage("com.whatsapp");
        startActivity(intent);
    }
}