package org.fingerlinks.mobile.android.samplel;

import android.content.Context;

/**
 * Created by Fabio Ranieri on 20/10/14.
 * Copyright 2014 Fingerlinks s.r.l.
 */
public class CodeUtils {

    /**
     * @param context
     * @param name
     * @return
     */
    public static int getImageResourceId(Context context, String name) {
        try {
            return context.getResources().
                    getIdentifier(name, "drawable", context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
