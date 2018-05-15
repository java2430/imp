package com.vaesoft.imp.uim.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Bean
	public HandlerExceptionResolver handler() {
		return new HandlerExceptionResolver() {

			@Override
			public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
					Exception arg3) {
				ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
				Map map = new HashMap();
				map.put("status", "error");
				mv.addAllObjects(map);
				return mv;
			}
		};
	}
}
