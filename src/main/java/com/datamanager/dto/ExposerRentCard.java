package com.datamanager.dto;

/**
 * 2018-05-16-15:10 Author By AgainP
 */
public class ExposerRentCard {

    private boolean exposed;

    private int cardState;

    private long cardId;

    public ExposerRentCard(boolean exposed, int cardState, long cardId) {
        this.exposed = exposed;
        this.cardState = cardState;
        this.cardId = cardId;
    }

    public ExposerRentCard(boolean exposed, long cardId) {
        this.exposed = exposed;
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "ExposerRentCard{" +
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
