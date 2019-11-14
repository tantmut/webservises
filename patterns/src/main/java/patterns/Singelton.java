package patterns;

public class Singelton {

    public static void main(String[] args) {

        Singelton singelton =  getInstance();
        Singelton singelton1 =  getInstance();

        System.out.println(singelton.toString());
        System.out.println(singelton1.toString());

    }

    private static Singelton instance;

    private Singelton() {

    }

    public static Singelton getInstance(){
        if (instance == null){
            instance = new Singelton();
        }
        return instance;

    }
}
