package com.cy.service.support.beta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 13:56
 */
@Service
public class Processor2 extends BaseProcessor<IHandler> {

    @Autowired
    public Processor2(IHandler handler3, IHandler handler4) {
        this.setProcessor(this);
        this.setSuccessor(null);
        this.append(handler4);
        this.append(handler3);
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