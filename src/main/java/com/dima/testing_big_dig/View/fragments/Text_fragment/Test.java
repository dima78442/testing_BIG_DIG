package com.dima.testing_big_dig.View.fragments.Text_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dima.testing_big_dig.R;

import java.util.Calendar;
import java.util.Date;

public class Test extends Fragment {

    public Test() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText editText = (EditText)view.findViewById(R.id.editText);
        Button button = (Button)view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage("com.dima.testing_big_dig_b");
                if (launchIntent != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("from","test");
                    bundle.putString("url",editText.getText().toString());
                    bundle.putString("time",timeGetter());
                    launchIntent.putExtra("Reference",bundle);
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
            }
        });
    }

    public String timeGetter(){
        Date currentTime = Calendar.getInstance().getTime();
        return Long.toString(currentTime.getTime());
    }


}
