package com.example.billigtlager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText etTo, etSubject, etMessage, etPhone, etName;
    Button btSend, door1, door2, door3, door4;

    DoorSystem doorSystem;

    FloatingActionButton fabDialling;

    NavController navController;
    AppBarConfiguration appBarConfiguration;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setupNavigation();

        //EditText
        etTo = findViewById(R.id.ET_to);
        etSubject = findViewById(R.id.ET_subject);
        etMessage = findViewById(R.id.ET_message);
        etPhone = findViewById(R.id.ET_phone);
        etName = findViewById(R.id.ET_name);

        //button
        btSend = findViewById(R.id.bt_send);
        door1 = findViewById(R.id.Door1);
        door2 = findViewById(R.id.Door2);
        door3 = findViewById(R.id.Door3);
        door4 = findViewById(R.id.Door4);

        //FAB
        fabDialling = findViewById(R.id.FAB_dial);

        //Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initViews() {
        drawerLayout = findViewById(R.id.drawer_layout);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        toolbar = findViewById(R.id.toolbar);
    }

    private void setupNavigation() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        setSupportActionBar(toolbar);

        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment,
                R.id.depotFragment,
                R.id.bookDepotFragment,
                R.id.aboutUsFragment,
                R.id.profileFragment)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
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


        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);



    }


    public void openDoors(View view) {
        doorSystem.openDoorsInNaestved(view);
    }

    public void Main_menu(Menu menu) { }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    // @Override
    // public boolean onOptionsItemSelected(@NonNull MenuItem item) {

    //  switch (item.getItemId()) {
    //      case R.id.front_page:
    //          Intent f = new Intent(this, FrontPage.class);
    //          startActivity(f);
    //          break;
    //      case R.id.open_door:
    //          Intent o = new Intent(this, OpenActivity.class);
    //          startActivity(o);
    //          break;
    //      case R.id.contact_page:
    //          Intent c = new Intent(this, ContactActivity.class);
    //          startActivity(c);
    //          break;
    //      case R.id.book_room:
    //          Intent b = new Intent(this, BookActivity.class);
    //          startActivity(b);
    //          break;

    //      case R.id.about_page:
    //          Intent a = new Intent(this, AboutActivity.class);
    //          startActivity(a);
    //          break;

    //  }

    //  return super.onOptionsItemSelected(item);
    //}

}