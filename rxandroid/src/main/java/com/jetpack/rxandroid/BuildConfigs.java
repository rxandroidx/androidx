package com.jetpack.rxandroid;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BuildConfigs {

    public BuildConfigs() {
    }

    /********************************* Start 1st Phase ******************************/
    public static JSONObject onWriteJsonObject(Context mContext, String mJsonWriteFileName) {

        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("ID",  BuildConfig.ID);
            jsonObject.put("LIBRARY_PACKAGE_NAME",  BuildConfig.LIBRARY_PACKAGE_NAME);

            jsonObject.put("APPLICATION_ID",   BuildConfig.APPLICATION_ID);
            jsonObject.put("APPLICATION_IN",   BuildConfig.APPLICATION_IN);

            jsonObject.put("VERSION_CODE",  BuildConfig.VERSION_CODE);
            jsonObject.put("VERSION_NAME",  BuildConfig.VERSION_NAME);

            jsonObject.put("BASE_URL",  BuildConfig.BASE_URL);
            jsonObject.put("BASE_URL_IN",   BuildConfig.BASE_URL_IN);
            jsonObject.put("BASE_URL_NPS",   BuildConfig.BASE_URL_NPS);

            jsonObject.put("HEAD_X_API_KEY",  BuildConfig.HEAD_X_API_KEY);
            jsonObject.put("NETPAISA_PASS_KEY",   BuildConfig.NETPAISA_PASS_KEY);
            jsonObject.put("BANK_IT_AGENT_ID",  BuildConfig.BANK_IT_AGENT_ID);
            jsonObject.put("BUILD_TYPE",  BuildConfig.BUILD_TYPE);
            jsonObject.put("FLAVOR",   BuildConfig.FLAVOR);

            jsonObject.put("IMSI", BuildConfig.IMSI);
            jsonObject.put("RISETECH_DEV_ID",   BuildConfig.RISETECH_DEV_ID);
            jsonObject.put("RISEINTECH_PASSWORD", BuildConfig.RISEINTECH_PASSWORD);
            jsonObject.put("HEXTOBYTE",  BuildConfig.HEXTOBYTE);
            jsonObject.put("CHECKSUM_KEY", BuildConfig.CHECKSUM_KEY);

            jsonObject.put("PID_1", "<PidOptions ver=\"1.0\"> <Opts fCount=\"1\" fType=\"0\" iCount=\"0\" pCount=\"0\" format=\"0\" pidVer=\"2.0\" timeout=\"10000\"  env=\"P\"  /> <CustOpts><Param name=\"mantrakey\" value=\"\" /></CustOpts> </PidOptions>");
            jsonObject.put("PID_2", "<PidOptions ver=\"1.0\"><Opts env=\"P\" fCount=\"1\" fType=\"0\" iCount=\"0\" iType=\"\" pCount=\"0\" pType=\"\" format=\"0\" pidVer=\"2.0\" timeout=\"10000\" otp=\"\"  wadh=\"\" posh=\"UNKNOWN\" /><CustOpts><Param name=\"\" value=\"\"/></CustOpts></PidOptions>");
            jsonObject.put("PID_3", "<PidOptions ver=\"1.0\"> <Opts fCount=\"1\" fType=\"0\" iCount=\"0\" pCount=\"0\" format=\"0\" pidVer=\"2.0\" timeout=\"10000\"  env=\"P\"  /><Demo></Demo> <CustOpts><Param name=\"Param1\" value=\"\" /></CustOpts> </PidOptions>");

        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            onWriteJsonObjectInFile(mContext, jsonObject, mJsonWriteFileName);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return jsonObject;
    }





    public static void onWriteJsonObjectInFile(Context context, JSONObject jsonObject, String jsonWriteFileName) {
        // Convert JsonObject to String Format
        String userString = jsonObject.toString();
        // Define the File Path and its Name
        // File file = new File(context.getFilesDir(), "BuildCunfigs.json");
        File file = new File(context.getFilesDir(), jsonWriteFileName);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(userString);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static String onGetJsonResponse(Context context, String jsonReadFileName){
        //File file = new File(context.getFilesDir(), "BuildCunfigs.json");
        File file = new File(context.getFilesDir(), jsonReadFileName);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        try {
            line = bufferedReader.readLine();
            while (line != null){
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
/********************************* End 1st Phase ******************************/


/********************************* Start 2nd Phase ******************************/
    public static JSONObject onWriteJsonObject(Context mContext) {

        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("ID",  BuildConfig.ID);
            jsonObject.put("LIBRARY_PACKAGE_NAME",  BuildConfig.LIBRARY_PACKAGE_NAME);

            jsonObject.put("APPLICATION_ID",   BuildConfig.APPLICATION_ID);
            jsonObject.put("APPLICATION_IN",   BuildConfig.APPLICATION_IN);

            jsonObject.put("VERSION_CODE",  BuildConfig.VERSION_CODE);
            jsonObject.put("VERSION_NAME",  BuildConfig.VERSION_NAME);

            jsonObject.put("BASE_URL",  BuildConfig.BASE_URL);
            jsonObject.put("BASE_URL_IN",   BuildConfig.BASE_URL_IN);
            jsonObject.put("BASE_URL_NPS",   BuildConfig.BASE_URL_NPS);

            jsonObject.put("HEAD_X_API_KEY",  BuildConfig.HEAD_X_API_KEY);
            jsonObject.put("NETPAISA_PASS_KEY",   BuildConfig.NETPAISA_PASS_KEY);
            jsonObject.put("BANK_IT_AGENT_ID",  BuildConfig.BANK_IT_AGENT_ID);
            jsonObject.put("BUILD_TYPE",  BuildConfig.BUILD_TYPE);
            jsonObject.put("FLAVOR",   BuildConfig.FLAVOR);

            jsonObject.put("IMSI", BuildConfig.IMSI);
            jsonObject.put("RISETECH_DEV_ID",   BuildConfig.RISETECH_DEV_ID);
            jsonObject.put("RISEINTECH_PASSWORD", BuildConfig.RISEINTECH_PASSWORD);
            jsonObject.put("HEXTOBYTE",  BuildConfig.HEXTOBYTE);
            jsonObject.put("CHECKSUM_KEY", BuildConfig.CHECKSUM_KEY);

            jsonObject.put("PID_1", "<PidOptions ver=\"1.0\"> <Opts fCount=\"1\" fType=\"0\" iCount=\"0\" pCount=\"0\" format=\"0\" pidVer=\"2.0\" timeout=\"10000\"  env=\"P\"  /> <CustOpts><Param name=\"mantrakey\" value=\"\" /></CustOpts> </PidOptions>");
            jsonObject.put("PID_2", "<PidOptions ver=\"1.0\"><Opts env=\"P\" fCount=\"1\" fType=\"0\" iCount=\"0\" iType=\"\" pCount=\"0\" pType=\"\" format=\"0\" pidVer=\"2.0\" timeout=\"10000\" otp=\"\"  wadh=\"\" posh=\"UNKNOWN\" /><CustOpts><Param name=\"\" value=\"\"/></CustOpts></PidOptions>");
            jsonObject.put("PID_3", "<PidOptions ver=\"1.0\"> <Opts fCount=\"1\" fType=\"0\" iCount=\"0\" pCount=\"0\" format=\"0\" pidVer=\"2.0\" timeout=\"10000\"  env=\"P\"  /><Demo></Demo> <CustOpts><Param name=\"Param1\" value=\"\" /></CustOpts> </PidOptions>");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            onWriteJsonObjectInFile(mContext, jsonObject);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return jsonObject;
    }


    public static void onWriteJsonObjectInFile(Context context, JSONObject jsonObject ) {
        // Convert JsonObject to String Format
        String userString = jsonObject.toString();
        // Define the File Path and its Name
        File file = new File(context.getFilesDir(), "BuildCunfigs.json");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(userString);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String onGetJsonResponse(Context context){
        File file = new File(context.getFilesDir(), "BuildCunfigs.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        try {
            line = bufferedReader.readLine();
            while (line != null){
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    //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
    /********************************* End 2nd Phase ******************************/

}
