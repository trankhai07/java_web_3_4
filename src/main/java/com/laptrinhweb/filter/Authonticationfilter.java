package com.laptrinhweb.filter;

import com.laptrinhweb.constant.System_constant;
import com.laptrinhweb.model.user;
import com.laptrinhweb.utils.Sessionutil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Authonticationfilter implements Filter {
    private ServletContext context;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        String url = request1.getRequestURI();

        if(url.startsWith("/admin")){
            user model = (user) Sessionutil.getInstance().getValue(request1,"USERMODEL");
            if(model != null){
                if(model.getRoleid().getRole_code().equals(System_constant.ADMIN)){
                    chain.doFilter(request,response);
                }
                else if(model.getRoleid().getRole_code().equals(System_constant.USER)){
                    response1.sendRedirect(request1.getContextPath()+"/Dang-nhap?action=login&message=not_permission&alter=danger");
                }
            }else{
                response1.sendRedirect(request1.getContextPath()+"/Dang-nhap?action=login&message=not_login&alter=danger");
            }
        }else{
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
