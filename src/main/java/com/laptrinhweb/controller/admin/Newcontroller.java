package com.laptrinhweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.constant.System_constant;
import com.laptrinhweb.model.song_play;
import com.laptrinhweb.paging.PageRequest;
import com.laptrinhweb.paging.Pageble;
import com.laptrinhweb.service.IAuthor_service;
import com.laptrinhweb.service.ICategory_Service;
import com.laptrinhweb.service.IRank_music_Service;
import com.laptrinhweb.service.ISong_play_Service;
import com.laptrinhweb.sorter.Sorter;
import com.laptrinhweb.utils.Formutil;

@WebServlet(urlPatterns = {"/admin-new"})
public class Newcontroller extends HttpServlet{

	@Inject
	private ISong_play_Service songplay_service;
	@Inject
	private ICategory_Service category_service;
	@Inject
	private IAuthor_service author_service;
	@Inject
	private IRank_music_Service rkservice;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		song_play sp = Formutil.toModel(song_play.class,req);
//		String pagepr = req.getParameter("page");
//		String maxpage = req.getParameter("maxpage");
//
//		if(pagepr != null){
//			sp.setPage(Integer.parseInt(pagepr));
//		}
//		else sp.setPage(1);
//		if(maxpage != null) sp.setMaxpage(Integer.parseInt(maxpage));
		String view = "";
		if(sp.getType().equals(System_constant.LIST)){
			PageRequest pageRequest = new PageRequest(sp.getPage(),sp.getMaxpage(),new Sorter(sp.getSortName(),sp.getSortBy())) ;



			sp.setList_item(songplay_service.findAll(pageRequest));


			sp.setTotalitem(songplay_service.gettotalitem());
			sp.setTotalpage((int)Math.ceil((double) sp.getTotalitem()/sp.getMaxpage()));

			view = "/views/admin/New/list.jsp";
		}
		else if(sp.getType().equals(System_constant.EDIT)){
			if(sp.getId_music() != null){
				sp = songplay_service.findone(sp.getId_music());
			}
			else {

			}
			req.setAttribute("categories",category_service.findAll(new PageRequest(null,null,new Sorter(null,null))));
			req.setAttribute("authors",author_service.findAll(new PageRequest(null,null,new Sorter(null,null))));
			req.setAttribute("rank_musics",rkservice.findAll(new PageRequest(null,null,new Sorter(null,null))));
			view ="/views/admin/New/edit.jsp";
		}
		req.setAttribute(System_constant.MODEL, sp);
		RequestDispatcher res = req.getRequestDispatcher(view);
		res.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
