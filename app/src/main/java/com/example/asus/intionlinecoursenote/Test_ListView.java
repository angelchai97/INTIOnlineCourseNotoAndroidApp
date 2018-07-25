package com.example.asus.intionlinecoursenote;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class Test_ListView extends Fragment {

    public Test_ListView() {
        //require empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test__list_view, container, false);
        getActivity().setTitle("Test");

        String[] test = {"Android Development Skill", "Software Engineer"};

        ListView listView = (ListView) view.findViewById(R.id.test_list);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                test
        );
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();
                switch (position) {
                    case 0:
                        Intent moveToAndroidTest = new Intent(getActivity(), Android_allquestion.class);
                        startActivity(moveToAndroidTest);
                        break;

                    case 1:
                        Intent moveToSETest = new Intent(getActivity(), SE_allquestion.class);
                        startActivity(moveToSETest);
                        break;
                }

            }
            void replaceFragment(Fragment someFragment) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_test_list_view, someFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }

}
