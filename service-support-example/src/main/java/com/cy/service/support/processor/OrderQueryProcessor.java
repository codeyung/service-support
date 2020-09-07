package com.cy.service.support.processor;

import com.cy.service.support.core.BaseProcessor;
import com.cy.service.support.core.IHandler;
import com.cy.service.support.handler.OrderQueryHandler;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/9/5 18:06
 */
@Service
public class OrderQueryProcessor extends BaseProcessor {


    public OrderQueryProcessor(OrderQueryHandler orderQueryHandler) {
        this.setProcessor(this);
        this.setSuccessor(null);
        this.append(orderQueryHandler);
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
