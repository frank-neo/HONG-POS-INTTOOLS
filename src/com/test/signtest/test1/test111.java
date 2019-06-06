package com.test.signtest.test1;

import com.test.signtest.SignMaker;

public class test111 {

    public static void main(String args[]) {

        String testString = "a=";

        System.out.println("============>"+testString.split("=")[1]);

        //String a = SignMaker.SignMakerDemo("USR_LOGIN=310011240060514&USR_LOGIN_PWD=6fe52245d63e62f485f82453416c7b1c","MD5_KEY");
        //String c = SignMaker.SignMakerDemo("USR_LOGIN=410011340077810&USR_LOGIN_PWD=0e2e88cdd7f498df792800cb1dd874da","MD5_KEY");
        //System.out.println("sign = "+ c);
    }
}
