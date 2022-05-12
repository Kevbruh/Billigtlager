package com.example.billigtlager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Rum9_10Activity extends AppCompatActivity {


    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rum9_10);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.front_page:
                Intent f = new Intent(this, FrontPage.class);
                startActivity(f);
                break;
            case R.id.open_door:
                Intent o = new Intent(this, OpenActivity.class);
                startActivity(o);
                break;
            case R.id.contact_page:
                Intent c = new Intent(this, ContactActivity.class);
                startActivity(c);
                break;
            case R.id.book_room:
                Intent b = new Intent(this, BookActivity.class);
                startActivity(b);
                break;

            case R.id.about_page:
                Intent a = new Intent(this, AboutActivity.class);
                startActivity(a);
                break;

        }

        return super.onOptionsItemSelected(item);
    }


}

