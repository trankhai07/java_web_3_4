package com.laptrinhweb.controller.admin;

import com.laptrinhweb.constant.System_constant;
import com.laptrinhweb.model.category;
import com.laptrinhweb.paging.PageRequest;
import com.laptrinhweb.service.ICategory_Service;
import com.laptrinhweb.sorter.Sorter;
import com.laptrinhweb.utils.Formutil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-category"})
public class Category extends HttpServlet {
    @Inject
    private ICategory_Service ctservice;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        category ct = Formutil.toModel(category.class,req);
        String view="";
        if(ct.getType().equals(System_constant.LIST)){
            PageRequest pageRequest = new PageRequest(ct.getPage(),ct.getMaxpage(),new Sorter(ct.getSortName(),ct.getSortBy())) ;

            ct.setList_item(ctservice.findAll(pageRequest));


            ct.setTotalitem(ctservice.gettotalitem());
            ct.setTotalpage((int)Math.ceil((double) ct.getTotalitem()/ct.getMaxpage()));

            view = "/views/admin/Category/list.jsp";
        }
        else if(ct.getType().equals("search")){
            PageRequest pageRequest = new PageRequest(ct.getPage(),ct.getMaxpage(),new Sorter(null,null)) ;

            ct.setList_item(ctservice.findAllbyname(pageRequest,ct.getName()));


            ct.setTotalitem(ctservice.gettotalitembyname(ct.getName()));
            ct.setTotalpage((int)Math.ceil((double) ct.getTotalitem()/ct.getMaxpage()));

            view = "/views/admin/Category/list.jsp";
        }
        else if(ct.getType().equals(System_constant.EDIT)){
            if(ct.getId_category() != null){
                ct = ctservice.findone(ct.getId_category());
            }
            else {

            }

            view ="/views/admin/Category/edit.jsp";
        }
        req.setAttribute(System_constant.MODEL,ct);
        RequestDispatcher res = req.getRequestDispatcher(view);
        res.forward(req, resp);
    }
}
