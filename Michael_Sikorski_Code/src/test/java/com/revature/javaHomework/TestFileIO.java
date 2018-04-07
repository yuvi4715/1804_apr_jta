package com.revature.javaHomework;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import file_io.*;

public class TestFileIO {

	@Test
	public void testQuestions24_28() {
		String[] args = {};
		_FileIO f = new _FileIO();
		f.main(args);
	}
	
	@Test
	public void testQuestion26() {
		String[] args = {};
		_FileIO f = new _FileIO();
		Assert.assertFalse(f.getFile() == null);
	}

}
