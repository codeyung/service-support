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
public class TokenCheckHandler implements IHandler {


    private final static Logger LOGGER = LoggerFactory.getLogger(TokenCheckHandler.class);

    @Override
    public void execute() {
        LOGGER.info("TokenCheckHandler-execute");
    }
}
