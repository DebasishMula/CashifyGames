package com.example.cashifygames;

import Adapter.CustomAdapter;
import Apis.APIService;
import Apis.APIUrl;
import Fragements.Home;
import Fragements.More;
import Fragements.MyContest;
import Fragements.MyProfile;
import PojoClasses.RetroPhoto;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,Toolbar.OnMenuItemClickListener{
   private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.cricketMainActivity);//connecting layout view with layout object
        NavigationView navigationView = findViewById(R.id.cricketHomeNavigationTop);//connecting navigation view with navigation object
        //binding View widget  With Object
         toolbar=findViewById(R.id.cricketHomeToolbar);

        toolbar.inflateMenu(R.menu.cricket_home_toolbar_menu);
        toolbar.setOnMenuItemClickListener(this);
        toolbar.setLogo(R.drawable.ic_person);
        // Find logo
        View view = toolbar.getChildAt(1);
        //to open navigation after clicking Logo Icon
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
                // Perform actions
            }
        });


        //loading the default fragment
        loadFragment(new Home());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.cricketHomeNavigationButtom);
        navigation.setOnNavigationItemSelectedListener(MainActivity.this);
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:

                fragment = new Home();
                break;

            case R.id.navigation_myContest:

                fragment = new MyContest();
                break;


            case R.id.navigation_more:

                fragment = new More();
                break;
        }

        return loadFragment(fragment);
    }


//       final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
//        progressDialog.setMessage("Loading....");
//        progressDialog.show();
//        APIService service= APIUrl.getRetrofitInstance().create(APIService.class);
//        Call<List<RetroPhoto>> call = service.getAllPhotos();
//        call.enqueue(new Callback<List<RetroPhoto>>() {
//                         @Override
//                         public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
//
//                             progressDialog.dismiss();
//                             generateDataList(response.body());
//                         }
//
//                         @Override
//                         public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
//                          progressDialog.dismiss();
//                             Toast.makeText(getApplicationContext(),"Something Went Wrong ....Please Try Again",Toast.LENGTH_SHORT).show();
//                         }
//                     }
//
//
//        );


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.cricketFragmentContainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.cricket_toolbar_home_wallet:
                Toast.makeText(getApplicationContext(), " nbnnbh", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }


//    private void generateDataList(List<RetroPhoto> photoList)
//    {
//        RecyclerView recyclerView=findViewById(R.id.customRecyclerView);
//        CustomAdapter adapter=new CustomAdapter(this,photoList);
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//
//    }

}
