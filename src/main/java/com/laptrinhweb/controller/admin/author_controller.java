package com.laptrinhweb.controller.admin;

import com.laptrinhweb.constant.System_constant;
import com.laptrinhweb.model.author;
import com.laptrinhweb.paging.PageRequest;
import com.laptrinhweb.service.IAuthor_service;
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

@WebServlet(urlPatterns = {"/admin-author"})
public class author_controller extends HttpServlet {
    @Inject
    private IAuthor_service auservice;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        author at = Formutil.toModel(author.class,req);
        String view = "";
        if(at.getType().equals(System_constant.LIST)){
            PageRequest pageRequest = new PageRequest(at.getPage(),at.getMaxpage(),new Sorter(at.getSortName(),at.getSortBy())) ;

           at.setList_item(auservice.findAll(pageRequest));


            at.setTotalitem(auservice.gettotalitem());
           at.setTotalpage((int)Math.ceil((double) at.getTotalitem()/at.getMaxpage()));

            view = "/views/admin/Author/list.jsp";
        }
        else if(at.getType().equals(System_constant.EDIT)){
            if(at.getId_author() != null){
                at = auservice.findone(at.getId_author());
            }
            else {

            }

            view ="/views/admin/Author/edit.jsp";
        }
        req.setAttribute(System_constant.MODEL,at);
        RequestDispatcher res = req.getRequestDispatcher(view);
        res.forward(req, resp);
    }
}
