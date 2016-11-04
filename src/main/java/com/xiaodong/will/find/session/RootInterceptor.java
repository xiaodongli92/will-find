package com.xiaodong.will.find.session;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xiaodong on 2015/11/30.
 */
public class RootInterceptor implements HandlerInterceptor {

//    private static final Logger LOG = LoggerFactory.getLogger(RootInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("lastUri",StringUtils.replace(request.getRequestURI(),"/willfind/",""));
//        if (handler.getClass().isAssignableFrom(HandlerMethod.class)){
//            AuthPermission authPermission = ((HandlerMethod)handler).getMethodAnnotation(AuthPermission.class);
            //当没有声明需要权限，或者声明不验证权限
//            if (authPermission == null || !authPermission.validate()){
//                return true;
//            }
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
