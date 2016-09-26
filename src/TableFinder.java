import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TableFinder {

    public static final int CODE_NOTYET = 2, CODE_CANNOT_FIND = 1, CODE_SUCCESS = 0;

    private static String COMPAREDATA = "업무공고번호공고명공고기관계약방법입찰방법입찰서마감일시번호제목내용담당부서등록일조회수구분첨부작성일작성자조회등록일입찰일시추정가격기간";

    private SFCallback callback;
    private Document document;
    private String URL;
    private int tableIndex = -1;

    private int resultCode = CODE_NOTYET;

    public int getResultCode(){
        return CODE_CANNOT_FIND;
    }

    public int getTableIndex(){
        return tableIndex;
    }

    private boolean isArticleTable(String msg){
        if(COMPAREDATA.contains(msg)) return true;
        return false;
    }

    public TableFinder(Document document, SFCallback callback, String URL){
        this.document = document;
        this.URL = URL;
        this.callback = callback;
        getStarted();
    }

    public void getStarted(){
        Elements tables = document.select("table");
        if(tables != null){
            for(Element elem : tables){
                ++tableIndex;
                Element trTags = elem.select("tr").first();
                if(trTags == null){
                    System.out.println("trTags does not Executed");
                    resultCode = CODE_CANNOT_FIND;
                    callback.callback();
                    return;
                }
                for(Element td : trTags.select("td,th")){
                    if(isArticleTable(td.text())){
                        resultCode = CODE_SUCCESS;
                        new JsoupCrawler(URL, "table", resultCode).start();
                        System.out.println(resultCode);
                        callback.callback();
                        return;
                    }
                }

                resultCode = CODE_CANNOT_FIND;
                callback.callback();
            }
        }else{
            System.out.println("Failed in table " + tableIndex);

            resultCode = CODE_CANNOT_FIND;
            callback.callback();
            return;
        }
    }

}
