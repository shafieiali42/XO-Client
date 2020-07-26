package RequestAndResponse.Requests;

public class EndGameRequest extends Request {


    public EndGameRequest(String applicator) {
        this.setRequestType("EndGameRequest");
        this.setApplicator(applicator);
    }


    @Override
    public void execute() {

    }


}
