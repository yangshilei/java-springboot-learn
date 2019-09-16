package com.multithread.learn.Interceptor;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Description：请求url拦截器，通过配置注入到容器中；
 * @Author yangshilei
 * @Date 2019-05-16 19:30
 */
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

  /**
   * /learn/user开头的请求无需鉴权
   * @param request
   * @param response
   * @param handler
   * @return
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    String requestURI = request.getRequestURI();
    // 拦截，并返回拦截原因
    if(requestURI.startsWith("/learn/test")){
      log.debug("鉴权失败，无权限的请求路径!");
      this.err(response,request);
      return false;
    }
    // 不拦截，可通过的接口
    if(StringUtils.startsWithIgnoreCase(requestURI,"/learn/user")){
      log.debug("可以访问的接口!");
      return true;
    }
    return false;
  }

  /**
   * 自定义拦截器报错提示信息
   * @param response
   */
  private void err(HttpServletResponse response,HttpServletRequest request){
    response.setContentType("application/json;charset=UTF-8");
    Map<String,String> map = new HashMap<>();
    map.put("code","400");
    map.put("errMessage","未开通访问权限的url");
    try(PrintWriter writer = response.getWriter()) {
      writer.write(JSONObject.toJSONString(map));
    }catch (IOException e){
      log.error(request.getRequestURI()+"无权限，已被拦截");
    }
  }
}
