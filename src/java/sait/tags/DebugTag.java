/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.tags;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author 733196
 */
public class DebugTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        boolean isDebug = false;
        boolean isValidDomain = false;

        String query = request.getQueryString();
        if (query != null) {
            Pattern p = Pattern.compile("\\bdebug\\b");
            Matcher m = p.matcher(query);
            isDebug = m.find();
        }

        query = request.getServerName();
        if (query != null && (query.contains("test") || query.contains("localhost"))) {
            isValidDomain = true;
        }

        if (isDebug && isValidDomain) {
            return EVAL_BODY_INCLUDE;
        } else {
            return SKIP_BODY;
        }
    }

}
