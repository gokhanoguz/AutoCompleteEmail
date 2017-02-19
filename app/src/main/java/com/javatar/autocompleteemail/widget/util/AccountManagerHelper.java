package com.javatar.autocompleteemail.widget.util;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Patterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

/**
 * Created by gokhan on 19-Feb-17.
 */

public class AccountManagerHelper {

    public static List<String> getEmails(Context context) {

        //Don't use list since there can be dublicate emails for different account
        //List<String> emailList = new ArrayList<String>();
        Set<String> emailSet = new HashSet<String>();

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
            new ArrayList<String>();
        }
        final Account[] accounts = AccountManager.get(context).getAccounts();

        for (Account account : accounts) {
            if (isEmail(account.name)) {
                emailSet.add(account.name);
            }
        }
        return new ArrayList<>(emailSet);
    }

    // Check if the account is email or not
    private static boolean isEmail(String account) {
        if (TextUtils.isEmpty(account)) {
            return false;
        }
        final Matcher matcher = Patterns.EMAIL_ADDRESS.matcher(account);
        return matcher.matches();
    }
}
