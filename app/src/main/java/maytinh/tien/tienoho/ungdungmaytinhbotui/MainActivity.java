package maytinh.tien.tienoho.ungdungmaytinhbotui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    private Button btnSo0;
    private Button btnSo1;
    private Button btnSo2;
    private Button btnSo3;
    private Button btnSo4;
    private Button btnSo5;
    private Button btnSo6;
    private Button btnSo7;
    private Button btnSo8;
    private Button btnSo9;

    private Button btnBang;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;
    private Button btnCong;
    private Button btnAc;
    private Button btnClear;
    private Button btnPhay;

    private EditText edtInput;
    private TextView tvKetQua;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nut();
        SuaKienClick();

    }


    public void Nut() {
        btnSo0 = (Button) findViewById(R.id.btn_0);
        btnSo1 = (Button) findViewById(R.id.btn_1);
        btnSo2 = (Button) findViewById(R.id.btn_2);
        btnSo3 = (Button) findViewById(R.id.btn_3);
        btnSo4 = (Button) findViewById(R.id.btn_4);
        btnSo5 = (Button) findViewById(R.id.btn_5);
        btnSo6 = (Button) findViewById(R.id.btn_6);
        btnSo7 = (Button) findViewById(R.id.btn_7);
        btnSo8 = (Button) findViewById(R.id.btn_8);
        btnSo9 = (Button) findViewById(R.id.btn_9);

        btnBang = (Button) findViewById(R.id.btn_bang);
        btnTru = (Button) findViewById(R.id.btn_tru);
        btnCong = (Button) findViewById(R.id.btn_cong);
        btnNhan = (Button) findViewById(R.id.btn_nhan);
        btnChia = (Button) findViewById(R.id.btn_chia);
        btnPhay = (Button) findViewById(R.id.btn_phay);
        btnClear = (Button) findViewById(R.id.btn_c);
        btnAc = (Button) findViewById(R.id.btn_ac);

        edtInput = (EditText) findViewById(R.id.edt_input);
        tvKetQua = (TextView) findViewById(R.id.tv_ketqua);
    }

    public void SuaKienClick() {
        btnSo0.setOnClickListener(this);
        btnSo1.setOnClickListener(this);
        btnSo2.setOnClickListener(this);
        btnSo3.setOnClickListener(this);
        btnSo4.setOnClickListener(this);
        btnSo5.setOnClickListener(this);
        btnSo6.setOnClickListener(this);
        btnSo7.setOnClickListener(this);
        btnSo8.setOnClickListener(this);
        btnSo9.setOnClickListener(this);

        btnBang.setOnClickListener(this);
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnAc.setOnClickListener(this);
        btnPhay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_0:
                edtInput.append("1"); // ghi liên tiếp các chữ
                break;
            case R.id.btn_1:
                edtInput.append("1"); // ghi liên tiếp các chữ
                break;
            case R.id.btn_2:
                edtInput.append("2"); // ghi liên tiếp các chữ
                break;
            case R.id.btn_3:
                edtInput.append("3"); // ghi liên tiếp các chữ
                break;
            case R.id.btn_4:
                edtInput.append("4"); // ghi liên tiếp các chữ
                break;
            case R.id.btn_5:
                edtInput.append("5"); // ghi liên tiếp các chữ
                break;
            case R.id.btn_6:
                edtInput.append("6"); // ghi liên tiếp các chữ
                break;
            case R.id.btn_7:
                edtInput.append("7"); // ghi liên tiếp các chữ
                break;
            case R.id.btn_8:
                edtInput.append("8"); // ghi liên tiếp các chữ
                break;
            case R.id.btn_9:
                edtInput.append("9"); // ghi liên tiếp các chữ
                break;
            case R.id.btn_cong:
                edtInput.append("+"); // ghi liên tiếp các chữ
                break;
            case R.id.btn_tru:
                edtInput.append("-"); // ghi liên tiếp các chữ
                break;
            case R.id.btn_nhan:
                edtInput.append("*"); // ghi liên tiếp các chữ
                break;
            case R.id.btn_chia:
                edtInput.append("/"); // ghi liên tiếp các chữ
                break;
            case R.id.btn_phay:
                edtInput.append("."); // ghi liên tiếp các chữ
                break;

            case R.id.btn_ac:

                edtInput.setText("");

                break;

            case R.id.btn_c:

                BaseInputConnection textBaseInputConnection = new BaseInputConnection(edtInput, true);
                textBaseInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                //edtInput.setText(deleteKiTu(edtInput.getText().toString()));

                break;
            case R.id.btn_bang:

                //int Number = Integer.valueOf(String.valueOf(edtInput.getText()));
                double ketQua = 0;
                addkiTuArrayList(edtInput.getText().toString());
                addNumber(edtInput.getText().toString());
                DecimalFormat df = new DecimalFormat("###.######");
                if (arrKiTu.size() >= arrNumber.size() || arrKiTu.size() < 1)
                    tvKetQua.setText("Lỗi định dạng");
                else {
                    for (int i = 0; i < arrNumber.size() - 1; i++) {
                        switch (arrKiTu.get(i)) {
                            case "+":
                                if (i == 0) {
                                    ketQua = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else
                                    ketQua = ketQua + arrNumber.get(i + 1);
                                break;
                            case "-":
                                if (i == 0) {
                                    ketQua = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else
                                    ketQua = ketQua - arrNumber.get(i + 1);
                                break;
                            case "*":
                                if (i == 0) {
                                    ketQua = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else
                                    ketQua = ketQua * arrNumber.get(i + 1);
                                break;
                            case "/":
                                if (i == 0) {
                                    ketQua = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else
                                    ketQua = ketQua / arrNumber.get(i + 1);
                                break;
                            default:
                                break;
                        }
                    }
                    tvKetQua.setText(df.format(ketQua) + "");
                }
        }
    }

    //lấy ra các dấu
    public ArrayList<String> arrKiTu;

    //lấy ra các số
    public ArrayList<Double> arrNumber;

    //lấy ra tất cả cái dấu thêm vào mảng arrKiTu
    public int addkiTuArrayList(String input) {
        arrKiTu = new ArrayList<>();

        char[] charArr = input.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            switch (charArr[i]) {
                case '+':
                    arrKiTu.add(charArr[i] + "");
                    break;
                case '-':
                    arrKiTu.add(charArr[i] + "");
                    break;
                case '*':
                    arrKiTu.add(charArr[i] + "");
                    break;
                case '/':
                    arrKiTu.add(charArr[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    public void addNumber(String numberArr) {

        arrNumber = new ArrayList<>();
        Pattern rePattern = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = rePattern.matcher(numberArr);
        while (matcher.find()) {
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }


//    public String deleteKiTu(String soKiTu) {
//        int thuTu = soKiTu.length();
//        String deleteSo = soKiTu.substring(0, thuTu - 1);
//        return deleteSo;
//    }
}
