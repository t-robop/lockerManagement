package org.t_robop.locker_management;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class PopupFragment extends Activity {

    protected Button spinnerButton;
    protected AlertDialog alertDialog;
    protected ArrayAdapter<String> adapter;
    protected int selectedIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_popup);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice);
        adapter.add("text1");
        adapter.add("text2");
        adapter.add("text3");
        adapter.add("text4");
        adapter.add("text5");

        // Spinner風のボタン
        spinnerButton = (Button) findViewById(R.id.button);
        spinnerButton.setText("削除");
        spinnerButton.setOnClickListener(onClickListener);
    }
    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            // AlertDialogで選択肢を表示
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    PopupFragment.this);
            builder.setTitle("削除");
            builder.setSingleChoiceItems(adapter, selectedIndex,
                    onDialogClickListener);
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