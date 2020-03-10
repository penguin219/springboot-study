package com.wwy.elasticsearch;

import com.wwy.elasticsearch.bean.Article;
import com.wwy.elasticsearch.bean.Book;
import com.wwy.elasticsearch.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ElasticsearchApplicationTests {

	@Autowired
	JestClient jestClient;

	@Autowired
	BookRepository bookRepository;

	@Test
	public void test(){
		Book book = new Book();
		bookRepository.index(book);
	}

	@Test
	void contextLoads() {
		Article article = new Article();
		article.setId(1);
		article.setTitle("depp");
		article.setAuthor("jack");
		article.setContent("hello");

		//构建一个索引
		Index index = new Index.Builder(article).index("depp").type("news").build();

		//插入数据
		try {
			jestClient.execute(index);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
