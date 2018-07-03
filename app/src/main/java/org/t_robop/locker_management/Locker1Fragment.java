package org.t_robop.locker_management;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/**
 * A simple {@link Fragment} subclass.
 */
public class Locker1Fragment extends Fragment {

    private static final String[] texts = {
            "一段目", "二段目", "三段目", "四段目", "五段目"
    };

    public Locker1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_locker1, container, false);
        ListView listView = (ListView)view.findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, texts);
        listView.setAdapter(arrayAdapter);
        // Inflate the layout for this fragment
        return view;
    }
}
