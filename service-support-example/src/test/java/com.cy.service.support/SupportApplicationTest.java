package com.cy.service.support;

import com.cy.service.support.holder.ContextHolder;
import com.cy.service.support.processor.RequestCheckProcessor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/20 14:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SupportApplication.class})
public class SupportApplicationTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(SupportApplicationTest.class);

    @Autowired
    private ContextHolder contextHolder;

    @Test
    public void contextHolder() {
        Assert.assertNotNull("ContextHolder is null", contextHolder);
        contextHolder.bindRequest("test");
        LOGGER.info("request:{}", contextHolder.getRequest());
    }


    @Autowired
    private RequestCheckProcessor requestCheckProcessor;

    @Test
    public void processor() {
        Assert.assertNotNull("RequestCheckProcessor is null", requestCheckProcessor);

        try {
            //step 1 bind request
            contextHolder.bindRequest("request");

            //step 2 set contextHolder.bindResponse sucess before the end 
            requestCheckProcessor.getProcessor().process();
            contextHolder.bindResponse("response");

            //step 3 return response
            LOGGER.info("response :{}", contextHolder.getResponse());
            
        } catch (Exception e) {
            Result result = new Result(e, ErrorCode.FAIL);
            LOGGER.info("response :{}", result);
        } finally {
            //step 4 ThreadLocal contextHolder clear
            contextHolder.clear();
        }
    }


}
