package com.example.renda.encrypt;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String seedValue = "This Is MySecure";
    TextView txe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout =
                (RelativeLayout) findViewById(R.id.root);

        String normalText = "rlbert VVVVancouver PHONE NUMBER IS 7788888888";
        String normalTextEnc;
        String normalTextDec;

        try {
            normalTextEnc = AESHelper.encrypt(seedValue, normalText);
            normalTextDec = AESHelper.decrypt(seedValue, normalTextEnc);

            txe = (TextView) findViewById(R.id.showCase);
            txe.setText("Normal Text ::\n"+normalText
                    +" \n\n Encrypted Value ::\n "+normalTextEnc
                    +" \n\n Decrypted value ::\n "+normalTextDec);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
