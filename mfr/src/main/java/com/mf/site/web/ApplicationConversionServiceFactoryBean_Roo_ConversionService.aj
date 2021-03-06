// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.mf.site.web;

import com.mf.site.entity.Meeting;
import java.lang.String;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(new MeetingConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
    static class com.mf.site.web.ApplicationConversionServiceFactoryBean.MeetingConverter implements Converter<Meeting, String>  {
        public String convert(Meeting meeting) {
            return new StringBuilder().append(meeting.getPlace()).append(" ").append(meeting.getStartDate()).append(" ").append(meeting.getAddress()).toString();
        }
        
    }
    
}
