package serverlinkpoc.jaxrs.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
public class LotteryInfo {
	
	@JsonProperty("gameType")
	private String gameType;
	
	@JsonProperty("drawNum")
	private int[] drawNum;
	
	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public int[] getDrawNum() {
		return drawNum;
	}

	public void setDrawNum(int[] drawNum) {
		this.drawNum = drawNum;
	}

	public Date getDrawDate() {
		return drawDate;
	}

	public void setDrawDate(Date drawDate) {
		this.drawDate = drawDate;
	}

	@JsonProperty("drawDate")
	private Date drawDate;
	
	public LotteryInfo(){
		
	}
	
	public LotteryInfo(@JsonProperty("gameType") String gameType,@JsonProperty("drawNum") int[] drawNum,@JsonProperty("drawDate") Date drawDate){
		this.gameType = gameType;
		this.drawNum = drawNum;
		this.drawDate = drawDate;
	}

}
