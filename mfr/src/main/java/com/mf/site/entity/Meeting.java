package com.mf.site.entity;

import java.util.Date;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Meeting {

    private String place;
    private Date startDate;
    private String address;
}
