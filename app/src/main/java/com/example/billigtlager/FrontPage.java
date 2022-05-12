package com.example.billigtlager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FrontPage extends AppCompatActivity {




        Toolbar toolbar;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.front_page);


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
                    setContentView(R.layout.open_door);
                    break;
                case R.id.contact_page:
                    Intent c = new Intent(this, ContactActivity.class);
                    startActivity(c);
                    break;
                case R.id.book_room:
                    setContentView(R.layout.book_room);
                    break;

                case R.id.about_page:
                    setContentView(R.layout.about_us);
                    break;

                case R.id.Rum3_4:
                    setContentView(R.layout.rum3_4);
                    break;

            }

            return super.onOptionsItemSelected(item);
        }


    }

