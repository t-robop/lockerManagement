package org.t_robop.locker_management;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Locker2Fragment extends Fragment {

    TextView textView;

    public Locker2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_locker2, container, false);
        textView = (TextView)view.findViewById(R.id.text1);

        textView.setText("Hello World");
        return view;
    }

}
