package RequestAndResponse.Requests;



public class LogOutRequest extends Request {


    public LogOutRequest(String applicatorToken) {
        this.setRequestType("LogOutRequest");
        this.setApplicator(applicatorToken);
    }


    @Override
    public void execute() {

    }


}
