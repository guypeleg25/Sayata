package com.example.demo.Interceptor;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        System.out.println("Inside pre handle");
//        String body = request.getReader().lines()
//                .reduce("", (accumulator, actual) -> accumulator + actual);
//        System.out.println(body);
//
//
//        if(request.getRequestURI().endsWith("home")){
////            response.sendRedirect("http://localhost:8080/home/createSubmission");
//
//            return false;
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        System.out.println("Inside post handle");
    }


}
