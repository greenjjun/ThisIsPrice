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
import android.widget.Toast;

import java.util.regex.Pattern;

public class PriceFragment extends Fragment {

    private MainActivity activity;
    private ImageView btnNext;
    private EditText editPrice;
    private EditText editShipping;
    private View boxAddress;
    private TextView txtAddress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        activity = (MainActivity) getActivity();
        View view = inflater.inflate(R.layout.fragment_price, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnNext = view.findViewById(R.id.btn_next);
        editShipping = view.findViewById(R.id.edit_shipping);
        editPrice = view.findViewById(R.id.edit_price);
        boxAddress = view.findViewById(R.id.box_address);
        txtAddress = view.findViewById(R.id.txt_address);

        final PopupMenu popupMenu = new PopupMenu(getContext(), boxAddress);
        popupMenu.getMenuInflater().inflate(R.menu.menu_address, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                txtAddress.setText(item.getTitle());
                return true;
            }
        });

        boxAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.show();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Pattern.matches("^[0-9]*$", editPrice.getText())) {
                    Toast.makeText(activity, "가격을 정확하게 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                activity.getPriceData().setPrice(Integer.parseInt(editPrice.getText().toString()));
                activity.getPriceData().setShipping(Integer.parseInt(editShipping.getText().toString()));
                activity.getPriceData().setAddress(txtAddress.getText().toString());
                activity.addFragment(new FeeFragment());
            }
        });
    }
}
