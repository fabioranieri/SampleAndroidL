package org.fingerlinks.mobile.android.samplel.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabio Ranieri on 20/10/14.
 * Copyright 2014 Fingerlinks s.r.l.
 */
public class ImageFactoryManager {

    private static String[] _names = {
            "Image1", "Image2", "Image3", "Image4", "Image5", "Image6"
    };
    private static String loremIpsum =
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut " +
            "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea " +
            "commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    private static ImageFactoryManager mInstance;
    private List<Image> images;

    public static ImageFactoryManager getInstance() {
        if (mInstance == null) {
            mInstance = new ImageFactoryManager();
        }
        return mInstance;
    }

    public List<Image> getAllImages() {
        if (images == null) {
            images = new ArrayList<Image>();

            for (String name : _names ) {
                Image _obj = new Image();
                _obj.name = name;
                _obj.description = loremIpsum;
                _obj.imageName = name.replaceAll("\\s+","").toLowerCase();
                images.add(_obj);
            }
        }
    return images;
    }

    public Image getImageAt(int position) {
        return images.get(position);
    }
}
