package com.dj.kuqu.common;

public enum StatusEnumList {
    QIYONG(1,"启用"),JINYONG(0,"禁用"),QUANBU(null,"全部");
    private Integer value;
    private String label;
    StatusEnumList(Integer value, String label){
        this.label = label;
        this.value = value;
    }

    public String getLabel(){
        return label;
    }
    public Integer getValue(){
        return value;
    }

    public static String getLabel(Integer value){
        for (StatusEnumList cr : StatusEnumList.values()){
            if (cr.getValue()==value){
                return cr.getLabel();
            }
        }
        return null;
    }
    public static Integer getValue(String name){
        for (StatusEnumList cr : StatusEnumList.values()){
            if (cr.getLabel().equals(name)){
                return cr.getValue();
            }
        }
        return null;
    }


}
