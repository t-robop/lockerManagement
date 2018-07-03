package org.t_robop.locker_management;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {
        private static final String[] countries = {
                "一段目","二段目","三段目","四段目","五段目"
        };
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_main_activity, container, false);
            ListView listView = (ListView) view.findViewById(R.id.listView);
            CustomAdapter adapter = new CustomAdapter(view.getContext(), R.layout.row, countries);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    switch (view.getId()) {
                        case R.id.edit:

                            break;
                        case R.id.delete:

                            break;
                    }
                }
            });
            //ここに書く
            return view;
        }

    }
