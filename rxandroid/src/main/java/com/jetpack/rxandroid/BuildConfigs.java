package com.jetpack.rxandroid;
 

public class BuildConfigs {

    public static final String ID  = "189509401986320399";

    public static final String  VERSION_CODE    = "1" ;
    public static final String  VERSION_NAME  = "1.0" ;

    public static final String TIMESTAMP = System.currentTimeMillis()+"L";

    public static final String  BUILD_TYPE  = "debug" ;
    public static final String  FLAVOR  = "netpaisa" ;

    public static final String  APPLICATION_ID  = "com.netpaisa" ;
    public static final String  APPLICATION_IN  = "com.netpaisa.in" ;

    public static final String BASE_URL = "https://reseller.netpaisa.com/api/";
  
    public static final String  BASE_URL_NPS  = "https://www.netpaisa.com/nps/api/" ;
    public static final String  BASE_URL_IN  = "https://netpaisa.in/api/" ;
    public static final String  BASE_URL_COM  = "https://reseller.netpaisa.com/api/" ;

    public static final String  BASE_URL_B2C  = "https://netpaisa.in/api/" ;
    public static final String  BASE_URL_B2B  = "https://reseller.netpaisa.com/api/" ;

    public static final String  HEAD_X_API_KEY  = "skg#@!12#09" ;
    public static final String  NETPAISA_PASS_KEY  = "snetpaisaSW" ;

    public static final String  LOGIN  = "true" ;
    public static final String  BANK_IT_AGENT_ID  = "" ;
    public static final String  BANK_IT_AGENT_ID_NPS  = "" ;
    public static final String  IMSI  = "404277270862423" ;
    public static final String  RISETECH_DEV_ID  = "RISEIN TECH PRIVATE LIMITED-RASHI052534" ;

    public static final String  RISEINTECH_PASSWORD  = "gz9lft4fxa" ;
    public static final String  HEXTOBYTE  = "0123456789abcdef" ;

    public static final String PID_1  = "<PidOptions ver=\"1.0\"> <Opts fCount=\"1\" fType=\"0\" iCount=\"0\" pCount=\"0\" format=\"0\" pidVer=\"2.0\" timeout=\"10000\"  env=\"P\"  /> <CustOpts><Param name=\"mantrakey\" value=\"\" /></CustOpts> </PidOptions>";
    public static final String PID_2 = "<PidOptions ver=\"1.0\"><Opts env=\"P\" fCount=\"1\" fType=\"0\" iCount=\"0\" iType=\"\" pCount=\"0\" pType=\"\" format=\"0\" pidVer=\"2.0\" timeout=\"10000\" otp=\"\"  wadh=\"\" posh=\"UNKNOWN\" /><CustOpts><Param name=\"\" value=\"\"/></CustOpts></PidOptions>";
    public static final String PID_3  = "<PidOptions ver=\"1.0\"> <Opts fCount=\"1\" fType=\"0\" iCount=\"0\" pCount=\"0\" format=\"0\" pidVer=\"2.0\" timeout=\"10000\"  env=\"P\"  /><Demo></Demo> <CustOpts><Param name=\"Param1\" value=\"\" /></CustOpts> </PidOptions>";
    public static final String PID_4 = "<PidOptions ver =\"1.0\"><Opts env=\"P\" fCount=\"1\" fType=\"0\" iCount=\"1\" iType=\"0\" pCount=\"1\" pType=\"0\" format=\"0\" pidVer=\"2.0\" timeout=\"10000\" otp=\"\" wadh=\"\" posh=\"UNKNOWN\"/> <Demo></Demo> <CustOpts> <Param name=\"Param1\" value=\"\"/></CustOpts></PidOptions>";

    public static final String PID_POINT1  = "<PidOptions ver=\"1.0\"> <Opts fCount=\"1\" fType=\"0\" iCount=\"0\" pCount=\"0\" format=\"0\" pidVer=\"2.0\" timeout=\"10000\"  env=\"P\"  /> <CustOpts><Param name=\"mantrakey\" value=\"\" /></CustOpts> </PidOptions>";
    public static final String PID_POINT2 = "<PidOptions ver=\"1.0\"><Opts env=\"P\" fCount=\"1\" fType=\"0\" iCount=\"0\" iType=\"\" pCount=\"0\" pType=\"\" format=\"0\" pidVer=\"2.0\" timeout=\"10000\" otp=\"\"  wadh=\"\" posh=\"UNKNOWN\" /><CustOpts><Param name=\"\" value=\"\"/></CustOpts></PidOptions>";
    public static final String PID_POINT3  = "<PidOptions ver=\"1.0\"> <Opts fCount=\"1\" fType=\"0\" iCount=\"0\" pCount=\"0\" format=\"0\" pidVer=\"2.0\" timeout=\"10000\"  env=\"P\"  /><Demo></Demo> <CustOpts><Param name=\"Param1\" value=\"\" /></CustOpts> </PidOptions>";
    public static final String PID_POINT4 = "<PidOptions ver =\"1.0\"><Opts env=\"P\" fCount=\"1\" fType=\"0\" iCount=\"1\" iType=\"0\" pCount=\"1\" pType=\"0\" format=\"0\" pidVer=\"2.0\" timeout=\"10000\" otp=\"\" wadh=\"\" posh=\"UNKNOWN\"/> <Demo></Demo> <CustOpts> <Param name=\"Param1\" value=\"\"/></CustOpts></PidOptions>";

    public static String CHECKSUM_KEY = "PackageName="+BuildConfigs.APPLICATION_ID+",NETPAISAPASSKEY="+BuildConfigs.NETPAISA_PASS_KEY+",x-api-key="+BuildConfigs.HEAD_X_API_KEY;

    public static final String  CHECKSUM_KEYS  = "PackageName=netpaisa.sdk,NETPAISAPASSKEY=snetpaisaSW,x-api-key=skg#@!12#09" ;

}
