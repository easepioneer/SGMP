package org.sgmp.webapp.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
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
     * @param text
     * @throws ActionException
     */
    public void responseText(String text) throws ActionException {
        response.setContentType("text/plain; charset=UTF-8");
        logger.debug("text : " + text);

        if(StringUtils.isBlank(text)) {
            text = "";
        }

        try {
            response.getOutputStream().write(text.getBytes("UTF-8"));
        }
        catch(IOException _ioe) {
            logger.error("responseText error", _ioe);
            throw new ActionException("ActionException", _ioe.getCause());
        }
        finally {
            text = null;
        }
    }

}
