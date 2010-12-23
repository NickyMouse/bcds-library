package com.alibaba.intl.bcds.goldroom.wangwang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class WwSocket {
    
    private static Log log = LogFactory.getLog(WwSocket.class);
    
    private int id;
    
    private static String HOST = "amos.im.alisoft.com";
    
    private static String PARAM1 = "GET http://amos.im.alisoft.com/online.aw?v=2&site=cnalichn&s=1&uid=";
    
    private static String PARAM2 = " HTTP/1.0\r\n\r\n";
    
    private Socket socket = null;
    
    public WwSocket(int id){
        this.id = id;
        try {
            socket = new Socket(HOST, 80);
        } catch (UnknownHostException e) {
            log.error("init socket error1");
            e.printStackTrace();
        } catch (IOException e) {
            log.error("init socket error2");
            e.printStackTrace();
        }
    }
    
    public boolean wwStatusOnLine(String wangwang){
        PrintWriter socketWriter = null;
        BufferedReader socketReader = null;
        try { 
            socketWriter = new PrintWriter(socket.getOutputStream());
//            String cmd = "GET http://amos.im.alisoft.com/online.aw?v=2&uid=linchaosen&site=cnalichn&s=1 HTTP/1.0\r\n\r\n";
//            socketWriter.println(cmd);            
            socketWriter.println(PARAM1 + wangwang + PARAM2);          
            socketWriter.flush();
            socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            log.debug("++++++++++++++++++++++++++++++++++ isClosed:" + socket.isClosed());
            log.debug("++++++++++++++++++++++++++++++++++ isConnected:" + socket.isConnected());
            log.debug("++++++++++++++++++++++++++++++++++ isBound:" + socket.isBound());
            log.debug("++++++++++++++++++++++++++++++++++ isInputShutdown:" + socket.isInputShutdown());
            log.debug("++++++++++++++++++++++++++++++++++ isOutputShutdown:" + socket.isOutputShutdown());
            while((line=socketReader.readLine())!=null){
                log.debug("++++++++++++++++++++++++++++++++++ line:["+wangwang+"]:" + line);
                if(line.startsWith("Location")){
                    if(line.endsWith("online.gif")){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            log.error("get Wangwang status error,will return false instead");
            e.printStackTrace();
        } finally {
            //不能关闭这些资源，因为socket是还会被使用的
//            if(socketWriter != null){
//                socketWriter.close();
//            }
//            if(socketReader != null){
//                try {
//                    socketReader.close();
//                } catch (IOException e) {
//                    log.error("close socketReader error");
//                    e.printStackTrace();
//                }
//            }
        }
        return false;
    }
    
    public void close(){
        try {
            this.socket.close();
        } catch (IOException e) {
            log.error("close wws["+this.toString()+"] error");
            e.printStackTrace();
        }
    }
    
    public String toString(){
        return super.toString() + "["+id+"]";
    }
}
