package org.sgmp.webapp.service.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import org.sgmp.webapp.mapper.module.TgMeterDataQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * 
 * @author Nick
 *
 */
@ContextConfiguration("classpath*:conf/sgmp/webapp/spring/applicationContext-*.xml")
public class SimpleQueryServiceTester extends AbstractJUnit4SpringContextTests {

    @Autowired
    private SimpleQueryService simpleQueryService;

    @Test
    @SuppressWarnings("unchecked")
    public void testGetList() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("startDate", "2012-12-01");
        params.put("endDate", "2012-12-12");
        List<Map<String, Object>> results = (List<Map<String, Object>>) simpleQueryService.getList(TgMeterDataQueryMapper.class, params, "0", "20", null, null);
        for(Map<String, Object> map : results) {
            logger.info(map.toString());
            System.out.println(map.toString());
        }
    }

    @Test
    public void testGetCount() throws Exception {
        Map<String, Object> params = null;
        params = ObjectUtils.defaultIfNull(params, new HashMap<String, Object>());
        params.put("startDate", "2012-12-01");
        params.put("endDate", "2012-12-12");
        Integer i = simpleQueryService.getCount(TgMeterDataQueryMapper.class, params);
        logger.info(String.valueOf(i));
        System.out.println(String.valueOf(i));
    }

}
