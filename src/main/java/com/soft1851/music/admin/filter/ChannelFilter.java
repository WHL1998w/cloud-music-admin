package com.soft1851.music.admin.filter;

import com.soft1851.music.admin.handler.RequestWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @ClassName ChannelFilter
 * @Description 过滤器Filter，用来把request传递下去
 * @Author wanghuanle
 * @Date 2020/4/21
 * @Version 1.0
 */

@Slf4j
@WebFilter(urlPatterns = "/*", filterName = "channelFilter")
public class ChannelFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if (servletRequest instanceof HttpServletRequest) {
            String url = ((HttpServletRequest) servletRequest).getRequestURI();
            if ("/api/upload/single".equals(url)){
                Part file = ((HttpServletRequest) servletRequest).getPart("file");
                log.info("文件名："+file);
            }
            requestWrapper = new RequestWrapper((HttpServletRequest) servletRequest);
        }
        if (requestWrapper == null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(requestWrapper, servletResponse);
        }



    }

    @Override
    public void destroy() {

    }
}