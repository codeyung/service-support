package com.cy.service.support;

import com.cy.service.support.holder.ContextHolder;
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
    public void test() {
        Assert.assertNotNull("ContextHolder is null", contextHolder);
        contextHolder.bindRequest("test");
        LOGGER.info("request:{}", contextHolder.getRequest());
    }

}
