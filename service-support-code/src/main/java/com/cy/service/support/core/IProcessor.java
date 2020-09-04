package com.cy.service.support.core;

/**
 * @Description:处理器
 * @Author: YongJingChuan
 * @Date: 2020/8/22 13:56
 */
public interface IProcessor<T> {

    /**
     * 处理器配置
     *
     * @return
     */
    void configurate();

    /**
     * 处理器执行
     *
     * @return
     */
    void process();

}
