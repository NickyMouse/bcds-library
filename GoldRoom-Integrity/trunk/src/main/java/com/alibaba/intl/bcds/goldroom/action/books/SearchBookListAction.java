package com.alibaba.intl.bcds.goldroom.action.books;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.action.books.dto.BookBigObject;
import com.alibaba.intl.bcds.goldroom.action.books.dto.BookBigObjectPage;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.result.BookSearchResult;
import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchBookType;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;
import com.alibaba.intl.bcds.goldroom.wangwang.WwSocket;
import com.alibaba.intl.bcds.goldroom.wangwang.WwSocketQueue;

public class SearchBookListAction extends BaseAction {

    private static final long   serialVersionUID = -6714583660333399107L;

    private WwSocketQueue       wwSocketQueue;
    
    private BookInfoService     bookInfoService;
    private String              keyword;
    private String              bookType;
    private BookItemService     bookItemService;

    private int                 page;
    private int                 pageSize;
    
    private String              aliTalk;

    private BookBigObjectPage   bigObjectPage;

    public BookBigObjectPage getBigObjectPage() {
        return bigObjectPage;
    }
    
    public void setWwSocketQueue(WwSocketQueue wwSocketQueue) {
        this.wwSocketQueue = wwSocketQueue;
    }
    
    public String getAliTalk() {
        return aliTalk;
    }
    
    public void setAliTalk(String aliTalk) {
        this.aliTalk = aliTalk;
    }

    public void setBookItemService(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public BookInfoService getBookInfoService() {
        return bookInfoService;
    }

    public void setBookInfoService(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String execute() throws Exception {
        List<BookBigObject> bigObjects       = new ArrayList<BookBigObject>();
        BookSearchResult bookSearchResult = null;
        SearchBookType bt = null;
        if (page <= 0) {
            page = 1;
        }
        bt = SearchBookType.getSearchBookType(bookType);
        
        if (keyword == null || "".equals(keyword.trim())) {
            bookSearchResult = bookInfoService.listAllBook(bt, page, pageSize);
        } else {
            bookSearchResult = bookInfoService.searchBookByKeyword(keyword, bt, page, pageSize);
        }
        if (bookSearchResult != null && bookSearchResult.getBookList() != null) {
            for (int i = 0; i < bookSearchResult.getBookList().size(); i++) {
                BookInfo info = bookSearchResult.getBookList().get(i);
                List<BookItem> item = null;
                if (info.getId() != null) {
                    item = bookItemService.listBookItemByBookInfoId(info.getId());
                }
                BookBigObject bigObject = new BookBigObject(info, item);
                bigObjects.add(bigObject);
            }
        }
        bigObjectPage = new BookBigObjectPage(bigObjects, bookSearchResult.getTotalCount());
        return SUCCESS;
    }
    
    /**
     * 通过queue缓存的方式读取amos.im.alisoft.com，判断旺旺是否在线</br>
     * 建议使用
     * @return
     */
    public String findWangWangSocket() {
        String aliTalk = this.getRequest().getParameter("aliTalk");
        WwSocket socket = wwSocketQueue.poll();
        boolean online = socket.wwStatusOnLine(aliTalk);
        if(online){
            this.getRequest().setAttribute("userOnline", "yes");
        }else{
            this.getRequest().setAttribute("userOnline", "no");
        }
        wwSocketQueue.offer(socket);
        return "json";
    }
    
    /**
     * 通过new Socket的方式读取amos.im.alisoft.com，判断旺旺是否在线</br>
     * 不建议使用
     * @return
     */
    public String findWangWangSocket2() {
        // 获取传递的wws参数，并将参数去重处理
        String wwsStr = this.getRequest().getParameter("wws");
        String[] wwss = wwsStr == null ? null : wwsStr.split(",");
        List<String> wwsList = new ArrayList<String>();
        for(int i=0; wwss!=null && i<wwss.length; i++){
            if(wwss[i] != null && !"".equals(wwss[i].trim())){
                wwsList.remove(wwss[i].trim());
                wwsList.add(wwss[i].trim());
            }
        }
        // 用于放置返回旺旺的状态key为旺旺ID value为是否在线（要么是y要么为空）
        Map<String, String> jsonMap = new HashMap<String, String>();
        String PARAM1 = "GET http://amos.im.alisoft.com/online.aw?v=2&site=cnalichn&s=1&uid=";
        String PARAM2 = " HTTP/1.0\r\n\r\n";
        for(int i=0; wwsList!=null && i<wwsList.size(); i++){
            StringBuffer jsonValue = new StringBuffer();
            String ww = wwsList.get(i);
            jsonMap.put(ww, "");
            try {
                Socket socket = new Socket("amos.im.alisoft.com", 80);
                PrintWriter socketWriter = null;
                BufferedReader socketReader = null;
    //            String cmd = "GET http://amos.im.alisoft.com/online.aw?v=2&uid=linchaosen&site=cnalichn&s=1 HTTP/1.0\r\n\r\n";
    //            socketWriter.println(cmd);            
                socketWriter = new PrintWriter(socket.getOutputStream());
                socketWriter.println(PARAM1 +ww + PARAM2);            
                socketWriter.flush();
                socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = null;
                while((line=socketReader.readLine())!=null){
                    if(line.startsWith("Location")){
                        if(line.endsWith("online.gif")){
                            jsonMap.put(ww, "y");
                        }
                        break;
                    }
                }
    //            socket.shutdownInput();
    //            socket.shutdownOutput();
                socket.close();
                socketWriter.close();
                socketReader.close();
                socketWriter = null;
                socketReader = null;
                socket = null;
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.debug(JSONObject.fromObject(jsonMap));
        this.getRequest().setAttribute("userOnline", JSONObject.fromObject(jsonMap));
        return "json";
    }
    
    public String findWangWang() throws IOException{
        String httpUrl = this.getRequest().getParameter("httpUrl");
        long start = System.currentTimeMillis();
        log.info("chaosenww1:" + start + ":" + httpUrl);
        URL url = new URL(httpUrl);
        log.info("chaosenww2:" + start + ":" + httpUrl + ":" + (System.currentTimeMillis() - start));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        log.info("chaosenww3:" + start + ":" + httpUrl + ":" + (System.currentTimeMillis() - start));
        log.debug(httpUrl + ":" +conn.getResponseCode());//必须对conn做一次动作，不然返回的URL不会变，即返回的不是重定向后的图片URL
        if(conn.getURL().toString().endsWith("online.gif")){
            log.info("chaosenww4:" + start + ":" + httpUrl + ":" + (System.currentTimeMillis() - start));
            this.getRequest().setAttribute("userOnline", "yes");
        }
        long end = System.currentTimeMillis();
        log.info("chaosenww5:" + end+ ":" + httpUrl + ":" + (end - start) );
        return "json";
    }
    
    public void testQz() throws IOException{
        log.info("loop for test Quartz");
        for(int i=0; i<1; i++){
            
            long start = System.currentTimeMillis();
            String httpUrl = "http://amos.im.alisoft.com/online.aw?v=2&uid=linchaosen&site=cnalichn&s=1";
            log.info("loop chaosenww1:" + start + ":" + httpUrl);
            URL url = new URL(httpUrl);
            log.info("loop chaosenww2:" + start + ":" + httpUrl + ":" + (System.currentTimeMillis() - start));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            log.info("loop chaosenww3:" + start + ":" + httpUrl + ":" + (System.currentTimeMillis() - start));
            log.debug(httpUrl + ":" +conn.getResponseCode());//必须对conn做一次动作，不然返回的URL不会变，即返回的不是重定向后的图片URL
            if(!conn.getURL().toString().endsWith("online.gif")){
                log.info("loop chaosenww4:" + start + ":" + httpUrl + ":" + (System.currentTimeMillis() - start));
            }
            long end = System.currentTimeMillis();
            log.info("loop chaosenww5:" + end+ ":" + httpUrl + ":" + (end - start) );
        }
    }
}
