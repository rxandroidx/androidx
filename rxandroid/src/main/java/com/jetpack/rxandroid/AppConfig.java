package com.jetpack.rxandroid;

public class AppConfig {


    public static String DOMAIN_URL = BuildConfigs.BASE_URL;
    public static final String BASE_URL = BuildConfigs.BASE_URL;

    public static int PIN_LENGTH = 10 ;
    public static int BENF_OTP_DELETE_LENGTH = 6 ;
    public static int OTP_LENGTH = 4 ;
    public static int PASSWORD_LENGTH     = 6 ;
    public static String APP_VERSION_CODE    = String.valueOf(BuildConfigs.VERSION_CODE);
    public static String APP_UPDATE = BuildConfigs.VERSION_NAME ;
    public static String SOURCE = "mobile";
    public static final int LOCATION_REQUEST = 1000;
    public static final int GPS_REQUEST = 1001;

    public static String DEVICE_VERSION = BuildConfigs.VERSION_NAME ;
    public static String PACKAGE_NAME = BuildConfigs.APPLICATION_ID ;

    public static String DEVICE_ID = "device_id" ;
    public static String LOGIN_DEVICE = "app";
    public static String SOURCE_TYPE = "App" ;
    public static String IS_LOGINED = "Is_Logined" ;

    public static String TRANSACTION_SOURCE = "APP" ;
    public static String HEAD_ACCEPT = "application/json";
    public static String HEAD_CONTENT_TYPE = "application/json";

    public static String HEAD_X_API_KEY = BuildConfigs.HEAD_X_API_KEY;
    public static String NETPAISA_PASS_KEY = BuildConfigs.NETPAISA_PASS_KEY;

    public static String CHECKSUM_KEY = "PackageName="+AppConfig.PACKAGE_NAME+",NETPAISAPASSKEY="+AppConfig.NETPAISA_PASS_KEY+",x-api-key="+AppConfig.HEAD_X_API_KEY;

    public static String INSTALLED_MOBILE = "";

    public static String PAYOUT = "false";

    public static String AEPS = "false";
    public static String RECHARGE = "false";
    public static String DMT = "false";
    public static String AADHAARPAY = "false";
    public static String BBPS = "false";
    public static String OFFLINE_EBILL = "false";
    public static String E_COLLECT = "false";
    public static String MICROATM = "false";
    public static String PAYTM_BILL = "false";

    public static String LOAN = "false";
    public static String INSURANCE = "false";
    public static String IRCTC = "false";

    public static String AEPS_INSTA_URL = "" ;

    public static String IMSI = BuildConfigs.IMSI ;
    public static String API_ACCESS_KEY = "";

    public static String DISTRIBUTOR_LOGIN_URL = "https://reseller.netpaisa.com/login.php" ;

    public static String SKIP_CAPTURE_APP="false";

    public static String LOGIN_USER_NAME = "";
    public static String LOGIN_USER_PWD = "";
    public static String FCM_REGISTRATION_TOKEN = "";

    public static String BLOCK_NAME = "";
    public static String CHECK_SERVICE_AVAILABILITY = "";

    public static String USER_NAME = "";
    public static String USER_MOBILE = "";
    public static String USER_REF_MOBILE_NO = "";
    public static String USER_EMAIL = "";

    public static String B2C_PG_NAME = "";
    public static String B2C_PG_AMOUNT = "Amount to be paid";
    public static String B2C_PG_MOBILE = "";
    public static String B2C_PG_EMAIL = "";

    public static String API_MEMBER_ID_EZYTM = "4215";
    public static String API_MEMBER_PASSWORD_EZYTM = "Rohit@123";

}
