package org.sgmp.webapp.mapper.module;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.sgmp.webapp.pojo.module.Tg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath*:conf/sgmp/webapp/spring/applicationContext-*.xml")
public class TgMapperTester extends AbstractJUnit4SpringContextTests {

    @Autowired
    private TgMapper tgMapper;

    @Before
    public void init() {
        PropertyConfigurator.configure("E:\\Zhangyu\\Repositories\\Git\\SGMP\\SGMP_WEBAPP\\webapp\\WEB-INF\\classes\\conf\\sgmp\\webapp\\log\\log4j.properties");
    }

    @Test
    public void testCreate() throws Exception {
        Tg tg = new Tg();
        tg.setOrgId(7L);
        tg.setTgNo("TG001");
        tg.setTgName("测试台区001");
        tg.setTgCap(100.00F);
        tg.setInstAddr("葛岭供电所");
        tg.setChgDate(new Date());
        tg.setPubPrivFlag("0");
        tg.setRunStatus("1");
        tg.setLastTimestamp(new Date());
        tgMapper.create(tg);
    }

    @Test
    public void testUpdate() throws Exception {
        Tg tg = tgMapper.getById(7L);
        tg.setTgName("测试台区001_update");
        tgMapper.update(tg);
    }

    @Test
    public void testDelete() throws Exception {
        Tg tg = tgMapper.getById(8L);
        tgMapper.delete(tg);
    }

    @Test
    public void testGetById() throws Exception {
        Long id = 2L;
        Tg tg = tgMapper.getById(id);
        logger.info(tg.toString());
    }

    @Test
    public void testGetList() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        List<Tg> list = tgMapper.getList(params);
        logger.info(list.toString());
    }

    @Test
    public void testGetCount() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        Integer cnt = tgMapper.getCount(params);
        logger.info(cnt);
    }

}
