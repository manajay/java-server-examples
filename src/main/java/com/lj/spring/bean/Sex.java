package com.lj.spring.bean;/**
 * @Author 段连洁 [ manajay.dlj@gmail.com ]
 * @Date 05/08/2017 4:39 PM
 */

/**
 * @author 段连洁 [manajay.dlj@gmail.com]
 * @enum Sex
 * @description user sex
 * @date 05/08/2017 4:39 PM
 */
public enum Sex {
    MALE(1,"男"), FEMALE(0,"女");

    /**
     * @author 段连洁 [ manajay.dlj@gmail.com ]
     * @date 05/08/2017 4:40 PM
     */
    private int i;
    private String name;

    private Sex(int i, String name) {
        this.i = i;
        this.name = name;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Sex getSex(int id) {
        if (id == 0){
            return FEMALE;
        } else if (id == 1) {
            return MALE;
        }

        return  null;
    }


    @Override
    public String toString() {
        return "Sex{" +
                "i=" + i +
                ", name='" + name + '\'' +
                '}';
    }
}
