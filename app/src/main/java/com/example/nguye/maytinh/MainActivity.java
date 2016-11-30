package com.example.nguye.maytinh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNumber;
    private TextView tvResult;

    private Button btNumber1;
    private Button btNumber2;
    private Button btNumber3;
    private Button btNumber4;
    private Button btNumber5;
    private Button btNumber6;
    private Button btNumber7;
    private Button btNumber8;
    private Button btNumber9;
    private Button btNumber0;

    private Button btCong;
    private Button btTru;
    private Button btNhan;
    private Button btChia;
    private Button btClean;
    private Button btAllclean;
    private Button btPoint;
    private Button btResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();
    }
    public void initWidget(){

        btNumber1 = (Button) findViewById(R.id.btNumber1);
        btNumber2 = (Button) findViewById(R.id.btNumber2);
        btNumber3 = (Button) findViewById(R.id.btNumber3);
        btNumber4 = (Button) findViewById(R.id.btNumber4);
        btNumber5 = (Button) findViewById(R.id.btNumber5);
        btNumber6 = (Button) findViewById(R.id.btNumber6);
        btNumber7 = (Button) findViewById(R.id.btNumber7);
        btNumber8 = (Button) findViewById(R.id.btNumber8);
        btNumber9 = (Button) findViewById(R.id.btNumber9);
        btNumber0 = (Button) findViewById(R.id.btNumber0);

        btCong = (Button) findViewById(R.id.btCong);
        btTru = (Button) findViewById(R.id.btTru);
        btNhan = (Button) findViewById(R.id.btNhan);
        btChia = (Button) findViewById(R.id.btChia);


        btClean = (Button) findViewById(R.id.btClean);
        btAllclean= (Button) findViewById(R.id.btAllclean);
        btResult = (Button) findViewById(R.id.btResult);
        btPoint = (Button) findViewById(R.id.btPoint);
        editNumber = (EditText) findViewById(R.id.edt_intput);
        tvResult=(TextView) findViewById(R.id.tv_result);

    }
    public void setEventClickViews(){

        btNumber1.setOnClickListener(this);
        btNumber2.setOnClickListener(this);
        btNumber3.setOnClickListener(this);
        btNumber4.setOnClickListener(this);
        btNumber5.setOnClickListener(this);
        btNumber6.setOnClickListener(this);
        btNumber7.setOnClickListener(this);
        btNumber8.setOnClickListener(this);
        btNumber9.setOnClickListener(this);
        btNumber0.setOnClickListener(this);

        btCong.setOnClickListener(this);
        btTru.setOnClickListener(this);
        btNhan.setOnClickListener(this);
        btChia.setOnClickListener(this);

        btClean.setOnClickListener(this);
        btAllclean.setOnClickListener(this);
        btResult.setOnClickListener(this);
        btPoint.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btNumber0:
                // to do
                editNumber.append("0");
                    break;
            case R.id.btNumber1:
                // to do
                editNumber.append("1");
                break;
            case R.id.btNumber2:
                // to do
                editNumber.append("2");
                break;
            case R.id.btNumber3:
                // to do
                editNumber.append("3");
                break;
            case R.id.btNumber4:
                // to do
                editNumber.append("4");
                break;
            case R.id.btNumber5:
                // to do
                editNumber.append("5");
                break;
            case R.id.btNumber6:
                // to do
                editNumber.append("6");
                break;
            case R.id.btNumber7:
                // to do
                editNumber.append("7");
                break;
            case R.id.btNumber8:
                // to do
                editNumber.append("8");
                break;
            case R.id.btNumber9:
                // to do
                editNumber.append("9");
                break;

            case R.id.btCong:
                // to do
                editNumber.append("+");
                break;
            case R.id.btTru:
                // to do
                editNumber.append("-");
                break;
            case R.id.btNhan:
                // to do
                editNumber.append("*");
                break;
            case R.id.btChia:
                // to do
                editNumber.append("/");
                break;
            case R.id.btClean:
                // to do
//                String NumberAfterRemove = deleteNumber(editNumber.getText().toString());
//                editNumber.setText(NumberAfterRemove);
                // nút back dt lun lệnh vậy đó
                BaseInputConnection textFileInputConnection = new BaseInputConnection(editNumber,true);
                textFileInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btAllclean:
                // to do
                editNumber.setText("");
                tvResult.setText("");
                break;
            case R.id.btPoint:
                // to do
                editNumber.append(".");
                break;
            case R.id.btResult:
                // to do
                DecimalFormat df = new DecimalFormat("###.######");
                addOperation(editNumber.getText().toString());
                addNumber(editNumber.getText().toString());
                // thuat toán tính biêu thưc
                double result = 0;
                if(arrOperation.size()>= arrNumber.size()){
                    tvResult.setText("Lỗi Nhập Bạn ơi");
                }else {
                for(int i=0;i<(arrNumber.size()-1); i++){
                    switch(arrOperation.get(i)){
                        case "+":
                            if(i==0){
                                result = arrNumber.get(i)+ arrNumber.get(i+1);
                            }else result = result + arrNumber.get(i+1);
                            break;
                        case "-":
                            if(i==0){
                                result = arrNumber.get(i)- arrNumber.get(i+1);
                            }else result = result - arrNumber.get(i+1);
                            break;
                        case "*":
                            if(i==0){
                                result= arrNumber.get(i)*arrNumber.get(i+1);
                            }else result= result * arrNumber.get(i+1);
                            break;
                        case "/":
                            if(i==0){
                                result =arrNumber.get(i)/arrNumber.get(i+1);
                            }else result =result / arrNumber.get(i+1);
                            break;
                        default:
                            break;


                    }

                }
                tvResult.setText(df.format(result ) + "" );

                }
                break;
        }

    }


//    public String deleteNumber (String number){
//        int lenght = number.length();
//        String tem = number.substring(0,lenght-1);
//        return tem;
//    }

    // mãng chứa các phép toán + - * /
    public ArrayList<String> arrOperation;
    // Mãng luu các so
    public ArrayList<Double> arrNumber;

    //các phép toán lưu vao trong mãng arroPeration

    public int addOperation(String input){
        arrOperation = new ArrayList<>();
        char [] cArray = input.toCharArray();
        for(int i=0;i<cArray.length; i++){
            if((cArray[i]=='*') || (cArray[i]=='/')) {
                arrOperation.add(cArray[i] + "");

            }else if((cArray[i]=='+') || (cArray[i]=='-'))
                arrOperation.add(cArray[i]+ "");

            }

        return 0;
    }
    //các phép toán lưu vao trong mãng arrNumber
    public void addNumber (String stringInput){
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher=regex.matcher(stringInput);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }


}
