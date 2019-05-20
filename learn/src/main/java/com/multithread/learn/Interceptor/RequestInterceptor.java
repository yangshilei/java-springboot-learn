package com.multithread.learn.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description：请求url拦截器
 *
 * @Author yangshilei
 * @Date 2019-05-16 19:30
 */
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    String requestURI = request.getRequestURI();
    if(requestURI.startsWith("/test")){
      log.debug("鉴权失败，无权限的请求路径！");
      return true;
    }
    return false;
  }
}
