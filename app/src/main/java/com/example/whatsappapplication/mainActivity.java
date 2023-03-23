package com.example.whatsappapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
//
//public class mainActivity {
//}


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class mainActivity extends Activity {
    ArrayList<String> arrayList= new ArrayList<String>();
    ArrayList<String> alContacts = new ArrayList<String>();


    ListView simpleList;
    String countryList[] = {"A", "B", "C", "D","E","F","G"};
    int flags[] = {R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon};
//    FragmentManager fm=getFragmentManager();
//    FragmentTransaction ft= fm.beginTransaction();
    Button fourth,call,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);
//        simpleList = (ListView) findViewById(R.id.simpleListView);
//        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryList, flags);
//        simpleList.setAdapter(customAdapter);

//        fourth=(Button) findViewById(R.id.chat);
//        fourth.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadFragment(new chatFragment());
//            }
//        });
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
// requesting to the user for permission.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 100);

        } else {
//if app already has permission this block will execute.
            readContacts();
        }


        Log.d("Success,","Value: "+alContacts);
        Log.d("Success2,","Value: "+arrayList);

        String[] strname=new String[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            strname[i]= arrayList.get(i);
            Log.d("Success3","value:"+strname[i]);

        }
        String[] strnum=new String[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            strnum[i]= arrayList.get(i);
            Log.d("Success3","value:"+strnum[i]);

        }
        loadFragment(new chatFragment(),strname,strnum);





    }
    private void loadFragment(Fragment fragment,String[] strname,String[] strnum) {
        FragmentManager fm= getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        Bundle data=new Bundle();
        data.putStringArray("name",strname);
        data.putStringArray("num",strnum);
//        Log.d("Success11","Value: "+i);
//
//
//
        fragment.setArguments(data);
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        readContacts();
    }

    public void chat(View v){
        String[] strname=new String[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            strname[i]= arrayList.get(i);
            Log.d("Success3","value:"+strname[i]);

        }
        String[] strnum=new String[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            strnum[i]= arrayList.get(i);
            Log.d("Success3","value:"+strnum[i]);

        }
        loadFragment(new chatFragment(),strname,strnum);
    }
    public void call(View v){
        String[] strname=new String[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            strname[i]= arrayList.get(i);
            Log.d("Success3","value:"+strname[i]);

        }
        String[] strnum=new String[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            strnum[i]= arrayList.get(i);
            Log.d("Success3","value:"+strnum[i]);

        }
        loadFragment(new chatFragment(),strname,strnum);
    }
    public void contact(View v){
        String[] strname=new String[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            strname[i]= arrayList.get(i);
            Log.d("Success3","value:"+strname[i]);

        }
        String[] strnum=new String[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            strnum[i]= arrayList.get(i);
            Log.d("Success3","value:"+strnum[i]);

        }
        loadFragment(new chatFragment(),strname,strnum);
    }
    @SuppressLint("Range")
    private void readContacts() {
        ContentResolver cr = getContentResolver(); //Activity/Application android.content.Context
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if(cursor.moveToFirst())
        {

            do
            {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));

                if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0)
                {
                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",new String[]{ id }, null);
                    while (pCur.moveToNext())
                    {
                        String contactNumber = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        alContacts.add(contactNumber);
                        String contactName = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY));
                        arrayList.add(contactName);
                        break;
                    }
                    pCur.close();
                }

            } while (cursor.moveToNext()) ;
        }



    }


}