package com.javatar.autocompleteemail.widget;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.javatar.autocompleteemail.widget.util.AccountManagerHelper;

import java.util.List;

/**
 * Created by gokhan on 19-Feb-17.
 */

public class AutoCompleteEmail extends AutoCompleteTextView {

    private OnTouchListener mOnTouchListener;
    private OnFocusChangeListener mOnFocusChangeListener;

    public AutoCompleteEmail(Context context) {
        super(context);
        init(context);
    }

    public AutoCompleteEmail(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AutoCompleteEmail(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        mOnTouchListener = l;
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        mOnFocusChangeListener = l;
    }

    private void init(Context context) {

        List<String> emailList = AccountManagerHelper.getEmails(context);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_dropdown_item_1line,
                emailList);
        setAdapter(adapter);
        setSelectAllOnFocus(true);
        setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
    }
}