package jp.ac.asojuku.st.naverforget;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class PropertyFragment extends Fragment {

    public static Fragment newInstance(Context context) {
        PropertyFragment f = new PropertyFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_property, null);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("property", Context.MODE_APPEND);
        int car_number = prefs.getInt("car_number", 0);
        int phone_number = prefs.getInt("phone_number", 0);

        EditText edText1 = (EditText) getView().findViewById(R.id.editText1);
        if(car_number != 0) {
            edText1.setText(Integer.toString(car_number));
        }
        EditText edText2 = (EditText) getView().findViewById(R.id.editText2);
        if(phone_number != 0) {
            edText2.setText(Integer.toString(phone_number));
        }
    }

    @Override
    public  void onPause() {
        super.onPause();
        EditText editText1 = (EditText) getView().findViewById(R.id.editText1);
        EditText editText2 = (EditText) getView().findViewById(R.id.editText2);

        int car_number;
        try {
            car_number = Integer.parseInt(editText1.getText().toString());
        } catch (NumberFormatException e) {
            car_number = 0;
        }

        int phone_number;
        try {
            phone_number = Integer.parseInt(editText2.getText().toString());
        } catch (NumberFormatException e) {
            phone_number = 0;
        }



        SharedPreferences prefs = this.getActivity().getSharedPreferences("property", Context.MODE_APPEND);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("car_number", car_number);
        editor.putInt("phone_number", phone_number);

        //editor.commit()
        editor.apply(); //commitの非同期版

    }

}



