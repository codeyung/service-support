package com.cy.service.support.processor;

import com.cy.service.support.core.BaseProcessor;
import com.cy.service.support.core.IHandler;
import com.cy.service.support.handler.RequestCheckHandler;
import com.cy.service.support.handler.TokenCheckHandler;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/9/4 18:06
 */
@Service
public class RequestCheckProcessor extends BaseProcessor {


    public RequestCheckProcessor(TokenCheckHandler tokenCheckHandler, RequestCheckHandler requestCheckHandler) {
        this.setProcessor(this);
        this.setSuccessor(null);
        this.append(tokenCheckHandler);
        this.append(requestCheckHandler);
    }

    @Override
    public void configurate() {

    }

    @Override
    public void process() {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            IHandler handler = (IHandler) iterator.next();
            if (handler.executeFlag()) {
                handler.execute();
            }
        }
        this.processSuccessor();
    }
}
