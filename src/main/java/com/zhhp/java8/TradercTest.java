package com.zhhp.java8;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TradercTest {

     class Trader{
        private final String name;
        private final String city;
        public Trader(String n, String c){
            this.name = n;
            this.city = c;
        }

        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }
    }

     class Transaction{
        private final Trader trader;
        private final int year;
        private final int value;
        public Transaction(Trader trader, int year, int value){
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader() {
            return trader;
        }

        public int getYear() {
            return year;
        }

        public int getValue() {
            return value;
        }
    }

    private List<Transaction> transactions;

    @Before
    public void before(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    //(1) 找出2011年发生的所有交易，并按交易额排序（从低到高）
    @Test
    public void test1(){
        transactions.stream().filter(a -> a.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
    }

    //(2) 交易员都在哪些不同的城市工作过？
    @Test
    public void test2(){
        transactions.stream().map(a -> a.getTrader().getCity()).distinct().collect(Collectors.toList());
    }

    //(3) 查找所有来自于剑桥的交易员，并按姓名排序。
    @Test
    public void test3(){
        transactions.stream().filter(a -> "jianqiao".equals(a.getTrader().getCity())).map(Transaction::getTrader).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
    }

//    (4) 返回所有交易员的姓名字符串，按字母顺序排序。
    //            (5) 有没有交易员是在米兰工作的？

    //            (6) 打印生活在剑桥的交易员的所有交易额。
//            (7) 所有交易中，最高的交易额是多少？
//            (8) 找到交易额最小的交易。
    @Test
    public void test4(){
       // transactions.stream().map(a -> a.getTrader().getName())
        transactions.stream().anyMatch(a -> a.getTrader().getCity() == "milan");
        transactions.stream().map(Transaction::getValue).reduce(Integer::max);

    }

}

