package RequestAndResponse.Requests;


public class LogInRequest extends Request {

    private String userName;
    private String password;
    private String mode; //SignUp or LogIn



    public LogInRequest(String applicator,String userName, String password, String mode) {
        this.setRequestType("LogInRequest");
        this.setApplicator(applicator);
        this.userName = userName;
        this.password = password;
        this.mode = mode;

    }



    @Override
    public void execute() {


    }


}
