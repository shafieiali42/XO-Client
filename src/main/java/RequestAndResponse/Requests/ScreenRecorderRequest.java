package RequestAndResponse.Requests;

public class ScreenRecorderRequest extends Request {

    public ScreenRecorderRequest(String applicator) {
        this.setRequestType("ScreenRecorderRequest");
        this.setApplicator(applicator);
    }


    @Override
    public void execute() {




    }


}
