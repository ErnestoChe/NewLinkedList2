package com.company;

import java.util.ArrayList;

public class Test {
    public static void testCount(){
        LinkedList2 list = new LinkedList2();
        for(int i = 0; i<5; i++){
            list.addInTail(new Node(i+1));
        }
        int success = 0, fail = 0;

        if(list.count() == 5){
            success++;
            System.out.println("count 5 success");
        }else {
            fail++;
            System.out.println("count 5 fail");
        }


        list.clear();
        list.addInTail(new Node(1));
        if(list.count() == 1){
            success++;
            System.out.println("count 1 success");
        }else {
            fail++;
            System.out.println("count 1 fail");
        }

        list.clear();
        if(list.count() == 0){
            success++;
            System.out.println("count 0 success");
        }else {
            fail++;
            System.out.println("count 0 fail");
        }

        System.out.println(success+" success");
        System.out.println(fail+" fail");
    }
    public static void testFind(){
        LinkedList2 list = new LinkedList2();
        for(int i = 0; i<5; i++){
            list.addInTail(new Node(i+1));
        }
        int success = 0, fail = 0;
        Node found = list.find(9);
        if(found == null){
            success++;
            System.out.println("not existing not found");
        }else {
            fail++;
            System.out.println("non existing found somehow?????");
        }
        //finding non existing

        Node found1 = list.find(1);
        if(found1.value == 1){
            success++;
            System.out.println("found 1");
        }else {
            fail++;
            System.out.println("didnt find 1");
        }
        //found first in list

        Node found5 = list.find(5);
        if(found5.value == 5){
            success++;
            System.out.println("found 5");
        }else {
            fail++;
            System.out.println("didnt find 5");
        }
        //found last in list

        Node found3 = list.find(3);
        if(found3.value == 3 && found3.next == list.tail.prev && list.head.next == found3.prev){
            success++;
            System.out.println("found 3");
        }else {
            fail++;
            System.out.println("didnt find 3");
        }
        //found in the middle of list
        list.clear();
        Node n = list.find(2);
        if(n == null){
            System.out.println("null");
        }else System.out.println(" not null");

        System.out.println(success+" success");
        System.out.println(fail+" fail");
    }
    public static void testRemove(){
        LinkedList2 list = new LinkedList2();
        for(int i = 0; i<5; i++){
            list.addInTail(new Node(i+1));
        }
        int success = 0, fail = 0;
        boolean check = list.remove(9);
        if(!check){
            success++;
            System.out.println("coudlnt delete non existing element(9)");
        }else{
            fail++;
            System.out.println("somehow deleted non existing element");
        }

        check = list.remove(1);
        if(check){
            success++;
            System.out.println("deleted first element");
        }else{
            fail++;
            System.out.println("coudlnt delet first element");
        }

        check = list.remove(5);
        if(check){
            success++;
            System.out.println("deleted last element");
        }else{
            fail++;
            System.out.println("coudlnt delete last element");
        }

        check = list.remove(3);
        if(check){
            success++;
            System.out.println("deleted middle element");
        }else{
            fail++;
            System.out.println("coudlnt delete middle elemnt");
        }

        list.remove(2);

        check = list.remove(4);
        if(check){
            success++;
            System.out.println("deleted last element");
        }else{
            fail++;
            System.out.println("coudlnt delete last element");
        }

        check = list.remove(10);
        System.out.println(check);
        if(!check){
            success++;
            System.out.println("couldnt delete from empty list");
        }else {
            fail++;
            System.out.println("somehow deleted from empty list???");
        }

        System.out.println(success+" success");
        System.out.println(fail+" fail");

    }
    public static void testRemoveAll(){
        LinkedList2 list = new LinkedList2();
        for(int i = 0; i<5; i++){
            list.addInTail(new Node(i%3));
        }
        list.addInTail(new Node(5));
        for(int i = 0; i<5; i++){
            list.addInTail(new Node(i+1));
        }
        int success = 0, fail = 0;
        int head = list.head.value;
        int headNext = list.head.next.value;
        int tail = list.tail.value;
        int tailPrev = list.tail.prev.value;


        list.removeAll(9);
        int head1 = list.head.value;
        int head1Next = list.head.next.value;
        int tail1 = list.tail.value;
        int tail1Prev = list.tail.prev.value;
        if(head == head1 && headNext == head1Next && tail == tail1 && tailPrev == tail1Prev){
            success++;
            System.out.println("Nothing happened");
        }else{
            fail++;
            System.out.println("something bad happened");
        }

        list.removeAll(0);
        int head2 = list.head.value;
        int head2Next = list.head.next.value;
        int tail2 = list.tail.value;
        int tail2Prev = list.tail.prev.value;
        if(head2 == head1Next && tail1 == tail2 && tail1Prev == tail2Prev){
            success++;
            System.out.println("deleted head element and new head = head.next");
        }else{
            fail++;
            System.out.println("couldnt delete head element");
        }

        list.removeAll(5);
        int head3 = list.head.value;
        int head3Next = list.head.next.value;
        int tail3 = list.tail.value;
        int tail3Prev = list.tail.prev.value;
        if(tail3 != tail2 && tail3 == tail2Prev){
            success++;
            System.out.println("deleted tail");
        }else{
            fail++;
            System.out.println("couldnt delete tail");
        }

        list.removeAll(1);
        int head4 = list.head.value;
        int head4Next = list.head.next.value;
        if(head4 != head3 && head4 == head3Next){
            success++;
            System.out.println("deleted head element");
        }else {
            fail++;
            System.out.println("couldnt delete head element");
        }

        list.removeAll(2);
        int head5 = list.head.value;
        int tail5 = list.tail.value;
        list.removeAll(3);
        int head6 = list.head.value;
        int tail6 = list.tail.value;
        if(head6 == tail5 && tail6 == tail5){
            success++;
            System.out.println("delete head succes");
        }else{
            fail++;
            System.out.println("delete head failed");
        }

        list.remove(10);
        Node h = list.head;
        Node t = list.tail;
        if(list.head == null){
            success++;
            System.out.println("head null");
        }else{
            fail++;
            System.out.println("???");
        }
        //deleting from empty list

        for(int i = 0; i < 3;i++){
            list.addInTail(new Node(1));
        }
        list.log();
        list.removeAll(1);
        if(list.head == null && list.tail == null){
            success++;
            //System.out.println("deleted all list");
        }else{
            fail++;
            //System.out.println("coudlnt delete all list");
        }
        list.log();
        list.removeAll(2);
        if(list.head == null){
            System.out.println("null");
        }else System.out.println(list.head.value);


        System.out.println(success+" success");
        System.out.println(fail+" fail");
    }
    public static void testInsert(){
        LinkedList2 list = new LinkedList2();
        int success = 0, fail = 0;

        list.insertAfter(list.find(123), new Node (15));
        if(list.head!= null && list.tail != null){
            success++;
            System.out.println("insert into empty list");
        }else{
            fail++;
            System.out.println("fail insert into empty list");
        }
        for(int i = 0; i<5; i++){
            list.addInTail(new Node(i));
        }

        list.insertAfter(list.head, new Node (10));
        if(list.head.next.value == 10){
            success++;
            System.out.println("insert after head");
        }else{
            fail++;
            System.out.println("insert after head failed");
        }

        list.insertAfter(list.find(123), new Node (20));
        if(list.tail.value == 20){
            success++;
            System.out.println("insert before head(null)");
        }else{
            fail++;
            System.out.println("insert before head failed");
        }

        list.insertAfter(list.tail, new Node(25));
        if(list.tail.value == 25){
            success++;
            System.out.println("insert after tail");
        }else{
            fail++;
            System.out.println("insert after tail failed");
        }

        int tail1 = list.tail.value;
        list.insertAfter(list.tail.prev, new Node (30));
        if(tail1 == list.tail.value && list.tail.prev.value == 30){
            success++;
            System.out.println("insert before tail");
        }else{
            fail++;
            System.out.println("insert before tail failed");
        }

        Node findMid = list.find(2);
        Node midNext = findMid.next;
        list.insertAfter(findMid, new Node(40));
        if(midNext!= findMid.next && findMid.next.value == 40){
            success++;
            System.out.println("insert in the middle of list");
        }else{
            fail++;
            System.out.println("insert in the middle of list");
        }

        Node t = list.tail;
        list.insertAfter(list.tail.next, new Node(45));
        if(list.tail.prev == t && list.tail.value == 45){
            success++;
            System.out.println("insert after tail.next of list");
        }else{
            fail++;
            System.out.println("insert after tail.next of list");
        }

        System.out.println(success+" success");
        System.out.println(fail+" fail");
    }
    public static void testFindAll(){
        LinkedList2 list = new LinkedList2();
        for(int i = 0; i< 5; i++){
            list.addInTail(new Node(i));
            list.addInTail(new Node(6-i));
            list.addInTail(new Node(i));
        }
        int count = 0, fail = 0;
        list.log();

        ArrayList<Node> arList = new ArrayList<>();
        arList = list.findAll(0);
        if(arList.size() == 2){
            count++;
        }else fail++;

        arList = list.findAll(1);
        if(arList.size() == 2){
            count++;
        }else fail++;

        arList = list.findAll(2);
        if(arList.size() == 3){
            count++;
        }else fail++;

        arList = list.findAll(3);
        if(arList.size() == 3){
            count++;
        }else fail++;

        arList = list.findAll(4);
        if(arList.size() == 3){
            count++;
        }else fail++;

        arList = list.findAll(5);
        if(arList.size() == 1){
            count++;
        }else fail++;

        arList = list.findAll(6);
        if(arList.size() == 1){
            count++;
        }else fail++;

        System.out.println(count + " success");
        System.out.println(fail + " fails");

    }
}
class Main{
    public static void main(String[] args){
        //Test.testCount();
        //Test.testFind();
        Test.testRemove();
        Test.testRemoveAll();
        Test.testInsert();
        Test.testFindAll();
    }
}

//list.head.value
//list.head.value