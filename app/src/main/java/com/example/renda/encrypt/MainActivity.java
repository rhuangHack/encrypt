package com.example.renda.encrypt;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String seedValue = "This Is MySecure";
    String payload;
    TextView txe;
    EditText edt;
    Button button;
    Button encrypt;
    Button decrypt;
    EditText enUserPass;
    EditText deUserPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout =
                (RelativeLayout) findViewById(R.id.root);

        button = (Button) findViewById(R.id.start);
        button.setOnClickListener(view->runService());

        encrypt = (Button) findViewById(R.id.button_en);
        encrypt.setOnClickListener(view->runEncrypt());

        decrypt = (Button) findViewById(R.id.button_de);
        decrypt.setOnClickListener(view->runDecrypt());

    }

    private String getText(){
        edt = (EditText) findViewById(R.id.editText);
        return edt.getText().toString();
    }

    private String getPasswd(String userInput){
        if(!userInput.isEmpty())
            userInput = seedValue + userInput;
        else
            userInput = seedValue;
        return userInput;
    }

    private  void showResult(String result){
        txe = (TextView) findViewById(R.id.showCase);
        txe.setText(result);
    }

    private void runEncrypt(){
        String normalText = getText();

        enUserPass = (EditText) findViewById(R.id.encrypt_text);
        String userPass = enUserPass.getText().toString();

        userPass = getPasswd(userPass);
        try {
            payload = AESHelper.encrypt(userPass, normalText);
            String result = "Normal Text ::\n"+normalText
                    +" \n\n Encrypted Value ::\n "+payload
                    +" \n\n";
            showResult(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void runDecrypt(){
        String normalText = getText();
        String normalTextDec;

        deUserPass  = (EditText) findViewById(R.id.decrypt_text);
        String userPass = deUserPass.getText().toString();

        userPass = getPasswd(userPass);
        try {
            normalTextDec = AESHelper.decrypt(userPass, payload);
            String result = "Normal Text ::\n"+normalText
                    +" \n\n Encrypted Value ::\n "+payload
                    +" \n\n Decrypted value ::\n "+normalTextDec;
            showResult(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void runService(){

        String normalText = getText();
        String normalTextEnc;
        String normalTextDec;

        String userPass = "";

        userPass = getPasswd(userPass);

        try {
            normalTextEnc = AESHelper.encrypt(userPass, normalText);
            normalTextDec = AESHelper.decrypt(userPass, normalTextEnc);
            String result = "Normal Text ::\n"+normalText
                    +" \n\n Encrypted Value ::\n "+normalTextEnc
                    +" \n\n Decrypted value ::\n "+normalTextDec;
            showResult(result);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
