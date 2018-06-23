package com.test.graph.webcrawler;

/**
 * Created by kunal on 17/11/17.
 */
public class Test {

    public static void main(String[] args) {
        WebCrawler crawler = new WebCrawler();
        crawler.discoverWeb("http://www.basicsbehind.com");
    }
}
