package org.sgmp.webapp.action;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.sgmp.webapp.ActionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Nick
 *
 */
public class AbstractSimpleAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5844727930674417510L;

    private static final Logger logger = LoggerFactory.getLogger(AbstractSimpleAction.class);

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> session) {
        logger.debug("session Map : " + session.toString());
        this.session = session;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        logger.debug("response CharacterEncoding : " + response.getCharacterEncoding());
        logger.debug("response ContentType       : " + response.getContentType());
        this.response = response;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        logger.debug("request CharacterEncoding : " + request.getCharacterEncoding());
        logger.debug("request AttributeNames    : " + request.getAttributeNames().toString());
        this.request = request;
    }

    /**
     * 
     * @param s
     * @throws ActionException
     */
    public void responseText(String s) throws ActionException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain; charset=UTF-8");

        if(StringUtils.isBlank(s)) {
            s = "";
        }

        try {
            response.getOutputStream().write(s.getBytes("UTF-8"));
        }
        catch(IOException _ioe) {
            logger.error("responseText error", _ioe);
            throw new ActionException("ActionException", _ioe.getCause());
        }
        finally {
            s = null;
        }
    }

    /**
     * 
     * @param o
     * @throws ActionException
     */
    public void responseJson(Object o) throws ActionException {
        responseJson(o, null);
    }

    /**
     * 
     * @param o
     * @param dateFormat
     * @throws ActionException
     */
    public void responseJson(Object o, String dateFormat) throws ActionException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        if(StringUtils.isNotBlank(dateFormat)) {
            objectMapper.setDateFormat(new SimpleDateFormat(dateFormat)); 
        }
        StringWriter stringWriter = new StringWriter();
        JsonGenerator jsonGenerator = null;
        try {
            jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(stringWriter);
            objectMapper.writeValue(jsonGenerator, o);
        }
        catch(IOException _ioe) {
            logger.error("responseJson error", _ioe);
            throw new ActionException("ActionException", _ioe.getCause());
        }
        finally {
            if(jsonGenerator != null) {
                try {
                    jsonGenerator.close();
                }
                catch(IOException _ioe) {
                    logger.error("responseJson error", _ioe);
                    throw new ActionException("ActionException", _ioe.getCause());
                }
            }
        }
        String jsonString = stringWriter.toString();
        logger.debug("jsonString : " + jsonString);

        try {
            response.getOutputStream().write(jsonString.getBytes("UTF-8"));
        }
        catch(IOException _ioe) {
            logger.error("responseJson error", _ioe);
        }
        finally {
            try {
                stringWriter.close();
            }
            catch(IOException _ioe) {
                logger.error("responseJson error", _ioe);
                throw new ActionException("ActionException", _ioe.getCause());
            }
            objectMapper = null;
            jsonString = null;
        }
    }

}
