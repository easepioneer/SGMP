package org.sgmp.webapp.dao.module;

import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.sgmp.webapp.mapper.module.OrgnizationMapper;
import org.sgmp.webapp.mapper.module.TgMapper;
import org.sgmp.webapp.pojo.module.Orgnization;
import org.sgmp.webapp.pojo.module.Tg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath*:conf/sgmp/webapp/spring/applicationContext-*.xml")
public class SimpleCURDDaoTester extends AbstractJUnit4SpringContextTests {

    @Autowired
    private SimpleCURDDao<Orgnization> simpleCURDDaoOrgnization;

    @Autowired
    private SimpleCURDDao<Tg> simpleCURDDaoTg;

    @Before
    public void init() {
        PropertyConfigurator.configure("E:\\Zhangyu\\Repositories\\Git\\SGMP\\SGMP_WEBAPP\\webapp\\WEB-INF\\classes\\conf\\sgmp\\webapp\\log\\log4j.properties");
    }

    @Test
    public void testCreateOrgnization() throws Exception {
        Orgnization o = new Orgnization();
        o.setOrgNo("HD0102");
        o.setOrgName("测试Test");
        o.setOrgType("03");
        o.setParentId(2L);
        o.setSortNo(1);
        o.setLastTimestamp(new Date());
        simpleCURDDaoOrgnization.create(OrgnizationMapper.class, o);
    }

    @Test
    public void testCreateTg() throws Exception {
        Tg tg = new Tg();
        tg.setOrgId(22L);
        tg.setTgNo("TG003");
        tg.setTgName("测试台区003");
        tg.setTgCap(null);
        tg.setInstAddr("测试台区3");
        tg.setChgDate(new Date());
        tg.setPubPrivFlag("0");
        tg.setRunStatus("1");
        tg.setLastTimestamp(new Date());
        simpleCURDDaoTg.create(TgMapper.class, tg);
    }

    @Test
    public void testUpdateOrgnization() throws Exception {
        Orgnization o = simpleCURDDaoOrgnization.getById(OrgnizationMapper.class, 23L);
        logger.info(o.toString());
        o.setOrgName("测试Test3");
        simpleCURDDaoOrgnization.update(OrgnizationMapper.class, o);
    }

}
