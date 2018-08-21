package com.seven.base_core.base;

/**
 * Created  on 2018/7/28.
 * author:seven
 * email:seven2016s@163.com
 * 管理切换module的URL
 */
public interface RouterURL {
    /*进入kotlin版本lurl*/
    String KOTLIN_MAIN = "/kotlin/kotlin_main";
    /*进入Java版本url*/
    String JAVA_MAIN = "/java/java_main";

    /*java版本获取application*/
    String MYAPP_CONTEXT = "/myapp/service";
}
