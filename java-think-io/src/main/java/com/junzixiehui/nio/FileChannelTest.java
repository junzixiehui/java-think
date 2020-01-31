package com.junzixiehui.nio;

import org.junit.Test;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2020/1/30  5:39 PM
 * @version: 1.0
 */
public class FileChannelTest {

	@Test
	public void test() throws Exception {

		FileChannel fileChannel = FileChannel
				.open(Paths.get("timg.jpeg"), StandardOpenOption.READ, StandardOpenOption.WRITE);

		final MappedByteBuffer mappedByteBuffer = fileChannel
				.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());

		byte[] bytes = new byte[mappedByteBuffer.limit()];
		mappedByteBuffer.get(bytes);

		String str = new String(bytes);
		System.out.println(str);
	}

	@Test
	public void test1() throws Exception {

		FileChannel inFileChannel = FileChannel
				.open(Paths.get("timg.jpeg"), StandardOpenOption.READ);

		final MappedByteBuffer mappedByteBuffer = inFileChannel
				.map(FileChannel.MapMode.READ_ONLY, 0, inFileChannel.size());

		byte[] bytes = new byte[mappedByteBuffer.limit()];
		mappedByteBuffer.get(bytes);

		FileChannel outFileChannel = FileChannel
				.open(Paths.get("timgCopy.jpeg"), StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

		final MappedByteBuffer outMappedByteBuffer = outFileChannel
				.map(FileChannel.MapMode.READ_WRITE, 0, inFileChannel.size());

		outMappedByteBuffer.put(bytes);

		inFileChannel.close();
		outFileChannel.close();
	}



}
