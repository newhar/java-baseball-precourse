package baseball;

public final class GameResult {
    private static final int ZERO = 0;
    private static final int THREE_STRIKE = 3;

    private int strikeCnt;
    private int ballCnt;

    public GameResult(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public String getResultMessage() {
        if(ballCnt == ZERO && strikeCnt == ZERO) {
            return ResultStatus.NOTHING;
        }

        return makeResultMessage();
    }

    public boolean checkGameOver() {
        return this.strikeCnt == THREE_STRIKE;
    }

    private String makeResultMessage() {
        String msg = "";
        if(ballCnt > ZERO) {
            msg += String.valueOf(ballCnt).concat(ResultStatus.BALL);
        }

        if(strikeCnt > ZERO) {
            msg += String.valueOf(strikeCnt).concat(ResultStatus.STRIKE);
        }
        return msg;
    }
}
