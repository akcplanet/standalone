package com.executable.info;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.LogOutputStream;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ExecutablejarApplication {

	public static void main(String[] args) throws ExecuteException, IOException {
		ApplicationContext ctx = SpringApplication.run(ExecutablejarApplication.class, args);
        MessageSender msgSender = (MessageSender)ctx.getBean("messageSender");
		String command="java -jar /opt/temp/cucumber-jvm-java-example.jar --plugin pretty --plugin html:cucumber/html  --glue steps classpath:features";
		  ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		    CommandLine commandline = CommandLine.parse(command);
		    DefaultExecutor exec = new DefaultExecutor();		    	
	            LogOutputStream output = new LogOutputStream() {
	                @Override
	                protected void processLine(String line, int level) {
	                   System.out.println(line);
	                    msgSender.sendMessage(line+'\n');

	                }	         
	            };
	            PumpStreamHandler streamHandler = new PumpStreamHandler(output);
	            exec.setStreamHandler(streamHandler);
	            exec.setExitValue(0);
	    	    DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();   
			    exec.execute(commandline,resultHandler);
	            }

}
