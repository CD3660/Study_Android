package com.example.and00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv_money;
    EditText edt_money;
    Button btn_input, btn_output;

    int money;//사용자의 금액을 관리하기 위한 변수
    int[] counts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_money = findViewById(R.id.tv_money);
        edt_money = findViewById(R.id.edt_money);
        btn_input = findViewById(R.id.btn_input);
        btn_output = findViewById(R.id.btn_output);

        setTv_moneyText();
        ArrayList<Drink> list = new ArrayList<>();
        list.add(new Drink("콜라", 800, 10, findViewById(R.id.tv_name1), findViewById(R.id.tv_cnt1), findViewById(R.id.btn_order1)));
        list.add(new Drink("사이다", 1000, 10, findViewById(R.id.tv_name2), findViewById(R.id.tv_cnt2), findViewById(R.id.btn_order2)));
        list.add(new Drink("환타", 1200, 10, findViewById(R.id.tv_name3), findViewById(R.id.tv_cnt3), findViewById(R.id.btn_order3)));
        list.add(new Drink("데미소다", 1300, 10, findViewById(R.id.tv_name4), findViewById(R.id.tv_cnt4), findViewById(R.id.btn_order4)));
        counts = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            final int IDX = i;
            list.get(i).getBtn_order().setOnClickListener(v -> {
                if (money < list.get(IDX).getPrice()) {
                    Toast.makeText(this, "잔액이 부족합니다", Toast.LENGTH_SHORT).show();
                    return;
                } else if (list.get(IDX).getCnt() < 1) {
                    Toast.makeText(this, "재고가 부족합니다", Toast.LENGTH_SHORT).show();
                } else {
                    counts[IDX]++;
                    list.get(IDX).setCnt(list.get(IDX).getCnt()-1);
                    money -= list.get(IDX).getPrice();
                    setTv_moneyText();
                }
            });
        }

        btn_output.setOnClickListener(v -> {
            Toast.makeText(this, counts.toString() ,Toast.LENGTH_SHORT);
        });

        btn_input.setOnClickListener(v -> {
            money += getEditTextInt(edt_money);

            setTv_moneyText();
            edt_money.setText("");
        });

    }

    public void setTv_moneyText(){
        tv_money.setText("잔돈 " + money + "원");
    }
    public int getEditTextInt(EditText editText) {
        try {
            int rtnInt = Integer.parseInt(editText.getText().toString());
            if (rtnInt >= 0) {
                return rtnInt;
            } else {
                Toast.makeText(this, "0 이상의 값을 입력을 해주세요.", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "숫자로 변환이 불가능 합니다.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "오류가 발생했습니다. 재시도 해주세요.", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }
}