package com.magnitudestudios.sriharivishnu.outfitters;

/**
 * Created by Srihari Vishnu on 2018-05-05.
 */
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.magnitudestudios.sriharivishnu.outfitters.MainActivity.images;


public class ImageFragment extends Fragment implements View.OnClickListener{
    private ImageButton yesButton;
    private ImageButton noButton;
    private TextView yesPercent;
    private TextView noPercent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int position = getArguments().getInt("position");
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.image_fragment, container,false);
        ImageView iv = rootView.findViewById(R.id.image);
        iv.setBackgroundResource(images.get(position));
        yesButton = rootView.findViewById(R.id.yesButton);
        yesButton.setOnClickListener(this);
        noButton = rootView.findViewById(R.id.noButton);
        noButton.setOnClickListener(this);

        yesPercent = (TextView) rootView.findViewById(R.id.yesPercent);
        noPercent = (TextView) rootView.findViewById(R.id.noPercent);
        return rootView;
    }
    @Override
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.yesButton:
                yesButton.setImageResource(R.drawable.plain_black_square);
                yesButton.setScaleX(0.6f);
                yesButton.setScaleY(0.9f);
                noButton.setImageResource(R.drawable.plain_black_square);
                noButton.setScaleX(0.6f);
                noButton.setScaleY(0.9f);
                yesButton.setEnabled(false);
                noButton.setEnabled(false);
                showPercentage();
            case R.id.noButton:
                yesButton.setImageResource(R.drawable.plain_black_square);
                yesButton.setScaleX(0.6f);
                yesButton.setScaleY(0.9f);
                noButton.setImageResource(R.drawable.plain_black_square);
                noButton.setScaleX(0.6f);
                noButton.setScaleY(0.9f);
                yesButton.setEnabled(false);
                noButton.setEnabled(false);
                showPercentage();
        }

    }
    private void showPercentage() {
        int percentYes = (int) (Math.random()*101);
        int percentNo = 100-percentYes;
        yesPercent.setVisibility(View.VISIBLE);
        noPercent.setVisibility(View.VISIBLE);
        yesPercent.setText(Integer.toString(percentYes)+"%");
        noPercent.setText(Integer.toString(percentNo)+"%");
    }

}
