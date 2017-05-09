package com.myt.ikili.besindeerleri;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listBesinler;
    MaterialSearchView searchView;

    String[] besinlerListesi = {
            "Tahıllar",
            "Süt Ürünleri",
            "Yumurta",
            "Yağlar",
            "Etler",
            "Deniz Ürünleri",
            "Sebzeler",
            "Kuruyemişler",
            "Meyveler",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar ab =getSupportActionBar();

        listBesinler = (ListView) findViewById(R.id.listBesinler);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, besinlerListesi);
        listBesinler.setAdapter(adapter);
        //action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Besin Değerleri");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        /*searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, besinlerListesi);
                listBesinler.setAdapter(adapter);
            }
        });

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null && !newText.isEmpty()){
                    List<String> lstFound = new ArrayList<String>();
                    for(String item:besinlerListesi){
                        if (item.contains(newText))
                            lstFound.add(item);
                    }
                    ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, besinlerListesi);
                    listBesinler.setAdapter(adapter);
                }
                else{
                    ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, besinlerListesi);
                    listBesinler.setAdapter(adapter);
                }
                return true;
            }
        });*/

        final ListView besinler = (ListView) findViewById(R.id.listBesinler);
        besinler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pozisyon = position;
                //Toast.makeText(getApplicationContext(),"a="+besinler.getAdapter().getItem(position),Toast.LENGTH_LONG).show();
                String baslik = besinler.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), BesinlerActivity.class);
                intent.putExtra("baslik", baslik);
                intent.putExtra("pozisyon", pozisyon);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Action Bar içinde kullanılacak menü öğelerini inflate edelim
        //MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.menu_main, menu);
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }
   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Action Bar öğelerindeki basılmaları idare edelim
        switch (item.getItemId()) {
            case R.id.action_settings:
                settings();
                return true;
            case R.id.action_search:
                arama();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void settings(){
        Toast.makeText(getApplicationContext(),"Yapım Aşamasında",Toast.LENGTH_LONG).show();
        //Intent myIntent = new Intent(getApplicationContext(), settings.class);
        //startActivity(myIntent);
    }
    public void arama(){
        Toast.makeText(getApplicationContext(),"Yapılıyor",Toast.LENGTH_LONG).show();
        //Intent myIntent = new Intent(getApplicationContext(), settings.class);
        //startActivity(myIntent);
    }*/
}
