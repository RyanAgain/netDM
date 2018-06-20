package com.datamanager.dto;

/**
 * 2018-05-17-18:03 Author By AgainP
 */
public class ExposerReturn {
    private boolean exposed;

    private int cardState;

    private long cardId;

    public ExposerReturn(boolean exposed, int cardState, long cardId) {
        this.exposed = exposed;
        this.cardState = cardState;
        this.cardId = cardId;
    }

    public ExposerReturn(boolean exposed, long cardId) {
        this.exposed = exposed;
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "ExposerReturn{" +
                "exposed=" + exposed +
                ", cardState=" + cardState +
                ", cardId=" + cardId +
                '}';
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public int getCardState() {
        return cardState;
    }

    public void setCardState(int cardState) {
        this.cardState = cardState;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }
}
