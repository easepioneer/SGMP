package org.sgmp.webapp.service.module;

import org.sgmp.webapp.dao.module.MonitorInteractionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Nick
 *
 */
@Service
public class MonitorInteractionServiceImpl implements MonitorInteractionService {

    @Autowired
    private MonitorInteractionDao monitorInteractionDao;

}
