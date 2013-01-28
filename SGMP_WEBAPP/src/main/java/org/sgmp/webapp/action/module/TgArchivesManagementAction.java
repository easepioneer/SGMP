package org.sgmp.webapp.action.module;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.sgmp.webapp.ActionException;
import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.mapper.module.AnalogueInfoQueryMapper;
import org.sgmp.webapp.mapper.module.AnalogueMapper;
import org.sgmp.webapp.mapper.module.GatherPointMapper;
import org.sgmp.webapp.mapper.module.MeasuringPointMapper;
import org.sgmp.webapp.mapper.module.MeterInfoQueryMapper;
import org.sgmp.webapp.mapper.module.MeterMapper;
import org.sgmp.webapp.mapper.module.ProtectorInfoQueryMapper;
import org.sgmp.webapp.mapper.module.ProtectorMapper;
import org.sgmp.webapp.mapper.module.RelationTerminalAndObjectMapper;
import org.sgmp.webapp.mapper.module.SwitchMapper;
import org.sgmp.webapp.mapper.module.TerminalMapper;
import org.sgmp.webapp.mapper.module.TgMapper;
import org.sgmp.webapp.pojo.module.Analogue;
import org.sgmp.webapp.pojo.module.AnalogueInfo;
import org.sgmp.webapp.pojo.module.GatherPoint;
import org.sgmp.webapp.pojo.module.MeasuringPoint;
import org.sgmp.webapp.pojo.module.Meter;
import org.sgmp.webapp.pojo.module.MeterInfo;
import org.sgmp.webapp.pojo.module.Protector;
import org.sgmp.webapp.pojo.module.ProtectorInfo;
import org.sgmp.webapp.pojo.module.RelationTerminalAndObject;
import org.sgmp.webapp.pojo.module.Switch;
import org.sgmp.webapp.pojo.module.Terminal;
import org.sgmp.webapp.pojo.module.Tg;
import org.sgmp.webapp.service.module.SimpleCURDService;
import org.sgmp.webapp.service.module.SimpleQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
    private SimpleCURDService<Analogue> agService;
    @Autowired
    private SimpleCURDService<Switch> swService;
    @Autowired
    private SimpleQueryService simpleQueryService;

    /**
     * 获取台区列表
     * 
     * @throws ActionException
     */
    public void getTgList() throws ActionException {
        String withAll = request.getParameter("withAll");
        String orgId = request.getParameter("orgId");                       // 机构标识
        Map<String, Object> params = new HashMap<String, Object>();
        if(StringUtils.isNotBlank(orgId)) {
            Long id = Long.valueOf(orgId);
            params.put("orgId", id);
        }

        List<Tg> records = new ArrayList<Tg>();
        if(StringUtils.equals(withAll, "true")) {
            Tg all = new Tg();
            all.setId(0L);
            all.setTgName(" --- 所有台区 --- ");
            records.add(all);
        }

        try {
            records.addAll(tgService.getList(TgMapper.class, params));
        }
        catch(ServiceException _se) {
            logger.error("getTgList error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
        finally {
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("records", records);
            responseJson(result);
        }
    }

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
                responseJson(tg, "yyyy-MM-dd");
            }
            catch(ServiceException _se) {
                logger.error("getTgById error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new Tg(), "yyyy-MM-dd");
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
        ObjectMapper objectMapper = new ObjectMapper();
        Long tgId = 0L;
        try {
            Tg tgView = objectMapper.readValue(tgString, Tg.class);
            logger.info(tgView.toString());

            tgView.setChgDate(new Date());
            tgView.setPubPrivFlag("0");
            tgView.setLastTimestamp(new Date());

            if(tgView.getId() != null && tgView.getId() > 0) {
                Tg tg = tgService.getById(TgMapper.class, tgView.getId());
                BeanUtils.copyProperties(tgView, tg);
                tgService.update(TgMapper.class, tg);
                tgId = tg.getId();
                logger.info("tgId : " + tgId);
            }
            else {
                tgService.create(TgMapper.class, tgView);
                tgId = tgView.getId();
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
     * 获取集中器列表
     * 
     * @throws ActionException
     */
    public void getTermList() throws ActionException {
        String withAll = request.getParameter("withAll");
        String orgId = request.getParameter("orgId");                       // 机构标识
        String tgId = request.getParameter("tgId");                         // 台区标识
        Map<String, Object> params = new HashMap<String, Object>();
        if(StringUtils.isNotBlank(orgId)) {
            Long id = Long.valueOf(orgId);
            params.put("orgId", id);
        }
        if(StringUtils.isNotBlank(tgId)) {
            Long id = Long.valueOf(tgId);
            params.put("tgId", id);
        }

        List<Terminal> records = new ArrayList<Terminal>();
        if(StringUtils.equals(withAll, "true")) {
            Terminal all = new Terminal();
            all.setId(0L);
            all.setLogicalAddr(" --- 所有集中器 --- ");
            records.add(all);
        }

        try {
            records.addAll(termService.getList(TerminalMapper.class, params));
        }
        catch(ServiceException _se) {
            logger.error("getTermList error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
        finally {
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("records", records);
            responseJson(result);
        }
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
                responseJson(result, "yyyy-MM-dd HH:mm:ss");
            }
            catch(ServiceException _se) {
                logger.error("getTermListByTgId error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new ArrayList<Terminal>(), "yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 通过集中器ID获取集中器
     * 
     * @throws ActionException
     */
    public void getTermById() throws ActionException {
        String termid = request.getParameter("id");                       // 集中器标识
        if(StringUtils.isNotBlank(termid)) {
            Long id = Long.valueOf(termid);
            try {
                Terminal terminal = termService.getById(TerminalMapper.class, id);
                responseJson(terminal, "yyyy-MM-dd");
            }
            catch(ServiceException _se) {
                logger.error("getTermById error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new Terminal(), "yyyy-MM-dd");
        }
    }

    /**
     * 保存集中器
     * 
     * @throws ActionException
     */
    public void saveTerm() throws ActionException {
        String termString = request.getParameter("term");
        String stgid = request.getParameter("tgId");
        logger.info("termString : " + termString);
        logger.info("tgId       : " + stgid);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        Long termId = 0L;
        try {
            Long tgId = Long.parseLong(stgid);
            Tg tg = tgService.getById(TgMapper.class, tgId);
            if(tg != null) {
                Terminal terminalView = objectMapper.readValue(termString, Terminal.class);
                logger.info(terminalView.toString());

                terminalView.setLastTimestamp(new Date());

                if(terminalView.getId() != null && terminalView.getId() > 0) {
                    Terminal terminal = termService.getById(TerminalMapper.class, terminalView.getId());
                    BeanUtils.copyProperties(terminalView, terminal, new String[] {"orgId", "runStatus", "termType", "termModel", "pr", "isAc", "physicsAddr", "commPattern"});
                    termService.update(TerminalMapper.class, terminal);
                    termId = terminal.getId();
                    logger.info("termId : " + termId);
                }
                else {
                    terminalView.setOrgId(tg.getOrgId());
                    terminalView.setRunStatus("2");
                    terminalView.setTermType("05");
                    terminalView.setPr("1");
                    terminalView.setIsAc("0");
                    termService.create(TerminalMapper.class, terminalView);
                    termId = terminalView.getId();

                    RelationTerminalAndObject rtao = new RelationTerminalAndObject();
                    rtao.setTermId(termId);
                    rtao.setObjectId(tgId);
                    rtao.setObjectType("2");
                    rtaoService.create(RelationTerminalAndObjectMapper.class, rtao);

                    logger.info("termId : " + termId);
                }
            }
        }
        catch(NumberFormatException _nfe) {
            termId = -1L;
            logger.error("saveTerm error", _nfe);
            throw new ActionException("ActionException", _nfe.getCause());
        }
        catch(JsonParseException _jpe) {
            termId = -1L;
            logger.error("saveTerm error", _jpe);
            throw new ActionException("ActionException", _jpe.getCause());
        }
        catch(JsonMappingException _jme) {
            termId = -1L;
            logger.error("saveTerm error", _jme);
            throw new ActionException("ActionException", _jme.getCause());
        }
        catch(IOException _ioe) {
            termId = -1L;
            logger.error("saveTerm error", _ioe);
            throw new ActionException("ActionException", _ioe.getCause());
        }
        catch(ServiceException _se) {
            termId = -1L;
            logger.error("saveTerm error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
        finally {
            responseText(String.valueOf(termId));
        }
    }

    /**
     * 获取考核表列表
     * 
     * @throws ActionException
     */
    @SuppressWarnings("unchecked")
    public void getMeterList() throws ActionException {
        String withAll = request.getParameter("withAll");
        String orgId = request.getParameter("orgId");                       // 机构标识
        String tgId = request.getParameter("tgId");                         // 台区标识
        String termId = request.getParameter("termId");                     // 集中器标识
        Map<String, Object> params = new HashMap<String, Object>();
        if(StringUtils.isNotBlank(orgId)) {
            Long id = Long.valueOf(orgId);
            params.put("orgId", id);
        }
        if(StringUtils.isNotBlank(tgId)) {
            Long id = Long.valueOf(tgId);
            params.put("tgId", id);
        }
        if(StringUtils.isNotBlank(termId)) {
            Long id = Long.valueOf(termId);
            params.put("termId", id);
        }

        List<MeterInfo> records = new ArrayList<MeterInfo>();
        if(StringUtils.equals(withAll, "true")) {
            MeterInfo all = new MeterInfo();
            all.setId(0L);
            all.setMpName(" --- 所有考核表 --- ");
            all.setMpId(0L);
            all.setGpId(0L);
            records.add(all);
        }

        try {
            records.addAll((Collection<? extends MeterInfo>) simpleQueryService.getList(MeterInfoQueryMapper.class, params, null, null, null, null));
        }
        catch(ServiceException _se) {
            logger.error("getMeterList error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
        finally {
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("records", records);
            responseJson(result);
        }
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
                responseJson(result, "yyyy-MM-dd HH:mm:ss");
            }
            catch(ServiceException _se) {
                logger.error("getMeterListByTgId error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new ArrayList<MeterInfo>(), "yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 通过考核表ID获取考核表
     * 
     * @throws ActionException
     */
    public void getMeterById() throws ActionException {
        String meterId = request.getParameter("id");                       // 考核表标识
        if(StringUtils.isNotBlank(meterId)) {
            Long id = Long.valueOf(meterId);
            try {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("id", id);
                List<?> records = simpleQueryService.getList(MeterInfoQueryMapper.class, params, null, null, null, null);
                if(records != null && records.size() > 0) {
                    MeterInfo meterInfo = (MeterInfo) records.get(0);
                    responseJson(meterInfo, "yyyy-MM-dd");
                }
                else {
                    responseJson(new MeterInfo());
                }
            }
            catch(ServiceException _se) {
                logger.error("getMeterById error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new MeterInfo(), "yyyy-MM-dd");
        }
    }

    /**
     * 保存考核表
     * 
     * @throws ActionException
     */
    public void saveMeter() throws ActionException {
        String meterString = request.getParameter("meter");
        String stgid = request.getParameter("tgId");
        logger.info("meterString   : " + meterString);
        logger.info("tgId       : " + stgid);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        Long meterId = 0L;
        Long mpId = 0L;
        Long gpId = 0L;
        try {
            Long tgId = Long.parseLong(stgid);
            Tg tg = tgService.getById(TgMapper.class, tgId);
            if(tg != null) {
                MeterInfo meterInfo = objectMapper.readValue(meterString, MeterInfo.class);
                Meter meterView = objectMapper.readValue(meterString, Meter.class);
                MeasuringPoint measuringPointView = objectMapper.readValue(meterString, MeasuringPoint.class);
                measuringPointView.setId(meterInfo.getMpId());
                GatherPoint gatherPointView = objectMapper.readValue(meterString, GatherPoint.class);
                gatherPointView.setId(meterInfo.getGpId());
                logger.info(meterInfo.toString());
                logger.info(meterView.toString());
                logger.info(measuringPointView.toString());
                logger.info(gatherPointView.toString());

                meterView.setCommNo(gatherPointView.getProtocolNo());
                Float totalFactor = null;
                Integer ct = gatherPointView.getCtTimes();
                Integer pt = gatherPointView.getPtTimes();
                if(ct != null && pt != null) {
                    totalFactor = ct.floatValue() * pt.floatValue();
                }
                meterView.setTotalFactor(totalFactor);

                measuringPointView.setMpNo(meterView.getAssetNo());
                measuringPointView.setAppDate(meterView.getInstDate());
                measuringPointView.setRunDate(meterView.getInstDate());
                measuringPointView.setLastTimestamp(new Date());

                gatherPointView.setLastTimestamp(new Date());

                if(meterView.getId() != null && meterView.getId() > 0) {
                    Meter meter = meterService.getById(MeterMapper.class, meterView.getId());
                    BeanUtils.copyProperties(meterView, meter, new String[] {"orgId"});
                    meterService.update(MeterMapper.class, meter);
                    meterId = meter.getId();
                    logger.info("meterId : " + meterId);
                    if(measuringPointView.getId() != null && measuringPointView.getId() > 0) {
                        MeasuringPoint measuringPoint = mpService.getById(MeasuringPointMapper.class, measuringPointView.getId());
                        BeanUtils.copyProperties(measuringPointView, measuringPoint, new String[] {"orgId", "tgId", "meterId"});
                        mpService.update(MeasuringPointMapper.class, measuringPoint);
                        mpId = measuringPoint.getId();
                        logger.info("mpId : " + mpId);
                        if(gatherPointView.getId() != null && gatherPointView.getId() > 0) {
                            GatherPoint gatherPoint = gpService.getById(GatherPointMapper.class, gatherPointView.getId());
                            BeanUtils.copyProperties(gatherPointView, gatherPoint, new String[] {"objectId", "tranId", "mpId", "gmId", "gpChar", "gpType"});
                            gpService.update(GatherPointMapper.class, gatherPoint);
                            gpId = gatherPoint.getId();
                            logger.info("gpId : " + gpId);
                        }
                    }
                }
                else {
                    meterView.setOrgId(tg.getOrgId());
                    meterService.create(MeterMapper.class, meterView);
                    meterId = meterView.getId();

                    measuringPointView.setOrgId(tg.getOrgId());
                    measuringPointView.setTgId(tgId);
                    measuringPointView.setMeterId(meterId);
                    mpService.create(MeasuringPointMapper.class, measuringPointView);
                    mpId = measuringPointView.getId();

                    gatherPointView.setObjectId(tgId);
                    gatherPointView.setMpId(mpId);
                    gatherPointView.setGpChar("1");
                    gatherPointView.setGpType("2");
                    gpService.create(GatherPointMapper.class, gatherPointView);
                    gpId = gatherPointView.getId();
                }
            }
        }
        catch(NumberFormatException _nfe) {
            meterId = -1L;
            logger.error("saveMeter error", _nfe);
            throw new ActionException("ActionException", _nfe.getCause());
        }
        catch(JsonParseException _jpe) {
            meterId = -1L;
            logger.error("saveMeter error", _jpe);
            throw new ActionException("ActionException", _jpe.getCause());
        }
        catch(JsonMappingException _jme) {
            meterId = -1L;
            logger.error("saveMeter error", _jme);
            throw new ActionException("ActionException", _jme.getCause());
        }
        catch(IOException _ioe) {
            meterId = -1L;
            logger.error("saveMeter error", _ioe);
            throw new ActionException("ActionException", _ioe.getCause());
        }
        catch(ServiceException _se) {
            meterId = -1L;
            logger.error("saveMeter error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
        finally {
            responseText(String.valueOf(meterId));
        }
    }

    /**
     * 获取保护器列表
     * 
     * @throws ActionException
     */
    @SuppressWarnings("unchecked")
    public void getPsList() throws ActionException {
        String withAll = request.getParameter("withAll");
        String orgId = request.getParameter("orgId");                       // 机构标识
        String tgId = request.getParameter("tgId");                         // 台区标识
        String termId = request.getParameter("termId");                     // 集中器标识
        Map<String, Object> params = new HashMap<String, Object>();
        if(StringUtils.isNotBlank(orgId)) {
            Long id = Long.valueOf(orgId);
            params.put("orgId", id);
        }
        if(StringUtils.isNotBlank(tgId)) {
            Long id = Long.valueOf(tgId);
            params.put("tgId", id);
        }
        if(StringUtils.isNotBlank(termId)) {
            Long id = Long.valueOf(termId);
            params.put("termId", id);
        }

        List<ProtectorInfo> records = new ArrayList<ProtectorInfo>();
        if(StringUtils.equals(withAll, "true")) {
            ProtectorInfo all = new ProtectorInfo();
            all.setId(0L);
            all.setPsName(" --- 所有保护器 --- ");
            all.setGpId(0L);
            records.add(all);
        }

        try {
            records.addAll((Collection<? extends ProtectorInfo>) simpleQueryService.getList(ProtectorInfoQueryMapper.class, params, null, null, null, null));
        }
        catch(ServiceException _se) {
            logger.error("getPsList error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
        finally {
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("records", records);
            responseJson(result);
        }
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
                logger.error("getPsListByTgId error", _se);
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
        String psId = request.getParameter("id");                       // 保护器标识
        if(StringUtils.isNotBlank(psId)) {
            Long id = Long.valueOf(psId);
            try {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("id", id);
                List<?> records = simpleQueryService.getList(ProtectorInfoQueryMapper.class, params, null, null, null, null);
                if(records != null && records.size() > 0) {
                    ProtectorInfo psInfo = (ProtectorInfo) records.get(0);
                    responseJson(psInfo);
                }
                else {
                    responseJson(new ProtectorInfo());
                }
            }
            catch(ServiceException _se) {
                logger.error("getPsById error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new ProtectorInfo());
        }
    }

    /**
     * 保存保护器
     * 
     * @throws ActionException
     */
    public void savePs() throws ActionException {
        String psString = request.getParameter("ps");
        String stgid = request.getParameter("tgId");
        logger.info("psString   : " + psString);
        logger.info("tgId       : " + stgid);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        Long psId = 0L;
        Long gpId = 0L;
        try {
            Long tgId = Long.parseLong(stgid);
            Tg tg = tgService.getById(TgMapper.class, tgId);
            if(tg != null) {
                ProtectorInfo protectorInfo = objectMapper.readValue(psString, ProtectorInfo.class);
                Protector protectorView = objectMapper.readValue(psString, Protector.class);
                GatherPoint gatherPointView = objectMapper.readValue(psString, GatherPoint.class);
                gatherPointView.setId(protectorInfo.getGpId());
                logger.info(protectorView.toString());
                logger.info(gatherPointView.toString());

                protectorView.setLastTimestamp(new Date());

                protectorView.setPsType("1");
                gatherPointView.setLastTimestamp(new Date());

                if(protectorView.getId() != null && protectorView.getId() > 0) {
                    Protector protector = psService.getById(ProtectorMapper.class, protectorView.getId());
                    BeanUtils.copyProperties(protectorView, protector, new String[] {"gpId", "psModel", "ratedEc", "psType", "testDay", "testTime", "autoTest"});
                    psService.update(ProtectorMapper.class, protector);
                    psId = protector.getId();
                    logger.info("psId : " + psId);
                    if(gatherPointView.getId() != null && gatherPointView.getId() > 0) {
                        GatherPoint gatherPoint = gpService.getById(GatherPointMapper.class, gatherPointView.getId());
                        BeanUtils.copyProperties(gatherPointView, gatherPoint, new String[] {"objectId", "tranId", "mpId", "gmId", "gpChar", "gpType", "ctTimes", "ptTimes"});
                        gatherPoint.setLastTimestamp(new Date());
                        gpService.update(GatherPointMapper.class, gatherPoint);
                        gpId = gatherPoint.getId();
                        logger.info("gpId : " + gpId);
                    }
                }
                else {
                    gatherPointView.setGpChar("1");
                    gatherPointView.setGpType("2");
                    gatherPointView.setCtTimes(1);
                    gatherPointView.setPtTimes(1);
                    gatherPointView.setObjectId(tgId);
                    gpService.create(GatherPointMapper.class, gatherPointView);
                    gpId = gatherPointView.getId();

                    protectorView.setGpId(gpId);
                    psService.create(ProtectorMapper.class, protectorView);
                    psId = protectorView.getId();

                    logger.info("psId : " + psId);
                }
            }
        }
        catch(NumberFormatException _nfe) {
            psId = -1L;
            logger.error("savePs error", _nfe);
            throw new ActionException("ActionException", _nfe.getCause());
        }
        catch(JsonParseException _jpe) {
            psId = -1L;
            logger.error("savePs error", _jpe);
            throw new ActionException("ActionException", _jpe.getCause());
        }
        catch(JsonMappingException _jme) {
            psId = -1L;
            logger.error("savePs error", _jme);
            throw new ActionException("ActionException", _jme.getCause());
        }
        catch(IOException _ioe) {
            psId = -1L;
            logger.error("savePs error", _ioe);
            throw new ActionException("ActionException", _ioe.getCause());
        }
        catch(ServiceException _se) {
            psId = -1L;
            logger.error("savePs error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
        finally {
            responseText(String.valueOf(psId));
        }
    }

    /**
     * 获取模拟量列表
     * 
     * @throws ActionException
     */
    public void getAgList() throws ActionException {
        String orgId = request.getParameter("orgId");                       // 机构标识
        String tgId = request.getParameter("tgId");                         // 台区标识
        String termId = request.getParameter("termId");                     // 集中器标识
        Map<String, Object> params = new HashMap<String, Object>();
        if(StringUtils.isNotBlank(orgId)) {
            Long id = Long.valueOf(orgId);
            params.put("orgId", id);
        }
        if(StringUtils.isNotBlank(tgId)) {
            Long id = Long.valueOf(tgId);
            params.put("tgId", id);
        }
        if(StringUtils.isNotBlank(termId)) {
            Long id = Long.valueOf(termId);
            params.put("termId", id);
        }

        try {
            List<?> records = simpleQueryService.getList(AnalogueInfoQueryMapper.class, params, null, null, null, null);
            Integer totalCount = simpleQueryService.getCount(AnalogueInfoQueryMapper.class, params);
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("records", records);
            result.put("totalCount", totalCount);
            responseJson(result);
        }
        catch(ServiceException _se) {
            logger.error("getAgList error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
    }

    /**
     * 通过台区ID获取模拟量列表
     * 
     * @throws ActionException
     */
    public void getAgListByTgId() throws ActionException {
        String tgid = request.getParameter("id");                       // 台区标识
        if(StringUtils.isNotBlank(tgid)) {
            Long id = Long.valueOf(tgid);
            try {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("tgId", id);
                List<?> records = simpleQueryService.getList(AnalogueInfoQueryMapper.class, params, null, null, null, null);
                Integer totalCount = simpleQueryService.getCount(AnalogueInfoQueryMapper.class, params);
                Map<String, Object> result = new HashMap<String, Object>();
                result.put("records", records);
                result.put("totalCount", totalCount);
                responseJson(result);
            }
            catch(ServiceException _se) {
                logger.error("getAgListByTgId error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new ArrayList<AnalogueInfo>());
        }
    }

    /**
     * 通过模拟量ID获取模拟量
     * 
     * @throws ActionException
     */
    public void getAgById() throws ActionException {
        String agId = request.getParameter("id");                       // 模拟量标识
        if(StringUtils.isNotBlank(agId)) {
            Long id = Long.valueOf(agId);
            try {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("gpId", id);
                List<?> records = simpleQueryService.getList(AnalogueInfoQueryMapper.class, params, null, null, null, null);
                if(records != null && records.size() > 0) {
                    AnalogueInfo agInfo = (AnalogueInfo) records.get(0);
                    responseJson(agInfo);
                }
                else {
                    responseJson(new AnalogueInfo());
                }
            }
            catch(ServiceException _se) {
                logger.error("getAgById error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new AnalogueInfo());
        }
    }

    /**
     * 保存模拟量
     * 
     * @throws ActionException
     */
    public void saveAg() throws ActionException {
        String agString = request.getParameter("ag");
        String stgid = request.getParameter("tgId");
        logger.info("agString   : " + agString);
        logger.info("tgId       : " + stgid);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        Long gpId = 0L;
        try {
            Long tgId = Long.parseLong(stgid);
            Tg tg = tgService.getById(TgMapper.class, tgId);
            if(tg != null) {
                AnalogueInfo analogueInfo = objectMapper.readValue(agString, AnalogueInfo.class);
                Analogue analogueView = objectMapper.readValue(agString, Analogue.class);
                GatherPoint gatherPointView = objectMapper.readValue(agString, GatherPoint.class);
                gatherPointView.setId(analogueInfo.getGpId());
                logger.info(analogueInfo.toString());
                logger.info(analogueView.toString());
                logger.info(gatherPointView.toString());

                gatherPointView.setLastTimestamp(new Date());

                if(analogueView.getGpId() != null && analogueView.getGpId() > 0) {
                    Analogue analogue = agService.getById(AnalogueMapper.class, analogueView.getGpId());
                    BeanUtils.copyProperties(analogueView, analogue);
                    agService.update(AnalogueMapper.class, analogue);

                    GatherPoint gatherPoint = gpService.getById(GatherPointMapper.class, gatherPointView.getId());
                    BeanUtils.copyProperties(gatherPointView, gatherPoint, new String[] {"objectId", "tranId", "mpId", "gmId", "gpChar", "gpType", "ctTimes", "ptTimes"});
                    gpService.update(GatherPointMapper.class, gatherPoint);
                    gpId = gatherPoint.getId();
                    logger.info("gpId : " + gpId);
                }
                else {
                    gatherPointView.setGpChar("8");
                    gatherPointView.setGpType("2");
                    gatherPointView.setCtTimes(1);
                    gatherPointView.setPtTimes(1);
                    gatherPointView.setObjectId(tgId);
                    gpService.create(GatherPointMapper.class, gatherPointView);
                    gpId = gatherPointView.getId();

                    analogueView.setGpId(gpId);
                    agService.create(AnalogueMapper.class, analogueView);
                }
            }
        }
        catch(NumberFormatException _nfe) {
            gpId = -1L;
            logger.error("saveAg error", _nfe);
            throw new ActionException("ActionException", _nfe.getCause());
        }
        catch(JsonParseException _jpe) {
            gpId = -1L;
            logger.error("saveAg error", _jpe);
            throw new ActionException("ActionException", _jpe.getCause());
        }
        catch(JsonMappingException _jme) {
            gpId = -1L;
            logger.error("saveAg error", _jme);
            throw new ActionException("ActionException", _jme.getCause());
        }
        catch(IOException _ioe) {
            gpId = -1L;
            logger.error("saveAg error", _ioe);
            throw new ActionException("ActionException", _ioe.getCause());
        }
        catch(ServiceException _se) {
            gpId = -1L;
            logger.error("saveAg error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
        finally {
            responseText(String.valueOf(gpId));
        }
    }

    /**
     * 获取开关量列表
     * 
     * @throws ActionException
     */
    public void getSwList() throws ActionException {
        String orgId = request.getParameter("orgId");                       // 机构标识
        String tgId = request.getParameter("tgId");                         // 台区标识
        String termId = request.getParameter("termId");                     // 集中器标识
        Map<String, Object> params = new HashMap<String, Object>();
        if(StringUtils.isNotBlank(orgId)) {
            Long id = Long.valueOf(orgId);
            params.put("orgId", id);
        }
        if(StringUtils.isNotBlank(tgId)) {
            Long id = Long.valueOf(tgId);
            params.put("tgId", id);
        }
        if(StringUtils.isNotBlank(termId)) {
            Long id = Long.valueOf(termId);
            params.put("termId", id);
        }

        try {
            List<Switch> records = swService.getList(SwitchMapper.class, params);
            Integer totalCount = swService.getCount(SwitchMapper.class, params);
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("records", records);
            result.put("totalCount", totalCount);
            responseJson(result);
        }
        catch(ServiceException _se) {
            logger.error("getSwList error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
    }

    /**
     * 通过台区ID获取开关量列表
     * 
     * @throws ActionException
     */
    public void getSwListByTgId() throws ActionException {
        String tgid = request.getParameter("id");                       // 台区标识
        if(StringUtils.isNotBlank(tgid)) {
            Long id = Long.valueOf(tgid);
            try {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("tgId", id);
                List<Switch> records = swService.getList(SwitchMapper.class, params);
                Integer totalCount = swService.getCount(SwitchMapper.class, params);
                Map<String, Object> result = new HashMap<String, Object>();
                result.put("records", records);
                result.put("totalCount", totalCount);
                responseJson(result, "yyyy-MM-dd HH:mm:ss");
            }
            catch(ServiceException _se) {
                logger.error("getSwListByTgId error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new ArrayList<Switch>(), "yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 通过开关量ID获取开关量
     * 
     * @throws ActionException
     */
    public void getSwById() throws ActionException {
        String swid = request.getParameter("id");                       // 开关量标识
        if(StringUtils.isNotBlank(swid)) {
            Long id = Long.valueOf(swid);
            try {
                Switch sw = swService.getById(SwitchMapper.class, id);
                responseJson(sw, "yyyy-MM-dd");
            }
            catch(ServiceException _se) {
                logger.error("getSwById error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
        }
        else {
            responseJson(new Switch(), "yyyy-MM-dd");
        }
    }

    /**
     * 保存开关量
     * 
     * @throws ActionException
     */
    public void saveSw() throws ActionException {
        String swString = request.getParameter("sw");
        logger.info("swString   : " + swString);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        Long swId = 0L;
        try {
            Switch sw = objectMapper.readValue(swString, Switch.class);
            logger.info(sw.toString());

            if(sw.getId() != null && sw.getId() > 0) {
                swService.update(SwitchMapper.class, sw);
                swId = sw.getId();
                logger.info("swId : " + swId);
            }
            else {
                swService.create(SwitchMapper.class, sw);
                swId = sw.getId();
                logger.info("swId : " + swId);
            }
        }
        catch(JsonParseException _jpe) {
            swId = -1L;
            logger.error("saveSw error", _jpe);
            throw new ActionException("ActionException", _jpe.getCause());
        }
        catch(JsonMappingException _jme) {
            swId = -1L;
            logger.error("saveSw error", _jme);
            throw new ActionException("ActionException", _jme.getCause());
        }
        catch(IOException _ioe) {
            swId = -1L;
            logger.error("saveSw error", _ioe);
            throw new ActionException("ActionException", _ioe.getCause());
        }
        catch(ServiceException _se) {
            swId = -1L;
            logger.error("saveSw error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
        finally {
            responseText(String.valueOf(swId));
        }
    }

}
