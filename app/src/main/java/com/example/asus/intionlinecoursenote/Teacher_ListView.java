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


public class Teacher_ListView extends Fragment {
    public Teacher_ListView() {
        //require empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher__list_view, container, false);
        getActivity().setTitle("Search Lecturer");

        String[] teacherName = {"Lecturer: Chris Pratt\nCourse: Android Development Skill", "Lecturer: Tom Jerry\nCourse: Software Engineer"};

        ListView listView = (ListView) view.findViewById(R.id.teacher_list);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                teacherName
        );
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();
                Fragment fragment;
                switch (position) {
                    case 0:
                        fragment = new Android_note();
                        replaceFragment(fragment);
                        break;
                    case 1:
                        fragment = new SE_note();
                        replaceFragment(fragment);
                        break;
                }

            }
            void replaceFragment(Fragment someFragment) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_teacher_list_view, someFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}
