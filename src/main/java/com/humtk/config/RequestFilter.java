package com.humtk.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by burcu on 14.08.2017.
 */


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse res , FilterChain chain) {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin","http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods","POST,PUT,GET,OPTIONS,DELETE");
        response.setHeader("Access-Control-Allow-Headers","x-requested-with");
        response.setHeader("Access-Control-Max-Age","3600");
        response.setHeader("Access-Control-Allow-Credentials","true");

        if(!(request.getMethod().equalsIgnoreCase("options"))) {
            try {
                chain.doFilter(req,res);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            response.setHeader("Access-Control-Allow-Methods","POST,GET,DELETE");
            response.setHeader("Access-Control-Allow-Headers","authorization, content-type,"+ "access-control-request-headers" +
                    "access-control-request-method,accept,origin,authorization,x-requested-with");
            response.setHeader("Access-Control-Max-Age","3600");
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    @Override
    public void destroy() {

    }

}