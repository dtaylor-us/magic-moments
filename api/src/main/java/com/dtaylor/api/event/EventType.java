package com.dtaylor.api.event;

public enum EventType {
    PRODUCT("Product Event");
    private final String name;

     EventType(String stringVal) {
        name = stringVal;
    }

    @Override
    public String toString() {
        return name;
    }

    public static String getEventTypeByString(String code) {
        for (EventType e : EventType.values()) {
            if (e.name.equals(code)) {
                return e.name();
            }
        }
        return null;
    }
}
