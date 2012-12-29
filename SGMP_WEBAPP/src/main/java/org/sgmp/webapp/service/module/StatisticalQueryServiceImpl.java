package org.sgmp.webapp.service.module;

import org.sgmp.webapp.dao.module.StatisticalQueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Nick
 *
 */
@Service
public class StatisticalQueryServiceImpl implements StatisticalQueryService {

    @Autowired
    private StatisticalQueryDao statisticalQueryDao;

}
