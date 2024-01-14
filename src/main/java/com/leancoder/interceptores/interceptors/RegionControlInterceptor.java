package com.leancoder.interceptores.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.leancoder.models.domains.Country;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component(value = "regionControlInterceptor")
public class RegionControlInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(RegionControlInterceptor.class);

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        logger.info("RegionControlInterceptor: postHandle() saliendo...");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("RegionControlInterceptor: preHandle() entrando...");
        var xd = request.getSession().getAttribute("scopedTarget.initCountry");
        Country country = (Country) xd;
        System.out.println(country);
        if (country == null) {
            logger.info("");
            response.sendRedirect("/home");
            return true;
        }
        if (country.getName().equals("PERU") || country.getName().equals("BOLIVIA")) {
            response.sendRedirect("/home/prohibido");
            return false;
        }
        return true;
    }

}
