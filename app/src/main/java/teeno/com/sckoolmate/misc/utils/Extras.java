package teeno.com.sckoolmate.misc.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static teeno.com.sckoolmate.misc.utils.Constants.INOUROUT;
import static teeno.com.sckoolmate.misc.utils.Constants.NTEACHER_LOGIN;
import static teeno.com.sckoolmate.misc.utils.Constants.NTEACHER_LOGIN_TRACK;
import static teeno.com.sckoolmate.misc.utils.Constants.ONETIMESCREEN;
import static teeno.com.sckoolmate.misc.utils.Constants.STUDENT_LOGIN;
import static teeno.com.sckoolmate.misc.utils.Constants.STUDENT_LOGIN_TRACK;
import static teeno.com.sckoolmate.misc.utils.Constants.TEACHER_LOGIN;
import static teeno.com.sckoolmate.misc.utils.Constants.TEACHER_LOGIN_TRACK;
import static teeno.com.sckoolmate.misc.utils.Constants.USERNAME;

/**
 * Created by Coolalien on 2/20/2017.
 */

public class Extras {

    public Context context;
    private SharedPreferences sharedPreferences;

    private SharedPreferences userSession;
    private SharedPreferences.Editor userSessionEdit;

    /**
     * Constructor
     * @param context
     */
    public Extras (Context context){
        this.context = context;
        userSession = context.getSharedPreferences("UserSession", Context.MODE_PRIVATE);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        userSessionEdit = userSession.edit();
    }


    //////////////////// LOGIN SESSION //////////////////////

    /**
     * Enable userlogin Session
     * @param username
     */
    public void setuserLogginSession(String username, Boolean torf) {
        userSessionEdit.putBoolean(INOUROUT, torf);
        userSessionEdit.putString(USERNAME, username);
        userSessionEdit.commit();
    }

    /**
     * Is User Logged or not
     * @return
     */
    public boolean isLogged(){
        return userSession.getBoolean(INOUROUT, false);
    }


    /**
     * Username
     * @return
     */
    public String getUserName(){
        return userSession.getString(USERNAME, null);
    }

    public SharedPreferences.Editor getUserSessionEdit() {
        return userSessionEdit;
    }

    /////////////////////// MULTI LOGIN SYSTEM MANAGEMENT /////////////////////

    /**
     * Set Student Values
     * @param
     */


    public void setFirebaseSession(int sess){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Firebase", sess);
        editor.apply();
    }
    public int getFirebaseSession(){
        return sharedPreferences.getInt("Firebase", 0);
    }

    public void setGooglename(String Googlename){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Googlename", Googlename);
        editor.apply();
    }
    public String getGooglename(){
        return sharedPreferences.getString("Googlename", "null");
    }


    public void setGooglemail(String Googlemail){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Googlemail", Googlemail);
        editor.apply();
    }
    public String getGooglemail(){
        return sharedPreferences.getString("Googlemail", "null");
    }


    public void setGooglenum(String Googlenum){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Googlenum", Googlenum);
        editor.apply();
    }
    public String getGooglenum(){
        return sharedPreferences.getString("Googlenum", "null");
    }








    public void setFbSession(int sess){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Fb", sess);
        editor.apply();
    }
    public int getFbSession(){
        return sharedPreferences.getInt("Fb", 0);
    }

    public void setfbname(String Googlename){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("fbname", Googlename);
        editor.apply();
    }
    public String getfbname(){
        return sharedPreferences.getString("fbname", "null");
    }


    public void setfbmail(String Googlemail){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("fbmail", Googlemail);
        editor.apply();
    }
    public String getfbmail(){
        return sharedPreferences.getString("fbmail", "null");
    }


    public void setfbnum(String Googlenum){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("fbnum", Googlenum);
        editor.apply();
    }
    public String getfbnum(){
        return sharedPreferences.getString("fbnum", "null");
    }




    public void setStudent(String student){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(STUDENT_LOGIN, student);
        editor.apply();
    }

    public void setLogin(int login){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("LOGIN", login);
        editor.apply();
    }
    public int getLogin(){
        return sharedPreferences.getInt("LOGIN", 0);
    }

    /**
     * Set Teacher Values
     * @param teacher
     */
    public void setTeacher(String teacher){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEACHER_LOGIN, teacher);
        editor.apply();
    }

    /**
     * Set NTeacher Values
     * @param nTeacher
     */
    public void setNTeacher(String nTeacher){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NTEACHER_LOGIN, nTeacher);
        editor.apply();
    }
    /**
     * Student
     * @return
     */
    public String isStudent(){
        return sharedPreferences.getString(STUDENT_LOGIN, null);
    }


    /**
     * Teacher
     * @return
     */
    public String isTeacher(){
        return sharedPreferences.getString(TEACHER_LOGIN, null);
    }

    /**
     * NTeacher
     * @return
     */
    public String isNTeacher(){
        return sharedPreferences.getString(NTEACHER_LOGIN, null);
    }


    ///////////////////////////////// TRACKING PREF //////////////////////

    /**
     * Set Student Values
     * @param studentTrack
     */
    public void setStudentTrack(boolean studentTrack){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(STUDENT_LOGIN_TRACK, studentTrack);
        editor.apply();
    }

    /**
     * Set Teacher Values
     * @param teacherTrack
     */
    public void setTeacherTrack(boolean teacherTrack){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(TEACHER_LOGIN_TRACK, teacherTrack);
        editor.apply();
    }

    /**
     * Set NTeacher Values
     * @param nTeacherTrack
     */
    public void setNTeacherTrack(boolean nTeacherTrack){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(NTEACHER_LOGIN_TRACK, nTeacherTrack);
        editor.apply();
    }
    /**
     * Student Track
     * @return
     */
    public boolean studentTrack(){
        return sharedPreferences.getBoolean(STUDENT_LOGIN_TRACK, true);
    }

    /**
     * Teacher Track
     * @return
     */
    public boolean teacherTrack(){
        return sharedPreferences.getBoolean(TEACHER_LOGIN_TRACK, true);
    }

    /**
     * NTeacher Track
     * @return
     */
    public boolean nteacherTrack(){
        return sharedPreferences.getBoolean(NTEACHER_LOGIN_TRACK, true);
    }


    ////////////////////////////////// STUDENT INIT PREF //////////////




    ////////////////////////// OTHER STUFF /////////////////



    /**
     * Init Screen
     * @return
     */
    public int getfirstScreen(){
        return sharedPreferences.getInt(ONETIMESCREEN, 0);
    }



    /////////////////////// SyallbusTracker ///////////////////////




    /////////////////////////// Tracker as per year /////////////////////////////////







}

