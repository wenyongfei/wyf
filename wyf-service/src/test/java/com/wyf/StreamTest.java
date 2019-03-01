package com.wyf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest(classes = ServiceApplicationClient.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class StreamTest {

    @Test
    public void testStream(){
        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
        //reduce计算
//        Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y);
        //简约写法
//        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        //默认值
          Integer reduce = list.stream().reduce(0,(x, y) -> x + y);
//        reduce.isPresent();
        System.out.println(reduce);//Optional[6]

    }
}
