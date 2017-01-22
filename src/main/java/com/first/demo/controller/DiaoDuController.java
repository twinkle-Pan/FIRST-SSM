package com.first.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DiaoDuController {
	
    public void testRun(){
    	Date date=new Date();
    	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	System.out.println("=========="+simpleDateFormat.format(date));
    }
}
