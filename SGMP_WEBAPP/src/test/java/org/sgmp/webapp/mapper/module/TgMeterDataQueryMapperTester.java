package org.sgmp.webapp.mapper.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath*:conf/sgmp/webapp/spring/applicationContext-*.xml")
public class TgMeterDataQueryMapperTester extends AbstractJUnit4SpringContextTests {

    @Autowired
    private TgMeterDataQueryMapper tgMeterDataQueryMapper;

    @Before
    public void init() {
        PropertyConfigurator.configure("E:\\Zhangyu\\Repositories\\Git\\SGMP\\SGMP_WEBAPP\\webapp\\WEB-INF\\classes\\conf\\sgmp\\webapp\\log\\log4j.properties");
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testGetList() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("startDate", "2012-12-01");
        params.put("endDate", "2012-12-12");
        params.put("_start", 0);
        params.put("_end", 3);
        List<Map<String, Object>> results = (List<Map<String, Object>>) tgMeterDataQueryMapper.getList(params);
        for(Map<String, Object> map : results) {
            logger.info(map.toString());
        }
    }

    @Test
    public void testGetCount() throws Exception {
        Map<String, Object> params = null;
        params = ObjectUtils.defaultIfNull(params, new HashMap<String, Object>());
        params.put("startDate", "2012-12-01");
        params.put("endDate", "2012-12-12");
        Integer i = tgMeterDataQueryMapper.getCount(params);
        logger.info(String.valueOf(i));
    }

}
