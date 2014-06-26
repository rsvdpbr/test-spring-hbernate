package com.ryonishikawa.bbs;

public class UserStatic {

	private static String name;

	public UserStatic(String sess) {
		name = sess;
	}

	@Override
	public String toString() {
		return super.toString() + " / " + name;
	}
}
