package com.tangjing.esper.event;

/**
 * Describe:
 * User:tangjing
 * Date:2017/4/6
 * Time:下午1:46
 */

public class TestEvent extends Event {
    private int id;
    private String name;

    public TestEvent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
