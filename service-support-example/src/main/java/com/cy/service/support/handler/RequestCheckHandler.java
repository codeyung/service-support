package com.cy.service.support.handler;


import com.cy.service.support.core.IHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 13:56
 */
@Service
public class RequestCheckHandler implements IHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(RequestCheckHandler.class);

    @Override
    public void execute() {
        LOGGER.info("RequestCheckHandler-execute");

    }
}
