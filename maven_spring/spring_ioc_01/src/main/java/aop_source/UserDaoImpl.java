package aop_source;



public class UserDaoImpl implements Userdao {
    public int add(int a, int b) {
        return a+b;
    }

    public String updata(String id) {
        return id;
    }
}
