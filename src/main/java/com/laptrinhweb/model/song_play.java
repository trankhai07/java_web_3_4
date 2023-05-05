package com.laptrinhweb.model;

import java.util.List;

public class song_play extends Abstract<song_play> {
	private Integer id_music;
	private Integer id_author;
	private Integer id_category;
	private String name;
	private String filemusic;
	private String categorycode;

	private String author_name;
	private Integer amount_add;

	public Integer getAmount_add() {
		return amount_add;
	}

	public void setAmount_add(Integer amount_add) {
		this.amount_add = amount_add;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getCategorycode() {
		return categorycode;
	}

	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode;
	}

	public Integer getId_music() {
		return id_music;
	}
	public void setId_music(Integer id_music) {
		this.id_music = id_music;
	}
	public Integer getId_author() {
		return id_author;
	}
	public void setId_author(Integer l) {
		this.id_author = l;
	}
	public Integer getId_category() {
		return id_category;
	}
	public void setId_category(Integer id_category) {
		this.id_category = id_category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilemusic() {
		return filemusic;
	}
	public void setFilemusic(String filemusic) {
		this.filemusic = filemusic;
	}
	
	
}
