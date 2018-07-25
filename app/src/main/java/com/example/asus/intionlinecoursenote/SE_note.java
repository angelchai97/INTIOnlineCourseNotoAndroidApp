package com.example.asus.intionlinecoursenote;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class SE_note extends Fragment {
    public SE_note() {
        //require empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_se_note, container, false);
        getActivity().setTitle("Software Engineering");

        String[] SEnote = {"Week 1", "Week 2"};

        ListView listView = (ListView) view.findViewById(R.id.note_2);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                SEnote
        );
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();
                Fragment fragment;
                switch (position) {
                    case 0:
                        fragment = new Functional_note();
                        replaceFragment(fragment);
                        break;
                    case 1:
                        fragment = new NonFuntional_note();
                        replaceFragment(fragment);
                        break;
                }

            }
            void replaceFragment(Fragment someFragment) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_se_note, someFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}
