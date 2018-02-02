package com.obe.filesexplorer.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;

import com.obe.filesexplorer.utils.LogFile;

/**
 * Created by ken on 2018/2/2.
 */

public class VerticalSmoothGridView extends GridView{
    private final static String TAG = "VerticalSmoothGridView";

    public VerticalSmoothGridView(Context context) {
        super(context);
    }

    public VerticalSmoothGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalSmoothGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            View view = getChildAt(0);
            int numColumns  = 5;

            if(null != view){
                int count = getAdapter().getCount() -1;
                int selectedPos = getSelectedItemPosition();
                int firstVisiblePos = getFirstVisiblePosition();
                int lastVisiblePos = getLastVisiblePosition();
                if(keyCode == KeyEvent.KEYCODE_DPAD_DOWN){
                    if(count >= 0){
                        if(firstVisiblePos/numColumns < count/numColumns){
                            LogFile.LOGD(TAG,"firstVisiblePos="+firstVisiblePos+",lastVisiblePos="+lastVisiblePos);
                            if(selectedPos/numColumns == firstVisiblePos/numColumns){
                                if(selectedPos + numColumns <= lastVisiblePos){
                                    setSelection(selectedPos + numColumns);
                                }else{
                                    setSelection(lastVisiblePos);
                                }
                            }else if(selectedPos/numColumns == lastVisiblePos/numColumns
                                    && lastVisiblePos/numColumns < count/numColumns ){
                                int distance = getSelectedView().getHeight()+getVerticalSpacing();
                                LogFile.LOGD(TAG,"=========== distance "+distance);
                                smoothScrollBy(distance, 400);
                                if(selectedPos/numColumns < count/numColumns){
                                    int curPos = selectedPos + numColumns;
                                    for(;curPos ==count; curPos--){
                                        LogFile.LOGD(TAG,"=========== curPos "+curPos);
                                        postDelayed(new SetAction(curPos),400L);
                                    }
                                }
                            }
                        }
                    }
                }else if(keyCode == KeyEvent.KEYCODE_DPAD_UP){
                    if(selectedPos >= numColumns){
                        if(firstVisiblePos/numColumns < lastVisiblePos/numColumns){
                            if(selectedPos/numColumns == firstVisiblePos/numColumns){
                                if(selectedPos/numColumns > 0){
                                    LogFile.LOGD(TAG,"===========KEYCODE_DPAD_UP selectedPos "+selectedPos);
                                    smoothScrollBy(-(getSelectedView().getHeight()+getVerticalSpacing()), 400);
                                    postDelayed(new SetAction(selectedPos-5),400L);
                                }
                            }else if(selectedPos/numColumns == lastVisiblePos/numColumns){
                                LogFile.LOGD(TAG,"===========KEYCODE_DPAD_UP selectedPos - numColumns "+(selectedPos - numColumns));
                                setSelection(selectedPos - numColumns);
                            }
                        }
                    }
                }
            }
        }
        return super.dispatchKeyEvent(event);
    }

    private class SetAction implements Runnable{
        private int mPosition;
        public  SetAction(int pos){
            mPosition = pos;
        }

        @Override
        public void run() {
            setSelection(mPosition);
        }
    }
}
