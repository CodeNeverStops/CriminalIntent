package io.github.uv_lab.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by youwei on 2016/11/1.
 */

public class PhotoFragment extends DialogFragment {

    public static final String ARG_PHOTO = "photo";

    private int mImageWidth;
    private int mImageHeight;
    private ImageView mImageView;


    public static PhotoFragment newInstance(File file) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO, file);

        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        // 设置dialog的大小为图片大小
        getDialog().getWindow().setLayout(mImageWidth, mImageHeight);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        File file = (File) getArguments().getSerializable(ARG_PHOTO);

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_photo, null);

        mImageView = (ImageView) v.findViewById(R.id.dialog_photo);

        Bitmap bitmap = PictureUtils.getScaledBitmap(file.getPath(), getActivity());
        mImageView.setImageBitmap(bitmap);

        mImageWidth = bitmap.getWidth();
        mImageHeight = bitmap.getHeight();

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }


}
