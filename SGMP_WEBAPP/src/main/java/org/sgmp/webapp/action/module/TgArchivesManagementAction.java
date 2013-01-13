package org.sgmp.webapp.action.module;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.sgmp.webapp.ActionException;
import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.mapper.module.MeterInfoQueryMapper;
import org.sgmp.webapp.mapper.module.ProtectorInfoQueryMapper;
import org.sgmp.webapp.mapper.module.TerminalMapper;
import org.sgmp.webapp.mapper.module.TgMapper;
import org.sgmp.webapp.mapper.module.TransformerMapper;
import org.sgmp.webapp.pojo.module.GatherPoint;
import org.sgmp.webapp.pojo.module.MeasuringPoint;
import org.sgmp.webapp.pojo.module.Meter;
import org.sgmp.webapp.pojo.module.MeterInfo;
import org.sgmp.webapp.pojo.module.Protector;
import org.sgmp.webapp.pojo.module.ProtectorInfo;
import org.sgmp.webapp.pojo.module.RelationTerminalAndObject;
import org.sgmp.webapp.pojo.module.Terminal;
import org.sgmp.webapp.pojo.module.Tg;
import org.sgmp.webapp.pojo.module.Transformer;
import org.sgmp.webapp.service.module.SimpleCURDService;
import org.sgmp.webapp.service.module.SimpleQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 台区档案管理
 * 
 * @author Nick
 *
 */
@Component
public class TgArchivesManagementAction extends AbstractSimpleCURDAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2940498208040696429L;

    private static final Logger logger = LoggerFactory.getLogger(TgArchivesManagementAction.class);

    @Autowired
    private SimpleCURDService<Tg> tgService;
    @Autowired
    private SimpleCURDService<Transformer> tranService;
    @Autowired
    private SimpleCURDService<Terminal> termService;
    @Autowired
    private SimpleCURDService<RelationTerminalAndObject> rtaoService;
    @Autowired
    private SimpleCURDService<GatherPoint> gpService;
    @Autowired
    private SimpleCURDService<MeasuringPoint> mpService;
    @Autowired
    private SimpleCURDService<Meter> meterService;
    @Autowired
    private SimpleCURDService<Protector> psService;
    @Autowired
    private SimpleQueryService simpleQueryService;

    /**
     * 通过台区ID获取台区
     * 
     * @throws ActionException
     */
    public void getTgById() throws ActionException {
        String tgid = request.getParameter("id");                       // 台区标识
        if(StringUtils.isNotBlank(tgid)) {
            Long id = Long.valueOf(tgid);
            try {
                Tg tg = tgService.getById(TgMapper.class, id);
                responseJson(tg);
            }
            catch(ServiceException _se) {
                logger.error("getTgById error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new Tg());
        }
    }

    /**
     * 保存台区
     * 
     * @throws ActionException
     */
    public void saveTg() throws ActionException {
        String tgString = request.getParameter("tg");
        logger.info(tgString);
        Tg tg = null;
        ObjectMapper objectMapper = new ObjectMapper();
        Long tgId = 0L;
        try {
            tg = objectMapper.readValue(tgString, Tg.class);
            tg.setChgDate(new Date());
            tg.setPubPrivFlag("0");
            tg.setLastTimestamp(new Date());
            logger.info(tg.toString());
            if(tg.getId() != null && tg.getId() > 0) {
                tgService.update(TgMapper.class, tg);
                tgId = tg.getId();
                logger.info("tgId : " + tgId);
            }
            else {
                tgService.create(TgMapper.class, tg);
                tgId = tg.getId();
                logger.info("tgId : " + tgId);
            }
        }
        catch(JsonParseException _jpe) {
            tgId = -1L;
            logger.error("saveTg error", _jpe);
            throw new ActionException("ActionException", _jpe.getCause());
        }
        catch(JsonMappingException _jme) {
            tgId = -1L;
            logger.error("saveTg error", _jme);
            throw new ActionException("ActionException", _jme.getCause());
        }
        catch(IOException _ioe) {
            tgId = -1L;
            logger.error("saveTg error", _ioe);
            throw new ActionException("ActionException", _ioe.getCause());
        }
        catch(ServiceException _se) {
            tgId = -1L;
            logger.error("saveTg error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
        finally {
            responseText(String.valueOf(tgId));
        }
    }

    /**
     * 通过台区ID获取变压器列表
     * 
     * @throws ActionException
     */
    public void getTranListByTgId() throws ActionException {
        String tgid = request.getParameter("id");                       // 台区标识
        if(StringUtils.isNotBlank(tgid)) {
            Long id = Long.valueOf(tgid);
            try {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("tgId", id);
                List<Transformer> records = tranService.getList(TransformerMapper.class, params);
                Integer totalCount = tranService.getCount(TransformerMapper.class, params);
                Map<String, Object> result = new HashMap<String, Object>();
                result.put("records", records);
                result.put("totalCount", totalCount);
                responseJson(result);
            }
            catch(ServiceException _se) {
                logger.error("getTgById error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new ArrayList<Transformer>());
        }
    }

    /**
     * 通过变压器ID获取变压器
     * 
     * @throws ActionException
     */
    public void getTranById() throws ActionException {
        
    }

    /**
     * 保存变压器
     * 
     * @throws ActionException
     */
    public void saveTran() throws ActionException {
        
    }

    /**
     * 通过台区ID获取集中器列表
     * 
     * @throws ActionException
     */
    public void getTermListByTgId() throws ActionException {
        String tgid = request.getParameter("id");                       // 台区标识
        if(StringUtils.isNotBlank(tgid)) {
            Long id = Long.valueOf(tgid);
            try {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("tgId", id);
                List<Terminal> records = termService.getList(TerminalMapper.class, params);
                Integer totalCount = termService.getCount(TerminalMapper.class, params);
                Map<String, Object> result = new HashMap<String, Object>();
                result.put("records", records);
                result.put("totalCount", totalCount);
                responseJson(result);
            }
            catch(ServiceException _se) {
                logger.error("getTgById error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new ArrayList<Terminal>());
        }
    }

    /**
     * 通过集中器ID获取集中器
     * 
     * @throws ActionException
     */
    public void getTermById() throws ActionException {
        
    }

    /**
     * 保存集中器
     * 
     * @throws ActionException
     */
    public void saveTerm() throws ActionException {
        
    }

    /**
     * 通过台区ID获取考核表列表
     * 
     * @throws ActionException
     */
    public void getMeterListByTgId() throws ActionException {
        String tgid = request.getParameter("id");                       // 台区标识
        if(StringUtils.isNotBlank(tgid)) {
            Long id = Long.valueOf(tgid);
            try {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("tgId", id);
                List<?> records = simpleQueryService.getList(MeterInfoQueryMapper.class, params, null, null, null, null);
                Integer totalCount = simpleQueryService.getCount(MeterInfoQueryMapper.class, params);
                Map<String, Object> result = new HashMap<String, Object>();
                result.put("records", records);
                result.put("totalCount", totalCount);
                responseJson(result);
            }
            catch(ServiceException _se) {
                logger.error("getTgById error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new ArrayList<MeterInfo>());
        }
    }

    /**
     * 通过考核表ID获取考核表
     * 
     * @throws ActionException
     */
    public void getMeterById() throws ActionException {
        
    }

    /**
     * 保存考核表
     * 
     * @throws ActionException
     */
    public void saveMeter() throws ActionException {
        
    }

    /**
     * 通过台区ID获取保护器列表
     * 
     * @throws ActionException
     */
    public void getPsListByTgId() throws ActionException {
        String tgid = request.getParameter("id");                       // 台区标识
        if(StringUtils.isNotBlank(tgid)) {
            Long id = Long.valueOf(tgid);
            try {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("tgId", id);
                List<?> records = simpleQueryService.getList(ProtectorInfoQueryMapper.class, params, null, null, null, null);
                Integer totalCount = simpleQueryService.getCount(ProtectorInfoQueryMapper.class, params);
                Map<String, Object> result = new HashMap<String, Object>();
                result.put("records", records);
                result.put("totalCount", totalCount);
                responseJson(result);
            }
            catch(ServiceException _se) {
                logger.error("getTgById error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new ArrayList<ProtectorInfo>());
        }
    }

    /**
     * 通过保护器ID获取保护器
     * 
     * @throws ActionException
     */
    public void getPsById() throws ActionException {
        
    }

    /**
     * 保存保护器
     * 
     * @throws ActionException
     */
    public void savePs() throws ActionException {
        
    }

}
