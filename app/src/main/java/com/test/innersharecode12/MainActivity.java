package com.test.innersharecode12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.test.innersharecode12.dialog.ShowCustomViewDialog;
import com.test.innersharecode12.dialog.ShowCustomViewGroupDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void testCustomeView(View view) {
        new ShowCustomViewDialog().show(getSupportFragmentManager(), "CustomeViewDialog");
    }

    public void testCustomeViewGroup(View view) {
        new ShowCustomViewGroupDialog().show(getSupportFragmentManager(), "CustomeViewGroupDialog");
    }
}
