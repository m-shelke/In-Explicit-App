package com.example.in_explicitintentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        Button btnDialPad = findViewById(R.id.btnDialPad);
        Button btnMessanger = findViewById(R.id.btnMessangerApp);
        Button btnEmail = findViewById(R.id.btnEmailApp);
        Button btnShare = findViewById(R.id.btnShareApp);


        btnDialPad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);          //or
                intent.setAction(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:+91 7058264634"));
                startActivity(intent);
            }
        });

        btnMessanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+Uri.encode("7058264634")));
                intent.putExtra("sms_body","Hey, Mahesh Shelke from this side");
                startActivity(intent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"mshelke074@gmail.com","mshelke0508@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"Question Regarding");
                intent.putExtra(Intent.EXTRA_TEXT,"I have serious qustion about the content, that you provided in the video");
                startActivity(Intent.createChooser(intent,"Email Via :"));
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"Download This App,https://play.google.com/store/apps/details?id=com.tiramisu.driftmax2&pcampaignid=merch_published_cluster_promotion_battlestar_featured_games");
                startActivity(Intent.createChooser(intent,"Share Via"));
            }
        });

    }
}