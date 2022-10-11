package com.learn.wqgstart;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by wangqinggang on 2021/03/06.
 */
public class Test {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(formatter.format(LocalDate.now()));
    }

}
