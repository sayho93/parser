import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class main{

    private static TableFinder tableFinder;
    private static Document document;
    private static String URL = "http://spp.seoul.go.kr/main/news/news_contract.jsp";

    public static void main(String[] args) throws IOException{

        document = Jsoup.connect(URL)
                .followRedirects(true)
                .method(Connection.Method.POST)
                .timeout(10000)
                .get();
        tableFinder = new TableFinder(document, new SFCallback() {
            @Override
            public void callback() {
            }
        }, URL);


        //new JsoupCrawler("http://www.dje.go.kr/dje/2/board.do?boardID=451&menuID=030102", "table", 5).start();

    }
}
