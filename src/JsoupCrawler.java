import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupCrawler extends Thread {

    public static final int TIMEOUT = 10000;

    private int lastUpdate = 0;
    private int ColumnCount = 0;
    private Document document;
    private String Query = "";
    private String URL = "";
    private Elements elements;

    private SFCallback onStart, onSuccess, onFailed;

    public JsoupCrawler(String URL, String query, int columnCount){
        this.URL = URL;
        setBoardTable(query);
        setColumnCount(columnCount);
    }

    public JsoupCrawler(String URL, String query, int columnCount, SFCallback onSuccess){
        this.URL = URL;
        setBoardTable(query);
        setColumnCount(columnCount);
        this.onSuccess = onSuccess;
    }

    public JsoupCrawler(String URL, String query, int columnCount, SFCallback onSuccess, SFCallback onFailed){
        this.URL = URL;
        setBoardTable(query);
        setColumnCount(columnCount);
        this.onSuccess = onSuccess;
        this.onFailed = onFailed;
    }

    public JsoupCrawler(String URL, String query, int columnCount, SFCallback onStart, SFCallback onSuccess, SFCallback onFailed){
        this.URL = URL;
        setBoardTable(query);
        setColumnCount(columnCount);
        this.onStart = onStart;
        this.onSuccess = onSuccess;
        this.onFailed = onFailed;
    }

    public void setBoardTable(String Query){
        this.Query = Query;
    }

    public void setColumnCount(int ColumnCount){
        this.ColumnCount = ColumnCount;
    }

    @Override
    public void run(){
        super.run();
        if(onStart != null) onStart.callback();
        try {
            document = Jsoup.connect(this.URL)
                    .followRedirects(true)
                    .method(Connection.Method.POST)
                    .timeout(TIMEOUT)
                    .get();
        }catch(IOException e){
            e.printStackTrace();
            if(onFailed != null) onFailed.callback();
            return;
        }
        postExecute();
    }

    @Override
    public void start(){
        super.start();
    }

    public void postExecute(){
        elements = document.select("table").select("tr");
        for(Element elem : elements)
            if(elem.text().trim().length() != 0) System.out.println(elem.text() + " :: " + elem.select("a").attr("href")); // Do what you want
        if(onSuccess != null) onSuccess.callback();
    }

}
