package com.karan.fliplayoutanimationexample.ui.custom;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

import com.karan.fliplayoutanimationexample.R;

import static android.os.Looper.getMainLooper;

public class FlipLayoutManager extends LinearLayoutManager {
    private Context mContext;
    private boolean isFlipping=false;
    private Handler flipHandler = new Handler(getMainLooper(), new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if(msg.obj!=null)
            {
                ((FlipView) msg.obj).flip();
            }
            else
            {
                isFlipping=false;
                if(onFlipListener!=null)onFlipListener.onFlipEnd();
            }


            return false;
        }
    });

    public FlipLayoutManager(Context context) {
        super(context);
        init(context);
    }

    public FlipLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        init(context);
    }

    public FlipLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
    }



    public void flip() {
        isFlipping=true;
        if(onFlipListener!=null){
            onFlipListener.onFlipStart();
        }
        int firstPosition = findFirstVisibleItemPosition();
        int lastPosition = findLastVisibleItemPosition();
        int flipAnimDuration = mContext.getResources().getInteger(R.integer.flip_animation_duration);
        int count=0;
        for (int i = firstPosition; i <= lastPosition; i++, count++) {
            FlipView flipView = (FlipView) findViewByPosition(i);
            Message flipMessage = new Message();
            flipMessage.obj = flipView;
            flipMessage.arg1= i == lastPosition ? 1 : 0;
            flipHandler.sendMessageDelayed(flipMessage, count * flipAnimDuration);
        }
        Message flipEndMessage = new Message();
        flipHandler.sendMessageDelayed(flipEndMessage,(count+1) * flipAnimDuration);

    }

    public boolean isFlipping()
    {
        return isFlipping;
    }
    private OnFlipListener onFlipListener;

    public OnFlipListener getOnFlipListener() {
        return onFlipListener;
    }

    public void setOnFlipListener(OnFlipListener onFlipListener) {
        this.onFlipListener = onFlipListener;
    }

    public  interface OnFlipListener {
       void onFlipStart();
       void onFlipEnd();
    }
}
