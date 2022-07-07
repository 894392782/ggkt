package com.atguigu;

import com.alibaba.excel.EasyExcel;
import com.atguigu.excel.User;

import java.util.ArrayList;
import java.util.List;

public class TextWrite {

    public static void main(String[] args) {
        String fileName = "D:\\test.xlsx";
        EasyExcel.write(fileName, User.class)
                .sheet("写操作")
                .doWrite(data());
    }
    private static List<User> data() {
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User data = new User();
            data.setId(i);
            data.setName("张三"+i);
            list.add(data);
        }
        return list;
    }
}
