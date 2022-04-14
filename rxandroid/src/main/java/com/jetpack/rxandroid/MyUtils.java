package com.jetpack.rxandroid;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;



public class MyUtils {

    public static boolean isNotEmpty(Object object) {
        if(object == null) return false ;
        return !String.valueOf(object).isEmpty();
    }

    public static boolean isEmpty(Object object) {
        if(object == null) return true ;
        return String.valueOf(object).isEmpty();
    }


    public static void setImageInView(Uri uri, ImageView imageView) {
        if(imageView != null) {
            imageView.setImageURI(null);
            imageView.setImageURI(uri);
        }
    }

    public static String removeSpecialChars(String string) {
        return string.replaceAll("[^a-zA-Z0-9\\s]", "").trim();
    }

    public static void setFirstVisible(View viewVisible, View ...viewHide){
        viewVisible.setVisibility(View.VISIBLE);
        hideAllView(viewHide);
    }

    public static void setFirstGone(View viewToHide, View ...viewToVisible){
        viewToHide.setVisibility(View.GONE);
        showAllView(viewToVisible);
    }

    public static void hideAllView(View ...viewsToHide){
        for (View view : viewsToHide) {
            if(view != null) {
                view.setVisibility(View.GONE);
            }
        }
    }
    public static void showAllView(View ...viewsToShow){
        for (View view : viewsToShow) {
            if(view != null) {
                view.setVisibility(View.VISIBLE);
            }
        }
    }

    public static String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        byte[] byteFormat = stream.toByteArray();
        return Base64.encodeToString(byteFormat, Base64.NO_WRAP);
    }


    public static String getTextForImage(String text) {
        return getTextForImage(text, 2);
    }

    public static String getTextForImage(String text, int textLength) {
        if(text == null) return "N" ;
        text = text.trim() ;

        String[] array = text.split(" ");
        StringBuilder ss = new StringBuilder();
        if(array.length > 0 ) {
            for (int i = 0 ; i < array.length && i < textLength ; i++ ) {
                String s = array[i];
                s = s.trim();
                if (s.length() > 0) {
                    ss.append(s.toUpperCase().charAt(0));
                }
            }
        } else {
            ss.append("N");
        }
        return ss.toString();
    }

    public static void openUrl(Context ctx, String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            ctx.startActivity(intent);
        } catch (Exception e){e.printStackTrace();}
    }

    public static String formatStringDouble(String input, int toPoint) {
        toPoint = toPoint == 0 ? 2 : toPoint ;
        StringBuilder ss = new StringBuilder("#.");
        for(int i = 0 ; i < toPoint ; i++ ) {
            ss.append("#");
        }
        DecimalFormat df2 = new DecimalFormat(ss.toString());
        try {
            double dd = Double.parseDouble(input);
            return df2.format(dd) ;
        } catch (Exception e) {
            return input ;
        }
    }

    public static String getUrlFileName(String url) {
        try {
            return new File(new URI(url).getPath()).getName();
        } catch (Exception e) {
            return "" ;
        }
    }

    public static int dpToPx(Context c, int dp) {
        Resources r = c.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public static String getFirstUpper(String s) {
        if(s == null || s.trim().isEmpty() ) { return s ; }
        StringBuilder ss = new StringBuilder();
        if(s.contains(" ")) {
            boolean isFirst = true;
            String [] words = s.split(" ");
            for(String word : words) {
                word = word.trim();
                if(word.isEmpty()) {continue;}
                ss.append(isFirst ? getUpper(word) : " " + getUpper(word));
                isFirst = false;
            }
        } else {
            ss.append(getUpper(s));
        }
        return ss.toString();
    }
    private static String getUpper(String s){
        if(s.length() == 1) {return s.toUpperCase();}
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static boolean hasGPSDevice(Context context) {
        final LocationManager mgr = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (mgr == null)
            return false;
        final List<String> providers = mgr.getAllProviders();
        if (providers == null)
            return false;
        return providers.contains(LocationManager.GPS_PROVIDER);
    }

    public static String getMacAddress() {

        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(Integer.toHexString(b & 0xFF) + ":");
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < macBytes.length; i++) {
                    sb.append(String.format("%02X%s", macBytes[i], (i < macBytes.length - 1) ? "-" : ""));
                }
                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
            //handle exception
        }
        return getMac();
    }

    public static String getMacAddress(Context ctx) {

        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(Integer.toHexString(b & 0xFF) + ":");
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < macBytes.length; i++) {
                    sb.append(String.format("%02X%s", macBytes[i], (i < macBytes.length - 1) ? "-" : ""));
                }
                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
            //handle exception
        }
        return getMac();
    }

    public static String gotMacAddress() {
        try {
            List <NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif: all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b: macBytes) {
                    //res1.append(Integer.toHexString(b & 0xFF) + ":");
                    res1.append(String.format("%02X:", b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {}
        return "02:00:00:00:00:00";
    }

    public static String gotMacAddress1(Context context) {
        WifiManager wifiMan = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInf = wifiMan.getConnectionInfo();
        @SuppressLint("MissingPermission") String macadd=wifiInf.getMacAddress();
        //System.out.println("MAC address info---- "+macadd);
        if(macadd==null){
            macadd="1A:DC:5C:8E:15:7B";
        }
        return macadd;
    }


    private static String loadFileAsString(String filePath) throws IOException{
        StringBuffer data = new StringBuffer(1000);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            data.append(readData);
        }
        reader.close();
        return data.toString();
    }

    private static String getMac(){
        try {
            return loadFileAsString("/sys/class/net/eth0/address")
                    .toUpperCase().substring(0, 17);
        } catch (IOException e) {
            e.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }




    public static boolean dialNumber(Context ctx, String number){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        if (intent.resolveActivity(ctx.getPackageManager()) != null) {
            ctx.startActivity(intent);
            return true;
        }
        return false;
    }
    public static boolean isEqual(String string, String string2) {
        return string.equalsIgnoreCase(string2);
    }
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission")
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if(isEqual(ni.getTypeName(), "WIFI") || isEqual(ni.getTypeName(), "MOBILE"))
                if(ni.isConnected())
                    return true;
        }
        return false;
    }
    public static Boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission")
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static boolean isAboveAPILevel(int apiV) {
        return Build.VERSION.SDK_INT > apiV;
    }
    public static boolean isBelowAPILevel(int paramInt) {
        return Build.VERSION.SDK_INT < paramInt;
    }

    public static String createJsonObject(Map<String, String> values) throws JSONException {
        JSONObject outer = new JSONObject();
        for (Map.Entry<String, String> entry : values.entrySet()) {
            outer.put(entry.getKey(), entry.getValue());
        }
        return outer.toString();
    }
    public static String getPostGetString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if(!first) result.append("&");
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            first = false;
        }
        return result.toString();
    }

    public static void setFirstVisible(View viewVisible, View viewHide){
        viewVisible.setVisibility(View.VISIBLE);
        viewHide.setVisibility(View.GONE);
    }
    public static boolean isValidNumber(String number){
        Matcher m = Pattern.compile("(0/91)?[6-9][0-9]{9}").matcher(number);
        return (m.find() && m.group().equals(number));
    }
    public static boolean isValidEmail(String email){
        return (Patterns.EMAIL_ADDRESS).matcher(email).matches();
    }
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= AppConfig.PASSWORD_LENGTH ;//&& password.matches("^[a-zA-Z0-9]*$");
    }
    public static boolean isValidPin(String pin) {
        if(pin == null || pin.length() != AppConfig.PIN_LENGTH ) {
            return false;
        }
        String regex = "\\d+";
        return pin.matches(regex);
    }

    public static boolean isValidOtp(String otp) {
        if(otp == null || otp.length() != AppConfig.OTP_LENGTH ) {
            return false;
        }
        String regex = "\\d+";
        return otp.matches(regex);
    }

    public static Spanned fromHtml(String source) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(source);
        }
    }
    public static void showToast(Context context ,String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
    public static void dumpIntent(Intent intent){
        if(intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                for (String key : bundle.keySet()) {
                    Object value = bundle.get(key);
                    if (value != null) {
                        Log.e("Key Tag : ", String.format("%s %s (%s)", key,
                                value.toString(), value.getClass().getName()));

//                        Log.e("Key bundle : ", bundle.toString());
//                        Log.e("Key Data : ", value.toString());

                    }
                }
            }
        }
    }
    public static boolean copyStream(InputStream in , OutputStream out) throws IOException {
        int size = in.available();
        byte[] buffer = new byte[size];
        if(in.read(buffer) > 0) {
            out.write(buffer);
            out.flush();
            out.close();
            in.close();
            return true;
        }
        return false;
    }

    public static void callGc(){
        System.gc();
    }

    public static String getPassedTime(long milli){
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - milli;

        double seconds = tDelta / 1000.0;
        if(seconds < 59 ) return seconds +" Seconds Ago";
        int minute = (int)(seconds / 60 );
        if(minute < 59 ) return minute+" Minutes Ago";
        int hours = minute / 60 ;
        if(hours < 23 ) return hours+" Hours Ago";
        return getCalFields(Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND , ":", true, milli ) +
                " on " +
                getCalFields(Calendar.DAY_OF_MONTH, Calendar.MONTH, Calendar.YEAR , "/",true, milli );
    }
    public static String getDate(){
        return getCalFields(Calendar.DAY_OF_MONTH, Calendar.MONTH, Calendar.YEAR ,"/", false, 0 );
    }
    public static String getDate(long milli){
        return getCalFields(Calendar.DAY_OF_MONTH, Calendar.MONTH, Calendar.YEAR , "/",true, milli );
    }
    public static String getTime(){
        return getCalFields(Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND , ":", false, 0);
    }
    public static String getTime(long milli){
        return getCalFields(Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND , ":", true, milli );
    }
    private static String getCalFields(int f1, int f2, int f3, String sp, boolean b1, long milli) {
        Calendar cl = Calendar.getInstance();
        if(b1) cl.setTimeInMillis(milli);
        return get0Append(cl.get(f1)) + sp + get0Append(cl.get(f2)) + sp + get0Append(cl.get(f3));
    }
    public static String get0Append(int value){
        return value < 10 ? "0"+String.valueOf(value) : String.valueOf(value);
    }

    private static final String SAVED_OBJECT_FILE = "object_json_file";



    public static <GenericClass> GenericClass getSavedObject(Context context, String preferenceKey, Class<GenericClass> classType) {
        return null;
    }




    public static void setDateToTextView(Context ctx, TextView textView) {
        MyUtils.setDateToTextView(ctx, textView, "yyyy-MM-dd");
    }

    public static void setDateToTextView(Context ctx, TextView textView, String dateFormat) {

        final Calendar myCalendar = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener date = (view, year, monthOfYear, dayOfMonth) -> {

            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String tmpString = null;
            if(dateFormat != null && !dateFormat.isEmpty()) {
                try {
                    SimpleDateFormat sdFormat = new SimpleDateFormat(dateFormat, Locale.US);
                    tmpString = sdFormat.format(myCalendar.getTime());
                } catch (Exception ignored) {}
            }

            if(tmpString == null ) {
                String mt_new = monthOfYear > 9 ? String.valueOf(monthOfYear) : "0" + monthOfYear ;
                String dy_new = dayOfMonth > 9 ? String.valueOf(dayOfMonth) : "0" + dayOfMonth ;

                tmpString = year + "-" + mt_new + "-" + dy_new ;
            }

            Log.e("Selected Date", tmpString);
            textView.setText(tmpString);
        };


        DatePickerDialog datePickerDialog = new DatePickerDialog(Objects.requireNonNull(ctx), date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));
         //datePickerDialog.setM(Calendar.getInstance());
         //myCalendar.add(Calendar.DAY_OF_MONTH, 30);

         //datePickerDialog.setMaxDate(now);

         //datePickerDialog.getDatePicker().setMinDate(Calendar.getInstance());
         //myCalendar.add(Calendar.DAY_OF_MONTH, 30);
         //datePickerDialog.getDatePicker().setMaxDate(myCalendar);

        datePickerDialog.show();
    }


    public static int getDaysDifference(Date fromDate, Date toDate)
    {
        if(fromDate==null||toDate==null)
            return 0;

        return (int)( (toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24));
    }


    public static String getDeviceID(Context ctx){
        @SuppressLint("HardwareIds")
        String deviceID = Settings.Secure.getString(ctx.getContentResolver(), Settings.Secure.ANDROID_ID);
        //Log.e("Android ID : ",""+deviceID);
        return deviceID ;
    }


    public static String getUniqueIMEIId(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return "";
            }
            @SuppressLint("MissingPermission")
            String imei = telephonyManager.getDeviceId();
            //Log.e("imei", "=" + imei);
            if (imei != null && !imei.isEmpty()) {
                return imei;
            } else {
                return Build.SERIAL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "not_found";
    }


    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMEINumber(@NonNull final Context context)
            throws SecurityException, NullPointerException {
        String deviceID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return deviceID ;

//        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//        String imei = "";
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                assert tm != null;
//                imei = tm.getImei();
//                //this change is for Android 10 as per security concern it will not provide the imei number.
//                if (imei == null) {
//                    imei = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
//                }
//            } else {
//                assert tm != null;
//                if (null != tm.getDeviceId()) {
//                    if (!tm.getDeviceId().equals("000000000000000")) {
//                        imei = tm.getDeviceId();
//                    } else {
//                        imei = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
//                    }
//                } else {
//                    imei = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
//                }
//            }
//
//
//        return imei;
    }

    public static String getDeviceManuFacturer(@NonNull final Context context) {
        String deviceName = Build.MANUFACTURER ;
        if(deviceName.isEmpty()){
            deviceName="";
        }
            return deviceName;
    }

    public static String getDeviceModel(@NonNull final Context context) {
        String deviceModel =  Build.MODEL;
        if(deviceModel.isEmpty()){
            deviceModel="";
        }
        return deviceModel;
    }

    public static String getAndroidVersion(@NonNull final Context context) {
        String versionName = "";
        try {
            versionName = String.valueOf(Build.VERSION.RELEASE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

    @SuppressLint("NewApi")
    public static String formatQueryParams(Map<String, String> params) {
        return params.entrySet().stream()
                .map(p -> p.getKey() + "=" + p.getValue())
                .reduce((p1, p2) -> p1 + "&" + p2)
                .orElse("");
    }




    public static String generateHashWithHmac256(String message, String key) {
        String value="";
        try {
            final String hashingAlgorithm = "HmacSHA256"; //or "HmacSHA1", "HmacSHA512"
            byte[] bytes = hmac(hashingAlgorithm, key.getBytes(), message.getBytes());
            final String messageDigest = bytesToHex(bytes);
            value=messageDigest;
            //Log.i("TAG", "message digest: " + messageDigest);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public static byte[] hmac(String algorithm, byte[] key, byte[] message) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(key, algorithm));
        return mac.doFinal(message);
    }

    public static String bytesToHex(byte[] bytes) {
        final char[] hexArray = BuildConfig.HEXTOBYTE.toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0, v; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }







    public static String maskPhoneNumber(String inputPhoneNum){
        return inputPhoneNum.replaceAll("[()\\s]+", "-")
                .replaceAll("\\d(?=(?:\\D*\\d){4})", "*");
    }

    public static String maskEmailID(String inputEmailID){
//        Pattern pattern = Pattern.compile("(.)(.*?)(.@.)(.*?)(\\.[^\\.]+)$");
//        Pattern pattern = Pattern.compile("(.)(.*?)(.@.)(.*?)(\\.[^\\.]+)$");
//        Matcher matcher = pattern.matcher(inputEmailID);
//        if (matcher.find()) {
//            inputEmailID = matcher.group(1) + matcher.group(2).replaceAll(".", "*") +
//                    matcher.group(3) + matcher.group(4).replaceAll(".", "*") +
//                    matcher.group(5);
//        }
        return inputEmailID.replaceAll("(?<=.).(?=[^@]*?.@)", "*");
    }

}
