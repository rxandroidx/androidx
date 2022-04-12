package com.jetpack.rxandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class UserData {

    public static String USER_LOGGED_IN = "user_logged_in";
    public static String USER_TYPE = "user_type";
    public static String USER_ID = "user_id";
    public static String USER_PIN = "user_pin";
    public static String USER_TOKEN = "user_token";
    public static String PASSWORD_SAVE = "password";
    public static String USER_NAME = "user_name";
    public static String RETAILER_NAME = "retailer_name";
    public static String REMITTER_ID = "remitter_id";
    public static String USER_MOBILE = "user_mobile";
    public static String COM_MOBILE = "com_mobile";
    public static String MOBILE_NEW = "mobile_new";
    public static String DMT_USER_MOBILE = "dmt_user_mobile";
    public static String DMT_BANKIT_USER_MOBILE = "dmt_bankit_user_mobile";
    public static String DMT_BANKIT_WALLET_BALANCE = "dmt_bankit_wallet_balance";
    public static String DMT_BANKIT_REMAIN_BALANCE = "dmt_bankit_remain_balance";
    public static String AEPS_LOGIN = "aeps_login_success";
    public static String AEPS_MSG = "aeps_msg";
    public static String REMAINING_LIMIT = "remaining_wallet_limit";
    public static String LONGITUDE = "longitude";
    public static String LATITUDE = "latitude";
    public static String TID = "tid";
    public static String MID = "mid";
    public static String USERNAME_MOSAMBEE = "user_mosambee";
    public static String PASSWORD_MOSAMBEE = "pass";
    public static String DEVICE_TYPE = "device_type";
    public static String LOGIN_AUTH_TOKEN = "0";
    public static String USER_EMAIL = "user_email";
    public static String PAYOUT_SERVICE = "payout";
    public static String REGISTERED_B2C = "false";


    public static void logOut(Context context) {
        getEditor(context).clear().apply();
    }

    private static SharedPreferences getPref(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    private static SharedPreferences.Editor getEditor(Context context){
        return getPref(context).edit();
    }

    public static void setUserLogin(Context context, boolean is) {
        getEditor(context).putBoolean(USER_LOGGED_IN, is).apply();
    }

    public static boolean isLoggedIn(Context context) {
        return getPref(context).getBoolean(USER_LOGGED_IN, false);
    }

    public static void setRegisteredB2c(Context context, String is) {
        getEditor(context).putString(REGISTERED_B2C, is).apply();
    }
    public static String getRegisteredB2c(Context context) {
        return getPref(context).getString(REGISTERED_B2C, "false");
    }



    public static void setUserType(Context context, String is) {
        getEditor(context).putString(USER_TYPE, is).apply();
    }

    public static String getUserType(Context context) {
        return getPref(context).getString(USER_TYPE, "");
    }

    public static void setUserId(Context context, String is) {
        getEditor(context).putString(USER_ID, is).apply();
    }

    public static String getUserId(Context context) {
        return getPref(context).getString(USER_ID, "");
    }

    public static void setUserPin(Context context, String is) {
        getEditor(context).putString(USER_PIN, is).apply();
    }

    public static String getUserPin(Context context) {
        return getPref(context).getString(USER_PIN, "");
    }


    public static void setUserMobile(Context context, String is) {
        getEditor(context).putString(USER_MOBILE, is).apply();
    }

    public static String getUserMobile(Context context) {
        return getPref(context).getString(USER_MOBILE, "");
    }


    public static void setComMobile(Context context, String is) {
        getEditor(context).putString(COM_MOBILE, is).apply();
    }

    public static String getComMobile(Context context) {
        return getPref(context).getString(COM_MOBILE, "");
    }


    public static void setMobileNoNew(Context context, String is) {
        getEditor(context).putString(MOBILE_NEW, is).apply();
    }

    public static String getMobileNoNew(Context context) {
        return getPref(context).getString(MOBILE_NEW, "");
    }

    public static void setToken(Context context, String is) {
        getEditor(context).putString(USER_TOKEN, is).apply();
    }

    public static String getToken(Context context) {
        return getPref(context).getString(USER_TOKEN, "0");
    }

    public static void setPassword(Context context, String is) {
        getEditor(context).putString(PASSWORD_SAVE, is).apply();
    }

    public static String getPassword(Context context) {
        return getPref(context).getString(PASSWORD_SAVE, "");
    }

    public static void setUserName(Context context, String is) {
        getEditor(context).putString(USER_NAME, is).apply();
    }

    public static String getUsername(Context context) {
        return getPref(context).getString(USER_NAME, "");
    }

    public static void setRetailerName(Context context, String is) {
        getEditor(context).putString(RETAILER_NAME, is).apply();
    }

    public static String getRetailerName(Context context) {
        return getPref(context).getString(RETAILER_NAME, "");
    }

    public static void setRemitterId(Context context, String is) {
        getEditor(context).putString(REMITTER_ID, is).apply();
    }

    public static String getRemitterId(Context context) {
        return getPref(context).getString(REMITTER_ID, "");
    }

    public static  String getRemainingLimit(Context context) {
        return getPref(context).getString(REMAINING_LIMIT, "");
    }

    public static void setRemainingLimit(Context context,String remainingLimit) {
        getEditor(context).putString(REMAINING_LIMIT, remainingLimit).apply();
    }

    public static void setDmtUserMobile(Context context, String is) {
        getEditor(context).putString(DMT_USER_MOBILE, is).apply();
    }

    public static String getDmtUserMobile(Context context) {
        return getPref(context).getString(DMT_USER_MOBILE, "");
    }

    public static void setDMTBankitUserMobile(Context context, String is){
        getEditor(context).putString(DMT_BANKIT_USER_MOBILE,is).apply();
    }

    public static String getDMTBankitUserMobile(Context context){
        return getPref(context).getString(DMT_BANKIT_USER_MOBILE,"");
    }

    public static void setDmtBankitWalletBalance(Context context,String is){
        getEditor(context).putString(DMT_BANKIT_WALLET_BALANCE,is).apply();
    }

    public static String getDmtBankitWalletBalance(Context context){
        return getPref(context).getString(DMT_BANKIT_WALLET_BALANCE,"");
    }

    public static void setDmtBankitRemainBalance(Context context,String is){
        getEditor(context).putString(DMT_BANKIT_REMAIN_BALANCE,is).apply();
    }

    public static String getDmtBankitRemainBalance(Context context){
        return getPref(context).getString(DMT_BANKIT_REMAIN_BALANCE,"");
    }

    public static String getAepsLogin(Context context) {
        return getPref(context).getString(AEPS_LOGIN,"");
    }

    public static void setAepsLogin(Context context,String is) {
        getEditor(context).putString(AEPS_LOGIN,is).apply();
    }

    public static String getAepsMsg(Context context){
        return  getPref(context).getString(AEPS_MSG,"");
    }

    public static void setAepsMsg(Context context,String is){
        getEditor(context).putString(AEPS_MSG,is).apply();
    }

    public static void setLatitude(Context context, String is) {
        getEditor(context).putString(LATITUDE, is).apply();
    }

    public static String getLatitude(Context context) {
        return getPref(context).getString(LATITUDE, "");
    }

    public static void setLongitude(Context context, String is) {
        getEditor(context).putString(LONGITUDE, is).apply();
    }

    public static String getLongitude(Context context) {
        return getPref(context).getString(LONGITUDE, "");
    }

    public static void setLatitude(double wayLatitude) {
    }

    public static void setLoginAuthToken(Context context, String is) {
        getEditor(context).putString(LOGIN_AUTH_TOKEN, is).apply();
    }

    public static String getLoginAuthToken(Context context ) {
        return getPref(context).getString(LOGIN_AUTH_TOKEN, "");
    }

    public static String getUserEmail(Context context ) {
        return getPref(context).getString(USER_EMAIL, "");
    }

    public static void setUserEmail(Context context, String userEmail) {
        getEditor(context).putString(USER_EMAIL, userEmail).apply();
    }

    public static void setTid(Context context, String is) {
        getEditor(context).putString(TID, is).apply();
    }

    public static String getTid(Context context) {
        return getPref(context).getString(TID, "");
    }

    public static void setMid(Context context, String is) {
        getEditor(context).putString(MID, is).apply();
    }

    public static String getMid(Context context) {
        return getPref(context).getString(MID, "");
    }

    public static void setUsernameMosambee(Context context, String is) {
        getEditor(context).putString(USERNAME_MOSAMBEE, is).apply();
    }

    public static String getUsernameMosambee(Context context) {
        return getPref(context).getString(USERNAME_MOSAMBEE, "");
    }

    public static void setPasswordMosambee(Context context, String is) {
        getEditor(context).putString(PASSWORD_MOSAMBEE, is).apply();
    }

    public static String getPasswordMosambee(Context context) {
        return getPref(context).getString(PASSWORD_MOSAMBEE, "");
    }

    public static void setDeviceType(Context context, String is) {
        getEditor(context).putString(DEVICE_TYPE, is).apply();
    }

    public static String getDeviceType(Context context) {
        return getPref(context).getString(DEVICE_TYPE, "");
    }

    public static void setPayoutService(Context context, boolean is) {
        getEditor(context).putBoolean(PAYOUT_SERVICE, is).apply();
    }

    public static boolean isPayoutService(Context context) {
        return getPref(context).getBoolean(PAYOUT_SERVICE, false);
    }
}
