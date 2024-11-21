package ex05;

public class App {
    public static void main(String[] args) {
        ControllerAdvice advice = new ControllerAdvice();
        Repository rp = new Repository();
        Service service = new Service(rp);
        Controller con = new Controller(service);
        DispatcherServlet ds = new DispatcherServlet(con, advice);


        ds.route("/");
        ds.route("/board");
    }
}
