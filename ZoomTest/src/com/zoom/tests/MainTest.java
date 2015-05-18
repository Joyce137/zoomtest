package com.zoom.tests;

import com.zoom.utils.Checkid;

public class MainTest {
	public static void main(String[] args){
		String a = "345678900";
		System.out.println(a+" = "+Checkid.isOK(a));
		System.out.println(a+" = "+Checkid.isPMIOK(a));
		System.out.println(a+" = "+Checkid.isExisted(a));
		System.out.println(a+" = "+Checkid.isOpening(a));
	}
}
