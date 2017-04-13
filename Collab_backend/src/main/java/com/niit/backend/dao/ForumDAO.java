package com.niit.backend.dao;

import java.util.List;
import com.niit.backend.model.Forum;

public interface ForumDAO 

{
	public boolean save(Forum forum);
	
	public boolean update(Forum forum);
	
	public boolean delete(Forum forum);
	
	public Forum get (String forumID);
	
	public Forum getName (String name);
	
	public List<Forum> list();

}
