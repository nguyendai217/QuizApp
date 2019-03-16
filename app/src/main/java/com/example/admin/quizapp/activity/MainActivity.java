package com.example.admin.quizapp.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.admin.quizapp.R;
import com.example.admin.quizapp.fragment.Fragment_About;
import com.example.admin.quizapp.fragment.Fragment_Chemistry;
import com.example.admin.quizapp.fragment.Fragment_English;
import com.example.admin.quizapp.fragment.Fragment_Home;
import com.example.admin.quizapp.fragment.Fragment_Math;
import com.example.admin.quizapp.fragment.Fragment_Physics;
import com.example.admin.quizapp.question.DBHelper;

import java.io.IOException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setTitle("Home");
        Fragment_Home fragmentHome = new Fragment_Home();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_main, fragmentHome, fragmentHome.getTag()).commit();

        DBHelper dbHelper= new DBHelper(this);
        try {
            dbHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
          Dialog dialog = new Dialog(MainActivity.this);
           showAlertDialog();
//            //  super.onBackPressed();
//
//        }
    }
    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông Báo");
        builder.setMessage("Bạn có muốn thoát hay không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportActionBar().setTitle("Home");
            Fragment_Home fragmentHome = new Fragment_Home();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main, fragmentHome, fragmentHome.getTag()).commit();
            // Handle the camera action
        } else if (id == R.id.nav_english) {
            getSupportActionBar().setTitle(" Tiếng Anh");
            Fragment_English fragmenEnglish = new Fragment_English();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main, fragmenEnglish, fragmenEnglish.getTag()).commit();

        }else if (id == R.id.nav_math) {
            getSupportActionBar().setTitle("  Môn Toán");
            Fragment_Math fragmentMath = new Fragment_Math();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main, fragmentMath, fragmentMath.getTag()).commit();

        }else if (id == R.id.nav_physics) {
            getSupportActionBar().setTitle("  Môn Vật Lý");
            Fragment_Physics fragmentPhysics = new Fragment_Physics();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main, fragmentPhysics, fragmentPhysics.getTag()).commit();

        } else if (id == R.id.nav_chemistry) {
            getSupportActionBar().setTitle(" Môn Hóa Học");
            Fragment_Chemistry fragmentChemistry = new Fragment_Chemistry();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main, fragmentChemistry, fragmentChemistry.getTag()).commit();


        } else if (id == R.id.nav_about) {
            getSupportActionBar().setTitle("   Thông tin");
            Fragment_About fragmentAbout = new Fragment_About();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main, fragmentAbout, fragmentAbout.getTag()).commit();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
