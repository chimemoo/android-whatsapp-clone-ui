package com.chimemoo.whatsappcloneui.decorator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chimemoo.whatsappcloneui.R;

public class SimpleDivider extends RecyclerView.ItemDecoration {
    private Drawable mDivider;

    public SimpleDivider(Context context){
        mDivider = context.getResources().getDrawable(R.drawable.divider_gray);
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int left = parent.getPaddingLeft()+200;
        int right = parent.getWidth() - parent.getPaddingRight() - 30;

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++){
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
}
