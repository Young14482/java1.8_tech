package ex05;

public class DispatcherServlet {

    private final Controller con;
    private final ControllerAdvice advice;

    public DispatcherServlet(Controller con, ControllerAdvice advice) {
        this.con = con;
        this.advice = advice;
    }

    public void route(String path){
        try {
            if (path.equals("/")) {
                con.list();
            } else if (path.equals("/board")) {
                con.detail();
            } else {
                System.out.println("404 Not Found");
            }
        } catch (RuntimeException e) {
            // 1. 컴포넌트 스캔 @ControllerAdvice
            // 2. invoke(호출) 한다. >> RuntimeException 매개변수를 가진 친구들
            advice.process(e);
        }
    }
}
