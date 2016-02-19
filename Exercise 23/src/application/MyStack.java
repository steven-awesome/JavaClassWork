/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;

class MyStack implements Cloneable {

    private ArrayList<String> list = new ArrayList<String>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public String peek() {
        return list.get(getSize() - 1);
    }

    public String pop() {
        String o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public void push(String o) {
        list.add(o);
    }

}
