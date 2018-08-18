package com.example.thisisprice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private PriceData priceData = new PriceData();

    public PriceData getPriceData(){
        return priceData;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // xml의 box_frame을 MainFragment로 바꿔라
        fragmentTransaction.replace(R.id.box_frame, new MainFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void addFragment(Fragment fragment) { // fragment는 새로 보여질 fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // box_frame에 들어있는 Fragment를 찾아와라
        Fragment find = fragmentManager.findFragmentById(R.id.box_frame);
        // 찾아온 Fragment 숨기기
        fragmentTransaction.hide(find);

        // box_frame을 새로 가져온 fragment로 바꿔주기
        fragmentTransaction.add(R.id.box_frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
