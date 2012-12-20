package org.sgmp.webapp.mapper.module;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.sgmp.webapp.pojo.module.Orgnization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath*:conf/sgmp/webapp/spring/applicationContext-*.xml")
public class OrgnizationManagementMapperTester extends AbstractJUnit4SpringContextTests {

    @Autowired
    private OrgnizationManagementMapper<Orgnization> orgnizationManagementMapper;

    @Before
    public void init() {
        PropertyConfigurator.configure("E:\\Zhangyu\\Repositories\\Git\\SGMP\\SGMP_WEBAPP\\webapp\\WEB-INF\\classes\\conf\\sgmp\\webapp\\log\\log4j.properties");
    }

    @Test
    public void testCreate() throws Exception {
        Orgnization o = new Orgnization();
        o.setOrgNo("HD0101");
        o.setOrgName("测试Test");
        o.setOrgType("03");
        o.setParentId(2L);
        o.setSortNo(1);
        o.setLastTimestamp(new Date());
        orgnizationManagementMapper.create(o);
    }

    @Test
    public void testUpdate() throws Exception {
        Orgnization o = orgnizationManagementMapper.getById(7L);
        o.setOrgName("测试Test2");
        orgnizationManagementMapper.update(o);
    }

    @Test
    public void testDelete() throws Exception {
        Orgnization o = orgnizationManagementMapper.getById(7L);
        orgnizationManagementMapper.delete(o);
    }

    @Test
    public void testGetById() throws Exception {
        Long id = 1L;
        Orgnization o = orgnizationManagementMapper.getById(id);
        logger.info(o.toString());
    }

    @Test
    public void testGetList() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        List<Orgnization> list = orgnizationManagementMapper.getList(params);
        logger.info(list.toString());
    }

    @Test
    public void testGetCount() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        Integer cnt = orgnizationManagementMapper.getCount(params);
        logger.info(cnt);
    }

}
