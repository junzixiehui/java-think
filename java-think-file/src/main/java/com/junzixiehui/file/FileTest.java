package com.junzixiehui.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/7/24  18:05
 * @version: 1.0
 */
public class FileTest {

	public static void main(String[] args) throws Exception {

		File file = new File("/Users/qulibin/white.txt");

		final FileReader fileReader = new FileReader(file);

		BufferedReader reader = new BufferedReader(fileReader);

		String tempString = null;
		// 一次读入一行，直到读入null为文件结束
		while ((tempString = reader.readLine()) != null) {
			// 显示行号
			//insert into `db_user_market`.`t_userdefined_tag_363` ( `phone`) values ( '18612463474');
			System.out.println(
					"insert into `db_user_market`.`t_userdefined_tag_14181` ( `phone`) values ( '" + tempString
							+ "');");
		}
		reader.close();
	}
}
