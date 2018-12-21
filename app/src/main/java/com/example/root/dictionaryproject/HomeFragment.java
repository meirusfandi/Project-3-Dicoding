package com.example.root.dictionaryproject;import android.content.Context;import android.net.Uri;import android.os.Bundle;import android.support.v4.app.Fragment;import android.support.v7.widget.LinearLayoutManager;import android.support.v7.widget.RecyclerView;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.Button;import android.widget.EditText;import android.widget.TextView;import com.example.root.dictionaryproject.helper.MyAdapter;import com.example.root.dictionaryproject.helper.MyHelper;import com.example.root.dictionaryproject.helper.MyModel;import java.util.ArrayList;public class HomeFragment extends Fragment {    RecyclerView recyclerView;    MyHelper helper;    MyAdapter adapter;    EditText editCari;    Button btnCari;    @Override    public void onViewCreated(View view,Bundle savedInstanceState) {        super.onViewCreated(view, savedInstanceState);        getActivity().setTitle("Beranda");        editCari = (EditText)view.findViewById(R.id.editSearch);        btnCari  = (Button)view.findViewById(R.id.btnSearch);        helper   = new MyHelper(getContext());        adapter  = new MyAdapter(getContext());        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_home);        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));        btnCari.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                recyclerView.setAdapter(adapter);                helper.open();                    String cari = editCari.getText().toString();                    ArrayList<MyModel> kamus = helper.getByName(cari);                    ArrayList<MyModel> dict  = helper.getByNameENG(cari);                helper.close();                adapter.addItem(kamus);                adapter.addItem(dict);            }        });    }    @Override    public View onCreateView(LayoutInflater inflater, ViewGroup container,                             Bundle savedInstanceState) {        // Inflate the layout for this fragment        return inflater.inflate(R.layout.fragment_home, container, false);    }    public interface OnFragmentInteractionListener {        // TODO: Update argument type and name        void onFragmentInteraction(Uri uri);    }}