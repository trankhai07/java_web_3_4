package com.laptrinhweb.controller.admin;

import com.laptrinhweb.constant.System_constant;
import com.laptrinhweb.model.rank_music;
import com.laptrinhweb.paging.PageRequest;
import com.laptrinhweb.service.IRank_music_Service;
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

@WebServlet(urlPatterns = {"/admin-rank"})
public class Rank_music extends HttpServlet {

    @Inject
    private IRank_music_Service rkservice;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        rank_music rk = Formutil.toModel(rank_music.class,req);
        String view = "";
        if(rk.getType().equals(System_constant.LIST)){
            PageRequest pageRequest = new PageRequest(rk.getPage(),rk.getMaxpage(),new Sorter(rk.getSortName(),rk.getSortBy())) ;

            rk.setList_item(rkservice.findAll(pageRequest));


            rk.setTotalitem(rkservice.gettotalitem());
            rk.setTotalpage((int)Math.ceil((double) rk.getTotalitem()/rk.getMaxpage()));

            view = "/views/admin/Rank/list.jsp";
        }
        else if(rk.getType().equals(System_constant.EDIT)){
            if(rk.getId_music() != null){
                rk = rkservice.findone(rk.getId_music());
            }
            else {

            }

            view ="/views/admin/Rank/edit.jsp";
        }
        req.setAttribute(System_constant.MODEL,rk);
        RequestDispatcher res = req.getRequestDispatcher(view);
        res.forward(req, resp);
    }
}
