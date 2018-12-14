package com.company;

class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }


    public Node find(int _value)
    {
        Node tmp = head;
        while(tmp!= null && tmp.value != _value){
            tmp = tmp.next;
        }
        return tmp;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node tmp = head;
        while(tmp != null){
            if(tmp.value == _value){
                nodes.add(tmp);
            }
            tmp = tmp.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        boolean flag = false;
        if(head == null){
            flag = false;
        }else if(head == tail){
            head = null;
            tail = null;
            flag = true;
        }else if(tail.value == _value){
            tail = tail.prev;
            tail.next = null;
            flag = true;
        }else if(head.value == _value){
            head = head.next;
            flag = true;
        }else {
            Node key = find(_value);
            if(key == null){
                flag = false;
            }else{
                key.prev.next = key.next;
                key.next.prev = key.prev;
                flag = true;
            }
        }
        return flag;
    }

    public void removeAll(int _value)
    {
        if(head.next == tail){
            remove(_value);
        }else{
            boolean flag = remove(_value);
            if(flag)
                while(flag){
                    flag = remove(_value);
                }
        }
    }

    public void clear()
    {
        head = null;
        tail = null;
    }

    public int count()
    {
        Node temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if(head != null && _nodeAfter == null){
            addInTail(_nodeToInsert);
        }else
        if(tail == _nodeAfter){
            addInTail(_nodeToInsert);
        }else{
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next.prev = _nodeToInsert;
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
        }
    }

    public void log(){
        Node tmp = head;
        if(head == null){
            System.out.println("empty list");
        }else{
            while(tmp != null){
                System.out.print(tmp.value+" ");
                tmp = tmp.next;
            }
        }
        System.out.println();
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}
