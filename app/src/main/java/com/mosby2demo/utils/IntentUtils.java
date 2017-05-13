package com.mosby2demo.utils;

import android.content.Intent;

/**
 * Created by Vyacheslav on 10.05.2017.
 */

public class IntentUtils {

    public static Intent getPickImageFromGalleryIntent() {
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
//        getIntent.setType("image/*");
//
//        Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        pickIntent.setType("image/*");
//
//        Intent intent = Intent.createChooser(getIntent, App.getApplication().getString(R.string.select_picture));
//        intent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});

        return getIntent;
    }


}
