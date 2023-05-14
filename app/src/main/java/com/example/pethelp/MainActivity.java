package com.example.pethelp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.example.pethelp.enums.Caes;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pethelp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private static MainActivity instace;

    public static MainActivity getInstace() {
        return instace;
    }
    private ImageButton cao1;
    private ImageButton cao2;
    private ImageButton cao3;
    private ImageButton cao4;
    private EditText ipview = null;
    private static String ip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_perfil, R.id.nav_lista,R.id.nav_chat)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        cao1 = findViewById(R.id.Cachorro1);
        cao2 = findViewById(R.id.Cachorro2);
        cao3 = findViewById(R.id.Cachorro3);
        cao4 = findViewById(R.id.Cachorro4);
        ipview = findViewById(R.id.IP);


        instace = this;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void goToDog(View v){
        Intent i = new Intent(MainActivity.getInstace(), AnimalActivity.class);
        ImageButton image = v.findViewById(v.getId());
        i.putExtra("Cao",v.getId());
        String fullName = getResources().getResourceName(v.getId());
        String name = fullName.substring(fullName.lastIndexOf("/") + 1);
        i.putExtra("Nome", name);
        passDog(i,image.getId());
        startActivity(i);
    }
    public void passDog(Intent i, int id){

        if (id == cao1.getId()){
            i.putExtra("Enum", Caes.CACHORRO1);
        } else if(id == cao2.getId()){
            i.putExtra("Enum", Caes.CACHORRO2);
        } else if(id == cao3.getId()){
            i.putExtra("Enum", Caes.CACHORRO3);
        } else if(id == cao4.getId()){
            i.putExtra("Enum", Caes.CACHORRO4);
        } else {
            throw new IllegalStateException("Unexpected value: " + id);
        }
    }

    public void setIP(){
        ip = this.ipview.getText().toString();
    }




    public static String getId(){
        return ip;
    }






}