package com.queen_cash.interceptor;

import com.queen_cash.domain.admin.Administrator;
import com.queen_cash.repository.AdminRepository;
import com.queen_cash.util.AppUtil;
import com.queen_cash.constants.NameConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    AdminRepository adminRepository;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) object;
        String canonicalName = handlerMethod.getBeanType().getCanonicalName();
        Method method = handlerMethod.getMethod();
        if(canonicalName.startsWith(NameConstant.ADMIN_PACKAGE)) {
            Long adminId = AppUtil.loggedAdmin();
            String loginUri = "auth/adminLogin?referer=" + request.getRequestURI();
            if(adminId == null) {
                response.sendRedirect(AppUtil.baseUrl() + loginUri);
                return false;
            } else {
                Administrator admin = adminRepository.findOne(adminId);
                if(admin.getId() != adminId) {
                    AppUtil.removeSessionAttr("admin");
                    response.sendRedirect(AppUtil.baseUrl() + loginUri);
                    return false;
                }
            }
        } else if(canonicalName.startsWith(NameConstant.CUSTOMER_PACKAGE)) {

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3) throws Exception {
    }
}
