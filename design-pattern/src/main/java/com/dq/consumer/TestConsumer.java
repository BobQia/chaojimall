package com.dq.consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

/**
 * @author DengQiao
 * @date 2023-8-3 0003
 */
@Slf4j
public class TestConsumer {

    public static void main(String[] args) {

        readAndPrint("我要测试", new Consumer<String>() {
            @Override
            public void accept(String s) {
                
            }
        });
    }

    private static void readAndPrint(String path, Consumer<String> consumer) {
        consumer.accept(path);
    }
}
