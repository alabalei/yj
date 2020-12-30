package com.lala.controller;




import jodd.io.StreamGobbler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;

import static sun.font.FontUtilities.isWindows;

/**
 * @author yj
 * @date 2020/12/17 上午11:41
 */
public class ShellTest {

    /**
     *    String bashCommand = "/Applications/Google\\ Chrome.app/Contents/MacOS/Google\\ Chrome -remote-debugging-port=9222";
     *             String bashCommand = "chmod 777 " + "/usr/local/java/jdk1.8.0_121/lib/stopffmpeg.sh" ;
     *             String bashCommand = "kill -9" + ip;
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {


//        BufferedReader reader = null;
        try{
//            reader = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("请输入IP:");
//            String ip = reader.readLine();



            ProcessBuilder builder = new ProcessBuilder();
            String cmd = "sh -c \"/Applications/Google\\ Chrome.app/Contents/MacOS/Google\\ Chrome -remote-debugging-port=9222\"";
            if (isWindows) {
                builder.command("cmd.exe", "/c", "dir");
            } else {
                builder.command("sh", "-c", cmd);
            }
            builder.directory(new File(System.getProperty("user.home")));

//            String cmd = "sh -c \"/Applications/Google\\ Chrome.app/Contents/MacOS/Google\\ Chrome -remote-debugging-port=9222\"";
            String cmdarray[] = {"sh -c \"/Applications/Google\\ Chrome.app/Contents/MacOS/Google\\ Chrome -remote-debugging-port=9222\""};
            Runtime runtime = Runtime.getRuntime();
            Process pro = builder.start();
            int status = pro.waitFor();
            if (status != 0)
            {
                System.out.println("Failed to call shell's command ");
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            StringBuffer strbr = new StringBuffer();
            String line;
            while ((line = br.readLine())!= null)
            {
                strbr.append(line).append("\n");
            }

            String result = strbr.toString();
            System.out.println(result);

        }
        catch (IOException ec)
        {
            ec.printStackTrace();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();

        }

    }


    public static void ex() throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder();
        if (isWindows) {
            builder.command("cmd.exe", "/c", "dir");
        } else {
            builder.command("sh", "-c", "pwd");
        }
        builder.directory(new File(System.getProperty("user.home")));
        Process process = builder.start();
        int exitCode = process.waitFor();
        assert exitCode == 0;
    }


}
