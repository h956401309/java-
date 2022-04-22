package com.chao.hu;


//演示bean的生命周期
public class Order {
    private String oname;

    public Order() {
        System.out.println("第一步  执行无参构造");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步 调用set方法设置属性值");
    }

    public void init(){
        System.out.println("第三步 执行初始化方法");
    }
    public  void destroy(){
        System.out.println("第五步 执行销毁方法");
    }



}
