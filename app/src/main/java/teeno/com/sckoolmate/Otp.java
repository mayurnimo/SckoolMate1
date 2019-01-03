package teeno.com.sckoolmate;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Otp extends AppCompatActivity implements View.OnClickListener{
    TextView mTextField;
    Button bt_otp_resend, btn_send;
    EditText editText;
    String otp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        mTextField = (TextView) findViewById(R.id.otp_timer);
        bt_otp_resend = (Button) findViewById(R.id.btn_otp_resend);
        bt_otp_resend.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.editText);
        btn_send = (Button) findViewById(R.id.btn_otp);
        btn_send.setOnClickListener(this);

docountdown();

    }

    private void docountdown() {
bt_otp_resend.setVisibility(View.GONE);
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("Time remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mTextField.setText("Resend Opt!");
                bt_otp_resend.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_otp_resend:
                docountdown();
                editText.setText("");
                break;

            case R.id.btn_otp:
                Log.d("click", "=");
                checkOtp();
                break;
        }
    }

void checkOtp(){

    otp= editText.getText().toString().trim();
    Log.d("otp", "length" + otp.length());
    if(otp.isEmpty() || otp.length()>4) {
        Toast.makeText(getApplicationContext(), "Plaese enter correct 4 digit OTP", Toast.LENGTH_SHORT).show();
    }else {
        Log.d("otp", "=" + otp);

        Intent i = new Intent(this, SchoolDetails.class);
        startActivity(i);
    }
}
}
