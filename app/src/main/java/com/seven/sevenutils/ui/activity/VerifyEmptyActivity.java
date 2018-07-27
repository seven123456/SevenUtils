package com.seven.sevenutils.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.seven.sevenutils.R;
import com.seven.sevenutils.base.BaseActivity;
import com.seven.sevenutils.ui.info.VerifyInfo;
import com.seven.sevenutils.utils.AppManager;
import com.seven.sevenutils.utils.RegularUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  on 2018/7/26 0026.
 * author:seven
 * email:seven2016s@163.com
 */
public class VerifyEmptyActivity extends BaseActivity {

    private EditText phoneEd, passwordEd;
    private TextView loginBtn;
    private List<VerifyInfo> verifyInfoList;

    @Override
    public int getContentViewResId() {
        return R.layout.activity_verfiy_empty;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        phoneEd = findViewById(R.id.ed_username);
        passwordEd = findViewById(R.id.ed_password);
        loginBtn = findViewById(R.id.tv_login);
    }

    @Override
    public void initData() {

    }

    @Override
    public void widgetClick(View v) {
        if (v.getId() == R.id.tv_login) {
            RegularUtils.getmInstance();
            String phone = phoneEd.getText().toString().trim();
            String password = passwordEd.getText().toString().trim();
            verifyInfoList = new ArrayList<>();
            VerifyInfo verifyInfo1 = new VerifyInfo(phone, "手机号不能为空！", RegularUtils.verifyPhone(phone), "手机号格式不正确！");
            VerifyInfo verifyInfo2 = new VerifyInfo(password, "密码不能为空！", RegularUtils.verifyPassword(password), "密码格式不正确！");
            verifyInfoList.add(verifyInfo1);
            verifyInfoList.add(verifyInfo2);
            if (checkStringIsNull(verifyInfoList)) {
                Toast.makeText(mActivity, "注册成功", Toast.LENGTH_SHORT).show();
                AppManager.getAppManager().finishActivity(mActivity);
            }

        }
    }

    @Override
    public void initListener() {
        loginBtn.setOnClickListener(this);
    }

    /**
     * 检查字符是否为 null || ""
     * 如果是 null 或者 "" 则返回false ,反则为 true 并且提示
     * 检查正则验证是否通过 通过为true 反则为false 并且提示
     *
     * @param verifyInfoList 需要验证的信息
     * @return
     */
    public boolean checkStringIsNull(final List<VerifyInfo> verifyInfoList) {
        int count = 0;
        for (int i = 0; i < verifyInfoList.size(); i++) {
            //遍历字符数组所有的参数，发现某个为 null 或者 "" ,则跳出
            if (TextUtils.isEmpty(verifyInfoList.get(i).getMsg())) {
                Toast.makeText(mActivity, verifyInfoList.get(i).getMsgTip(), Toast.LENGTH_SHORT).show();
                return false;
            } else {
                if (!verifyInfoList.get(i).isSuccess()) {
                    Toast.makeText(mActivity, verifyInfoList.get(i).getIsFailTip(), Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
            count++;
        }
        if (count == verifyInfoList.size()) {
            return true;
        }
        return false;
    }
}
