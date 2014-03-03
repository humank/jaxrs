package jaxrs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import serverlinkpoc.jaxrs.model.LotteryInfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyTest {

	@Test
	public void test() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		LotteryInfo test = new LotteryInfo();
		test.setDrawDate(new Date());
		test.setGameType("SSC");
		test.setDrawNum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 });
		
		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		mapper.setDateFormat(df);
		
		String jsonString = mapper.writeValueAsString(test);
		System.out.println(jsonString);
		
	}

}
