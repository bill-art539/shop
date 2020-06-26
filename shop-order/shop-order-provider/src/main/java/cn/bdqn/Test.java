package cn.bdqn;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) throws Exception{
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1000);
        for (int i=2;i<10002;i++){
            final int x=i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    String url="http://goods.local.com/api/sendQgGoodsMessage?token=token:"+x+"&goodsId=1";
                    try {
                        Connection connection=Jsoup.connect(url).header("User-Agent","Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
                        connection.ignoreContentType(true);
                        Document document=connection.get();
                        System.out.println(document.text());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
