package com.myt.ikili.besindeerleri;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BesinlerActivity extends AppCompatActivity {
    Activity mContext;
    ListView besinlerListView;
    ArrayList besinlerList;
    MaterialSearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_besinler);

        Bundle gelenVeri = getIntent().getExtras();
        String baslik = gelenVeri.getString("baslik");
        int pozisyon = gelenVeri.getInt("pozisyon");
        //ActionBar ab = getSupportActionBar();
        //ab.setTitle(baslik);
        //ab.setSubtitle(pozisyon);
        //Toast.makeText(getApplicationContext(),pozisyon,Toast.LENGTH_LONG).show();
        mContext = this;
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(baslik);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));



        searchView = (MaterialSearchView)findViewById(R.id.search_view);


        //listview a verileri ekliyoruz
        besinlerListView = (ListView) findViewById(R.id.liste);
        besinlerList = new ArrayList();
        if (pozisyon == 0) {
            tahillar();
        } else if (pozisyon == 1) {
            besinlerList.add(new besinler("Sütlerrrrrrrrrrrrrrrrrrrrrr", "15", "12", "15", "15"));
            besinlerList.add(new besinler("Süt", "15", "12", "15", "15"));
            besinlerList.add(new besinler("Süt", "15", "12", "15", "15"));
            besinlerList.add(new besinler("Süt", "15", "12", "15", "15"));
            besinlerList.add(new besinler("Süt", "15", "12", "15", "15"));
            besinlerList.add(new besinler("Süt", "15", "12", "15", "15"));
            besinlerList.add(new besinler("Süt", "15", "12", "15", "15"));
            besinlerList.add(new besinler("Süt", "15", "12", "15", "15"));
        } else {
            besinlerList.add(new besinler("asasas", "15", "12", "15", "15"));
        }

        besinlerListAdapter besinlerlistadapter = new besinlerListAdapter();
        besinlerListView.setAdapter(besinlerlistadapter);

        /*searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                besinlerListView = (ListView) findViewById(R.id.liste);
                besinlerListAdapter besinlerlistadapter = new besinlerListAdapter();
                besinlerListView.setAdapter(besinlerlistadapter);
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
                    for(Object item:besinlerList){
                        if (item.equals(newText))
                            lstFound.add((String) item);
                    }
                    besinlerListAdapter besinlerlistadapter = new besinlerListAdapter();
                    besinlerListView.setAdapter(besinlerlistadapter);
                }
                else{
                    besinlerListAdapter besinlerlistadapter = new besinlerListAdapter();
                    besinlerListView.setAdapter(besinlerlistadapter);
                }
                return true;
            }
        });*/



    }

    class besinler {
        String adi;
        String protein;
        String yag;
        String karbonhidrat;
        String kalori;

        public besinler(String adi, String protein, String yag, String karbonhidrat, String kalori) {
            this.adi = adi;
            this.protein = protein;
            this.yag = yag;
            this.karbonhidrat = karbonhidrat;
            this.kalori = kalori;


        }

    }

    class besinlerListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return besinlerList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null)
                convertView = mContext.getLayoutInflater().inflate(
                        R.layout.list_row_besinler, parent, false);

            TextView besinAdi = (TextView) convertView
                    .findViewById(R.id.txtBesinAdi);
            TextView besinProtein = (TextView) convertView
                    .findViewById(R.id.txtProtein);
            TextView besinYag = (TextView) convertView
                    .findViewById(R.id.txtYag);
            TextView besinKarbonhidrat = (TextView) convertView
                    .findViewById(R.id.txtKhidrat);
            TextView besinKalori = (TextView) convertView
                    .findViewById(R.id.txtKalori);
            besinler besin = (besinler) besinlerList.get(position);

            besinAdi.setText(besin.adi);
            besinProtein.setText(besin.protein);
            besinYag.setText(besin.yag);
            besinKarbonhidrat.setText(besin.karbonhidrat);
            besinKalori.setText(besin.kalori);


            return convertView;

        }

    }

    public void tahillar() {


        besinlerList.add(new besinler("Buğday ekmeği", "7,2", "1,1", "53,1", "247"));
        besinlerList.add(new besinler("Bulgur", "12,5", "1,5", "69,8", "350"));
        besinlerList.add(new besinler("Erişte", "7,7", "5", "76", "390"));
        besinlerList.add(new besinler("Makarna", "7,7", "5", "76", "390"));
        besinlerList.add(new besinler("Mısır", "9,4", "2,2", "72", "351"));
        besinlerList.add(new besinler("Mısır unu", "9", "1,4", "74", "353"));
        besinlerList.add(new besinler("Nişasta", "10", "1", "74", "353"));
        besinlerList.add(new besinler("Pilav", "3,5", "21", "39,5", "368"));
        besinlerList.add(new besinler("Pirinç unu", "10", "1", "74", "353"));
        besinlerList.add(new besinler("Şehriye", "7,7", "5", "76", "390"));
        besinlerList.add(new besinler("Tarhana", "14,1", "3,9", "58,8", "329"));
        besinlerList.add(new besinler("Yulaf unu", "14", "7", "66", "402"));

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

    public void listAdapt(){

    }


}
