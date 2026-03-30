package asyncApp;

public aspect AspectManners {

    /* ==========================================================
       1. Логгирование геттеров и сеттеров
       ========================================================== */

    pointcut getters():
            execution(* asyncApp.HelloWorld.get*(..));

    pointcut setters():
            execution(* asyncApp.HelloWorld.set*(..));

    after(): getters() {
        System.out.println("Something was getted. "
                + thisJoinPoint
                + " Timestamp: "
                + System.currentTimeMillis());
    }

    after(): setters() {
        System.out.println("Something was setted. "
                + thisJoinPoint
                + " Timestamp: "
                + System.currentTimeMillis());
    }


    /* ==========================================================
       2. Перед каждым методом содержащим "say"
          вывести "Good day!"
          После — "Nice to meet you!"
       ========================================================== */

    pointcut sayMethods():
            execution(* asyncApp.HelloWorld.say*(..));

    before(): sayMethods() {
        System.out.println("Good day!");
    }

    after(): sayMethods() {
        System.out.println("Nice to meet you!");
    }


    /* ==========================================================
       3. После каждого CALL метода без "say"
          вывести сообщение
       ========================================================== */

    pointcut callMethodsWithoutSay():
            call(* asyncApp.HelloWorld.*(..))
            && !call(* asyncApp.HelloWorld.say*(..));

    after(): callMethodsWithoutSay() {
        System.out.println("Without say method is called");
    }


    /* ==========================================================
       4. При вызове sayToPerson добавить фамилию
       ========================================================== */

    pointcut callSayToPerson(String message, String name):
            call(* asyncApp.HelloWorld.sayToPerson(String, String))
            && args(message, name);

    void around(String message, String name): callSayToPerson(message, name) {

        HelloWorld hw = (HelloWorld) thisJoinPoint.getTarget();

        String fullName = name + " " + hw.getFamilyName();

        proceed(message, fullName);
    }
}