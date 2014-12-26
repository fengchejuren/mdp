package myfirst.test;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class FileSourceExample {

	public static void main(String[] args) throws IOException {
		String filePath = "F:\\mywork\\mdp\\src\\config\\testsource.txt";
		Resource rs1 = new FileSystemResource(filePath);
		Resource rs2 = new ClassPathResource("config/testsource.txt");
		InputStream int1 = rs1.getInputStream();
		InputStream int2 = rs2.getInputStream();
		System.out.println("file1:"+rs1.getFilename());
		System.out.println("file2:"+rs2.getFilename());
	}
	
}
