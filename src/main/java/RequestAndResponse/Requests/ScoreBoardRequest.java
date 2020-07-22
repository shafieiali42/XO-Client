package RequestAndResponse.Requests;

public class ScoreBoardRequest extends Request {




    public ScoreBoardRequest(String applicator) {
        this.setRequestType("ScoreBoardRequest");
        this.setApplicator(applicator);
    }



    @Override
    public void execute() {


    }






}
