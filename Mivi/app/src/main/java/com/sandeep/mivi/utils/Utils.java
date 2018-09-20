package com.sandeep.mivi.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 03/11/15.
 */
public class Utils {
    private Context _context;

    public Utils(Context context) {
        this._context = context;
    }


    public static boolean isInternetOn(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;

    }


    public static void toast(Context activity, String text) {
        if (null != activity)
            Toast.makeText(activity, text + "...", Toast.LENGTH_SHORT).show();
    }


    public static String getDate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c);
        return formattedDate;

    }

    public static String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String str = sdf.format(new Date());
        return str;
    }

/*    public static void startIntent(Context context, Class activity, int i) {
        Intent intent = new Intent(context, activity);
        if (i != 0) {
            intent.addFlags(i);
        }
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);

    }*/

    public static boolean validateEditText(View view, Context _context) {
        if (((EditText) view).getText().toString().matches("")) {
            //toast(_context, "Please fill");
            return false;
        }
        return true;
    }

    public static String getMonth(String month) {

        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        return months[Integer.parseInt(month)];
    }

    /*    public static void setDateToEditText(final View v, final Context context, String title, final int from) {
            final Calendar mcurrentDate = Calendar.getInstance();
            int mYear = mcurrentDate.get(Calendar.YEAR);
            int mMonth = mcurrentDate.get(Calendar.MONTH);
            int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog mDatePicker = new DatePickerDialog(context, R.style.TimePickerTheme,
                    new DatePickerDialog.OnDateSetListener() {
                        public void onDateSet(DatePicker datepicker,
                                              int selectedyear, int selectedmonth, int selectedday) {
                            String da = selectedday < 10 ? "0" + Integer.toString(selectedday) : Integer.toString(selectedday);
                            String m = selectedmonth < 10 ? "0" + Integer.toString(selectedmonth + 1) : Integer.toString(selectedmonth + 1);
                            String y = Integer.toString(selectedyear);
                            if (from == 1)
                                ((EditText) v).setText(da + "-" + getMonth(selectedmonth + ""));
                            else
                                //((EditText) v).setText(da + "-" + m+"-"+y);
                                ((EditText) v).setText(da + "-" + m);
                        }
                    }, mYear, mMonth, mDay);
            mDatePicker.setTitle(title + "");
            //mDatePicker.getDatePicker().setMinDate(System.currentTimeMillis());
            mDatePicker.show();
        }*/
    public static boolean isGPSOn(Activity activity) {
        LocationManager manager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        boolean statusOfGPS = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (statusOfGPS) {
            return true;
        } else {
            return false;
        }
    }

    //............................ovverride keypad overlapping .....................
    public static void hideKeyboard(Activity activity, View viewToHide) {
        InputMethodManager imm = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(viewToHide.getWindowToken(), 0);
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null && activity.getCurrentFocus().getWindowToken() != null)
            imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
    //    ......................email validation..................

    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public static void startActivity(Class cls, Bundle extras, Context context) {
        Intent i = new Intent(context, cls);
        if (extras != null)
            i.putExtras(extras);
        context.startActivity(i);
    }

    public static void showSnackBar(View view, String text, int duration, int color) {
        Snackbar snackbar = Snackbar
                .make(view, text, duration);
              /*  .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
// Changing action button text color

        snackbar.setActionTextColor(Color.RED);*/

        // Changing message text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();
    }
}
