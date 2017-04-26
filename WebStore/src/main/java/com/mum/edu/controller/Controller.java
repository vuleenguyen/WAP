package com.mum.edu.controller;

public interface Controller {
	
	default String customPath(String realPath) {
		return realPath.replaceAll("\\\\", "/");
	}
	
	default String getPath() {
		return new String("D:\\image");
	}
} 
