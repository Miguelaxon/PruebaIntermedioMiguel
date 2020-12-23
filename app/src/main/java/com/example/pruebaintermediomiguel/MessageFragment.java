package com.example.pruebaintermediomiguel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pruebaintermediomiguel.databinding.FragmentMessageBinding;

public class MessageFragment extends Fragment {
    private FragmentMessageBinding eBinding;
    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        eBinding = FragmentMessageBinding.inflate(inflater, container, false);
        return eBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        eBinding.btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eBinding.btnFragment.setVisibility(View.GONE);
                eBinding.msgHolder.setVisibility(View.VISIBLE);
                eBinding.btnEnviar.setVisibility(View.VISIBLE);
            }
        });

        eBinding.btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(eBinding.msgEditText.getText().toString());
                eBinding.btnFragment.setVisibility(View.VISIBLE);
                eBinding.msgHolder.setVisibility(View.GONE);
                eBinding.btnEnviar.setVisibility(View.GONE);
            }
        });
    }

    public void sendMessage(String message){
        Intent intent = new Intent();
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL,"hideki.ahumada@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Correo a través de la APP");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("text/plain");
        startActivity(intent);
    }
}