package serverlinkpoc.jaxrs.service;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.io.FileUtils;

import serverlinkpoc.jaxrs.model.LotteryInfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("DrawService")
public class DrawService {
	/**
	 * Default constructor.
	 */
	public DrawService() {
	}

	
	@GET
	@Path("/query")
	public Response getUsers(@Context UriInfo info) {
 
		String from = info.getQueryParameters().getFirst("from");
		String to = info.getQueryParameters().getFirst("to");
		List<String> orderBy = info.getQueryParameters().get("orderBy");
 
		return Response
		   .status(200)
		   .entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();
 
	}
	
	/**
	 * Retrieves representation of an instance of DrawService
	 * 
	 * @return an instance of String
	 */
	@GET
	@Path("/get")
	public String getDrawNum() {

		ObjectMapper mapper = new ObjectMapper();

		LotteryInfo test = new LotteryInfo();
		test.setDrawDate(new Date());

		test.setGameType("SSC");

		test.setDrawNum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 });

		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		mapper.setDateFormat(df);

		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(test);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonString);
		return jsonString;
	}

	/**
	 * PUT method for updating or creating an instance of DrawService
	 * 
	 * @content content representation for the resource
	 * @return an HTTP response with content of the updated or created resource.
	 */
	@POST
	@Path("/add")
	public Response putDrawNum(
			@FormParam("gameType") String gameType,
			@FormParam("drawNum") String drawNum) {
		
		//String gameType = info.getQueryParameters().getFirst("gameType");
		System.out.println("gameType is : "+ gameType);
		
		//String num = info.getQueryParameters().getFirst("drawNum");
		System.out.println("drawnum is : " + drawNum);
		
		String[] item =drawNum.split(",");
		int[] _num = new int[item.length];
		for(int i=0;i<item.length;i++){
			_num[i]=Integer.parseInt(item[i]);
		}
		
		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		
		LotteryInfo li = new LotteryInfo();
		li.setDrawNum(_num);
		li.setGameType(gameType);
		li.setDrawDate(new Date());
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(df);
		
		
		File file = new File("/home/kim/Downloads/persistent.txt");
		String jsonString =null;
		try {
			jsonString = mapper.writeValueAsString(li);
			FileUtils.writeStringToFile(file, jsonString+"\n", true);
			
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return Response
		   .status(200)
		   .entity(jsonString).build();


	}
}