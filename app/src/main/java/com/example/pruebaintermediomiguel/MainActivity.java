package com.example.pruebaintermediomiguel;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        ImageView imageView1 = findViewById(R.id.imageViewAM);
        String url01 = "https://media-exp1.licdn.com/dms/image/C4E35AQEQjpSm2FGiJQ/profile-framedphoto-shrink_200_200/0/1606652051962?e=1608818400&v=beta&t=uwN_th0CekLpu8ymd1xsh_DDce1VpKwE5wENQhLSWW8";
        String url = "https://lh3.googleusercontent.com/9Gv1dCcuqkKXL3xwSBM7oxqtEA8pEUL465DwCm_euDqeoGz1VsPcno-1gzqhRAQNkZQz0CxvY2FDpUORo1K-SOVc63rdFprbRCReIHPwue--UIrhCYI71Jyp9XrGuGzTfJyAgie6Y4gc8n_xSWmNcT33L1KCxo-MTllJSBNP39D4RWiL_DMcGIK-reKRRnVte9dPK2wX9-yoAgaSI467dh8HIJNBSP1fGs-KC9WGa--HOe5Pcb1Qmq8cJ6_EFSHLHisXeJ6L7aDxJsR10s8Sxgu3RQQMtXQxhiW2U7mYaybo7rQ8GDI-rMS4h5wHtSj8MlN7UfalppuwqNkvUTBWA-GCOKtP-o3HsHRSkGMuYrnD6Zut2iFtKBe3WySAZ7accJuAfSiDGD7yG8k5yq5ff5TYIcnnSb8zGQuLsSNgVopan9ifoFNJwrGv5yqBJRKc_62g8x8euadUXhK-mJ-IvOo8gCbRkKYFQM-fhbeYUXqzXmr6maZ1ipoaFFnH0Vs803Lp2Ateis3Go73Y_6tPWMbCUUY79fn5h7Y0byGqh78981lvr3oKyXiNvyznO9PIbKD8jFEix50QfSoJXRCWsMm5PPvz_exPe7uU-iNerR540KQdzf6cSaVt9618cqjhFWSAWl7QuM9hJ6BzXJHp2mfGO3d7UIsN5yCrCEr1zlqepFOvb_tYoK7s-e4FeA=w834-h625-no?authuser=0";
        Glide.with(this).load(url01).centerCrop().into(imageView1);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ContactActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}