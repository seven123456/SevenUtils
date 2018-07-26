package com.seven.sevenutils.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created  on 2018/7/6 0006.
 * author:seven
 * email:seven2016s@163.com
 */
public class RegularUtils {
    private static volatile RegularUtils mInstance;

    private RegularUtils() {

    }

    public static RegularUtils getmInstance() {
        if (mInstance == null) {
            synchronized (RegularUtils.class) {
                if (mInstance == null) {
                    mInstance = new RegularUtils();
                }
            }
        }
        return mInstance;
    }

    /**
     * 手机号用****号隐藏中间数字
     *
     * @param phone
     * @return
     */
    public static String settingphone(String phone) {
        String phone_s = phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        return phone_s;
    }

    /**
     * 邮箱用****号隐藏前面的字母
     *
     * @return
     */
    public static String settingemail(String email) {
        String emails = email.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4");
        return emails;
    }

    /*
     * 验证邮箱格式
     * */
    public static boolean verifyEmail(String email) {
        String regular = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        return regular.matches(email);
    }

    /*验证手机号码 ^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$
    ^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$
     * */
    public static boolean verifyPhone(String phone) {
        String regular = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\\\d{8}$";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /*验证用户名 字母开头  英文字母（不区分大小写）、数字或下划线*/
    public static boolean verifyUserName(String phone) {
        String regular = "^[a-zA-Z]/w{4,20}$";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
    /*短信验证码 只能是四位数字*/
    public static boolean verifySMSCode(String code) {
        String regular = "^/d{4}$";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(code);
        return matcher.matches();
    }

    /*验证用户密码 6-20位 区分大小写，数字
    ^([A-Z]|[a-z]|[0-9]){6,20}$*/
    public static  boolean verifyPassword(String password){
        String regular = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
