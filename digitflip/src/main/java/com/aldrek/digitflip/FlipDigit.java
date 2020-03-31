package com.aldrek.digitflip;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;


public class FlipDigit extends RelativeLayout {

    private int color;
    private Context context;
    private View FlipItem = null;

    private boolean isFastFlip;
    private int mCurrentDigit;

    private Flip flip = null;

    public FlipDigit(Context context) {
        super(context);
        this.context = context;
        initialize();
    }

    @SuppressLint("ResourceAsColor")
    public FlipDigit(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FlipDigit);
        final int num = typedArray.getIndexCount();

        try {

            isFastFlip = typedArray.getBoolean(R.styleable.FlipDigit_isFastFlip, false);

            // Set tint
            for (int i = 0; i < num; i++) {
                int attr = typedArray.getIndex(i);

                if (attr == R.styleable.FlipDigit_tintColor)
                    color = typedArray.getColor(attr, 1);
            }

        }
        // the recycle() will be executed obligatorily
        finally {
            // for reuse
            typedArray.recycle();
        }

        initialize();
    }

    public FlipDigit(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;

    }

    private void inflateLayout() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        FlipItem = layoutInflater.inflate(R.layout.view_flipmeter_spinner, this);

    }

    public View getFlipItem() {
        return FlipItem;
    }

    public void setDigit(int animateTo, boolean withAnimation) {
        flip.setDigit(animateTo, withAnimation);
    }


    private void initialize() {
        inflateLayout();
        Log.d("Item", "initialize: " + isFastFlip);
        flip = new Flip(context, getId(), FlipItem, null, isFastFlip , color);

    }

    public int getCurrentDigit() {
        return mCurrentDigit;
    }

    public void setFastFlip(boolean isFastFlip) {
        flip.setFastFlip(isFastFlip);
    }


}
