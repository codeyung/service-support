package com.cy.service.support.handler;


import com.cy.service.support.core.IHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/9/5 13:56
 */
@Service
public class OrderQueryHandler implements IHandler {


    private final static Logger LOGGER = LoggerFactory.getLogger(OrderQueryHandler.class);

    @Override
    public void execute() {
        LOGGER.info("OrderQueryHandler-execute");
    }
}
