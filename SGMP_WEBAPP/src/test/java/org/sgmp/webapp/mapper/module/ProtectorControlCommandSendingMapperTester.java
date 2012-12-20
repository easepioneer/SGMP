package org.sgmp.webapp.mapper.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath*:conf/sgmp/webapp/spring/applicationContext-*.xml")
public class ProtectorControlCommandSendingMapperTester extends AbstractJUnit4SpringContextTests {

    @Autowired
    private ProtectorControlCommandSendingMapper protectorControlCommandSendingMapper;

    @Before
    public void init() {
        PropertyConfigurator.configure("E:\\Zhangyu\\Repositories\\Git\\SGMP\\SGMP_WEBAPP\\webapp\\WEB-INF\\classes\\conf\\sgmp\\webapp\\log\\log4j.properties");
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testGetInteractionObjectList() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        List<Map<String, Object>> results = (List<Map<String, Object>>) protectorControlCommandSendingMapper.getInteractionObjectList(params);
        for(Map<String, Object> result : results) {
            logger.info(result.toString());
        }
    }

    @Test
    public void testGetInteractionObjectCount() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        Integer i = protectorControlCommandSendingMapper.getInteractionObjectCount(params);
        logger.info(String.valueOf(i));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testGetInteractionObject() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> result = (Map<String, Object>) protectorControlCommandSendingMapper.getInteractionObjectList(params);
        logger.info(result.toString());
    }

}
