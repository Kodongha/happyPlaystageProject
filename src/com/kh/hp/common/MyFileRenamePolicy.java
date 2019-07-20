package com.kh.hp.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	private int userSeq;

	public MyFileRenamePolicy(int userSeq) {
		// TODO Auto-generated constructor stub
		this.userSeq = userSeq;
	}

	@Override
	public File rename(File oldFile) {
		// TODO Auto-generated method stub

		long currentTime = System.currentTimeMillis();
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
		int randomNumber = (int) (Math.random() * 100000);

		String name = oldFile.getName();
		String body = null;
		String ext = null;

		int dot = name.lastIndexOf(".");

		if(dot != -1) {
			body = name.substring(0, dot);
			ext = name.substring(dot);
		} else {
			body = name;
			ext = "";
		}

		String fileName = ft.format(new Date(currentTime)) + randomNumber + ext;

		File newFile = new File(oldFile.getParent(), fileName);

		return newFile;
	}
}
