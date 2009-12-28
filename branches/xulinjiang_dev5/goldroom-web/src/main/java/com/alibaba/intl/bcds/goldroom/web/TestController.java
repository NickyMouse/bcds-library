package com.alibaba.intl.bcds.goldroom.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.dataobject.Integral;
import com.alibaba.intl.bcds.goldroom.dataobject.IntegralQuery;
import com.alibaba.intl.bcds.goldroom.service.IntegralService;

public class TestController extends SimpleFormController {
	
	IntegralService integralService;
	
    public void setIntegralService(IntegralService integralService) {
        this.integralService = integralService;
    }
    
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		
//		IntegralQuery integralQuery0 = new IntegralQuery();
//		integralQuery0.setLoginId("venwyhk2");
//		integralQuery0.setValue(0);
//		this.integralService.updateById(integralQuery0);
		
		ModelAndView modelAndView = new ModelAndView("test");
		List<Integral> list = new ArrayList<Integral>();
		if(this.integralService != null) {
			list = this.integralService.listAll();
		}
		//=====
		List<Integral> list2 = new ArrayList<Integral>();
		IntegralQuery integralQuery = new IntegralQuery();
//		integralQuery.setLoginId("venwyhk");
		integralQuery.setOrderBy("value");
		if(this.integralService != null) {
			list2 = this.integralService.listByQuery(integralQuery);
		}
		//=====
//		this.integralService.decreaseIntegral("venwyhk2", 100);
		IntegralQuery integralQuery2 = new IntegralQuery("sulei");
		this.integralService.insert(integralQuery2);
		
		modelAndView.addObject("test", list);
		modelAndView.addObject("test2", list2);
		System.out.println("test......");
        return modelAndView;
    }
}
