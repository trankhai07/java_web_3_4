package com.laptrinhweb.controller.api.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhweb.model.rank_music;
import com.laptrinhweb.model.song_play;
import com.laptrinhweb.service.IRank_music_Service;
import com.laptrinhweb.service.ISong_play_Service;
import com.laptrinhweb.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-song"})
public class song_play_api extends HttpServlet {
    @Inject
    private ISong_play_Service spservice;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();

        song_play sp = HttpUtil.of(req.getReader()).toModel(song_play.class);

         spservice.save(sp);
    }
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("application/json");
//
//        ObjectMapper mapper = new ObjectMapper();
//        song_play sp = HttpUtil.of(req.getReader()).toModel(song_play.class);
//        sp = spservice.save(sp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();

        song_play sp = HttpUtil.of(req.getReader()).toModel(song_play.class);
        spservice.delete(sp.getIds());
        mapper.writeValue(resp.getOutputStream(),sp );
    }
}
