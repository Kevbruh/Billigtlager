package com.example.billigtlager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.example.billigtlager.db.AppDatabase;
import com.example.billigtlager.db.Depotrum;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    static FragmentManager fragmentManager;
    static AppDatabase appDatabase;

  //  private DepotrumListAdapter depotrumListAdapter;

    Toolbar toolbar;

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

        //Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Data base
        fragmentManager = getSupportFragmentManager();
            appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "Mydb").allowMainThreadQueries().build();
        if (findViewById(R.id.Container) != null) {
            if (savedInstanceState != null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.Container, new AddAvailableRoomActivity(), null).commit();

        }

/*

          Button addAvailableRoomButton = findViewById(R.id.addAvailableRoomButton);
         addAvailableRoomButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
         startActivityForResult(new Intent(MainActivity.this, AddAvailableRoomActivity.class), 100);
           }
          });

         initRecyclerView();
            loadDepotrumlist();
       }

       private void initRecyclerView() {
          RecyclerView recyclerView = findViewById(R.id.recyclerView);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));

         DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
         recyclerView.addItemDecoration(dividerItemDecoration);
         depotrumListAdapter = new DepotrumListAdapter(this);
         recyclerView.setAdapter(depotrumListAdapter);
          }

         private void loadDepotrumlist() {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<Depotrum> depotrumList = db.depotrumDAO().getAllDepotrum();
         depotrumListAdapter.setDepotrumList(depotrumList);
          }

         @Override
         protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         if(requestCode == 100) {
            loadDepotrumlist();
               }

               super.onActivityResult(requestCode, resultCode, data);
           }
*/
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
                R.id.contactFragment,
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
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }

    //skal det her v??k?
    public void Main_menu(Menu menu) { }
    }