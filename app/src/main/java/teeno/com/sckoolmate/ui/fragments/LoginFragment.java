package teeno.com.sckoolmate.ui.fragments;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import teeno.com.sckoolmate.R;
import teeno.com.sckoolmate.StudentDash;
import teeno.com.sckoolmate.base.BaseFragment;
import teeno.com.sckoolmate.network.extras;
import teeno.com.sckoolmate.network.inputview;
import teeno.com.sckoolmate.network.loginAcc;
import teeno.com.sckoolmate.misc.utils.Extras;
import teeno.com.sckoolmate.ui.activities.MainActivity;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by Coolalien on 2/16/2017.
 */

public class LoginFragment extends BaseFragment {

    private TextInputEditText passwordInput, usernameInput, idInput;
    private AppCompatButton login;
    private String username, userpass, userid;
    private LinearLayout background;
    private Extras prefernces;
    private TextView forgot;
    private static boolean torf;
    private static boolean buttonAnim;

    /**
     * Instance of fragment
     * @return
     */
    public static LoginFragment getInstance(boolean torf, boolean buttonAnim){
        setTorf(torf);
        setButtonAnim(buttonAnim);
        return new LoginFragment();
    }


    @Override
    protected int layoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void ui(View rootview) {
        usernameInput = (TextInputEditText) rootview.findViewById(R.id.input_username);
        passwordInput = (TextInputEditText) rootview.findViewById(R.id.input_password);
        idInput = (TextInputEditText) rootview.findViewById(R.id.input_Id);
        login = (AppCompatButton) rootview.findViewById(R.id.btn_login);
        background = (LinearLayout) rootview.findViewById(R.id.login_layout);
        forgot = (TextView) rootview.findViewById(R.id.forgot_pass);
    }

    @Override
    protected void function() {
        login.setEnabled(true);
        if (torf){
            forgot.setVisibility(View.VISIBLE);
        }else {
            forgot.setVisibility(View.INVISIBLE);
        }
        if (buttonAnim){
            Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.rotate_right_to_left);
            login.setAnimation(animation);
        }
        login.setOnClickListener(onClick);
        forgot.setOnClickListener(onClick);
        prefernces = new Extras(getContext());
        usernameInput.setMaxLines(1);
        idInput.setMaxLines(1);
        forgot.setMaxLines(1);
        usernameInput.setSingleLine(true);
        idInput.setSingleLine(true);
        forgot.setSingleLine(true);
    }

    @Override
    protected Fragment setfragment() {
        return CommonFragment2.getInstance();
    }

    @Override
    protected int setContainerId() {
        return ((MainActivity) getActivity()).setContainerId();
    }

    @Override
    public void FrgamentLoader() {
        super.FrgamentLoader();
    }

    /**
     * OnCLickListerner
     */
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            switch (view.getId()){

                case R.id.forgot_pass:
                    FrgamentLoader();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (prefernces.studentTrack()){
                                prefernces.setStudent("9");
                            }
                            if (prefernces.teacherTrack()){
                                prefernces.setTeacher("10");
                            }
                            if (prefernces.nteacherTrack()){
                                prefernces.setNTeacher("11");
                            }
                        }
                    });
                    break;

                case R.id.btn_login:





                   Login(view);
                    break;
            }
        }
    };

    /**
     * Login
     * @param view
     */
    private void Login(View view){
        username = usernameInput.getText().toString().trim();
        userpass = passwordInput.getText().toString().trim();
        userid = idInput.getText().toString().trim();
        if (!username.isEmpty() && !userpass.isEmpty() && !userid.isEmpty()){
            /*loginAcc.LoginAccount(getContext(),view, LoginFragment.this, username, userpass, userid, new inputview() {
                @Override
                public TextInputEditText gettext() {
                    return usernameInput;
                }
            }, new inputview() {
                @Override
                public TextInputEditText gettext() {
                    return passwordInput;
                }
            }, new inputview() {
                @Override
                public TextInputEditText gettext() {
                    return idInput;
                }
            }, new extras() {
                @Override
                public Extras getExtras() {
                    return prefernces;
                }
            });*/
//doing();
            Intent i = new Intent(getContext(), StudentDash.class);
            startActivity(i);


        }else{
            if (username.isEmpty() || usernameInput.length() < 4 || usernameInput.length() > 10) {
                usernameInput.setError("enter a valid UserName");
            }
            if (userpass.isEmpty() || passwordInput.length() < 4 || passwordInput.length() > 10) {
                passwordInput.setError("enter a valid password");
            }
            if (userid.isEmpty()){
                idInput.setError("enter a valid Unique-Id");
            }
        }

    }
    public static void setTorf(boolean tosrf) {
        torf = tosrf;
    }

    public static void setButtonAnim(boolean buttonAnims) {
        buttonAnim = buttonAnims;
    }

  /*  public void doing(){


        StringRequest request = new StringRequest(Request.Method.POST, "http://acadika.com/meridian_school_kalyan/teacherap/Homework/get_class", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

               // dialog.dismiss();
                JSONObject object = null;

                try {
                    object = new JSONObject(response);
                    Log.d(TAG,"response = "+response);
                    String message = object.getString("message");
                    Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
                    JSONArray jsonArray = object.getJSONArray("class");
                    Log.d(TAG,"Class = "+jsonArray);
                    for (int i=0;i<jsonArray.length();i++){





                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }catch (NullPointerException e){
                    e.printStackTrace();
                }

// sp_class.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_ATOP);
// subjectNAmeAdapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,st_subject_name);
// sp_subject.setAdapter(subjectNAmeAdapter);

               *//* subjectNAmeAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_dropdown_item,st_subject_name);
                subjectNAmeAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                sp_subject.setAdapter(subjectNAmeAdapter);
*//*

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

               // dialog.dismiss();


            }
        }){
            @Override
            protected Map<String, String> getPostParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("teacher_id", "61");
                // params.put("section_id",section_id);
// Log.d(TAG,"Class Id = "+class_id);
                return params;
            }
        };

        int socketTimeout = 3000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(request);

    }
*/


}
