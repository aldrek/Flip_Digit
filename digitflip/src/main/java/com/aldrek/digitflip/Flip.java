package com.aldrek.digitflip;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static android.content.ContentValues.TAG;

class Flip implements AnimationListener {
    private ImageView flip_backup = null;
    private ImageView flipI_backlow = null;
    private ImageView flip_frontup = null;
    private ImageView flip_frontlow = null;

    private Context context;
    private Animation anim1;
    private Animation anim2;
    private int id;
    private OnAnimationComplete animComplete;

    private int animTo = 0;
    private int animFrom = 0;

    boolean isFastFlip;
    int color;

    public interface OnAnimationComplete {
        public void onComplete(int id);
    }

    public Flip(Context act, int id, View view, OnAnimationComplete animComplete, boolean isFastFlip, int color) {
        super();
        this.context = act;
        if(color != 0)
            this.color = color;
        this.id = id;
        this.animComplete = animComplete;
        this.isFastFlip = isFastFlip;

        flip_backup = (ImageView) view.findViewById(R.id.image_flip_back_upper);
        flipI_backlow = (ImageView) view.findViewById(R.id.image_flip_back_lower);
        flip_frontup = (ImageView) view.findViewById(R.id.image_flip_front_upper);
        flip_frontlow = (ImageView) view.findViewById(R.id.image_flip_front_lower);

        setColor();

        init();
    }

    public void setDigit(int digit, boolean withAnimation) {

        if (digit < 0)
            digit = 0;
        if (digit > 9)
            digit = 9;


        animTo = digit;

        Log.d(TAG, "setDigit: " + digit);

        if (withAnimation)
            animateDigit(true);
        else
            setDigitImageToAll(digit);
    }

    private void setColor(){

        if (color != 0) {

            flip_backup.setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN);
            flipI_backlow.setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN);
            flip_frontup.setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN);
            flip_frontlow.setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN);

        }

    }


    public void setFastFlip(boolean isFastFlip) {
        this.isFastFlip = isFastFlip;
    }

    public void setColor(int color) {
        this.color = color;
        setColor();

    }

    private void animateDigit(boolean isUpper) {

        animFrom = getLastDigit(isUpper);
        startAnimation();

    }

    private void init() {

        flip_backup.setTag(0);
        flipI_backlow.setTag(0);
        flip_frontup.setTag(0);
        flip_frontlow.setTag(0);

        anim1 = AnimationUtils.loadAnimation(context, R.anim.flip_point_to_middle);
        anim1.setAnimationListener(this);
        anim2 = AnimationUtils.loadAnimation(context, R.anim.flip_point_from_middle);
        anim2.setAnimationListener(this);

    }

    private void startAnimation() {

        if (animTo == animFrom) {
            if (animComplete != null)
                animComplete.onComplete(id);
        } else {
            startDigitAnimation(true);
        }

    }

    private void startDigitAnimation(boolean isUpper) {

        if (isUpper) {
            flip_frontup.clearAnimation();
            flip_frontup.setAnimation(anim1);
            flip_frontup.startAnimation(anim1);

        } else {
            flip_frontlow.clearAnimation();
            flip_frontlow.setAnimation(anim2);
            flip_frontlow.startAnimation(anim2);

        }
    }

    private void incrementFromCode() {
        animFrom++;
        if (animFrom < 0)
            animFrom = 0;

        if (animFrom > 9)
            animFrom = 9;

    }

    private int getLastDigit(boolean isUpper) {
        int digit = 0;
        try {
            if (isUpper)
                digit = (Integer) flip_frontup.getTag();
            else
                digit = (Integer) flip_frontlow.getTag();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (digit > 9)
            digit = 0;

        return digit;
    }

    private int getDigitToShow() {
        if (!isFastFlip)
            if (animFrom + 1 > 9)
                return 0;
            else
                return animFrom + 1;

        return animTo;
    }

    private void setDigitImageToAll(int digit) {
        setDigitImage(digit, true, flip_backup);
        setDigitImage(digit, false, flipI_backlow);
        setDigitImage(digit, true, flip_frontup);
        setDigitImage(digit, false, flip_frontlow);

    }

    private void setDigitImage(int digitToShow, boolean isUpper, ImageView image) {
        image.setTag(digitToShow);
        int resource = 0;
        switch (digitToShow) {
            case 0:
                if (isUpper)
                    resource = R.drawable.ic_upper_0;
                else
                    resource = R.drawable.ic_lower_0;

                break;

            case 1:
                if (isUpper)
                    resource = R.drawable.ic_upper_1;
                else
                    resource = R.drawable.ic_lower_1;

                break;

            case 2:
                if (isUpper)
                    resource = R.drawable.ic_upper_2;
                else
                    resource = R.drawable.ic_lower_2;

                break;

            case 3:
                if (isUpper)
                    resource = R.drawable.ic_upper_3;
                else
                    resource = R.drawable.ic_lower_3;

                break;

            case 4:
                if (isUpper)
                    resource = R.drawable.ic_upper_4;
                else
                    resource = R.drawable.ic_lower_4;

                break;

            case 5:
                if (isUpper)
                    resource = R.drawable.ic_upper_5;
                else
                    resource = R.drawable.ic_lower_5;

                break;

            case 6:
                if (isUpper)
                    resource = R.drawable.ic_upper_6;
                else
                    resource = R.drawable.ic_lower_6;

                break;

            case 7:
                if (isUpper)
                    resource = R.drawable.ic_upper_7;
                else
                    resource = R.drawable.ic_lower_7;

                break;

            case 8:
                if (isUpper)
                    resource = R.drawable.ic_upper_8;
                else
                    resource = R.drawable.ic_lower_8;

                break;

            case 9:
                if (isUpper)
                    resource = R.drawable.ic_upper_9;
                else
                    resource = R.drawable.ic_lower_9;

                break;

        }



        image.setImageResource(resource);

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == anim1) {
            flip_frontup.setVisibility(View.INVISIBLE);
            startDigitAnimation(false);

        } else if (animation == anim2) {

            flip_frontup.setVisibility(View.VISIBLE);
            setDigitImage(getDigitToShow(), true, flip_frontup);
            setDigitImage(getDigitToShow(), false, flipI_backlow);
            incrementFromCode();
            animateDigit(false);
        }

    }

    @Override
    public void onAnimationRepeat(Animation arg0) {

    }

    @Override
    public void onAnimationStart(Animation animation) {

        if (animation == anim1) {

            flip_frontlow.setVisibility(View.INVISIBLE);
            flip_frontup.setVisibility(View.VISIBLE);

            setDigitImage(getDigitToShow(), false, flip_frontlow);
            setDigitImage(getDigitToShow(), true, flip_backup);

        } else if (animation == anim2) {
            flip_frontlow.setVisibility(View.VISIBLE);
        }

    }


}
