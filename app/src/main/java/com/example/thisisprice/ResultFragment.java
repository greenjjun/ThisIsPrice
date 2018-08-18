package com.example.thisisprice;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultFragment extends Fragment {

    private MainActivity activity;
    private TextView txtWon;
    private TextView txtProductPrice;
    private TextView txtCustomTax;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        activity = (MainActivity) getActivity();
        View view = inflater.inflate(R.layout.fragment_result,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtWon = view.findViewById(R.id.won);
        txtProductPrice = view.findViewById(R.id.txt_product_price);
        txtCustomTax = view.findViewById(R.id.txt_custom_tax);

        // Retrofit: Android의 네트워크 통신을 위해 사용하는 라이브러리
        // Okhttp: HTTP Client를 만들어주는 라이브러리
        // Gson: Json을 자바 클래스로 파싱해주는 라이브러리
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Exchange> call = apiInterface.getExchange();
        call.enqueue(new Callback<Exchange>() {
            @Override
            public void onResponse(Call<Exchange> call, Response<Exchange> response) {
                Exchange exchange = response.body();
                double krw = exchange.getUSDKRW();

                PriceData priceData = activity.getPriceData();
                int productPrice = priceData.getProductPrice(krw);
                int customTax = priceData.getCustomTax();
                txtProductPrice.setText(String.format("%,d", productPrice) + "원");
                txtCustomTax.setText(String.format("%,d", customTax) + "원");
                txtWon.setText(String.format("%,d", productPrice + customTax) + "원");
                Log.d("ResultFragment", krw + "");
            }

            @Override
            public void onFailure(Call<Exchange> call, Throwable t) {
                txtProductPrice.setText("0원");
                txtCustomTax.setText("0원");
                txtWon.setText("0원");
                Log.d("ResultFragment", "Fail!");
            }
        });
    }
}
