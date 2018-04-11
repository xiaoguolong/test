import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Administrator on 2018/3/12.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        add();
    }
    public static void add() throws IOException {

        Article article = new Article();
        article.setId(1L);
        article.setTitle("Lucene全文检索");
        article.setContent("Lucene是apache软件基金会4 jakarta项目组的一个子项目，是一个开放源代码的全文检索引擎工具包，但它不是一个完整的全文检索引擎，而是一个全文检索引擎的架构，提供了完整的查询引擎和索引引擎，部分文本分析引擎（英文与德文两种西方语言）。");

        final Path path = Paths.get("./article/");

        Directory directory = FSDirectory.open(path);
        Analyzer analyzer = new StandardAnalyzer();

        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);

        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

        Document document = new Document();
        document.add(new TextField("id", article.getId().toString(), Field.Store.YES));
        document.add(new TextField("title", article.getTitle(), Field.Store.YES));
        document.add(new TextField("content", article.getContent(), Field.Store.YES));
        System.out.println(document);
        indexWriter.addDocument(document);
        indexWriter.close();

    }
}
