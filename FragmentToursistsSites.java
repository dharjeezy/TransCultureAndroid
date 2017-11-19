package com.example.user.transculture;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by USER on 11/18/2017.
 */

public class FragmentToursistsSites extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    public FragmentToursistsSites() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tourists_sites, container, false);

        mRecyclerView = (RecyclerView) root.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TouristSitesRecyclerAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        // Inflate the layout for this fragment
        return root;
    }

    private ArrayList<TouristSitesDO> getDataSet() {
        Integer[] drawableArray = {R.drawable.photo0, R.drawable.photo1, R.drawable.photo2,
                R.drawable.photo3, R.drawable.photo0, R.drawable.photo1};
        String[] titles = {"Hyperloop", "Climb Kilimanjaro", "Fishing at IITA", "Clubbing at Quilox", "Snooker at Fela's Shrine", "Eiffel Tower"};
        String[] amounts = {"$850", "$400", "$500", "$600", "$200", "$600"};
        ArrayList results = new ArrayList<TouristSitesDO>();
        for (int index = 0; index < 6; index++) {
            TouristSitesDO obj = new TouristSitesDO(titles[index],
                    "Ikogosi Fall Springs, Ikogosi Fall Springs, Ikogosi Fall Springs,Ikogosi Fall Springs," +
                            "Ikogosi Fall Springs, Ikogosi Fall Springs, Ikogosi Fall Springs"
                            , amounts[index], drawableArray[index]);
            results.add(index, obj);
        }
        return results;
    }
}
