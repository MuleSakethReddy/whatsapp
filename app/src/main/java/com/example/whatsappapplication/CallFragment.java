package com.example.whatsappapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class CallFragment extends Fragment {
    ListView simpleList;
    String countryList[] = {"A", "B", "C", "D","E","F","G"};
    int flags[] = {R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_call, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        Bundle data=this.getArguments();
//        if(data!=null){
//            imstr=data.getString("imgs");
//            detstr= data.getString("details");
//
//        }

        super.onViewCreated(view, savedInstanceState);

//        imv=view.findViewById(R.id.imageView2);
//        Log.d("Success2","value: "+imstr);
//        String imagename=String.valueOf(imstr);
//        imv.setImageResource(getResources().getIdentifier(imagename, "drawable", getActivity().getPackageName()));
//        tv=view.findViewById(R.id.textView4);
//        tv.setText(detstr);
        simpleList = (ListView) view.findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getActivity().getApplicationContext(), countryList, flags);
        simpleList.setAdapter(customAdapter);

    }
}