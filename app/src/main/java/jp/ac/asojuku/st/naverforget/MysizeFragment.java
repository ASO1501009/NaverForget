package jp.ac.asojuku.st.naverforget;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class MysizeFragment extends Fragment {

    public static Fragment newInstance(Context context) {
        MysizeFragment f = new MysizeFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_mysize, null);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("mysize", Context.MODE_APPEND);
        int neck = prefs.getInt("neck", 0);
        int sleeve = prefs.getInt("sleeve", 0);
        int waist = prefs.getInt("waist", 0);
        int insideLeg = prefs.getInt("insideLeg", 0);

        EditText edText1 = (EditText) getView().findViewById(R.id.editText1);
        if(neck != 0) {
            edText1.setText(Integer.toString(neck));
        }
        EditText edText2 = (EditText) getView().findViewById(R.id.editText2);
        if(sleeve != 0) {
            edText2.setText(Integer.toString(sleeve));
        }
        EditText edText3 = (EditText) getView().findViewById(R.id.editText3);
        if(waist != 0) {
            edText3.setText(Integer.toString(waist));
        }
        EditText edText4 = (EditText) getView().findViewById(R.id.editText4);
        if(insideLeg != 0) {
            edText4.setText(Integer.toString(insideLeg));
        }
    }

    @Override
    public  void onPause() {
        super.onPause();
        EditText editText1 = (EditText) getView().findViewById(R.id.editText1);
        EditText editText2 = (EditText) getView().findViewById(R.id.editText2);
        EditText editText3 = (EditText) getView().findViewById(R.id.editText3);
        EditText editText4 = (EditText) getView().findViewById(R.id.editText4);

        int neck;
        try {
            neck = Integer.parseInt(editText1.getText().toString());
        } catch (NumberFormatException e) {
            neck = 0;
        }

        int sleeve;
        try {
            sleeve = Integer.parseInt(editText2.getText().toString());
        } catch (NumberFormatException e) {
            sleeve = 0;
        }

        int waist;
        try {
            waist = Integer.parseInt(editText3.getText().toString());
        } catch (NumberFormatException e) {
            waist = 0;
        }

        int insideLeg;
        try {
            insideLeg = Integer.parseInt(editText4.getText().toString());
        } catch (NumberFormatException e) {
            insideLeg = 0;
        }

        SharedPreferences prefs = this.getActivity().getSharedPreferences("mysize", Context.MODE_APPEND);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("neck", neck);
        editor.putInt("sleeve", sleeve);
        editor.putInt("waist", waist);
        editor.putInt("insideLeg", insideLeg);
        //editor.commit()
        editor.apply(); //commitの非同期版

    }

}