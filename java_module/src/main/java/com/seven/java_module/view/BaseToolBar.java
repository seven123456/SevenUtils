package com.seven.java_module.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.seven.base_core.utils.StatusBarUtil;
import com.seven.java_module.R;


/**
 * Created  on 2018/7/27 0027.
 * author:seven
 * email:seven2016s@163.com
 * 本控件处理有以下几种情况
 * 1.左边icon 提供了设置本地资源 网络图片的方法以及是否要显示，默认显示  lefticon
 * 2.中间title 提供了设置中间title的颜色设置、内容设置                  centreTitle
 * 3.最右边title 提供的最右边title的内容设置，以及内容的颜色              rightTitle
 * 4.最右边title 左边的icon , 提供了设置本地资源 网络资源的方法(通过type来控制)以及是否显示  rightIcon1
 * 5.最右边的iocn 提供了设置最右边icon的src方法(包括本地资源和网络资源，通过type控制) rightIcon2
 * 6.最右边icon 左边的icon ，提供了设置最右边icon的src方法(包括本地资源和网络资源，通过type控制) rightIcon3
 * 7.可在xml中设置对应的属性 也可以在Java代码中调用对应的方法设置(方法不够可以自己添加),支持链式调用
 * 8.所有控件的点击事件监听,我再这里把所有的onclick方法都写在一个接口里面，具体实现会把所有方法都实现，如果想兼容项目中所有的样式，
 * 点击方法可以自己剥离出来处理
 */
public class BaseToolBar extends RelativeLayout implements View.OnClickListener {

    private ImageView iconLeft, rightIcon1, rightIcon2, rightIcon3;
    private TextView centreTitle, rightTitle;
    public static int TYPE_ONE = 1;//最右边icon
    public static int TYPE_TWO = 2;//最右边左边iocn
    public static int TYPE_THR = 3;//最右边title边上icon
    public int rightype = 0;

    public BaseToolBar(Context context) {
        super(context);
    }

    public BaseToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BaseToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.view_base_tool_bar, this, true);
        iconLeft = findViewById(R.id.icon_left);
        rightIcon1 = findViewById(R.id.icon_right1);
        rightIcon2 = findViewById(R.id.icon_right2);
        rightIcon3 = findViewById(R.id.icon_right3);
        centreTitle = findViewById(R.id.tv_title);
        rightTitle = findViewById(R.id.tv_right);
        View viewSpace = findViewById(R.id.view_space);
        StatusBarUtil.setTranslate((AppCompatActivity) context, false);
        StatusBarUtil.setFadeStatusBarHeight(context, viewSpace);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BaseToolBar);
        if (typedArray != null) {
            boolean isHowleft = typedArray.getBoolean(R.styleable.BaseToolBar_left_icon, true);
            if (!isHowleft) {
                iconLeft.setVisibility(GONE);
            }
            Drawable leftDrawable = typedArray.getDrawable(R.styleable.BaseToolBar_left_icon);//左边icon
            Drawable right1 = typedArray.getDrawable(R.styleable.BaseToolBar_right_icon1);//最右边icon
            Drawable right2 = typedArray.getDrawable(R.styleable.BaseToolBar_right_icon2);//右边第二个icon
            Drawable right3 = typedArray.getDrawable(R.styleable.BaseToolBar_right_icon3);//右边title边上的icon
            String tvTitle = typedArray.getString(R.styleable.BaseToolBar_centre_title);//中间的title
            String righttitle = typedArray.getString(R.styleable.BaseToolBar_right_title);//最右边的title
            int rightType = typedArray.getInt(R.styleable.BaseToolBar_right_type, 0);//默认右边全部不显示
            iconLeft.setImageDrawable(leftDrawable);
            centreTitle.setText(tvTitle);
            switch (rightType) {
                /*<!--显示右边title-->*/
                case 1:
                    rightIcon1.setVisibility(GONE);
                    rightIcon2.setVisibility(GONE);
                    rightIcon3.setVisibility(GONE);
                    rightTitle.setVisibility(VISIBLE);
                    rightTitle.setText(righttitle);
                    break;
                /*<!--显示右边单个icon-->*/
                case 2:
                    rightIcon1.setVisibility(VISIBLE);
                    rightIcon2.setVisibility(GONE);
                    rightIcon3.setVisibility(GONE);
                    rightTitle.setVisibility(GONE);
                    rightIcon1.setImageDrawable(right1);
                    break;
                /*  <!--显示右边所有icon-->*/
                case 3:
                    rightIcon1.setVisibility(VISIBLE);
                    rightIcon2.setVisibility(VISIBLE);
                    rightIcon3.setVisibility(GONE);
                    rightTitle.setVisibility(GONE);
                    rightIcon1.setImageDrawable(right1);
                    rightIcon2.setImageDrawable(right2);
                    break;
                /*  <!--显示右边title和icon-->*/
                case 4:
                    rightIcon1.setVisibility(GONE);
                    rightIcon2.setVisibility(GONE);
                    rightIcon3.setVisibility(VISIBLE);
                    rightTitle.setVisibility(VISIBLE);
                    rightIcon3.setImageDrawable(right3);
                    rightTitle.setText(righttitle);
                    break;
                /*默认什么都不显示*/
                case 0:
                default:
                    rightIcon1.setVisibility(GONE);
                    rightIcon2.setVisibility(GONE);
                    rightIcon3.setVisibility(GONE);
                    rightTitle.setVisibility(GONE);
                    break;
            }
            typedArray.recycle();
        }
        setListener();
    }

    private void setListener() {
        iconLeft.setOnClickListener(this);
        rightTitle.setOnClickListener(this);
        rightIcon1.setOnClickListener(this);
        rightIcon2.setOnClickListener(this);
        rightIcon3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.icon_left) {
            if (baseToolBaseOnClickListener != null) {
                baseToolBaseOnClickListener.leftOnClick();
            }

        } else if (i == R.id.tv_right) {
            if (baseToolBaseOnClickListener != null) {
                baseToolBaseOnClickListener.rightTitleOnClick();
            }

        } else if (i == R.id.icon_right1) {
            if (baseToolBaseOnClickListener != null) {
                baseToolBaseOnClickListener.rightIcon1OnClick();
            }

        } else if (i == R.id.icon_right2) {
            if (baseToolBaseOnClickListener != null) {
                baseToolBaseOnClickListener.rightIcon2OnClick();
            }

        } else if (i == R.id.icon_right3) {
            if (baseToolBaseOnClickListener != null) {
                baseToolBaseOnClickListener.rightIcon3OnClick();
            }

        }
    }

    /*右边可能是网络图片，所以要做兼容
     * 如果项目中toolbar上面都没有用到网络图片，就不用多写一个方法
     * 以下所有同理
     * */
    public BaseToolBar setLeftIconDrawable(Drawable resid) {
        iconLeft.setImageDrawable(resid);
        return this;
    }

    /*加载网络图片，方法自己用glide写*/
    public BaseToolBar setLeftIconUrl(String url) {
//        iconLeft.setImageDrawable(resid);
        return this;
    }

    /*加载右边icon 本地资源*/
    public BaseToolBar setRightIconDrawable(Drawable resid, int type) {
        if (type == TYPE_ONE) {
            rightIcon1.setImageDrawable(resid);
        } else if (type == TYPE_TWO) {
            rightIcon2.setImageDrawable(resid);
        } else if (type == TYPE_THR) {
            rightIcon3.setImageDrawable(resid);
        }
        return this;
    }

    /*加载右边网络图片*/
    public BaseToolBar setRightIconUrl(Drawable resid, int type) {
        if (type == TYPE_ONE) {
//            rightIcon1.setImageDrawable(resid);
        } else if (type == TYPE_TWO) {
//            rightIcon2.setImageDrawable(resid);
        } else if (type == TYPE_THR) {
//            rightIcon3.setImageDrawable(resid);
        }
        return this;
    }

    /*设置中间title的颜色*/
    public BaseToolBar setCentreTitleColor(int resid) {
        centreTitle.setTextColor(resid);
        return this;
    }

    /*设置最右边title的颜色*/
    public BaseToolBar setRightTitleColor(int resid) {
        rightTitle.setTextColor(resid);
        return this;
    }

    private onBaseToolBaseOnClickListener baseToolBaseOnClickListener;

    public void setBaseToolBaseOnClickListener(onBaseToolBaseOnClickListener onClickListener) {
        this.baseToolBaseOnClickListener = onClickListener;
    }

    public interface onBaseToolBaseOnClickListener {
        void leftOnClick();

        void rightTitleOnClick();

        void rightIcon1OnClick();

        void rightIcon2OnClick();

        void rightIcon3OnClick();

    }

}
