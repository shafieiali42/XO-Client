package RequestAndResponse.Requests;

import RequestAndResponse.Response.Response;

public class StatusRequest extends Request {


    public StatusRequest(String applicator) {
        this.setRequestType("StatusRequest");
        this.setApplicator(applicator);
    }



    @Override
    public void execute() {


    }





}
