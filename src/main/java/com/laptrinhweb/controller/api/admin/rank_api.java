package com.laptrinhweb.controller.api.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhweb.model.rank_music;
import com.laptrinhweb.service.IRank_music_Service;
import com.laptrinhweb.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-rank"})
public class rank_api extends HttpServlet {
    @Inject
    private IRank_music_Service rkservice;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();
        rank_music rk = HttpUtil.of(req.getReader()).toModel(rank_music.class);
        rk = rkservice.save(rk);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();
        rank_music rk = HttpUtil.of(req.getReader()).toModel(rank_music.class);
        rkservice.delete(rk.getIds());
        mapper.writeValue(resp.getOutputStream(),rk );
    }
}
