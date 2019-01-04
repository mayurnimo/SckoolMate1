package teeno.com.sckoolmate;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import teeno.com.sckoolmate.misc.utils.Extras;

public class SchoolDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private TextInputEditText schoolnameInput,cityInput,student_id,teacher_id;
    private AppCompatButton submit;
    private LinearLayout ll_admin,ll_teacher,ll_student;
    private String schoolname,city,teacherid,studentid;
    private String school_type,school_select;
    private Extras prefernces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_details);
        prefernces = new Extras(getApplicationContext());
        ll_teacher = (LinearLayout)findViewById(R.id.ll_teacher_school_details);
        ll_admin = (LinearLayout)findViewById(R.id.ll_admin_school_details);
        ll_student = (LinearLayout)findViewById(R.id.ll_student_school_details);

        schoolnameInput = (TextInputEditText) findViewById(R.id.input_schoolname);
        student_id = (TextInputEditText) findViewById(R.id.student_school_id);
        teacher_id = (TextInputEditText) findViewById(R.id.teacher_school_id);
        cityInput = (TextInputEditText) findViewById(R.id.input_city);
        submit = (AppCompatButton) findViewById(R.id.btn_school_submit);
        submit.setOnClickListener(this);

        Spinner school_spinner = (Spinner) findViewById(R.id.select_school_spinner) ;
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.School_type, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        school_spinner.setAdapter(adapter1);
        school_spinner.setOnItemSelectedListener(this);


        Spinner spinner = (Spinner) findViewById(R.id.school_type_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.School_type, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        if(prefernces.getLogin()==3){

            ll_admin.setVisibility(View.VISIBLE);
            ll_teacher.setVisibility(View.GONE);
            ll_student.setVisibility(View.GONE);
        }else if (prefernces.getLogin()==2){
            ll_admin.setVisibility(View.GONE);
            ll_teacher.setVisibility(View.VISIBLE);
            ll_student.setVisibility(View.GONE);
        }else if (prefernces.getLogin()==1){
            ll_admin.setVisibility(View.GONE);
            ll_teacher.setVisibility(View.GONE);
            ll_student.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId() == R.id.school_type_spinner)
        {

            school_type= (String) parent.getItemAtPosition(position);


            Log.d("spinner","spinner"+school_type);

            // operations
        }
        else if(parent.getId() == R.id.select_school_spinner)
        {
            //operations
            school_select= (String) parent.getItemAtPosition(position);


            Log.d("spinner","school_select= "+school_select);



        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_school_submit:
                submitDetails();
                break;
        }
    }

      private void submitDetails() {


            if(prefernces.getLogin()==3) {

                schoolname = schoolnameInput.getText().toString().trim();
                city = cityInput.getText().toString().trim();
                if (!schoolname.isEmpty() && !city.isEmpty() && !school_type.isEmpty()) {

                    Log.d("submit","school details submited = "+schoolname+"  "+city+"  "+school_type);
                    Intent i = new Intent(this, StudentDash.class);
                    startActivity(i);
                } else {
                    if (schoolname.isEmpty()) {
                        schoolnameInput.setError("enter valid School Name");
                    }
                    if (city.isEmpty()) {
                        cityInput.setError("Enter School Location");
                    }

                }
            }else if(prefernces.getLogin()==2) {
                teacherid = teacher_id.getText().toString().trim();

                if (!teacherid.isEmpty() && !school_select.isEmpty()) {



                    Log.d("submit","school details submited = "+teacherid+"  "+school_select);
                   // Intent i = new Intent(this, StudentDash.class);
                   // startActivity(i);
                } else {
                    if (teacherid.isEmpty()) {
                        teacher_id.setError("enter valid School Name");
                    }


                }

                Log.d("teacher dashboard","teacher dashboard");

                /*Intent i = new Intent(this, StudentDash.class);
                startActivity(i);*/
            }else if(prefernces.getLogin()==1) {

                studentid = student_id.getText().toString().trim();
                if (!studentid.isEmpty()) {

                    Log.d("submit","school details submited = "+studentid);
                    // Intent i = new Intent(this, StudentDash.class);
                    // startActivity(i);
                } else {
                    if (studentid.isEmpty()) {
                        student_id.setError("enter valid School Name");
                    }


                }
                Log.d("Student dashboard","Student dashboard");

                Intent i = new Intent(this, Dash.class);
                startActivity(i);

            }

      }
    }

