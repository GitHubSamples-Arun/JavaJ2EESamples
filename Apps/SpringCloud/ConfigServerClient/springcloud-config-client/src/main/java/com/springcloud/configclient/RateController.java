package com.springcloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class RateController {
	
	@Value("${rate:Unable to connect to config server}")
	String rate;
	
	@Value("${lanecount:Unable to connect to config server}")
	String laneCount;
	
	@Value("${tollstart:Unable to connect to config server}")
	String tollStart;
	
	@Value("${tollstop:Unable to connect to config server}")
	String tollStop;
	
	@RequestMapping("/getProperties")
	public String getProperties(Model m) {		
		return "rate is = " + this.rate + " lane count is = " + this.laneCount + " tollStart is = " + this.tollStart 
				+ " tollStop is = " + this.tollStop;
	}
	
	@RequestMapping("/getRates")
	public String getRates(Model m) {
		m.addAttribute("rateAmount",rate);
		m.addAttribute("lanes",laneCount);
		m.addAttribute("rateAmount",tollStart);
		
		return "stationrates";
		
	}

}
