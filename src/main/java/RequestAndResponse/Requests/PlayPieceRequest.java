package RequestAndResponse.Requests;

public class PlayPieceRequest extends Request{



    private int targetTileId;

    public PlayPieceRequest(String applicator,int targetTileId) {
        this.setRequestType("ScoreBoardRequest");
        this.setApplicator(applicator);
        this.targetTileId=targetTileId;
    }



    @Override
    public void execute() {


    }


    //getter and setters
    //********************

    public int getTargetTileId() {
        return targetTileId;
    }

    public void setTargetTileId(int targetTileId) {
        this.targetTileId = targetTileId;
    }


}
