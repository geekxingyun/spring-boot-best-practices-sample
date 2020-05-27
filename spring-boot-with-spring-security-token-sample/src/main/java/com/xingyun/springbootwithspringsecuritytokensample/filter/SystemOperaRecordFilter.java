package com.xingyun.springbootwithspringsecuritytokensample.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qing-feng.zhao
 */
@Component
@Slf4j
public class SystemOperaRecordFilter extends OncePerRequestFilter{
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info(SystemOperaRecordFilter.class.getName()+"----doFilterInternal---come in");

        String remoteHost=request.getRemoteHost();
        String remoteIpAddress=request.getRemoteAddr();
        String requestUri=request.getRequestURI();
        StringBuffer requestUrl=request.getRequestURL();

        log.info("remoteHost={}",remoteHost);
        log.info("remoteIpAddress={}",remoteIpAddress);
        log.info("requestUri={}",requestUri);
        log.info("requestURL={}",requestUrl);

        filterChain.doFilter(request,response);
    }
}

