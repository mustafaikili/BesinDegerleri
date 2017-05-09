package com.myt.ikili.besindeerleri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ikili on 26.01.2017.
 */

public class besinlerAdapter extends ArrayAdapter<Person> {


    public besinlerAdapter(Context context, int resource, List<Person> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.anasayfa_listview, null);

        }

        Person p = getItem(position);


        if (p != null) {
            ImageView personImage = (ImageView)v.findViewById(R.id.imgResim);
            TextView personName = (TextView)v.findViewById(R.id.textView_personname);


            if(personImage != null && personName != null ){
                personName.setText(p.getName());
                personImage.setImageResource(p.getPictureResourceID());
            }

        }
        return v;

    }
}

