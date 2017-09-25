package com.queen_cash.util;

import com.queen_cash.domain.admin.Administrator;
import com.queen_cash.repository.AdminRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class AppUtil {
    public static Integer maxResult = 10;
    public static ServletContext servletContext = null;
    public static ApplicationContext applicationContext;

    public static Date currentDateTime() {
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Dhaka");
        Calendar calendar = Calendar.getInstance(timeZone);
        return calendar.getTime();
    }

    public static Administrator loggedAdministrator() {
        Administrator administrator = null;
        if(loggedAdmin() != null) {
            administrator = getBean(AdminRepository.class).findOne(loggedAdmin());
        }
        return administrator;
    }

    public static HttpSession currentSession() {
        HttpSession session = getRequest().getSession();
        return session;
    }

    public static HttpServletRequest getRequest() {
        try {
            RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
            return ((ServletRequestAttributes) attributes).getRequest();
        } catch (Throwable t) {
            return null;
        }
    }

    public static Long loggedAdmin() {
        return (Long) currentSession().getAttribute("admin");
    }

    public static Long loggedCustomer() {
        return (Long) currentSession().getAttribute("customer");
    }

    public static HttpSession addSessionAttr(String name, Object value) {
        HttpSession session = currentSession();
        session.setAttribute(name, value);
        return session;
    }

    public static void removeSessionAttr(String attr) {
        currentSession().removeAttribute(attr);
    }

    public static String baseUrl() {
        return "/";
    }

    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}
