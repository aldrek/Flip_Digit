package com.aldrek.digitflip;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;



public class FlipWidget extends LinearLayout {

	private static int NO = 6;
	private int color;

	private boolean isFastFlip;

	private int currentVal;
	private int animCompleteCount = 0;

	private List<FlipDigit> spinners = new ArrayList<>();

	public FlipWidget(Context context) {
		super(context);

		initialize();
	}

	public FlipWidget(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FlipWidget);

		try {

			isFastFlip = typedArray.getBoolean(R.styleable.FlipWidget_isFastFlipMain, false);
			NO = typedArray.getInt(R.styleable.FlipWidget_numberOfDigits, 1);
			color = typedArray.getColor(R.styleable.FlipWidget_digitColor, 1);

		}
		// the recycle() will be executed obligatorily
		finally {
			// for reuse
			typedArray.recycle();
		}

		initialize();


	}

	public FlipWidget(Context context, AttributeSet attrs , int defStyle) {
		super(context, attrs , defStyle);
		initialize();

	}

	private void initialize() {
//		spinners = new FlipItem[NO];

		String infService = Context.LAYOUT_INFLATER_SERVICE;
		LayoutInflater li;
		li = (LayoutInflater) getContext().getSystemService(infService);
		li.inflate(R.layout.widget_flip, this, true);

		spinners.add((FlipDigit) findViewById(R.id.widget_flip_item_1));
		spinners.add((FlipDigit) findViewById(R.id.widget_flip_item_2));
		spinners.add((FlipDigit) findViewById(R.id.widget_flip_item_3));
		spinners.add((FlipDigit) findViewById(R.id.widget_flip_item_4));
		spinners.add((FlipDigit) findViewById(R.id.widget_flip_item_5));
		spinners.add((FlipDigit) findViewById(R.id.widget_flip_item_6));

		spinners.get(0).setVisibility(GONE);
		spinners.get(1).setVisibility(GONE);
		spinners.get(2).setVisibility(GONE);
		spinners.get(3).setVisibility(GONE);
		spinners.get(4).setVisibility(GONE);
		spinners.get(5).setVisibility(GONE);

		for (int i = 0; i < NO; i++) {
			spinners.get(i).setVisibility(VISIBLE);
		}

		spinners.get(0).setFastFlip(isFastFlip);
		spinners.get(1).setFastFlip(isFastFlip);
		spinners.get(2).setFastFlip(isFastFlip);
		spinners.get(3).setFastFlip(isFastFlip);
		spinners.get(4).setFastFlip(isFastFlip);
		spinners.get(5).setFastFlip(isFastFlip);

		if(color == 0) return;

		spinners.get(0).setColor(color);
		spinners.get(1).setColor(color);
		spinners.get(2).setColor(color);
		spinners.get(3).setColor(color);
		spinners.get(4).setColor(color);
		spinners.get(5).setColor(color);


	}

	public void setValue(int value, boolean withAnimation) {

		currentVal = value;
		int tempValue = value;

		for (int i=NO-1; i>0; --i) {

			int factor = (int) Math.pow(10, i);

			int digitVal = (int) Math.floor(tempValue / factor);
			tempValue -= (digitVal * factor);
			spinners.get(i).setDigit(digitVal , withAnimation);
			changeanimCompleteCount(withAnimation);

		}

		spinners.get(0).setDigit(tempValue, withAnimation);
		changeanimCompleteCount(withAnimation);

	}

	private synchronized int changeanimCompleteCount(Boolean increment) {
		if (increment == null)
			return animCompleteCount;
		else if (increment)
			return ++animCompleteCount;
		else
			return --animCompleteCount;
	}

	/**
	 * @return
	 */
	public int getValue() {
		return currentVal;
	}

	public interface OnValueChangeListener {
		abstract void onValueChange(FlipWidget sender, int newValue);
	}

}
