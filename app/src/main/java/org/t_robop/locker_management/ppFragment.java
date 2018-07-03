package org.t_robop.locker_management;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
/**
 * A simple {@link Fragment} subclass.
 */
public class ppFragment extends Fragment {
    protected Button spinnerButton;
    protected AlertDialog alertDialog;
    protected ArrayAdapter<String> adapter;
    protected int selectedIndex = 0;
    public ppFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pp, container, false);
    }
    @Override
    public void onViewCreated(View v,Bundle b){
        super.onViewCreated(v,b);
        setContentView(R.layout.fragment_pp);

        adapter = new ArrayAdapter<String>(view().getContext(), android.R.layout.simple_list_item_single_choice);
        adapter.add("text1");
        adapter.add("text2");
        adapter.add("text3");
        adapter.add("text4");
        adapter.add("text5");
        // Spinner風のボタン
        spinnerButton = (Button) findViewById(R.id.button);
        spinnerButton.setText("削除");
        spinnerButton.setOnClickListener(onClickListener);
        return view;
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // AlertDialogで選択肢を表示
            AlertDialog.Builder builder = new AlertDialog.Builder(ppFragment.view.getContext());
            builder.setTitle("削除");
            builder.setSingleChoiceItems(adapter, selectedIndex, onDialogClickListener);
            alertDialog = builder.create();
            alertDialog.show();
        }
    };
    private DialogInterface.OnClickListener onDialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // AlertDialogで選択された内容を保持
            selectedIndex = which;
            spinnerButton.setText(adapter.getItem(which));
            alertDialog.dismiss();
        }
    };
}
