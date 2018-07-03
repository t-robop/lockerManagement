package org.t_robop.locker_management;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class SupportFragment extends AppCompatActivity {
    private static final String[] countries = {
            "一段目","二段目","三段目","四段目","五段目"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_support);

        ListView listView = (ListView) findViewById(R.id.listView);
        CustomFragment adapter = new CustomFragment(getApplicationContext(), R.layout.fragment_custom, countries);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (view.getId()) {
                    case R.id.edit:
                        Toast.makeText(SupportFragment.this, countries[position] + "の編集ボタンが押されました", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.delete:
                        Toast.makeText(SupportFragment.this, countries[position] + "の削除ボタンが押されました", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}