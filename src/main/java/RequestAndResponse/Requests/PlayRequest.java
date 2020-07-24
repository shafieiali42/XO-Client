package RequestAndResponse.Requests;


public class PlayRequest extends Request {


    public PlayRequest(String applicator) {
        this.setRequestType("PlayRequest");
        this.setApplicator(applicator);
    }


    @Override
    public void execute() {

        }




}
