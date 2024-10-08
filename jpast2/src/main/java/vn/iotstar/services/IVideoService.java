package vn.iotstar.services;

import java.util.List;


import vn.iotstar.entity.Video;

public interface IVideoService {

	int count();



	List<Video> findAll(int page, int pagesize);



	List<Video> findByVideoname(String vidname);



	List<Video> findAll();


	List <Video> findByCategoryId(int cateid);
	Video findById(String vidid);



	void delete(String vidid) throws Exception;



	void update(Video video);



	void insert(Video video);
	
	


}
