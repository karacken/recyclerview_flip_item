package com.karan.fliplayoutanimationexample.ui.custom;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.karan.fliplayoutanimationexample.R;

public class FlipView extends FrameLayout {
    public FlipView( Context context) {
        super(context);
        init(null);
    }

    public FlipView( Context context,  AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public FlipView( Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }
    private boolean isFlipped=false;
    private View frontView;
    private View backView;
    private Animator enterFlipAnim;
    private Animator exitFlipAnim;
    private void init(AttributeSet attrs) {

        loadAnimation();

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        if(getChildCount()!=2)
            throw new RuntimeException("FlipView should contain two children.");

        backView = getChildAt(0);
        frontView = getChildAt(1);
        setActiveView();
        changeCameraDistance();
    }


    private void changeCameraDistance() {
        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
        frontView.setCameraDistance(scale);
        backView.setCameraDistance(scale);
    }

    private void loadAnimation() {
        enterFlipAnim = AnimatorInflater.loadAnimator(getContext(),R.animator.flip_enter_animator);
        exitFlipAnim = AnimatorInflater.loadAnimator(getContext(),R.animator.flip_exit_animator);
    }

    public void flip()
    {
        if(enterFlipAnim.isRunning() || exitFlipAnim.isRunning())
        {
            //Ignore when animation is running
            return;
        }

        if(isFlipped)
        {
            isFlipped=false;
            enterFlipAnim.setTarget(frontView);
            exitFlipAnim.setTarget(backView);
            enterFlipAnim.start();
            exitFlipAnim.start();

        }
        else
        {
            isFlipped=true;
            enterFlipAnim.setTarget(backView);
            exitFlipAnim.setTarget(frontView);
            enterFlipAnim.start();
            exitFlipAnim.start();

        }

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
        setActiveView();
    }

    private void setActiveView() {
        if(frontView==null || backView==null)return;
        frontView.setRotationY(0);
        backView.setRotationY(0);
        frontView.setAlpha(isFlipped ? 0 : 1);
        backView.setAlpha(isFlipped ? 1 : 0);
    }

    public View getFrontView() {
        return frontView;
    }

    public View getBackView() {
        return backView;
    }
}
