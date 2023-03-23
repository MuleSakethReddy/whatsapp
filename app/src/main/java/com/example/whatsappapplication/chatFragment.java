package com.example.whatsappapplication;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;



import android.app.Fragment;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class chatFragment extends Fragment {

    ListView simpleList;
    String countryList[] = {"A", "B", "C", "D", "E", "F", "G"};
    int icons[] = {R.drawable.icon, R.drawable.icon};
    String[] contname;
    String[] contnum;

    ListView listView;
    public ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle data = this.getArguments();
        if (data != null) {
            contname = data.getStringArray("name");
            contnum = data.getStringArray("num");
            Log.d("Success4", "value:" + contname);

        }
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle data = this.getArguments();
        if (data != null) {
            contname = data.getStringArray("name");
            contnum = data.getStringArray("num");
            Log.d("Success4", "value:" + contname);

        }
        Log.d("Success4", "value:" + contname);

        super.onViewCreated(view, savedInstanceState);
//        listView = view.findViewById(R.id.simpleListView); //listview from xml
//        arrayList = new ArrayList<>(); //empty array list.
//        arrayAdapter = new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
//        listView.setAdapter(arrayAdapter);
//
//        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext() , Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
//// requesting to the user for permission.
//            requestPermissions( new String[]{Manifest.permission.READ_CONTACTS}, 100);
//
//        } else {
////if app already has permission this block will execute.
//            readContacts();
//        }

//
//        imv=view.findViewById(R.id.imageView2);
//        Log.d("Success2","value: "+imstr);
//        String imagename=String.valueOf(imstr);
//        imv.setImageResource(getResources().getIdentifier(imagename, "drawable", getActivity().getPackageName()));
//        tv=view.findViewById(R.id.textView4);
//        tv.setText(detstr);
        simpleList = (ListView) view.findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getActivity().getApplicationContext(), contname, icons);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+contnum[i]));
                startActivity(intent);
                Log.d("Success5","value:"+contnum[i]);
            }
        });
        simpleList.setAdapter(customAdapter);


    }


//    public void onItemClick(AdapterView<?> custom, View view, int i, long l) {
//        Intent intent=new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:"+contnum[i]));
//        startActivity(intent);
//        Log.d("Success5","value:"+contnum[i]);
//
//    }
//    private void readContacts() {
//        ContentResolver contentResolver=getActivity().getApplicationContext().getContentResolver();
//        Cursor cursor=contentResolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
//        if (cursor.moveToFirst()){
//            do {     arrayList.add(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
//            }while (cursor.moveToNext());
//            arrayAdapter.notifyDataSetChanged();
//        }
//    }

}