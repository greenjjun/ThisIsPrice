package com.example.thisisprice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class FeeFragment extends Fragment {

    private MainActivity activity;
    private ImageView btnNext;
    private View boxCardCompany;
    private View boxBrand;
    private TextView txtBrand;
    private TextView txtCardCompany;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        activity = (MainActivity) getActivity();
        return inflater.inflate(R.layout.fragment_fee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState ){
        super.onViewCreated(view, savedInstanceState);
        btnNext = view.findViewById(R.id.btn_next);
        boxCardCompany = view.findViewById(R.id.box_card_company);
        boxBrand = view.findViewById(R.id.box_brand);
        txtBrand = view.findViewById(R.id.txt_brand);
        txtCardCompany = view.findViewById(R.id.txt_card_company);

        final PopupMenu popupBrand = new PopupMenu(getContext(), boxBrand);
        popupBrand.getMenuInflater().inflate(R.menu.menu_brand,popupBrand.getMenu());
        popupBrand.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                txtBrand.setText(item.getTitle());
                return true;
            }
        });

        boxBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupBrand.show();
            }
        });

        final PopupMenu popupCard = new PopupMenu(getContext(),boxCardCompany);
        popupCard.getMenuInflater().inflate(R.menu.menu_card_company,popupCard.getMenu());
        popupCard.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                txtCardCompany.setText(item.getTitle());
                return true;
            }
        });

        boxCardCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupCard.show();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                activity.getPriceData().setBrand(txtBrand.getText().toString());
                activity.getPriceData().setCardCompany(txtCardCompany.getText().toString());
                activity.addFragment(new ResultFragment());
            }
        });
    }
}
