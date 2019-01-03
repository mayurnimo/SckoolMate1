package teeno.com.sckoolmate.ui.fragments;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import teeno.com.sckoolmate.FacebookLoginActivity;
import teeno.com.sckoolmate.Otp;
import teeno.com.sckoolmate.R;
import teeno.com.sckoolmate.base.BaseFragment;
import teeno.com.sckoolmate.GoogleSignInActivity;
import teeno.com.sckoolmate.misc.utils.Extras;

/**
 * Created by Coolalien on 2/16/2017.
 */

public class SignupFragement extends BaseFragment {

    private TextInputEditText emailInput, passwordInput, usernameInput, confirmpasswordInput, fullnameInput, numberInput;
    private AppCompatButton signUp, btn_google, btn_fb;
    private String userfullname, usermail, userpass, username, userconfirmpass, number;
    private static boolean buttonAnim;
    private Extras prefernces;
    /**
     * Instance of fragment
     * @return
     */
    public static SignupFragement getInstance(boolean buttonAnim){
        setButtonAnim(buttonAnim);
        Log.d("fragment2","fragment2");
        return new SignupFragement();



    }




    @Override
    protected int layoutId() {
        Log.d("fragment3","fragment3");
        return R.layout.fragment_signup;
    }

    @Override
    protected void ui(View rootview) {
        Log.d("fragment4","fragment4");
        emailInput = (TextInputEditText) rootview.findViewById(R.id.input_email);
        passwordInput = (TextInputEditText) rootview.findViewById(R.id.input_password);
        signUp = (AppCompatButton) rootview.findViewById(R.id.btn_signup);
        btn_google = (AppCompatButton) rootview.findViewById(R.id.btn_google);
        btn_fb = (AppCompatButton) rootview.findViewById(R.id.btn_fb);
        usernameInput = (TextInputEditText) rootview.findViewById(R.id.input_username);
        confirmpasswordInput = (TextInputEditText) rootview.findViewById(R.id.input_passwordr);
        fullnameInput = (TextInputEditText) rootview.findViewById(R.id.input_fullname);
        numberInput = (TextInputEditText) rootview.findViewById(R.id.input_number);





    }

    @Override
    protected void function() {
        prefernces = new Extras(getContext());
        if (prefernces.getFirebaseSession()==1){
            if(prefernces.getGooglename()!="null") {
                usernameInput.setText(prefernces.getGooglename());
                fullnameInput.setText(prefernces.getGooglename());
            }if(prefernces.getGooglemail()!="null")
            emailInput.setText(prefernces.getGooglemail());
            if(prefernces.getGooglenum()!="null")
            numberInput.setText(prefernces.getGooglenum());

        }else if(prefernces.getFbSession()==1){
            if(prefernces.getfbname()!="null") {
                usernameInput.setText(prefernces.getfbname());
                fullnameInput.setText(prefernces.getfbname());
            }if(prefernces.getfbmail()!="null")
                emailInput.setText(prefernces.getfbmail());
            if(prefernces.getfbnum()!="null")
                numberInput.setText(prefernces.getfbnum());

        }
        Log.d("fragment5","fragment5");
        signUp.setEnabled(true);
        signUp.setOnClickListener(onClick);
        btn_google.setOnClickListener(onClick);
        btn_fb.setOnClickListener(onClick);
        if (buttonAnim){
            Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.rotate_left_to_right);
            signUp.setAnimation(animation);
        }
        emailInput.setMaxLines(1);
        usernameInput.setMaxLines(1);
        fullnameInput.setMaxLines(1);
        usernameInput.setSingleLine(true);
        emailInput.setSingleLine(true);
        fullnameInput.setSingleLine(true);

    }

    @Override
    protected Fragment setfragment() {
        return null;
    }

    @Override
    protected int setContainerId() {
        return 0;
    }

    @Override
    public void FrgamentLoader() {
        Log.d("fragment6","fragment6");
        super.FrgamentLoader();
    }



    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            switch (view.getId()){

                case R.id.btn_signup:
                    registerAcc(view);
                    break;
                case R.id.btn_google:
                   Log.d("btn_google","btn_google");
                    Intent i = new Intent(getActivity(), GoogleSignInActivity.class);
                    startActivity(i);
                    break;
                case R.id.btn_fb:
                    Log.d("btn_google","btn_google");
                    Intent in = new Intent(getActivity(), FacebookLoginActivity.class);
                    startActivity(in);
                    break;
            }
        }
    };


    /**
     * Register account
     * @param view
     */
    private void registerAcc(View view){

        usermail = emailInput.getText().toString().trim();
        userpass = passwordInput.getText().toString().trim();
        username = usernameInput.getText().toString().trim();
        userfullname = fullnameInput.getText().toString().trim();
        userconfirmpass = confirmpasswordInput.getText().toString().trim();
        number = numberInput.getText().toString().trim();

        if (!userfullname.isEmpty() && !usermail.isEmpty() && !userpass.isEmpty() && !username.isEmpty()  && !number.isEmpty() ){








            Intent i = new Intent(getActivity(), Otp.class);
            startActivity(i);


        }else {
            if (usermail.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(usermail).matches()) {
                emailInput.setError("enter a valid email address");
            }
            if (username.isEmpty() || usernameInput.length() < 4 || usernameInput.length() > 10){
                usernameInput.setError("enter valid username");
            }
            if (userpass.isEmpty() || passwordInput.length() < 4 || passwordInput.length() > 10) {
                passwordInput.setError("between 4 and 10 alphanumeric characters");
            }
            if (userconfirmpass.isEmpty() || confirmpasswordInput.length() < 4 || confirmpasswordInput.length() > 10) {
                confirmpasswordInput.setError("confirm password");
            }
            if (userfullname.isEmpty()){
                fullnameInput.setError("enter valid full name");

            }
            if (number.isEmpty() || numberInput.length() < 4 || numberInput.length() > 10) {
                numberInput.setError("Number must be of 10 characters");
            }
        }
    }

    public static void setButtonAnim(boolean buttonAnims) {
        buttonAnim = buttonAnims;
    }


}
