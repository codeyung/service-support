package com.cy.service.support.core;

/**
 * @Description:执行体
 * @Author: YongJingChuan
 * @Date: 2020/9/5 13:56
 */
public interface IHandler {

    /**
     * 业务开关是否执行
     *
     * @return
     */
    default boolean executeFlag() {
        return true;
    }

    /**
     * 模型处理方法
     *
     * @return
     */
    void execute();

}
